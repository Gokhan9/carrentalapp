package com.api.carrentalapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;


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

    private String brand; // markası
    private String model; // model
    private LocalDateTime creationDate; // oluşturulma tarihi
    private LocalDate registrationDate; // kayıt tarihi
    private String chassisNumber; // şase numarası
    private Integer mileage; // araç km

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    //account'a ait customerlar çekmek
    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Transaction> transactions;


    public Vehicle(Customer customer, BigDecimal initialRecord, LocalDateTime now) {
    }
}



