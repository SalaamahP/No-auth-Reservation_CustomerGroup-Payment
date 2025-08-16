package com.restaurant.rms.models.DTO;

import jakarta.validation.constraints.NotEmpty;

import java.util.Date;

public class EmployeeDTO {

    @NotEmpty(message="Field cannot be empty")
    private String empFirstName;

    @NotEmpty(message="Field cannot be empty")
    private String empLastName;

    private Date empStartDate;

    @NotEmpty(message="Field cannot be empty")
    private String role;

//    @NotEmpty
    private String empContactNum;

//    @NotEmpty
    private String empEmail;
    // --------------------------------

    // setters and getters
    public @NotEmpty(message = "Field cannot be empty") String getEmpFirstName() {
        return empFirstName;
    }

    public void setEmpFirstName(@NotEmpty(message = "Field cannot be empty") String empFirstName) {
        this.empFirstName = empFirstName;
    }

    public @NotEmpty(message = "Field cannot be empty") String getEmpLastName() {
        return empLastName;
    }

    public void setEmpLastName(@NotEmpty(message = "Field cannot be empty") String empLastName) {
        this.empLastName = empLastName;
    }

    public Date getEmpStartDate() {
        return empStartDate;
    }


    public void setEmpStartDate(Date empStartDate) {
        this.empStartDate = empStartDate;
    }

    public @NotEmpty(message = "Field cannot be empty") String getRole() {
        return role;
    }

    public void setRole(@NotEmpty(message = "Field cannot be empty") String role) {
        this.role = role;
    }

    public String getEmpContactNum() {
//    public @NotEmpty String getEmpContactNum() {
        return empContactNum;
    }

    public void setEmpContactNum(@NotEmpty String empContactNum) {
        this.empContactNum = empContactNum;
    }

    public String getEmpEmail() {
//    public @NotEmpty String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(@NotEmpty String empEmail) {
        this.empEmail = empEmail;
    }
}
