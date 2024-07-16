package com.kafka.consumer.event;

import com.kafka.consumer.dto.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class KafkaConsumerListener {
    Logger logger = LoggerFactory.getLogger(KafkaConsumerListener.class);
    @KafkaListener(groupId = "group-1", topics = "test-topic")
    public void consume(Customer     customer) {
        logger.info("Consumer received the message: {}", customer.toString());
    }



/*
This used to read old message  however you need to specify partitions
    @KafkaListener(groupId = "group-1", topicPartitions = {@TopicPartition(topic = "kafka", partitions = "0", partitionOffsets = @PartitionOffset(partition = "*", initialOffset = "0"))})
    public void consume(String message) {
        logger.info(" consumer 0 the message {}", message);

    }
*/

}
