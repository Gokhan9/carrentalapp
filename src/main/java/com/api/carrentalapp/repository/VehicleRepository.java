package com.api.carrentalapp.repository;

import com.api.carrentalapp.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {
}
