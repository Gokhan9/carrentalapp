package com.api.carrentalapp.dto;

import com.api.carrentalapp.model.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class TransactionDto {

    private Long id;
    private TransactionType transactionType = TransactionType.INITIAL;
    private BigDecimal amount;
    private LocalDateTime transactionDate;
}

