package com.prodapt.orderservice.publishiser;

import com.prodapt.orderservice.dto.OrderEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderProducer {

    @Value("${rabbitmq-orderqueue}")
    private String orderQueue;
    @Value("${rabbitmq-orderexchange}")
    private String orderExchange;
    @Value("${rabbitmq-orderroutingkay}")
    private String orderkey;

    @Value("${rabbitmq-emailqueue}")
    private String emailQueue;
    @Value("${rabbitmq-emailroutingkay}")
    private String emailkey;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(OrderEvent orderEvent){
        //send order event to order queue
        log.info(String.format("Order event sent to RabbitMQ %s",orderEvent));
        rabbitTemplate.convertAndSend(orderExchange,orderkey,orderEvent);

        //send an order event to email queue
        log.info(String.format("Order event sent to RabbitMQ for email queue %s",orderEvent));
        rabbitTemplate.convertAndSend(orderExchange,emailkey,orderEvent);
    }



}
