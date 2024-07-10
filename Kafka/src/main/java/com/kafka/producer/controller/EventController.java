package com.kafka.producer.controller;


import com.kafka.producer.service.KafkaMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
public class EventController {


    @Autowired
    private KafkaMessagePublisher kafkaMessagePublisher;


    @PostMapping("/{message}")
    public ResponseEntity<?> publish(@PathVariable String message ){
        try {
            kafkaMessagePublisher.sendMessageToTopic(message);
            return ResponseEntity.ok("Message Published Successfully");
        }catch (Exception e){
            return ResponseEntity.status(500).build();

        }
    }
}
