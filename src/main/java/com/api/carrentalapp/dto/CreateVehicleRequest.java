package com.api.carrentalapp.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class CreateVehicleRequest {

    private Long customerId;
    private BigDecimal initialRecord;
}
