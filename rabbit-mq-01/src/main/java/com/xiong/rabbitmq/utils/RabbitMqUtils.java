package com.xiong.rabbitmq.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitMqUtils {
    //得到一个连接的 channel
    public static Channel getChannel() throws Exception{
//创建一个连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("1.15.92.207");
        factory.setUsername("admin");
        factory.setPassword("123456");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        return channel;
    }
}
