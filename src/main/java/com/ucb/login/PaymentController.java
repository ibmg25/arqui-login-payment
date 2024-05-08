package com.ucb.login;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ucb.login.dto.PaymentDto;
import com.ucb.login.dto.PaymentResponseDto;

@RestController
public class PaymentController implements IPaymentApi {

    @Override
    @PostMapping("/api/payment")
    public ResponseEntity<PaymentResponseDto> processPayment(@RequestBody PaymentDto paymentRequest) {
        
        PaymentResponseDto responseDto = new PaymentResponseDto();
        return ResponseEntity.ok(responseDto);
    }
}
