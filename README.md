# spring-kafka-play
Spring Boot and Kafka

### Introduction
Apache Kafka is a distributed and fault-tolerant stream processing system. Spring Kafka brings the simple and typical Spring template programming model with a KafkaTemplate and Message driven POJOs via @kafkaListener annotation.    
This sample code gives you how to produce and consume message using Kafka.    
The application also help us to create and configure topics used for publishing and consuming the message.

### How to test
Start Spring boot application

* Use postman or similar REST API tool to POST a http request "Hello-kafka" http://localhost:8080/api/producer?message=Hello-Kafka
* And see the console log that kafka topic has published and consumed a message which was posted via http POST request


### References
[Install Kafka](https://kafka.apache.org/quickstart)   
[Create Kafka Topic](https://kafka.apache.org/quickstart#quickstart_createtopic)
