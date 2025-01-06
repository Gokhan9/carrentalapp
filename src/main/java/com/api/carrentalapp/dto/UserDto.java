package com.api.carrentalapp.dto;

import lombok.*;

//VehicleDto içerisinde, "CustomerDto" bilgileri yer alıcak.
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;

    private String username;
    private String surname;
    private String password;

    
}
