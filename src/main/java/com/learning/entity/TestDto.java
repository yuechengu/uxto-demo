package com.learning.entity;

import com.nh.micro.ext.ExtBeanWrapper;
import lombok.Data;

import java.util.Date;

@Data
public class TestDto {
    private Integer id;
    private String metaKey;
    private String metaName;
    private String metaType;
    private Date createTime;
    private ExtBeanWrapper extcol;
}
