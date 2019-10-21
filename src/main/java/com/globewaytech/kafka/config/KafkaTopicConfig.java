package com.globewaytech.kafka.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

/**
 * Create kafka topic for the application.
 */
@Configuration
public class KafkaTopicConfig {
    private static final int PARTITION = 1;
    private static final short REPLICATION_FACTOR = 1;

    public static final String TOPIC_NAME = "globewaytech";

    @Value(value = "${kafka.bootstrap.address}")
    private String bootstrapAddress;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String,Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic topic1() {
        return new NewTopic(TOPIC_NAME, PARTITION, REPLICATION_FACTOR);
    }
}
//investments/1218/capital-account/4723
