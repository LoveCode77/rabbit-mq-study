package com.xiong.rabbitmq.demo_queues_durable;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;
import com.xiong.rabbitmq.utils.RabbitMqUtils;

import java.util.Scanner;

public class Task01 {
    private static final String QUEUE_NAME = "ack_queue1";

    public static void main(String[] args) throws Exception {
        try (Channel channel = RabbitMqUtils.getChannel();) {
            boolean durable=true;
            channel.queueDeclare(QUEUE_NAME, durable, false, false, null);
//从控制台当中接受信息
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                String message = scanner.next();
                channel.basicPublish("", QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
                System.out.println("发送消息完成:" + message);
            }
        }
    }
}
