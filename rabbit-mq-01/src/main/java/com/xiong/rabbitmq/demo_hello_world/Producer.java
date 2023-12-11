package com.xiong.rabbitmq.demo_hello_world;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Producer {
    private final static String QUEUE_NAME = "hello1";

    public static void main(String[] args) throws Exception {
//����һ�����ӹ���
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("1.15.92.207");
        factory.setUsername("admin");
        factory.setPassword("123456");
//channel ʵ�����Զ� close �ӿ� �Զ��ر� ����Ҫ��ʾ�ر�
        try (
                Connection connection = factory.newConnection(); Channel channel =
                connection.createChannel()) {
/**
 * ����һ������
 * 1.��������
 * 2.�����������Ϣ�Ƿ�־û� Ĭ����Ϣ�洢���ڴ���
 * 3.�ö����Ƿ�ֻ��һ�������߽������� �Ƿ���й��� true ���Զ������������
 * 4.�Ƿ��Զ�ɾ�� ���һ�������߶˿������Ժ� �ö����Ƿ��Զ�ɾ�� true �Զ�ɾ��
 * 5.��������
 */
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = "hello world";
/**
 * ����һ����Ϣ
 * 1.���͵��Ǹ�������
 * 2.·�ɵ� key ���ĸ�
 * 3.�����Ĳ�����Ϣ
 * 4.������Ϣ����Ϣ��
 */
            for (int i = 0; i < 10; i++) {
                channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            }


            System.out.println("message send done!");
        }
    }
}
