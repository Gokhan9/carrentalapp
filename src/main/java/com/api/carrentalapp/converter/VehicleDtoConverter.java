package com.api.carrentalapp.converter;

import com.api.carrentalapp.dto.VehicleDto;
import com.api.carrentalapp.model.Vehicle;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class VehicleDtoConverter {

    private final CustomerDtoConverter customerDtoConverter;
    private final TransactionDtoConverter transactionDtoConverter;

    public VehicleDtoConverter(CustomerDtoConverter customerDtoConverter, TransactionDtoConverter transactionDtoConverter) {
        this.customerDtoConverter = customerDtoConverter;
        this.transactionDtoConverter = transactionDtoConverter;
    }

    //Fromlanan yeni oluşturulan dto'nun değeri olarak ata.
    public VehicleDto convert(Vehicle from) {
        return new VehicleDto(from.getId(),
                from.getBrand(),
                from.getModel(),
                from.getCreationDate(),
                from.getCustomer(),
                customerDtoConverter.convertToVehicleCustomer(from.getCustomer()),
                Objects.requireNonNull(from.getTransactions())
                        .stream()
                        .map(transactionDtoConverter::convert)
                        .collect(Collectors.toSet()));
    }
}
