package com.globewaytech.kafka.producer;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import static com.globewaytech.kafka.config.KafkaTopicConfig.TOPIC_NAME;

@Log4j2
@Component
public class KafkaMessageProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(final String message) {
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(TOPIC_NAME, message);

        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable throwable) {
                log.error("Error while sending message, " +  message, throwable);
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info("Sent message({}) with offset({})", message, result.getRecordMetadata().offset());
            }
        });
    }
}
