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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.ucb.login.dto.ErrorResponse;
import com.ucb.login.dto.LoginRequestDto;
import com.ucb.login.dto.LoginResponseDto;

@RestController
public class LoginController implements ILoginApi {

    @Override
    @PostMapping("/api/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequest) {
        // Aquí deberías implementar la lógica para autenticar al usuario utilizando el servicio de autenticación
        // authenticationService.authenticate(loginRequest.getEmail(), loginRequest.getPassword());

        // Por ahora, devolvemos una respuesta vacía para el ejemplo
        LoginResponseDto responseDto = new LoginResponseDto();
        return ResponseEntity.ok(responseDto);
    }
}

