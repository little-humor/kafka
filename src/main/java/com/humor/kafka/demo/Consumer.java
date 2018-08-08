package com.humor.kafka.demo;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * create by humor
 * @date 2018/8/1 下午5:02
 */
@Slf4j
@Component
public class Consumer {

    @KafkaListener(topics = {"living"},groupId = "xx")
    public void receive(ConsumerRecord<String,String> record){
        log.warn("***consumer message*** topic-{},partition-{},key-{},value-{}",record.topic(),record.partition(),record.key(),record.value());
    }

}
