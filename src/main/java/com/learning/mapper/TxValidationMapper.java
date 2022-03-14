package com.learning.mapper;

import com.learning.entity.TxValidation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TxValidationMapper {

    List<TxValidation> queryTxValidationList();

    TxValidation queryTxValidationByHashcode(String hashcode);

    int addTxValidation(TxValidation txValidation);

    int updateTxValidation(TxValidation txValidation);

    int deleteTxValidation(String id);
}
