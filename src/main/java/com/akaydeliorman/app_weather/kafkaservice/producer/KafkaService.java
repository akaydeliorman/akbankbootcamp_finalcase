package com.akaydeliorman.app_weather.kafkaservice.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaService {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public <T> void sendMessage(T record, String topic) {
        // log.info(String.format("%s event => %s", topic, record.toString())); GEREKSİZ
        Message<T> message = MessageBuilder
                .withPayload(record)
                .setHeader(KafkaHeaders.TOPIC, topic)
                .build();
        kafkaTemplate.send(message);
    }
}
