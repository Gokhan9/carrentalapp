package com.api.carrentalapp.dto;

import com.api.carrentalapp.model.User;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class VehicleDto {

    private Long id;

    private String brand;
    private String model;
    private LocalDateTime creationDate;
    private User user;

    public VehicleDto() {

    }
}
