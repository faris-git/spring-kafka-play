package com.globewaytech.kafka.controller;

import com.globewaytech.kafka.producer.KafkaMessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping("/api/producer")
public class KafkaMessageController {

    @Autowired
    private KafkaMessageProducer kafkaMessageProducer;

    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> postMessage(@RequestParam("message") String message) {
        kafkaMessageProducer.sendMessage(message);

        return ResponseEntity.ok().build();
    }
}
