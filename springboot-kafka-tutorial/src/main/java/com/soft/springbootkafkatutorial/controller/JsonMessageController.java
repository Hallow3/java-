package com.soft.springbootkafkatutorial.controller;

import com.soft.springbootkafkatutorial.kafka.JsonKafkaProducer;
import com.soft.springbootkafkatutorial.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
@Slf4j
public class JsonMessageController {

    @Autowired
    JsonKafkaProducer jsonKafkaProducer;

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user){
        jsonKafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Json Message sent to kafka");
    }
}
