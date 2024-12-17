package com.api.carrentalapp.service;

import com.api.carrentalapp.converter.CustomerDtoConverter;
import com.api.carrentalapp.dto.CustomerDto;
import com.api.carrentalapp.exception.CustomerNotFoundException;
import com.api.carrentalapp.model.Customer;
import com.api.carrentalapp.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter converter;

    public CustomerService(CustomerRepository customerRepository,
                           CustomerDtoConverter converter) {
        this.customerRepository = customerRepository;
        this.converter = converter;
    }

    protected Customer findCustomerById(Long id){
        return customerRepository.findById(id)
                .orElseThrow(
                        () -> new CustomerNotFoundException("Customer could not find by id:" + id));
    }

    public CustomerDto getCustomerById(Long customerId) {
        return converter.convertToCustomerDto(findCustomerById(customerId));
    }
}
