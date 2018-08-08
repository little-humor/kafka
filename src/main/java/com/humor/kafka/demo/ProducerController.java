package com.humor.kafka.demo;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * create by humor
 * @date 2018/8/8 下午4:07
 */
@Slf4j
@RestController
@RequestMapping("/producer")
public class ProducerController {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @PostMapping("send.do")
    public void send(String topic,String key,String value){
        kafkaTemplate.send(topic,key,value);
    }

    @PostMapping("sendSync.do")
    public void sendSync(String topic,String key,String value){
        ProducerRecord<String,String> record = new ProducerRecord<String,String>(topic,key,value);
        try {
            kafkaTemplate.send(record).get(10000,TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("sendAsync.do")
    public void sendAsync(String topic,String key,String value){
        kafkaTemplate.send(topic,key,value).addCallback(new MessageConfirmCallBack());
    }

}
