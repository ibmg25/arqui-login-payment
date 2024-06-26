package com.ucb.login;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import com.ucb.login.dto.ErrorResponse;
import com.ucb.login.dto.LoginRequestDto;
import com.ucb.login.dto.LoginResponseDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

public interface ILoginApi {

    @Tag(name = "Authentication", description = "User login")
    @Operation(summary = "User Login", description = "Endpoint to authenticate a user with email and password")
    @ApiResponses(
        value = {
            @ApiResponse(
                responseCode = "200", description = "Successful login",
                content = {
                    @Content(mediaType = "application/json",
                             schema = @Schema(implementation = LoginResponseDto.class))
                }
            ),
            @ApiResponse(
                responseCode = "400", description = "Bad request",
                content = {
                    @Content(mediaType = "application/json",
                             schema = @Schema(implementation = ErrorResponse.class))
                }
            ),
            @ApiResponse(
                responseCode = "401", description = "Unauthorized",
                content = {
                    @Content(mediaType = "application/json",
                             schema = @Schema(implementation = ErrorResponse.class))
                }
            ),
            @ApiResponse(
                responseCode = "500", description = "Internal server error",
                content = {
                    @Content(mediaType = "application/json",
                             schema = @Schema(implementation = ErrorResponse.class))
                }
            )
        }
    )
    @PostMapping("/api/login")
    public ResponseEntity<LoginResponseDto> login(LoginRequestDto loginRequest);

}

