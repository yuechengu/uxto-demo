package com.learning.entity;

import com.nh.micro.ext.ExtBeanWrapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TxValidation {
    private String txDependency;
    private ExtBeanWrapper txContent;
    private String hashcode;
    private Date validatedTime;
}
