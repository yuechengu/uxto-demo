package com.learning.service;

import com.learning.entity.TransferResponse;
import com.learning.entity.Txo;

import java.util.List;

public interface TransferService {
    public TransferResponse transfer(List<String> inputs, List<Txo> outputs);
}
