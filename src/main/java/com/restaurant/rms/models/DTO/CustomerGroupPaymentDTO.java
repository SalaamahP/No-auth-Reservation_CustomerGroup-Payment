package com.restaurant.rms.models.DTO;

import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public class CustomerGroupPaymentDTO {
  @NotNull
    private int paymentId;
   @NotNull(message= "Payment date and time is required")
   @FutureOrPresent(message = "Payment date and time cannot be in past/future")
    private LocalDateTime paymentDateTime;

   @NotNull(message="Please enter a payment amount")
   @Positive(message = "Payment amount must be greater than 0")

    private Double paymentAmount;

    @NotBlank(message= "Please select a transaction type")
    private String paymentTransactionType;

    @NotNull(message= "Customer group ID is required")
    private int customerGroupId;

    public int getPaymentId() {
        return paymentId;
    }
    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }
    public LocalDateTime getPaymentDateTime() {
        return paymentDateTime;
    }
    public void setPaymentDateTime(LocalDateTime paymentDateTime) {
        this.paymentDateTime = paymentDateTime;

    }
    public Double getPaymentAmount() {
        return paymentAmount;

    }
    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
    public String getPaymentTransactionType() {
        return paymentTransactionType;
    }

    public void setPaymentTransactionType(String paymentTransactionType) {
        this.paymentTransactionType = paymentTransactionType;
    }
    public int getCustomerGroupId() {
        return customerGroupId;
    }
    public void setCustomerGroupId(int customerGroupId) {
        this.customerGroupId = customerGroupId;
    }
}
