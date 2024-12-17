package com.api.carrentalapp.model;

import com.api.carrentalapp.model.enums.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private final TransactionType transactionType = TransactionType.INITIAL;
    private BigDecimal amount;
    private LocalDateTime transactionDate;

    //Transaction'dan "ACCOUNT" bilgisine ulaşabilmeliyiz.
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = {CascadeType.ALL})
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    public Transaction(BigDecimal amount, Vehicle vehicle) {
    }
}
