package com.api.carrentalapp.dto;

import com.api.carrentalapp.model.Customer;
import lombok.*;

//VehicleDto içerisinde, "CustomerDto" bilgileri yer alıcak.
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleCustomerDto {

    private Long id;

    private String name;
    private String surname;

}
