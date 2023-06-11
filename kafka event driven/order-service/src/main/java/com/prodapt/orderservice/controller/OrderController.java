package com.prodapt.orderservice.controller;

import com.prodapt.basedomain.dto.Order;
import com.prodapt.basedomain.dto.OrderEvent;
import com.prodapt.orderservice.kafka.OrderProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    private OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping("/orders")
    public String placeOrder(@RequestBody Order order){
        order.setOrderId(UUID.randomUUID().toString());

        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setStatus("PENDING");
        orderEvent.setMessage("Order status is in pending state!");
        orderEvent.setOrder(order);

        orderProducer.sendMessage(orderEvent);
        return "Order placed successfully.....!!!";
    }
}
