package com.learning.service.Impl;

import com.learning.entity.TransferResponse;
import com.learning.entity.Txo;
import com.learning.service.TransferService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferServiceImpl implements TransferService {
    @Override
    public TransferResponse transfer(List<String> inputs, List<Txo> outputs) {

        return null;
    }
}
