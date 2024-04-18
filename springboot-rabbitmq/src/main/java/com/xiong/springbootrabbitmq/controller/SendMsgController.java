package com.xiong.springbootrabbitmq.controller;

import com.xiong.springbootrabbitmq.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.nio.cs.UTF_32;

import java.io.UnsupportedEncodingException;
import java.util.Date;

@Slf4j
@RequestMapping("ttl")
@RestController
public class SendMsgController {
    @Autowired
    public RabbitTemplate rabbitTemplate;

    @GetMapping("sendMsg/{message}")
    public void sendMsg(@PathVariable String message) throws UnsupportedEncodingException {
        log.info("当前时间： {},发送一条信息给两个 TTL 队列:{}", DateUtils.getNowTime(), message);
        rabbitTemplate.convertAndSend("X", "XA", "message from  ttl is 10S queue: " + message);
        rabbitTemplate.convertAndSend("X", "XB", "message from  ttl is 40S queue: " + message);
    }

    @GetMapping("sendExpirationMsg/{message}/{ttlTime}")
    public void sendMsg(@PathVariable String message,@PathVariable String ttlTime) {
        rabbitTemplate.convertAndSend("X", "XC", message, correlationData ->{
            correlationData.getMessageProperties().setExpiration(ttlTime);
            return correlationData;
        });
        log.info("当前时间： {},发送一条时长{}毫秒 TTL 信息给队列 C:{}", DateUtils.getNowTime(),ttlTime, message);
    }
}
