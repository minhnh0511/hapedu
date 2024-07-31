package com.minhnh.hapedu.rabbitmq.producer;

import com.minhnh.hapedu.rabbitmq.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQReceiver {
    @RabbitListener(queues = RabbitMQConfig.DIRECT_QUEUE_NAME)
    public String receiveDirectMessage(String message) {
        return String.format("Direct message: %s", message);
    }

    @RabbitListener(queues = RabbitMQConfig.FANOUT_QUEUE_NAME)
    public String receiveFanoutMessage(String message) {
        System.out.printf("Fanout message: %s%n", message);
        return String.format("Fanout message: %s", message);
    }

    @RabbitListener(queues = RabbitMQConfig.SHARP_TOPIC_QUEUE_NAME)
    public String receiveSharpTopicMessage(String message) {
        return String.format("Sharp Topic message: %s", message);
    }

    @RabbitListener(queues = RabbitMQConfig.DOT_TOPIC_QUEUE_NAME)
    public String receiveDotTopicMessage(String message) {
        return String.format("Dot Topic message: %s", message);
    }

    @RabbitListener(queues = RabbitMQConfig.HEADER_QUEUE_NAME)
    public String receiveHeaderMessage(String message) {
        return String.format("Header message: %s", message);
    }
}
