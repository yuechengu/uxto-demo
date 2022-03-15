package com.learning.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Txo {
    private String txoId;
    private String owner;
    private BigDecimal amount;
    private Integer isSpent;
}
