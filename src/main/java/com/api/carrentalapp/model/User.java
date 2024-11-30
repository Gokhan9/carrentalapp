package com.api.carrentalapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users") //TABLO ADINI "users" OLARAK KAYDET. "POSTGRESQL" user olarak ENGELLEDİĞİ İÇİN OLUŞTURULDU.
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Birbirinden farklı "id" ürettiriyor.
    private Long id;

    @Column(nullable = false) //BOŞ OLMAYACAK
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String mail;

}
