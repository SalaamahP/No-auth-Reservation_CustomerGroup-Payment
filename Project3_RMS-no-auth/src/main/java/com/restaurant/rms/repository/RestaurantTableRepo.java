package com.restaurant.rms.repository;

import com.restaurant.rms.models.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantTableRepo extends JpaRepository<RestaurantTable, Integer> {
}
