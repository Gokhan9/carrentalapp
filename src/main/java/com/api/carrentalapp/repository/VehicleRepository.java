package com.api.carrentalapp.repository;

import com.api.carrentalapp.model.Vehicle;
import com.api.carrentalapp.model.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    void deleteById(Long vehicleId);

    List<Vehicle> findByStatus(Vehicle.Status status);

    List<Vehicle> getVehiclesById(Long vehicleId);
}
