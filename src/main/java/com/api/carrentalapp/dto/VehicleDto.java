package com.api.carrentalapp.dto;

import com.api.carrentalapp.model.Customer;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
public class VehicleDto {

    private Long id;

    private String brand;
    private String model;
    private LocalDateTime creationDate;
    private Customer customer;
    private VehicleCustomerDto vehicleCustomerDto;
    private Set<TransactionDto> transactions;

}
