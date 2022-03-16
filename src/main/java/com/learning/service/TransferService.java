package com.learning.service;

import com.learning.entity.TransferResponse;
import com.learning.entity.TxValidation;
import com.learning.entity.Txo;

import java.util.List;

public interface TransferService {
    public TxValidation transfer(List<Integer> inputs, List<Txo> outputs) throws Exception;
}
