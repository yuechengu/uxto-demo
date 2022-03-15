package com.learning.mapper;

import com.learning.entity.TestDto;
import com.learning.entity.TxValidation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TxValidationMapper {
    // 查询所有验证记录
    List<TxValidation> queryTxValidationList();
    // 通过验证记录的哈希值查询单条记录
    TxValidation queryTxValidationByHashcode(String hashcode);
    // 插入单条验证记录
    int addTxValidation(TxValidation txValidation);
    // 通过验证记录的哈希值删除单条记录
    int deleteTxValidation(String hashcode);

    // ※动态局部更新json字段txContent
    public void updateJson(TxValidation txValidation);
    // ※更新指定json字段txContent中的子元素
    public void updateJsonSubcol(TxValidation txValidation);
    // ※整体更新json字段txContent
    public void updateJsonAll(TxValidation txValidation);
}
