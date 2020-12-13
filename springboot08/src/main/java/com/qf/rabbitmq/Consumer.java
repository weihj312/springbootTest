package com.qf.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;

public class Consumer {
    public static void main(String[] args)throws Exception {
        System.out.println("我收到一条消息。。。");

        //配置连接参数
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.140.137");
        factory.setPort(5672);
        factory.setUsername("guest");
        factory.setPassword("guest");
        //获取连接
        Connection connection = factory.newConnection();

        Channel channel = connection.createChannel();
        //要与生产者中的该方法一致（注：方法中的参数值必须保持一致）
        channel.queueDeclare("secondDog", false, false, false, null);

        //监听队列
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {

            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("来自生产者的消息：" + new String(body));
            }
        };

        //消费消息
        //参数1：queue - 指定消费哪个队列
        //参数2：autoAck - 指定是否自动ACK （true表示接收到消息后，会立即告知RabbitMQ，false表示不告知）
        //参数3：consumer - 指定消费回调
        channel.basicConsume("secondDog", true, defaultConsumer);
    }
}
