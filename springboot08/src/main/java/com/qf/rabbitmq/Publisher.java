package com.qf.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Publisher {
    public static void main(String[] args) throws Exception {
        System.out.println("我生产了一个消息。。。");

        //配置连接参数
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.140.137");
        factory.setPort(5672);
        factory.setUsername("guest");
        factory.setPassword("guest");

        //获取连接
        Connection connection = factory.newConnection();
        //获取Channel
        Channel channel = connection.createChannel();

        //配置队列参数
        //参数1：queue - 指定队列的名称
        //参数2：durable - 当前队列是否需要持久化,值为true时表示持久化，rabbitmq宕机或重启后，队列依然在
        //参数3：exclusive - 当前队列是否为排他队列，值为true时表示与当前连接（connection）绑定，连接关闭，队列消失
        //参数4：autoDelete - 当前队列是否自动删除，值为true时表示队列中的消息一旦被消费，该队列会消失
        //参数5：arguments - 指定当前队列的相关参数
        channel.queueDeclare("secondDog",false,false,false,null);

        //发布消息到exchange，同时指定路由的规则
        // 参数1：指定exchange，使用""
        // 参数2：指定路由的规则，使用具体的队列名称
        // 参数3：指定传递的消息所携带的properties，使用null
        // 参数4：指定发布的具体消息，byte[]类型
        channel.basicPublish("","secondDog",null,"weihaoergou".getBytes());
        //关闭资源
        //channel.close();
        //Thread.sleep(3000);
        //connection.close();

    }
}
