package com.prodapt.employeeservice.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/order")
//@AllArgsConstructor
//@NoArgsConstructor
public class MessageController {

    @Value("${message}")
    private String message;

    @GetMapping("/hi")
    public String hi(){
        return message;
    }
}
