package com.ucb.login.dto;

public class PaymentDto {
    private String cardNumber;
    private String cvv;
    private String expirationDate;
    public PaymentDto(String cardNumber, String cvv, String expirationDate) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expirationDate = expirationDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }
    public String getCVV() {
        return cvv;
    }
    public String getExpirationDate() {
        return expirationDate;
    }
   
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public void setCVV(String cvv) {
        this.cvv = cvv;
    }
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}
