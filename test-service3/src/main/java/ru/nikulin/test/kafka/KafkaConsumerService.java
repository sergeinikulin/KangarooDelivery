package ru.nikulin.test.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumerService {

    @KafkaListener(topics = {"topic-name"}, groupId = "test-service3")
    public void consume(MyMsg myMsg) {
        System.out.println(String.format("сообщение прочитано: " + myMsg));
    }
}
