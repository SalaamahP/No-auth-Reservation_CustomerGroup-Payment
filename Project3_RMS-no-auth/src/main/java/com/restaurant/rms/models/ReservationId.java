package com.restaurant.rms.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
public class ReservationId implements Serializable {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_uuid", nullable = false)
    private UUID uuid;

    @Column(name = "customer_group_id", nullable = false)
    private int customerGroupId;

    public ReservationId() {
    }

    public ReservationId(UUID uuid, int customerGroupId) {
        this.uuid = uuid;
        this.customerGroupId = customerGroupId;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public int getCustomerGroupId() {
        return customerGroupId;
    }

    public void setCustomerGroupId(int customerGroupId) {
        this.customerGroupId = customerGroupId;
    }


}
