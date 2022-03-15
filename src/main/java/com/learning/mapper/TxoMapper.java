package com.learning.mapper;

import com.learning.entity.Txo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TxoMapper {

    List<Txo> queryTxoList();

    Txo queryTxoById(String id);

    int addTxo(Txo txo);

    int deleteTxo(String id);

    int queryTxosNumber();
}
