package com.api.carrentalapp.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class VehicleRequest {

    @NotBlank
    private Long customerId;

    private Long vehicleId;
    private String brand;
    private String model;
    private LocalDateTime creationDate;
    private LocalDate registrationDate;
    private String chassisNumber;
    private Integer mileage;

}
