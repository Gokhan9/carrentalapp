package com.api.carrentalapp.service;

import com.api.carrentalapp.converter.VehicleDtoConverter;
import com.api.carrentalapp.dto.CreateVehicleRequest;
import com.api.carrentalapp.dto.VehicleDto;
import com.api.carrentalapp.model.Customer;
import com.api.carrentalapp.model.Transaction;
import com.api.carrentalapp.model.Vehicle;
import com.api.carrentalapp.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final CustomerService customerService;
    private final TransactionService transactionService;
    private final VehicleDtoConverter converter;

    public VehicleService(VehicleRepository vehicleRepository,
                          CustomerService customerService,
                          TransactionService transactionService,
                          VehicleDtoConverter converter) {

        this.vehicleRepository = vehicleRepository;
        this.customerService = customerService;
        this.transactionService = transactionService;
        this.converter = converter;
    }

    public VehicleDto createVehicle(CreateVehicleRequest createVehicleRequest){
        Customer customer = customerService.findCustomerById(createVehicleRequest.getCustomerId());

        Vehicle vehicle = new Vehicle(
                customer,
                createVehicleRequest.getInitialRecord(),
                LocalDateTime.now());

        if (createVehicleRequest.getInitialRecord().compareTo(BigDecimal.ZERO) > 0) {
            Transaction transaction = transactionService.initiateMoney(vehicle, createVehicleRequest.getInitialRecord());
            vehicle.getTransactions().add(transaction);
        }

        return converter.convert(vehicleRepository.save(vehicle));

    }

}
