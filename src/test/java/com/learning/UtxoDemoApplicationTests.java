package com.learning;

import com.learning.controller.ServiceController;
import com.learning.entity.*;
import com.learning.mapper.MicroTestMapper;
import com.learning.mapper.TxValidationMapper;
import com.learning.mapper.TxoMapper;
import com.learning.service.TransferService;
import com.nh.micro.ext.ExtBeanWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class UtxoDemoApplicationTests {

    @Autowired
    MicroTestMapper microTestMapper;
    @Test
    public void testCreateJson(){
        // 具体的业务实体类
        TestDto testDto=new TestDto();
        testDto.setId(1);
        testDto.setMetaName("n1");
        // json对象转换的目标对象
        ExtBeanWrapper extBeanWrapper=new ExtBeanWrapper();
        // json扩展字段业务实体类 --ex: 保险订单
        ExtEntity extEntity=new ExtEntity();
        extEntity.setInsureNum(123123);
        extEntity.setInsureType("car");
        List contacts=new ArrayList();
        contacts.add("13512345678");
        contacts.add("13512345679");
        extEntity.setContacts(contacts);
        // 在json对象转换的目标对象extBeanWrapper中传入扩展字段业务实体类
        extBeanWrapper.setObj(extEntity);
        // 具体的业务实体类testDto中传入json对象转换的目标对象extBeanWrapper
        testDto.setExtcol(extBeanWrapper);
        // 在表中插入一条新业务数据
        microTestMapper.createJson(testDto);
    }

    @Autowired
    TxValidationMapper txValidationMapper;
    @Test
    public void testCreateTxValidation() {
        // 具体的业务实体类
        TxValidation txValidation = new TxValidation();
        txValidation.setTxDependency("所依赖行为hash#1");
        txValidation.setHashcode("本行为hash#2");
        // json对象转换的目标对象
        ExtBeanWrapper extBeanWrapper = new ExtBeanWrapper();
        // json扩展字段业务实体类 --ex: 单次交易行为内容txContent
        TxContent txContent = new TxContent();
        List<Integer> inputs = new ArrayList<Integer>(){
            {
                this.add(1);
                this.add(2);
                this.add(3);
            }
        };
        List<Txo> outputs = new ArrayList<Txo>(){
            {
                this.add(new Txo(4, "张三", new BigDecimal("50"), 0));
                this.add(new Txo(5, "李四", new BigDecimal("150"), 0));
            }
        };
        txContent.setInputs(inputs);
        txContent.setOutputs(outputs);
        // 在json对象转换的目标对象extBeanWrapper中传入扩展字段业务实体类txContent
        extBeanWrapper.setObj(txContent);
        // 具体的业务实体类txValidation中传入json对象转换的目标对象extBeanWrapper
        txValidation.setTxContent(extBeanWrapper);
        // 在表中插入一条新业务数据
        txValidationMapper.addTxValidation(txValidation);
    }

    @Autowired
    TxoMapper txoMapper;
    @Test
    public void testCreateTxo() {
        txoMapper.addTxo(new Txo(null, "张三", new BigDecimal("1000"), 0));
    }

    @Autowired
    ServiceController serviceController;
    @Test
    public void testTransferService() throws Exception {
        List<Integer> inputs = new ArrayList<Integer>(){
            {
//                this.add(1);
                this.add(2);
                this.add(3);
            }
        };
        List<Txo> outputs = new ArrayList<Txo>(){
            {
                this.add(new Txo(null, "张三", new BigDecimal("1"), null));
                this.add(new Txo(null, "吴振宇", new BigDecimal("999"), null));
            }
        };
        TransferRequest transferRequest = new TransferRequest(inputs, outputs);
        serviceController.transfer(transferRequest);
    }

    // ※roll back
    @Test
    public void rollBack() {
        txoMapper.deleteTxo(2);
        txoMapper.deleteTxo(3);
        txValidationMapper.deleteTxValidation("本交易行为hash");
    }

}
