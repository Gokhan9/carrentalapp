package com.api.carrentalapp.converter;

import com.api.carrentalapp.dto.TransactionDto;
import com.api.carrentalapp.model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionDtoConverter {

    public TransactionDto convert(Transaction from){
        return new TransactionDto(from.getId(),
                from.getTransactionType(),
                from.getAmount(),
                from.getTransactionDate());
    }
}
