package com.humor.kafka.demo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * create by humor
 * @date 2018/8/8 下午5:55
 */

@Aspect
@Slf4j
@Component
public class LoggerAspect {

@Pointcut("execution(* com.humor.kafka.demo.ProducerController.*(..))")
    public void kafkaDemo(){}


    @Before("kafkaDemo()")
    public void before(){
        log.info("***producer message*** 发送消息到broker");
    }

}
