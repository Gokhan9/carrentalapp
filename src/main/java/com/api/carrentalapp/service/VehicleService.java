package com.api.carrentalapp.service;

import com.api.carrentalapp.converter.VehicleDtoConverter;
import com.api.carrentalapp.request.VehicleRequest;
import com.api.carrentalapp.dto.VehicleDto;
import com.api.carrentalapp.model.User;
import com.api.carrentalapp.model.Vehicle;
import com.api.carrentalapp.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final UserService userService;
    private final VehicleDtoConverter converter;
    private final VehicleDtoConverter vehicleDtoConverter;


    public List<VehicleDto> getVehicles() {

        List<Vehicle> vehicles = vehicleRepository.findAll();
        return vehicles.stream()
                .map(vehicleDtoConverter::toDto)
                .collect(Collectors.toList());
    }

    public VehicleDto createVehicle(VehicleRequest vehicleRequest){

        User user = userService.getCustomerById(vehicleRequest.getCustomerId());
        Vehicle vehicle = converter.convert(vehicleRequest, user);
        return converter.convert(vehicleRepository.save(vehicle));
    }

    public VehicleDto updateVehicle(VehicleDto vehicleDto) {

        Vehicle vehicle = vehicleDtoConverter.toVehicle(vehicleDto);
        Vehicle updatedVehicle = vehicleRepository.save(vehicle);
        return vehicleDtoConverter.toDto(updatedVehicle);
    }

    public VehicleDto deleteVehicle(Long vehicleId) {

        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new RuntimeException("Vehicle not found with id" + vehicleId));

        vehicleRepository.delete(vehicle);
        return vehicleDtoConverter.toDto(vehicle);
    }

    public List<Vehicle> getAllAvailableVehicle(){
        return vehicleRepository.findByStatus(Vehicle.Status.AVAILABLE);
    }

    public String buyVehicle(Long vehicleId) {
        Optional<Vehicle> optionalVehicle = vehicleRepository.findById(vehicleId);

        if (optionalVehicle.isPresent()) {
            Vehicle vehicle = optionalVehicle.get();

            if (vehicle.getStatus() == Vehicle.Status.SOLD) {
                return "Error: This vehicle is already solded.";
            }

            vehicle.setStatus(Vehicle.Status.SOLD);
            vehicleRepository.save(vehicle);
            return "Vehicle purchased successfully.";
        } else {
            return "Error: Vehicle is not found.";
        }
    }

}
