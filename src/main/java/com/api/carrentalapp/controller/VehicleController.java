package com.api.carrentalapp.controller;

import com.api.carrentalapp.repository.UserRepository;
import com.api.carrentalapp.repository.VehicleRepository;
import com.api.carrentalapp.request.VehicleRequest;
import com.api.carrentalapp.dto.VehicleDto;
import com.api.carrentalapp.model.Vehicle;
import com.api.carrentalapp.service.VehicleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/vehicle")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;
    private final VehicleRepository vehicleRepository;
    private final UserRepository userRepository;

    //kayıtları listele
    @GetMapping
    public ResponseEntity<List<VehicleDto>> getAllVehicles() {
        List<VehicleDto> vehicles = vehicleService.getVehicles();
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    //read - mevcut olan veriyi görüntülemek.
    @GetMapping("/{id}")
    public List<Vehicle> getAllVehiclesById(@PathVariable Long vehicleId){
        return vehicleRepository.getVehiclesById(vehicleId);
    }

    @PutMapping
    public Vehicle save(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @PostMapping("/create")
    public ResponseEntity<VehicleDto> createVehicle(@Valid @RequestBody VehicleRequest request) {
        return ResponseEntity.ok(vehicleService.createVehicle(request));
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<VehicleDto> updateVehicleById(@RequestBody VehicleDto vehicleDto) {
        VehicleDto updatedVehicleDto = vehicleService.updateVehicle(vehicleDto);
        return new ResponseEntity<>(updatedVehicleDto, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{vehicleId}")
    public ResponseEntity<VehicleDto> deleteVehicleById(@PathVariable Long vehicleId) {
        VehicleDto deletedVehicleDto = vehicleService.deleteVehicle(vehicleId);
        return new ResponseEntity<>(deletedVehicleDto, HttpStatus.ACCEPTED);
    }

    //satılmamış olan araçlar.
    @GetMapping
    public List<Vehicle> getAvailableVehicle() {
        return vehicleService.getAllAvailableVehicle();
    }

    @PutMapping("/buy/{vehicleId}")
    public String buyVehicle(@PathVariable Long id) {
        return vehicleService.buyVehicle(id);
    }


    @PostMapping("/buy/{vehicleId}")
    public String buyVehicles(@PathVariable Long vehicleId, @RequestParam Long buyerId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow();
        if (vehicle.isSold() || vehicle.isDeleted()) {
            return "Vehicle is not available or purchase";
        }
        vehicle.setUser(userRepository.findById(buyerId)
                .orElseThrow());
        vehicle.setSold(true);
        vehicleRepository.save(vehicle);
        return "Vehicle purchased successfully.";
    }
}
