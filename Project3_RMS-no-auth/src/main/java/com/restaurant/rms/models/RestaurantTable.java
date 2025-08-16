package com.restaurant.rms.models;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
//@Table(name="RestaurantTableTest")
@Table(name="RestaurantTable")
public class RestaurantTable {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;

    private int tableNumber;
    private int capacity;
    private String status;
    //private int last_cleaned_by;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastCleaned;

//    @OneToMany
//    @JoinColumns({
//          @JoinColumn(  name="uuid", referencedColumnName="uuid"),
//        @JoinColumn(name="customer_group_id", referencedColumnName = "customer_group_id")})
//    private Reservation reservation;

//    @OneToMany(mappedBy="restaurant_table")
//    private List<Order> orders;

    //private Reservation reservation_id;
    //@Temporal(TemporalType.TIMESTAMP)

    public RestaurantTable(){}
    public RestaurantTable(int table_number, int capacity, String status, Date last_cleaned) {
        this.tableNumber = table_number;
        this.capacity = capacity;
        this.status = status;
        this.lastCleaned = last_cleaned;
    }
    // ----------------------------------

    // GETTERS
    public int getId() {
        return id;
    }
    public int getTableNumber() {
        return tableNumber;
    }
    public int getCapacity() {
        return capacity;
    }
    public String getStatus() {
        return status;
    }
    public Date getLastCleaned() {
        return lastCleaned;
    }

    // SETTERS
    public void setId(int id) {
        this.id = id;
    }
    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setLastCleaned(Date lastCleaned) {
        this.lastCleaned = lastCleaned;
    }
    // ----------------------------------

    public static RestaurantTable copy(RestaurantTable originalTable) {
        return new RestaurantTable(
                originalTable.getTableNumber(),
                originalTable.getCapacity(),
                originalTable.getStatus(),
                originalTable.getLastCleaned()
        );
    }

    @Override
    public String toString() {
        return "RestaurantTable{" +
                "id=" + id +
                ", tableNumber=" + tableNumber +
                ", capacity=" + capacity +
                ", status='" + status + '\'' +
                ", lastCleaned=" + lastCleaned +
                '}';
    }
}
