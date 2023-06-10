package com.example.restfulwebservice.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@Configuration
@RequestMapping("/products")
public class ProductController {

    @GetMapping
    public String getProducts() {
        return "hi";
    }
}
