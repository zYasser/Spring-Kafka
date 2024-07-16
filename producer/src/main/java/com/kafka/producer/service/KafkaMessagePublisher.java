package com.kafka.producer.service;


import com.kafka.producer.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher {
    @Autowired
    private KafkaTemplate<String ,Object> kafkaTemplate;

    public void sendEventToTopic(Customer customer){
        CompletableFuture<SendResult<String ,Object>> future=kafkaTemplate.send("kafka2" , customer);
        future.whenComplete((result,ex)->{
           if(ex==null){
               System.out.println("Sent Message:[" + customer.toString() + "] with Offset=["+result.getRecordMetadata().offset()+"]" + "Partition :" + result.getRecordMetadata().partition());


           }else{
               System.out.println("Unable to send message=[" + customer.toString()+"] dut to : "+ ex.getMessage());
           }
        });

    }
//    public void sendEventToTopic(Customer customer){
//        CompletableFuture<SendResult<String ,Object>> future=kafkaTemplate.send("kafka" , customer);
//        future.whenComplete((result,ex)->{
//            if(ex==null){
//                System.out.println("Sent Message:[" + customer.toString() + "] with Offset=["+result.getRecordMetadata().offset()+"]" + "Partition :" + result.getRecordMetadata().partition());
//
//
//            }else{
//                System.out.println("Unable to send message=[" + customer.toString()+"] dut to : "+ ex.getMessage());
//            }
//        });
//
//    }


}
