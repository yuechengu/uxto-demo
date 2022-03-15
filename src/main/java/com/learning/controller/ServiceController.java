package com.learning.controller;

import com.learning.entity.TransferResponse;
import com.learning.entity.Txo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/service")
public class ServiceController {

    @RequestMapping("/transfer")
    @ResponseStatus(HttpStatus.OK)
    public TransferResponse transfer(@RequestBody Map<String, Object> map) {
        List<String> inputs = (List<String>) map.get("inputs");
        List<Txo> outputs = (List<Txo>) map.get("outputs");//从前台取到的是字符串，怎么转成java对象？

        return null;
    }

}
