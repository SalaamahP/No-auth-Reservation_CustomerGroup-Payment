package com.restaurant.rms.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="CustomerGroup")
public class CustomerGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerGroupId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private int numberOfPeople;

    @OneToMany(mappedBy = "customerGroup", cascade = CascadeType.ALL)
    private List<CustomerGroupPayment> customerGroupPayments;

    public CustomerGroup(){}
    public CustomerGroup(int customerGroupId, String firstName, String lastName, String phoneNumber, int numberOfPeople) {
        this.customerGroupId = customerGroupId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.numberOfPeople = numberOfPeople;
    }
    // -------------------------------------

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

    public List<CustomerGroupPayment> getCustomerGroupPayments() {
        return customerGroupPayments;
    }

    public void setCustomerGroupPayments(List<CustomerGroupPayment> customerGroupPayments) {
        this.customerGroupPayments = customerGroupPayments;
    }

    @Override
    public String toString() {
        return "CustomerGroup{" +
                "customerGroupId=" + customerGroupId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", numberOfPeople=" + numberOfPeople +
                '}';
    }
}
