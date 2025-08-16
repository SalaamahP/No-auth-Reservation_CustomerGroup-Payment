package com.restaurant.rms.models.DTO;

import com.restaurant.rms.models.ReservationId;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class ReservationDTO {

    private ReservationId id;
    @NotNull(message = "Field cannot be empty")
    private LocalDateTime reservationDateTime;
    @NotNull(message = "Field cannot be empty")
    private int reservationTimeMax;
    @NotNull(message = "Field cannot be empty")
    private LocalDateTime reservationTimeStart;
    @NotNull(message = "Field cannot be empty")
    private LocalDateTime reservationTimeEnd;
    @Min(value = 1, message = "Table Id must be a positive number")
    private int tableId;

    @Valid
    @NotNull
    private CustomerGroupDTO customerGroup = new CustomerGroupDTO();


    public ReservationId getId() {
        return id;
    }

    public void setId(ReservationId id) {
        this.id = id;
    }

    public LocalDateTime getReservationDateTime() {
        return reservationDateTime;
    }

    public void setReservationDateTime(LocalDateTime reservationDateTime) {
        this.reservationDateTime = reservationDateTime;
    }


    public int getReservationTimeMax() {
        return reservationTimeMax;
    }

    public void setReservationTimeMax(int reservationTimeMax) {
        this.reservationTimeMax = reservationTimeMax;
    }

    public LocalDateTime getReservationTimeStart() {
        return reservationTimeStart;
    }

    public void setReservationTimeStart(LocalDateTime reservationTimeStart) {
        this.reservationTimeStart = reservationTimeStart;
    }

    public LocalDateTime getReservationTimeEnd() {
        return reservationTimeEnd;
    }

    public void setReservationTimeEnd(LocalDateTime reservationTimeEnd) {
        this.reservationTimeEnd = reservationTimeEnd;

    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public  CustomerGroupDTO getCustomerGroup() {
        return customerGroup;
    }

    public void setCustomerGroup(CustomerGroupDTO customerGroup) {
        this.customerGroup = customerGroup;
    }
}
