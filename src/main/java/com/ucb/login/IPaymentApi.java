package com.ucb.login;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import com.ucb.login.dto.ErrorResponse;
import com.ucb.login.dto.PaymentDto;
import com.ucb.login.dto.PaymentResponseDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

public interface IPaymentApi {

    @Tag(name = "Payment", description = "Process payment")
    @Operation(summary = "Process Payment", description = "Process a payment with credit card data")
    @ApiResponses(
        value = {
            @ApiResponse(
                responseCode = "200", description = "Payment processed successfully",
                content = {
                    @Content(mediaType = "application/json",
                             schema = @Schema(implementation = PaymentResponseDto.class))
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
                responseCode = "500", description = "Internal server error",
                content = {
                    @Content(mediaType = "application/json",
                             schema = @Schema(implementation = ErrorResponse.class))
                }
            )
        }
    )
    @PostMapping("/api/payment")
    public ResponseEntity<PaymentResponseDto> processPayment(PaymentDto paymentRequest);

}
