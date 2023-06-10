package com.prodapt.departmentservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RefreshScope
@RestController
@RequestMapping("/message")
//@AllArgsConstructor
//@NoArgsConstructor
@Slf4j
public class MessageController {



    @Value("${message}")
    private String message;

    @GetMapping("/hi")
    public String hi(){
    log.info(message);
        return message;
    }
}
