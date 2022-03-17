package com.learning.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nh.micro.ext.ExtBeanWrapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferResponse {
    @JsonProperty(value = "tx-dependency")
    private String txDependency;
    @JsonProperty(value = "tx-content")
    private TxContent txContent;
    private String hashcode;
    @JsonProperty(value = "validated-time")
    private Date validatedTime;
}
