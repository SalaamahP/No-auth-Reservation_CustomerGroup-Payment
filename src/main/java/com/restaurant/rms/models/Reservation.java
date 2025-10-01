package com.restaurant.rms.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="Reservation")
public class Reservation {
    @EmbeddedId
    private ReservationId id;


    @ManyToOne
    @MapsId("customerGroupId")
    @JoinColumn(name= "customer_group_id")
    private CustomerGroup customerGroup;

    private LocalDateTime reservationDateTime;
    private int reservationTimeMax;
    private LocalDateTime reservationTimeStart;
    private LocalDateTime reservationTimeEnd;

    @ManyToOne
    @JoinColumn(name = "table_id", nullable = false)
    private RestaurantTable restaurantTable;

    public Reservation() {
    }

    public Reservation(LocalDateTime reservationDateTime, int reservationTimeMax, LocalDateTime reservationTimeStart, LocalDateTime reservationTimeEnd, RestaurantTable restaurantTable) {

        //this.customerGroup = customerGroup;
        this.reservationDateTime = reservationDateTime;
        this.reservationTimeMax = reservationTimeMax;
        this.reservationTimeStart = reservationTimeStart;
        this.reservationTimeEnd = reservationTimeEnd;
        this.restaurantTable = restaurantTable;
    }

    public ReservationId getId() {
        return id;
    }

    public void setId(ReservationId id) {
        this.id = id;
    }

    public CustomerGroup getCustomerGroup() {
        return customerGroup;
    }

    public void setCustomerGroup(CustomerGroup customerGroup) {
        this.customerGroup = customerGroup;
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

    public RestaurantTable getRestaurantTable() {
        return restaurantTable;
    }

    public void setRestaurantTable(RestaurantTable restaurantTable) {
        this.restaurantTable = restaurantTable;
    }

    public Reservation copy(Reservation originalReservation) {
        return new Reservation(
               // originalReservation.getCustomerGroup(),
                originalReservation.getReservationDateTime(),
                originalReservation.getReservationTimeMax(),
                originalReservation.getReservationTimeStart(),
                originalReservation.getReservationTimeEnd(),
                originalReservation.getRestaurantTable()
        );

    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", customerGroup=" + customerGroup +
                ", reservationDateTime=" + reservationDateTime +
                ", reservationTimeMax=" + reservationTimeMax +
                ", reservationTimeStart=" + reservationTimeStart +
                ", reservationTimeEnd=" + reservationTimeEnd +
                ", restaurantTable=" + restaurantTable +
                '}';
    }
}

// NEWER; September

//package com.restaurant.rms.models;
//
//import jakarta.persistence.*;
//
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name="Reservation")
//public class Reservation {
//    @EmbeddedId
//    private ReservationId id;
//
//
//    @ManyToOne
//    @MapsId("customerGroupId")
//    @JoinColumn(name= "customer_group_id")
//    private CustomerGroup customerGroup;
//
//    private LocalDateTime reservationDateTime;
//    private int reservationTimeMax;
//    private LocalDateTime reservationTimeStart;
//    private LocalDateTime reservationTimeEnd;
////    private int tableId;
//
//    @ManyToOne
//    @JoinColumn(name="table_id", nullable=false)
//    private RestaurantTable restaurantTable;
//
//    public Reservation() {
//    }
//
//    public Reservation(LocalDateTime reservationDateTime, int reservationTimeMax, LocalDateTime reservationTimeStart, LocalDateTime reservationTimeEnd, RestaurantTable restaurantTable) {
//
//        //this.customerGroup = customerGroup;
//        this.reservationDateTime = reservationDateTime;
//        this.reservationTimeMax = reservationTimeMax;
//        this.reservationTimeStart = reservationTimeStart;
//        this.reservationTimeEnd = reservationTimeEnd;
//        this.restaurantTable = restaurantTable;
//    }
//
//    public ReservationId getId() {
//        return id;
//    }
//
//    public void setId(ReservationId id) {
//        this.id = id;
//    }
//
//    public CustomerGroup getCustomerGroup() {
//        return customerGroup;
//    }
//
//    public void setCustomerGroup(CustomerGroup customerGroup) {
//        this.customerGroup = customerGroup;
//    }
//
//    public LocalDateTime getReservationDateTime() {
//        return reservationDateTime;
//    }
//
//    public void setReservationDateTime(LocalDateTime reservationDateTime) {
//        this.reservationDateTime = reservationDateTime;
//    }
//
//    public int getReservationTimeMax() {
//        return reservationTimeMax;
//    }
//
//    public void setReservationTimeMax(int reservationTimeMax) {
//        this.reservationTimeMax = reservationTimeMax;
//    }
//
//    public LocalDateTime getReservationTimeStart() {
//        return reservationTimeStart;
//    }
//
//    public void setReservationTimeStart(LocalDateTime reservationTimeStart) {
//        this.reservationTimeStart = reservationTimeStart;
//    }
//
//    public LocalDateTime getReservationTimeEnd() {
//        return reservationTimeEnd;
//    }
//
//    public void setReservationTimeEnd(LocalDateTime reservationTimeEnd) {
//        this.reservationTimeEnd = reservationTimeEnd;
//    }
//
//    public RestaurantTable getRestaurantTable() {
//        return restaurantTable;
//    }
//
//    public void setRestaurantTable(RestaurantTable restaurantTable) {
//        this.restaurantTable = restaurantTable;
//    }
//
//    public Reservation copy(Reservation originalReservation) {
//        return new Reservation(
//                // originalReservation.getCustomerGroup(),
//                originalReservation.getReservationDateTime(),
//                originalReservation.getReservationTimeMax(),
//                originalReservation.getReservationTimeStart(),
//                originalReservation.getReservationTimeEnd(),
//                originalReservation.getRestaurantTable()
//        );
//
//    }
//
//    @Override
//    public String toString() {
//        return "Reservation{" +
//                "id=" + id +
//                ", customerGroup=" + customerGroup +
//                ", reservationDateTime=" + reservationDateTime +
//                ", reservationTimeMax=" + reservationTimeMax +
//                ", reservationTimeStart=" + reservationTimeStart +
//                ", reservationTimeEnd=" + reservationTimeEnd +
//                ", restaurantTable=" + restaurantTable +
//                '}';
//    }
//}

