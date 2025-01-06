package com.api.carrentalapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String model;
    private LocalDateTime creationDate;
    private LocalDate registrationDate;
    private String chassisNumber;
    private Integer mileage;

    @Enumerated(EnumType.STRING)
    private Status status = Status.AVAILABLE;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    public Vehicle(Long id, String brand, String model, String chassisNumber, int mileage) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.chassisNumber = chassisNumber;
        this.mileage = mileage;
    }

    public enum Status {
        AVAILABLE,SOLD
    }
}



