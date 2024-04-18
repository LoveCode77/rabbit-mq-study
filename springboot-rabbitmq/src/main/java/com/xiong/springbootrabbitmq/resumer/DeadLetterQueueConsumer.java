package com.xiong.springbootrabbitmq.resumer;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.xiong.springbootrabbitmq.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListeners;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

@Slf4j
@Component
public class DeadLetterQueueConsumer {
    @RabbitListener(queues = "QD")
    public void receive(Message message, Channel channel) throws IOException{
        String msg=new String(message.getBody());
        System.out.println(msg);
        //log.info("当前时间： {},收到死信队列信息{}", new Date().toString(), msg);
        log.info("当前时间： {},收到死信队列信息{}", DateUtils.getNowTime(), msg);

    }
}
