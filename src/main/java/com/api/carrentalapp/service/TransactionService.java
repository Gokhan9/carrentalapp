package com.api.carrentalapp.service;

import com.api.carrentalapp.model.Transaction;
import com.api.carrentalapp.model.Vehicle;
import com.api.carrentalapp.repository.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransactionService {

    private static final Logger logger = LoggerFactory.getLogger(TransactionService.class);

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    protected Transaction initiateMoney(final Vehicle vehicle, BigDecimal amount) {
        return transactionRepository.save(new Transaction(amount, vehicle));
    }
}
