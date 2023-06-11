package com.prodapt.orderservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
//spring based java configuration class, with in this class we can create spring bean
public class KafkaTopicConfig {

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    //spring bean for kafka topic
    @Bean
    public NewTopic newTopic(){
        return TopicBuilder.name(topicName).build();
    }
}
