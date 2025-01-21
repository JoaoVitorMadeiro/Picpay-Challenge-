package com.picpay.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record TransferDto (
        @NotNull
        @DecimalMin("0.01")
        BigDecimal value,
        Long payer,
        Long payee) { }