package com.learning.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

// ※目前这个返回体被弃用
@Data
public class TransferResponse {
    @JsonProperty(value = "is-spent")
    private List<String> isSpent;

    private List<Txo> txos;
}
