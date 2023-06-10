package com.prodapt.springbootkafkatutorials.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
// annotating to @Service to make this class as spring bean
public class KafkaConsumer {

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    @Value("${spring.kafka.topic-json.name}")
    private String topicJsonName;

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "${spring.kafka.topic.name}",groupId = "myGroup")
    //spring basically give this annotation to subscribes to the topic prodapt
    public void consume(String message){
        logger.info(String.format("Message consumer from kafka topic "+"prodapt for the kafka consumer Group Id :'myGroup' and \n the message sent from the consumer is : %s",message));
    }
}
