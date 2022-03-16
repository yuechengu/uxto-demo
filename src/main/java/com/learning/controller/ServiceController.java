package com.learning.controller;

import com.learning.entity.TransferRequest;
import com.learning.entity.TransferResponse;
import com.learning.entity.TxValidation;
import com.learning.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    TransferService transferService;

    @RequestMapping("/transfer")
    @ResponseStatus(HttpStatus.OK)
    public TxValidation transfer(@RequestBody TransferRequest transferRequest) throws Exception {
        return transferService.transfer(transferRequest.getInputs(), transferRequest.getOutputs());
    }

}
