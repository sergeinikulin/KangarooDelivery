package ru.nikulin.test.sheduling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.nikulin.test.kafka.KafkaProducerService;
import ru.nikulin.test.kafka.MyMsg;

import java.util.Date;

@Component
public class Tasks {

    @Autowired
    KafkaProducerService kafkaProducerService;

    @Scheduled(fixedRate = 5000)
    public void sendMessage() {
        MyMsg myMsg = new MyMsg();
        myMsg.setMsg("Hello World - " + new Date());
        myMsg.setId(1);
        kafkaProducerService.send("topic-name", myMsg);
    }
}
