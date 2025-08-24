package ru.nikulin.test.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumerService {

    @KafkaListener(
            topicPartitions = @TopicPartition(
                    topic = "topic-name",
                    partitions = {"1"}  // слушаем только партицию 1
            ),
            groupId = "test-service3"
    )
    public void listenToSpecificPartitions(
            @Header(KafkaHeaders.RECEIVED_PARTITION) int partition,
            @Payload MyMsg myMsg) {

        System.out.println("Message from partition " + partition + ": " + myMsg.getMsg());
    }

}
