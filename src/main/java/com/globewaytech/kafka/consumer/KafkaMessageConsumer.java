package com.globewaytech.kafka.consumer;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static com.globewaytech.kafka.config.KafkaTopicConfig.TOPIC_NAME;

@Log4j2
@Component
public class KafkaMessageConsumer {

    @KafkaListener(topics = TOPIC_NAME, groupId = "group1")
    public void consumeMessage(@Payload final String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        log.info("Message consumed from kafka:: {} from partition {}", message, partition);
    }
}
