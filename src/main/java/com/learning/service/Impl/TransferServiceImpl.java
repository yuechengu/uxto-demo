package com.learning.service.Impl;

import com.learning.entity.TransferResponse;
import com.learning.entity.TxContent;
import com.learning.entity.TxValidation;
import com.learning.entity.Txo;
import com.learning.mapper.TxValidationMapper;
import com.learning.mapper.TxoMapper;
import com.learning.service.TransferService;
import com.nh.micro.ext.ExtBeanWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Service
public class TransferServiceImpl implements TransferService {
    @Autowired
    TxoMapper txoMapper;
    @Autowired
    TxValidationMapper txValidationMapper;

    @Override
    public TxValidation transfer(List<Integer> inputs, List<Txo> outputs) throws Exception {
        BigDecimal totalInputAmount = new BigDecimal(BigInteger.ZERO);
        BigDecimal totalOutputAmount = new BigDecimal(BigInteger.ZERO);
        for (Integer inputIndex:inputs) {
            Txo inputTxo = txoMapper.queryTxoById(inputIndex);
            if (inputTxo.getIsSpent()!=0) {
                throw new Exception("试图消费已消费的记录!");
            }
            totalInputAmount = totalInputAmount.add(inputTxo.getAmount());
        }
        for (Txo outputTxo:outputs) {
            totalOutputAmount = totalOutputAmount.add(outputTxo.getAmount());
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
        return txValidation;
    }
}
