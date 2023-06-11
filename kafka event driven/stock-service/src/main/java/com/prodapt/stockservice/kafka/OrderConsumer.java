package com.prodapt.stockservice.kafka;

//import com.prodapt.basedomain.dto.OrderEvent;
import com.prodapt.basedomain.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private static final Logger logger = LoggerFactory.getLogger(OrderConsumer.class);

    @KafkaListener(topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}")
    public void consume(OrderEvent orderEvent){
    logger.info(String.format("Order event received by stock service: %s",orderEvent));

    //save the order event in to the database
    }
}
