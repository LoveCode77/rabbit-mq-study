package com.xiong.rabbitmq.demo_unfair_distribute;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.xiong.rabbitmq.utils.RabbitMqUtils;
import com.xiong.rabbitmq.utils.SleepUtils;

public class Work02 {
    private static final String ACK_QUEUE_NAME="ack_queue3";
    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        int prefetchCount=1;
        channel.basicQos(prefetchCount);
        System.out.println("C2 等待接收消息处理时间较长");
//消息消费的时候如何处理消息
        DeliverCallback deliverCallback=(consumerTag, delivery)->{
            String message= new String(delivery.getBody());
            SleepUtils.sleep(30);
            System.out.println("接收到消息:"+message);
/**
 * 1.消息标记 tag
 * 2.是否批量应答未应答消息
 */
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(),false);
        };
//采用手动应答
        boolean autoAck=false;
        channel.basicConsume(ACK_QUEUE_NAME,autoAck,deliverCallback,(consumerTag)->{
            System.out.println(consumerTag+"消费者取消消费接口回调逻辑");
        });
    }
}
