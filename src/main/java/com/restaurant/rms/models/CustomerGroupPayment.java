package com.restaurant.rms.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="CustomerGroupPayment")
public class CustomerGroupPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;
    private LocalDateTime paymentDateTime;
    private double paymentAmount;
    private String paymentTransactionType;

    @ManyToOne(optional=false)
    @JoinColumn(name="customer_group_id")
    private CustomerGroup customerGroup;

    public CustomerGroupPayment() {}
    public CustomerGroupPayment(LocalDateTime paymentDateTime, double paymentAmount, String paymentTransactionType) {
        this.paymentDateTime = paymentDateTime;
        this.paymentAmount = paymentAmount;
        this.paymentTransactionType = paymentTransactionType;

    }
    // -------------------------------

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
    public CustomerGroup getCustomerGroup() {
        return customerGroup;
    }
    public void setCustomerGroup(CustomerGroup customerGroup) {
        this.customerGroup = customerGroup;
    }
}
