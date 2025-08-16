package com.restaurant.rms.models.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class CustomerGroupPaymentDTO {
    @NotNull
    private int paymentId;
    @NotNull
    private LocalDateTime paymentDateTime;

    private double paymentAmount;
    @NotEmpty
    private String paymentTransactionType;

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
    public double getPaymentAmount() {
        return paymentAmount;

    }
    public void setPaymentAmount(double paymentAmount) {
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
