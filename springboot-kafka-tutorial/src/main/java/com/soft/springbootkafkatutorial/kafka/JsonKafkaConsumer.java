package com.soft.springbootkafkatutorial.kafka;

import com.soft.springbootkafkatutorial.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JsonKafkaConsumer {

    @KafkaListener(topics = "JsonGuide", groupId = "myGroup")
    public void Consume(User user){
        log.info("user sent: "+user.toString());
    }
}
