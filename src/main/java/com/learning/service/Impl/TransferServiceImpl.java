package com.learning.service.Impl;

import com.learning.entity.ApplyTxResEntity;
import com.learning.entity.Txo;
import com.learning.mapper.TxValidationMapper;
import com.learning.mapper.TxoMapper;
import com.learning.service.TransferService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class TransferServiceImpl implements TransferService {
    @Autowired
    TxoMapper txoMapper;
    @Autowired
    TxValidationMapper txValidationMapper;

    @Override
    public ApplyTxResEntity transfer(List<String> inputs, List<Txo> outputs) throws ParseException {
        return null;
    }
}
