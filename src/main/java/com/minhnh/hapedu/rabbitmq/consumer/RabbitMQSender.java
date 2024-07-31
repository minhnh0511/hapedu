package com.minhnh.hapedu.rabbitmq.consumer;

import com.minhnh.hapedu.rabbitmq.RabbitMQConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitMQSender {
    private final RabbitTemplate rabbitTemplate;

    public void sendDirectMessage(String message) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.DIRECT_EXCHANGE_NAME, RabbitMQConfig.DIRECT_ROUTING_KEY, message);
    }

    public void sendFanoutMessage(String message) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.FANOUT_EXCHANGE_NAME, "", message);
    }

    public void sendTopicMessage(String routingKey, String message) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.TOPIC_EXCHANGE_NAME, routingKey, message);
    }

    public void sendHeaderMessage(String message) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.HEADER_EXCHANGE_NAME, "", message, m -> {
            m.getMessageProperties().setHeader("headerKey", "headerValue");
            return m;
        });
    }
}
