package com.restaurant.rms.repository;

import com.restaurant.rms.models.Reservation;
import com.restaurant.rms.models.ReservationId;
import com.restaurant.rms.models.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

public interface ReservationRepo extends JpaRepository<Reservation, ReservationId> {
    boolean existsByReservationDateTimeAndRestaurantTable(LocalDateTime reservationDateTime, RestaurantTable restaurantTable);

    @Query("SELECT  r FROM Reservation r " +
            "WHERE r.reservationTimeStart< :end AND r.reservationTimeEnd > :start")
    List<Reservation> findByDoubleBooking(@Param("start") LocalDateTime start,
                                          @Param("end") LocalDateTime end);
}
