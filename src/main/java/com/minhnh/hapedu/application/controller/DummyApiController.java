package com.minhnh.hapedu.application.controller;

import com.minhnh.hapedu.application.response.base.BaseResponse;
import com.minhnh.hapedu.rabbitmq.consumer.RabbitMQSender;
import com.minhnh.hapedu.shared.factory.ResponseFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("open-api/dummy")
public class DummyApiController {
    private final PasswordEncoder passwordEncoder;
    private final RabbitMQSender rabbitMQSender;

    @GetMapping("encode-password")
    public ResponseEntity<BaseResponse<String>> encodePassword(@Param("password") String password) {
        return ResponseFactory.success(passwordEncoder.encode(password));
    }

    //rabbitmq test
    @GetMapping("/sendDirect")
    public String sendDirectMessage(@Param("message") String message) {
        rabbitMQSender.sendDirectMessage(message);
        return "Direct message sent";
    }

    @GetMapping("/sendFanout")
    public String sendFanoutMessage(@Param("message") String message) {
        rabbitMQSender.sendFanoutMessage(message);
        return "Fanout message sent";
    }

    @GetMapping("/sendTopic")
    public String sendTopicMessage(@Param("message") String message) {
        rabbitMQSender.sendTopicMessage("topic.something.key", message);
        return "Topic message sent";
    }

    @GetMapping("/sendHeader")
    public String sendHeaderMessage(@Param("message") String message) {
        rabbitMQSender.sendHeaderMessage(message);
        return "Header message sent";
    }
}
