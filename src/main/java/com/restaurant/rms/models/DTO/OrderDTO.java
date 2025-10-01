/*
 * Developer: Ammaar
 * Started: 22.04.25
 * Updated: 02.07.25
*/

package com.restaurant.rms.models.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class OrderDTO {
    private LocalDateTime orderTime;

//    @NotNull
    private double estimatedWaitTime;

    @NotNull
    private double totalPrice;

    @NotEmpty(message = "Field cannot be empty")
    private String status;
    // ----------------------------------

    // Getters
    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    @NotNull
    public double getEstimatedWaitTime() {
        return estimatedWaitTime;
    }

    @NotNull
    public double getTotalPrice() {
        return totalPrice;
    }

    public @NotEmpty(message = "Field cannot be empty") String getStatus() {
        return status;
    }

    // Setters
    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public void setEstimatedWaitTime(double estimatedWaitTime) {
        this.estimatedWaitTime = estimatedWaitTime;
    }

    public void setTotalPrice(@NotNull double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setStatus(@NotEmpty(message = "Field cannot be empty") String status) {
        this.status = status;
    }
}
