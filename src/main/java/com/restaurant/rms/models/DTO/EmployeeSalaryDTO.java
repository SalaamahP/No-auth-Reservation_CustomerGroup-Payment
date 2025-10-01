//package com.restaurant.rms.models.DTO;
//
//public class EmployeeSalaryDTO {
//    private int employeeId;
//    private double amount;
//    private String method;
//
//    public int getEmployeeId() {
//        return employeeId;
//    }
//
//    public void setEmployeeId(int employeeId) {
//        this.employeeId = employeeId;
//    }
//
//    public double getAmount() {
//        return amount;
//    }
//
//    public void setAmount(double amount) {
//        this.amount = amount;
//    }
//
//    public String getMethod() {
//        return method;
//    }
//
//    public void setMethod(String method) {
//        this.method = method;
//    }
//}

package com.restaurant.rms.models.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EmployeeSalaryDTO {

    // used for edit (optional); when adding, leave as 0 or null
//    private Integer employeePaymentId;

//    @NotNull(message = "Employee is required")
    private Integer employeeId;

//    @NotNull(message = "Amount is required")
//    @PositiveOrZero(message = "Amount must be zero or positive")
    private Double amount;

//    @NotNull(message = "Method is required")
//    @Size(min = 1, max = 100)
    private String method;

    // optional: allow manual override of lastPayment if desired
    private LocalDateTime lastPayment;
    // ------------------------------

//    // getters & setters
//    public Integer getEmployeePaymentId() {
//        return employeePaymentId;
//    }
//    public void setEmployeePaymentId(Integer employeePaymentId) {
//        this.employeePaymentId = employeePaymentId;
//    }

    public Integer getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getMethod() {
        return method;
    }
    public void setMethod(String method) {
        this.method = method;
    }

    public LocalDateTime getLastPayment() {
        return lastPayment;
    }
    public void setLastPayment(LocalDateTime lastPayment) {
        this.lastPayment = lastPayment;
    }
}
