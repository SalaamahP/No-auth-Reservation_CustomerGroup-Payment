package com.restaurant.rms.repository;

import com.restaurant.rms.models.Reservation;
import com.restaurant.rms.models.ReservationId;
import com.restaurant.rms.models.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ReservationRepo extends JpaRepository<Reservation, ReservationId> {
    boolean existsByReservationDateTimeAndRestaurantTable(LocalDateTime reservationDateTime, RestaurantTable restaurantTable);
}
