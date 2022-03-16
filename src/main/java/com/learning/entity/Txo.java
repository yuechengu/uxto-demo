package com.learning.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Txo {
    private Integer txoId;
    private String owner;
    private BigDecimal amount;
    private Integer isSpent;
}
