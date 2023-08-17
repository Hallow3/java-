package com.soft.springbootkafkatutorial.kafka;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "javaguide", groupId = "myGroup")
    public void consume(String message){

      LOGGER.info(String.format("Message received -> %s", message));
      log.info("Message received: "+message);
    }

}
