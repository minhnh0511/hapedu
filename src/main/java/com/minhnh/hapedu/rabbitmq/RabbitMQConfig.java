package com.minhnh.hapedu.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    // Direct Exchange
    public static final String DIRECT_QUEUE_NAME = "directQueue";
    public static final String DIRECT_EXCHANGE_NAME = "directExchange";
    public static final String DIRECT_ROUTING_KEY = "directRoutingKey";

    // Fanout Exchange
    public static final String FANOUT_QUEUE_NAME = "fanoutQueue";
    public static final String FANOUT_EXCHANGE_NAME = "fanoutExchange";

    // Topic Exchange
    public static final String TOPIC_EXCHANGE_NAME = "topicExchange";
    public static final String SHARP_TOPIC_QUEUE_NAME = "sharpTopic";
    public static final String DOT_TOPIC_QUEUE_NAME = "dotTopic";
    public static final String SHARP_TOPIC_ROUTING_KEY = "topic.#";
    public static final String DOT_TOPIC_ROUTING_KEY = "topic.*.key";

    // Header Exchange
    public static final String HEADER_QUEUE_NAME = "headerQueue";
    public static final String HEADER_EXCHANGE_NAME = "headerExchange";

    // Direct Exchange
    @Bean
    Queue directQueue() {
        return new Queue(DIRECT_QUEUE_NAME, false);
    }

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange(DIRECT_EXCHANGE_NAME);
    }

    @Bean
    Binding directBinding(Queue directQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueue).to(directExchange).with(DIRECT_ROUTING_KEY);
    }

    // Fanout Exchange
    @Bean
    Queue fanoutQueue() {
        return new Queue(FANOUT_QUEUE_NAME, false);
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange(FANOUT_EXCHANGE_NAME);
    }

    @Bean
    Binding fanoutBinding(Queue fanoutQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueue).to(fanoutExchange);
    }

    // Topic Exchange
    @Bean
    Queue sharpTopicQueue() {
        return new Queue(SHARP_TOPIC_QUEUE_NAME, false);
    }

    @Bean
    Queue dotTopicQueue() {
        return new Queue(DOT_TOPIC_QUEUE_NAME, false);
    }

    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_EXCHANGE_NAME);
    }

    @Bean
    Binding topicBindingSharp(Queue sharpTopicQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(sharpTopicQueue).to(topicExchange).with(SHARP_TOPIC_ROUTING_KEY);
    }

    @Bean
    Binding topicBindingDot(Queue dotTopicQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(dotTopicQueue).to(topicExchange).with(DOT_TOPIC_ROUTING_KEY);
    }

    // Header Exchange
    @Bean
    Queue headerQueue() {
        return new Queue(HEADER_QUEUE_NAME, false);
    }

    @Bean
    HeadersExchange headerExchange() {
        return new HeadersExchange(HEADER_EXCHANGE_NAME);
    }

    @Bean
    Binding headerBinding(Queue headerQueue, HeadersExchange headerExchange) {
        return BindingBuilder.bind(headerQueue).to(headerExchange).where("headerKey").matches("headerValue");
    }
}
