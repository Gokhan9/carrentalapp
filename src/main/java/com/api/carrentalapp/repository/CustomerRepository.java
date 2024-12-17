package com.api.carrentalapp.repository;

import com.api.carrentalapp.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
