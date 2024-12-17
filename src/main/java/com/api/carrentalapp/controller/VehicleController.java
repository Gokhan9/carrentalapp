package com.api.carrentalapp.controller;

import com.api.carrentalapp.dto.CreateVehicleRequest;
import com.api.carrentalapp.dto.VehicleDto;
import com.api.carrentalapp.service.VehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public ResponseEntity<VehicleDto> createVehicle(@RequestBody CreateVehicleRequest request) {
        return ResponseEntity.ok(vehicleService.createVehicle(request));
    }
}
