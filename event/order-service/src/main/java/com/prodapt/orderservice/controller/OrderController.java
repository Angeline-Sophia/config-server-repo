package com.prodapt.orderservice.controller;

import com.prodapt.orderservice.dto.Order;
import com.prodapt.orderservice.dto.OrderEvent;
import com.prodapt.orderservice.publishiser.OrderProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderProducer orderProducer;

    @PostMapping("/orders")
    public String placeOrder(@RequestBody Order order){

        log.info("ctlr--->:{}",order.getOrderName());
        order.setOrderId(UUID.randomUUID().toString());
        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setOrder(order);
        orderEvent.setMessage("PENDING");
        orderEvent.setStatus("Order is in pending status");
        orderProducer.sendMessage(orderEvent);
        return "Order sent to RabbitMQ!!!!";
    }
}
