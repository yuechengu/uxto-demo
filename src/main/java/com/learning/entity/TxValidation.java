package com.learning.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TxValidation {
    private String txDependency;
    private JSONObject txContent;
    private String hashcode;
    private Date validatedTime;
}
