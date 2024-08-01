package com.minhnh.hapedu.rabbitmq.producer;

import com.minhnh.hapedu.rabbitmq.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQReceiver {
    @RabbitListener(queues = RabbitMQConfig.DIRECT_QUEUE_NAME)
    public void receiveDirectMessage(String message) {
        String res = String.format("Direct message: %s", message);
        System.out.println(res);
    }

    @RabbitListener(queues = RabbitMQConfig.FANOUT_QUEUE_NAME)
    public void receiveFanoutMessage(String message) {
        String res = String.format("Fanout message: %s%n", message);
        System.out.println(res);
    }

    @RabbitListener(queues = RabbitMQConfig.SHARP_TOPIC_QUEUE_NAME)
    public void receiveSharpTopicMessage(String message) {
        String res = String.format("Sharp Topic message: %s", message);
        System.out.println(res);
    }

    @RabbitListener(queues = RabbitMQConfig.DOT_TOPIC_QUEUE_NAME)
    public void receiveDotTopicMessage(String message) {
        String res = String.format("Dot Topic message: %s", message);
        System.out.println(res);
    }

    @RabbitListener(queues = RabbitMQConfig.HEADER_QUEUE_NAME)
    public void receiveHeaderMessage(String message) {
        String res = String.format("Header message: %s", message);
        System.out.println(res);
    }
}
