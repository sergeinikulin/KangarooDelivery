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

//    @Scheduled(fixedRate = 5000)
//    public void sendMessage() {
//        MyMsg myMsg = new MyMsg();
//        myMsg.setMsg("Hello World - " + new Date());
//        myMsg.setId(1);
//        kafkaProducerService.send("topic-name", myMsg);
//    }

    @Scheduled(fixedRate = 5000)
    public void sendMessageByPartition() {
        MyMsg myMsg = new MyMsg();
        myMsg.setMsg("partition - 0");
        myMsg.setId(1);
        kafkaProducerService.send("topic-name", 0, 0, myMsg);

        MyMsg myMsg2 = new MyMsg();
        myMsg2.setMsg("partition - 1");
        myMsg2.setId(1);
        kafkaProducerService.send("topic-name", 1, 0, myMsg2);
    }
}
