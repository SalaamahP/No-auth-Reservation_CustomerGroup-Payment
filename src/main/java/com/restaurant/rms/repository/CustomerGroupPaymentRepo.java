package com.restaurant.rms.repository;

import com.restaurant.rms.models.CustomerGroupPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerGroupPaymentRepo extends JpaRepository<CustomerGroupPayment, Integer> {
}
