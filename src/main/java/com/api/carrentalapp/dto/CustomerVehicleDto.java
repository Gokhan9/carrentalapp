package com.api.carrentalapp.dto;

import com.api.carrentalapp.model.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

//CustomerDto içerisinde de,"VehicleDto" bilgieri yer alıcak.
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerVehicleDto {

    private Long id;

    private String brand;
    private String model;
    private LocalDateTime creationDate;
    private LocalDate registrationDate;
    private String chassisNumber;
    private Integer mileage;

    private Set<TransactionDto> transactions;

    public CustomerVehicleDto(Long id, String brand, String model, Set<TransactionDto> transactions, LocalDateTime creationDate){
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.transactions = transactions;
        this.creationDate = creationDate;
    }
}
