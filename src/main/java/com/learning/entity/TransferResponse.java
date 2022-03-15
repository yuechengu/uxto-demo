package com.learning.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class TransferResponse {
    @JsonProperty(value = "is-spent")
    private List<String> isSpent;

    private List<Txo> txos;
}
