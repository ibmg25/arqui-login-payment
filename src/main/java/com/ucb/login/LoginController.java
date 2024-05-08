package com.ucb.login;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion.VersionFlag;
import com.networknt.schema.ValidationMessage;
import com.ucb.login.dto.UserDto;

import io.sentry.Sentry;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Set;

import org.springframework.http.ResponseEntity;

@RestController
public class LoginController implements ILoginApi {
    
    @GetMapping("/")
    public String index() {

        try {
            throw new Exception("This is a test.");
          } catch (Exception e) {
            Sentry.captureException(e);
          }
        return "Greetings from Spring boot";
    }

    @GetMapping( value = "/products/{id}", produces = "application/json")
    public ResponseEntity<UserDto> obtain(@PathVariable String id) {
        
        var product = new UserDto("abc@gmail.com", "abc123");
        return ResponseEntity.ok(product);
    }
    
    @PostMapping( value = "/products", produces = "application/json")
    public ResponseEntity create(@RequestBody UserDto product) {

        ObjectMapper mapper = new ObjectMapper();
        String json;
        try {
            json = mapper.writeValueAsString(product);
            JsonSchemaFactory factory = JsonSchemaFactory.getInstance(VersionFlag.V7);
            JsonSchema jsonSchema = factory.getSchema(LoginController.class.getClassLoader().getResourceAsStream("schemas/product.json"));
            JsonNode jsonNode = mapper.readTree(json);
            Set<ValidationMessage> errors = jsonSchema.validate(jsonNode); 

            String errorsCombined = "";
            for( ValidationMessage error: errors) {
                errorsCombined += error.toString() +  "\n";
            }

            if(errors.size() > 0) {
                return ResponseEntity.badRequest().body("Please fix your JSON!,\n"+errorsCombined);
            }
            return ResponseEntity.ok(product);

        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return ResponseEntity.ok(product);
        }
    }
    
}