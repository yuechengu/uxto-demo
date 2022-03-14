package com.learning.service;

import com.learning.entity.ApplyTxResEntity;
import com.learning.entity.Txo;

import java.text.ParseException;
import java.util.List;

public interface TransferService {
    public ApplyTxResEntity transfer(List<String> inputs, List<Txo> outputs) throws ParseException;
}
