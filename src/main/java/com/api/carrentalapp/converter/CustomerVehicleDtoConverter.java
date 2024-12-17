package com.api.carrentalapp.converter;

import com.api.carrentalapp.dto.CustomerVehicleDto;
import com.api.carrentalapp.model.Vehicle;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomerVehicleDtoConverter {

    private final TransactionDtoConverter converter;

    public CustomerVehicleDtoConverter(TransactionDtoConverter converter) {
        this.converter = converter;
    }

    public CustomerVehicleDto convert(Vehicle from){
        return new CustomerVehicleDto(
                from.getId(),
                from.getBrand(),
                from.getModel(),
                from.getTransactions().stream().map(converter::convert).collect(Collectors.toSet()),
                from.getCreationDate()
        );
    }
}
