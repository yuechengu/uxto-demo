package com.learning.mapper;

import com.learning.entity.Txo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TxoMapper {

    List<Txo> queryUtxoList();

    Txo queryUtxoById(int id);

    int addUtxo(Txo txo);

    int updateUtxo(Txo txo);

    int deleteUtxo(String id);

    int queryTxosNumber();
}
