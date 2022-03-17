package com.learning.service.Impl;

import com.learning.entity.*;
import com.learning.mapper.TxValidationMapper;
import com.learning.mapper.TxoMapper;
import com.learning.service.TransferService;
import com.nh.micro.ext.ExtBeanWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransferServiceImpl implements TransferService {
    @Autowired
    TxoMapper txoMapper;
    @Autowired
    TxValidationMapper txValidationMapper;

    @Override
    public TransferResponse transfer(List<Integer> inputs, List<UnhandledTxo> unhandledOutputs) throws Exception {
        List<Txo> outputs = new ArrayList<>();
        BigDecimal totalInputAmount = new BigDecimal(BigInteger.ZERO);
        BigDecimal totalOutputAmount = new BigDecimal(BigInteger.ZERO);
        for (Integer inputIndex:inputs) {
            Txo inputTxo = txoMapper.queryTxoById(inputIndex);
            if (inputTxo.getIsSpent()!=0) {
                throw new Exception("试图消费已消费的记录!");
            }
            totalInputAmount = totalInputAmount.add(inputTxo.getAmount());
        }
        for (UnhandledTxo unhandledOutputTxo:unhandledOutputs) {
            Txo outputTxo = new Txo();
            outputTxo.setOwner(unhandledOutputTxo.getOwner());
            outputTxo.setAmount(unhandledOutputTxo.getAmount());
            outputs.add(outputTxo);
            totalOutputAmount = totalOutputAmount.add(unhandledOutputTxo.getAmount());
        }
        if (totalInputAmount.compareTo(totalOutputAmount)!=0) {
            throw new Exception("input和output的金额不相等!!");
        }

        for (Integer inputIndex:inputs) {
            txoMapper.updateTxo(txoMapper.queryTxoById(inputIndex));
        }
        for (Txo outputTxo:outputs) {
            outputTxo.setIsSpent(0);
            txoMapper.addTxo(outputTxo);
        }

        // TO DO --validation
        ExtBeanWrapper extBeanWrapper = new ExtBeanWrapper();
        TxContent txContent = new TxContent(inputs, outputs);
        extBeanWrapper.setObj(txContent);
        TxValidation txValidation = new TxValidation("所依赖交易行为hash", extBeanWrapper, "本交易行为hash", null);
        txValidationMapper.addTxValidation(txValidation);

        // TransferResponse
        return new TransferResponse("所依赖交易行为hash", txContent, "本交易行为hash", null);
    }
}
