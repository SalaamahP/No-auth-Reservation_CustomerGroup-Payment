package com.restaurant.rms.repository;

import com.restaurant.rms.models.CustomerGroup;
import com.restaurant.rms.models.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface CustomerGroupRepo extends JpaRepository<CustomerGroup, Integer> {
   Optional<CustomerGroup> findByPhoneNumber(String phoneNumber);

}
