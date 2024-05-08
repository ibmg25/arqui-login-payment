package com.ucb.login.dto;

public class PaymentResponseDto {

    private String message;

    public PaymentResponseDto() {}

    public PaymentResponseDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
