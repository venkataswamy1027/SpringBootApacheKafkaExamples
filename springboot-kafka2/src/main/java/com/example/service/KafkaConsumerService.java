package com.example.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "kafka-topic", groupId = "group-id")
    public void listen(String message) {
        System.out.println("Received Messasge : " + message);
    }
}
