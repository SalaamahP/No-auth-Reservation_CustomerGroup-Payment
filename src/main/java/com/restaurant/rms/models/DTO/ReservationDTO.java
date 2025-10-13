package com.restaurant.rms.models.DTO;

import com.restaurant.rms.models.ReservationId;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class ReservationDTO {

    private ReservationId id;

 @NotNull(message = "Reservation Date and Time cannot be empty")
    private LocalDateTime reservationDateTime;

 @NotNull(message = "Please enter maximum reservation time")
 @Min(value = 1, message = "Please enter a valid time")
    private Integer reservationTimeMax;

 @NotNull(message = "Reservation Start Time cannot be empty")
    private LocalDateTime reservationTimeStart;

  @NotNull(message = "Reservation End Time cannot be empty")
    private LocalDateTime reservationTimeEnd;

 @Min(value = 1, message = "Table Id must be a positive number")
    private Integer tableId;

    @Valid
    private CustomerGroupDTO customerGroup ;


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


    public Integer getReservationTimeMax() {
        return reservationTimeMax;
    }

    public void setReservationTimeMax(Integer reservationTimeMax) {
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

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public  CustomerGroupDTO getCustomerGroup() {
        return customerGroup;
    }

    public void setCustomerGroup(CustomerGroupDTO customerGroup) {
        this.customerGroup = customerGroup;
    }
}
