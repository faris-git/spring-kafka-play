package com.globewaytech.kafka.consumer;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import static com.globewaytech.kafka.config.KafkaTopicConfig.TOPIC_NAME;

@Log4j2
@Component
public class KafkaMessageConsumer {

    //@KafkaListener(topics = TOPIC_NAME)
    public void consumeMessage(final String message) {
        log.info("Message consumed from kafka:: {}", message);
    }
}
