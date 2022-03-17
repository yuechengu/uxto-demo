package com.learning.service;

import com.learning.entity.TransferResponse;
import com.learning.entity.UnhandledTxo;

import java.util.List;

public interface TransferService {
    public TransferResponse transfer(List<Integer> inputs, List<UnhandledTxo> unhandledOutputs) throws Exception;
}
