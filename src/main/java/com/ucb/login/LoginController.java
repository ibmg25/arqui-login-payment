package com.ucb.login;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.http.ResponseEntity;

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

