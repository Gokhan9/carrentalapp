package com.api.carrentalapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class CustomerDto {

    private Long id;
    private String name;
    private String surname;

}
