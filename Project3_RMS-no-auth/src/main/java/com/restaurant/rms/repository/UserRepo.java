package com.restaurant.rms.repository;

import com.restaurant.rms.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
//    Optional<User> findByUsername(String username);
}
