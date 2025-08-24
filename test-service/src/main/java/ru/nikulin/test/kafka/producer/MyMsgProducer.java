package ru.nikulin.test.kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.nikulin.test.kafka.messages.MyMsg;

@Service
@Slf4j
public class MyMsgProducer {

    @Autowired
    KafkaTemplate<String, MyMsg> kafkaTemplate;

    public void send(String topicName, MyMsg value) {
        var future = kafkaTemplate.send(topicName, value);
        future.whenComplete((sendResult, exception) -> {
            if (exception != null) {
                future.completeExceptionally(exception);
            } else {
                future.complete(sendResult);
            }
            log.info(String.format("Task status send to Kafka topic : %s, Object: ", topicName)+ value);
        });
    }

    //use partition
    public void send(String topicName, Integer partition, Integer key, MyMsg value) {
        var future = kafkaTemplate.send(topicName, partition, String.valueOf(key), value);
        future.whenComplete((sendResult, exception) -> {
            if (exception != null) {
                future.completeExceptionally(exception);
            } else {
                future.complete(sendResult);
            }
            log.info(String.format("Task status send to Kafka topic : %s, Object: ", topicName)+ value);
        });
    }
}
