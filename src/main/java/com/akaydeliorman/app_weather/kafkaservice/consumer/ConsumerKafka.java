package com.akaydeliorman.app_weather.kafkaservice.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumerKafka {

    @KafkaListener(
            topics = "info-topics",
            groupId = "id-group"
    )

    public void consume(String info) {
        log.info(info);
    }
    @KafkaListener(
            topics = "error-topics",
            groupId = "id-group"
    )
    public void consumeError(String error) {
        log.error(error);
    }
}
