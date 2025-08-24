package ru.nikulin.test.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
* Автоматическое создание топика при старте приложения
* Если топик уже существует, настройки не перезаписываются (Kafka игнорирует дублирующиеся создания)
*/

@Configuration
public class KafkaTopics {

    @Bean
    public NewTopic myMsgTopic() {
        return TopicBuilder.name("topic-name")
                .partitions(2)
                .replicas(1)
                .build();
    }

}
