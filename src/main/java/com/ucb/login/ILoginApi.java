package com.ucb.login;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ucb.login.dto.ErrorResponse;
import com.ucb.login.dto.UserDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

public interface ILoginApi {

    @Tag(name = "Products", description = "Obtain the list of products")
    @Operation(summary = "Lista de productos", description = "Loren ipsum")
    @ApiResponses(
        value = {
            @ApiResponse(
                responseCode = "200", description = "loren ipson landa bla"
            ),
            @ApiResponse(
                responseCode = "500", description = "${api.responseCodes.internalServer.description}",
                 content = {
                    @Content(mediaType = "application/json",
                             schema = @Schema(implementation = ErrorResponse.class))
                 }

            )
        }
    )
    public String index();
    
    @Tag(name = "Products", description = "Obtain one product by id")
    public ResponseEntity<UserDto> obtain(String id);


    @Tag(name = "Products", description = "Create product")
    public ResponseEntity<UserDto> create(UserDto product);

}

