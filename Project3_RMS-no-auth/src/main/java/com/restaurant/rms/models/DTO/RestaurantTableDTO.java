package com.restaurant.rms.models.DTO;

import jakarta.validation.constraints.NotEmpty;

import java.util.Date;

public class RestaurantTableDTO {
    private int tableNumber;
    private int capacity;

    @NotEmpty(message = "Status cannot be empty")
    private String status;

    private Date lastCleaned;
    // ----------------------------------

    // getters
    public int getTableNumber() {
        return tableNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public @NotEmpty(message = "Status cannot be empty") String getStatus() {
        return status;
    }

    public Date getLastCleaned() {
        return lastCleaned;
    }

    // setters
    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setStatus(@NotEmpty(message = "Status cannot be empty") String status) {
        this.status = status;
    }

}