package com.kafka.producer.controller;


import com.kafka.producer.dto.Customer;
import com.kafka.producer.service.KafkaMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/event")
public class EventController {


    @Autowired
    private KafkaMessagePublisher kafkaMessagePublisher;


    @PostMapping("")
    public ResponseEntity<?> publish(@RequestBody Customer customer ){
        try {
            kafkaMessagePublisher.sendEventToTopic(customer);
            return ResponseEntity.ok("Message Published Successfully");
        }catch (Exception e){
            return ResponseEntity.status(500).build();

        }
    }
}
