package com.ucb.login;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ucb.login.dto.ErrorResponse;
import com.ucb.login.dto.PaymentDto;
import com.ucb.login.dto.PaymentResponseDto;

@RestController
public class PaymentController implements IPaymentApi {

    @Override
    @PostMapping("/api/payment")
    public ResponseEntity<PaymentResponseDto> processPayment(@RequestBody PaymentDto paymentRequest) {
        // Aquí implementa la lógica para procesar el pago utilizando los datos de la tarjeta de crédito
        // Si hay errores, puedes devolver un ErrorResponse adecuado
        // Si el pago se procesa correctamente, devuelve un PaymentResponseDto con los detalles del pago

        // Por ahora, devolvemos una respuesta vacía para el ejemplo
        PaymentResponseDto responseDto = new PaymentResponseDto();
        return ResponseEntity.ok(responseDto);
    }
}
