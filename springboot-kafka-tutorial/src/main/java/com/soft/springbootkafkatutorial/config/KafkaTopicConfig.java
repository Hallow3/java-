package com.soft.springbootkafkatutorial.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    //lets create the topics!
    @Bean
    public NewTopic javaGuideTopic(){
        return TopicBuilder.name("javaguide")
                //in how mani partitions (events) do you want to split this topic
                //.partitions(10)
                .build();

    }

    //let create another topic only for Json Message
    @Bean
    public NewTopic JsonTopic(){
        return TopicBuilder.name("JsonGuide")
                .build();
    }
}
