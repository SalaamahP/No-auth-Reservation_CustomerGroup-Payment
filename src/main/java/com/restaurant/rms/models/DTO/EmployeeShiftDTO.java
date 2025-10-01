package com.restaurant.rms.models.DTO;

//import jakarta.validation.constraints.Future;
//import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class EmployeeShiftDTO {
//    @Min(0)
//    private int id;

//    @NotNull(message = "Date must not be null")
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
//    @PastOrPresent(message = "Today's date not a future date.")
    private LocalDateTime dateNow;

//    @NotNull (message = "Shift start date cannot be null")
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime startTime;

//    @NotNull (message = "Shift end date cannot be null")
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime endTime;
    // ----------------------------------------

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public LocalDateTime getDateNow() {
        return dateNow;
    }

    public void setDateNow(LocalDateTime dateNow) {
        this.dateNow = dateNow;
    }
}
