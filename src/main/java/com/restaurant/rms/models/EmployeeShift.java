package com.restaurant.rms.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name="EmployeeShift")
public class EmployeeShift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDateTime dateNow;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

//    @ManyToOne
//    @MapsId("employee_id")
//    @JoinColumn(name="employee_id")

    public EmployeeShift(){}
    public EmployeeShift(LocalDateTime dateNow, LocalDateTime startTime, LocalDateTime endTime) {
        this.dateNow = dateNow;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    // ---------------------------------

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDateNow() {
        return dateNow;
    }

    public void setDateNow(LocalDateTime dateNow) {
        this.dateNow = dateNow;
    }

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

    @Override
    public String toString() {
        return "EmployeeShift{" +
                "id=" + id +
                ", dateNow=" + dateNow +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}

