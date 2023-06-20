package com.prodapt.orderservice.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

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


    //spring bean for queue-order queue
    @Bean
    public Queue orderQueue(){
        return new Queue(orderQueue);
    }

    //spring bean for queue-order queue
    @Bean
    public Queue emailQueue(){
        return new Queue(emailQueue);
    }
    //spring bean for exchange

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(orderExchange);
    }
    //spring bean for binging between exchange and queue using routing key
    @Bean
    public Binding binding(){
        return BindingBuilder.bind(orderQueue()).to(topicExchange()).with(orderkey);
    }

    //spring bean for binging between exchange and queue using routing key
    @Bean
    public Binding bindingEmail(){
        return BindingBuilder.bind(emailQueue()).to(topicExchange()).with(emailkey);
    }

    //message converter
    @Bean
    public MessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }
    //configure RabbitTemplate
    // amqptemplate is an interface which implements rabbittemplate class
    //rabbitmqtemplate uses message converter to cnvert java object to json and json to java onbj
    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }

}
