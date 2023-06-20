package com.prodapt.stockservice.consumer;

import com.prodapt.stockservice.dto.OrderEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderConsumer {

    @RabbitListener(queues = "${rabbitmq-orderqueue}")
    public void orderConsumer(OrderEvent orderEvent){
    log.info(String.format("Order event received => %s",orderEvent.toString()));

    //save order event data in db
    }
}
