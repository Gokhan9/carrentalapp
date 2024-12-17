package com.api.carrentalapp.converter;

import com.api.carrentalapp.dto.CustomerDto;
import com.api.carrentalapp.dto.VehicleCustomerDto;
import com.api.carrentalapp.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDtoConverter {

    private final CustomerVehicleDtoConverter converter;

    public CustomerDtoConverter(CustomerVehicleDtoConverter converter) {
        this.converter = converter;
    }

    public VehicleCustomerDto convertToVehicleCustomer(Customer from){
        if (from == null) {
            return new VehicleCustomerDto(1L, "", "");
        }
        return new VehicleCustomerDto(from.getId(), from.getName(), from.getSurname());
    }

    public CustomerDto convertToCustomerDto(Customer from) {
        return new CustomerDto(
                from.getId(),
                from.getName(),
                from.getSurname());
    }

}
