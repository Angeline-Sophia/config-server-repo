package com.prodapt.springbootkafkatutorials.controller;

import com.prodapt.springbootkafkatutorials.beans.User;
import com.prodapt.springbootkafkatutorials.kafka.JsonKafkaProducer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/json/kafka")
public class JsonMessageController {

    private JsonKafkaProducer jsonKafkaProducer;

    public JsonMessageController(JsonKafkaProducer jsonKafkaProducer) {
        this.jsonKafkaProducer = jsonKafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user){
        jsonKafkaProducer.sendMessage(user);
        return new ResponseEntity("Java object converted to json byte[]", HttpStatus.CREATED);
    }
}
