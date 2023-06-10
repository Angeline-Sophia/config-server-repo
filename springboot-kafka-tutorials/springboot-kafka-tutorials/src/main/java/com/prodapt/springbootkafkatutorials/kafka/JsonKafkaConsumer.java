package com.prodapt.springbootkafkatutorials.kafka;

import com.prodapt.springbootkafkatutorials.beans.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    @Value("${spring.kafka.topic-json.name}")
    private String topicJsonName;

    private static final Logger logger = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "${spring.kafka.topic-json.name}",groupId = "myGroup")
    //spring basically give this annotation to subscribes to the topic prodapt
    public void consume(User message){
        logger.info(String.format("Json message received by consumer is : %s",message));
    }
}
