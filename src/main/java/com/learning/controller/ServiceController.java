package com.learning.controller;

import com.learning.entity.TransferRequest;
import com.learning.entity.TransferResponse;
import com.learning.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    TransferService transferService;

    @PostMapping("/transfer")
    @ResponseStatus(HttpStatus.OK)
    public TransferResponse transfer(@RequestBody TransferRequest transferRequest) throws Exception {
        return transferService.transfer(transferRequest.getInputs(), transferRequest.getOutputs());
    }

}
