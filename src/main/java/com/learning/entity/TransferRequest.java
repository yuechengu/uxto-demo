package com.learning.entity;

import lombok.Data;

import java.util.List;

@Data
public class TransferRequest {
    private List<String> inputs;

    private List<Txo> outputs;
}
