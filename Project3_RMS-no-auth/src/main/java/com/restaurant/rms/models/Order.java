/*
 * Developer: Ammaar
 * Started: 22.04.25
 * Updated: 05.06.25
*/

package com.restaurant.rms.models;

import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name="OrderTest")
//@Table(name="Order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDateTime orderTime;
    // LocalDateTime now = LocalDateTime.now();

//    private Datetime serveTime;
    // rather change it? to...

    private double estimatedWaitTime;
    // calculate this in the back-end, instead of a user entering a value?

    private double totalPrice;
    private String status;
//    private enum status;

    // FK ------
    // empId;
    // tableId;
    // paymentId;

    // orderDetail?


    // temp
//       import java.time.LocalDateTime;
//   import java.time.format.DateTimeFormatter;
//
//    public class DateTimeExample {
//        public static void main(String[] args) {
//            LocalDateTime now = LocalDateTime.now();
//            System.out.println("Current DateTime: " + now);
//
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//            String formattedDateTime = now.format(formatter);
//            System.out.println("Formatted DateTime: " + formattedDateTime);
//        }
//    }


    public Order(){}
    public Order(LocalDateTime orderTime, double estimatedWaitTime, double totalPrice, String status) {
        this.orderTime = orderTime;
        this.estimatedWaitTime = estimatedWaitTime;
        this.totalPrice = totalPrice;
        this.status = status;
    }
    // ----------------------------------

    // Getters
    public int getId() {
        return id;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public double getEstimatedWaitTime() {
        return estimatedWaitTime;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getStatus() {
        return status;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public void setEstimatedWaitTime(double estimatedWaitTime) {
        this.estimatedWaitTime = estimatedWaitTime;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderTime=" + orderTime +
                ", estimatedWaitTime=" + estimatedWaitTime +
                ", totalPrice=" + totalPrice +
                ", status='" + status + '\'' +
                '}';
    }
}
