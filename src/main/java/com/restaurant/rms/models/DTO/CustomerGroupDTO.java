package com.restaurant.rms.models.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class CustomerGroupDTO {
//    @NotNull
    private int customerGroupId;
//    @NotNull
    private String firstName;
//    @NotNull
    private String lastName;
//    @NotNull
@NotNull
@Pattern(
        regexp = "^(\\+\\d{1,3}[- ]?)?\\d{10}$",
        message = "Phone number must be valid"
)

private String phoneNumber;
    @Min(value = 1, message = "At least one customer required")
    private int numberOfPeople;

    public int getCustomerGroupId() {
        return customerGroupId;
    }
    public void setCustomerGroupId(int customerGroupId) {
        this.customerGroupId = customerGroupId;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public int getNumberOfPeople() {
        return numberOfPeople;
    }
    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;

    }
}
