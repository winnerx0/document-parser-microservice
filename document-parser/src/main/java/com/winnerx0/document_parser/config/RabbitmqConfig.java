package com.winnerx0.document_parser.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {

    public static final String QUEUE = "document_parser";

    public static final String EXCHANGE = "document_parser_exchange";

    // the holds the messages that would eb sent the consumer
    @Bean
    public Queue queue(){
        return new Queue(QUEUE);
    }

    // this accepts messages from teh producer and sends them to the appropriate queue using the routing key
    @Bean
    public DirectExchange exchange(){
        return new DirectExchange(EXCHANGE);
    }

    // this binds the queue to the exchange using a possible routing key
    @Bean
    public Binding binding(DirectExchange exchange, Queue queue){
        return BindingBuilder.bind(queue).to(exchange).with("document");
    }
}
