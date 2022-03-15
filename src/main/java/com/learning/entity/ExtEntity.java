package com.learning.entity;

import lombok.Data;

import java.util.List;

@Data
public class ExtEntity {
    private Integer insureNum;
    private String insureType;
    private List contacts;
}
