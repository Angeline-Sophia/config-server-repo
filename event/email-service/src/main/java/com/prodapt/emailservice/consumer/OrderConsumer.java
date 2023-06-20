package com.prodapt.emailservice.consumer;

import com.prodapt.emailservice.dto.OrderEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderConsumer {

    @RabbitListener(queues = "${rabbitmq-emailqueue}")
    public void consume(OrderEvent orderEvent){
        log.info(String.format("Order event is received by email queue -> %s",orderEvent.toString()));

        //email service needs to send email to the customer
    }
}
