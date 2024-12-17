package com.api.carrentalapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;

    //customer'a ait accountları çekmek
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private Set<Vehicle> vehicles; //"accounts" vardı, "vehicles" ile güncelledim. BAK
}
