package com.api.carrentalapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users") //TABLO ADINI "users" OLARAK KAYDET. "POSTGRESQL" user olarak ENGELLEDİĞİ İÇİN OLUŞTURULDU.
public class User extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Birbirinden farklı "id" ürettiriyor.
    private Long id;

    @Column(name = "username", nullable = false) //BOŞ OLMAYACAK
    private String username;
    @Column(name="surname", nullable = false)
    private String surname;
    @Column(name="password", nullable = false)
    private String password;
    @Column(name="email", nullable = false)
    private String email;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<Vehicle> vehicles;

}
