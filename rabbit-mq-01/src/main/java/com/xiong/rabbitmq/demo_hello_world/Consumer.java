package com.xiong.rabbitmq.demo_hello_world;

import com.rabbitmq.client.*;

public class Consumer {
    private final static String QUEUE_NAME = "hello1";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("1.15.92.207");
        factory.setUsername("admin");
        factory.setPassword("123456");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        System.out.println("�ȴ�������Ϣ....");
//���͵���Ϣ��ν������ѵĽӿڻص�
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody());
            System.out.println(message);
        };
//ȡ�����ѵ�һ���ص��ӿ� �������ѵ�ʱ����б�ɾ������
        CancelCallback cancelCallback = (consumerTag) -> {
            System.out.println("��Ϣ���ѱ��ж�");
        };
        /**
         * ������������Ϣ
         * 1.�����ĸ�����
         * 2.���ѳɹ�֮���Ƿ�Ҫ�Զ�Ӧ�� true �����Զ�Ӧ�� false �ֶ�Ӧ��
         * 3.������δ�ɹ����ѵĻص�
         */
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, cancelCallback);
    }
}