package com.api.carrentalapp.repository;

import com.api.carrentalapp.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    void deleteById(Long vehicleId);

    List<Vehicle> getVehiclesById(Long vehicleId);
}
