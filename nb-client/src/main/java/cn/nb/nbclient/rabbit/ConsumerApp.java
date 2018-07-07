package cn.nb.nbclient.rabbit;

import com.rabbitmq.client.*;

import java.io.IOException;
//接收默认消息的消费者
public class ConsumerApp {
    public static void main(String[] args)
    {
        Connection connection = null;
        Channel channel = null;
        try
        {
            //创建连接工厂
            ConnectionFactory factory = new ConnectionFactory();
            //设置RabbitMQ地址
            factory.setHost("localhost");
//            factory.setPort(5672);
//            factory.setUsername("rabbitmq_consumer");
//            factory.setPassword("123456");
//            factory.setVirtualHost("test_vhosts");
            //创建一个新的连接
            connection = factory.newConnection();
            //创建通道
            channel = connection.createChannel();
            //DefaultConsumer类实现了Consumer接口，通过传入一个频道，告诉服务器我们需要那个频道的消息，如果频道中有消息，就会执行回调函数handleDelivery
            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                        throws IOException {
                    String message = new String(body, "UTF-8");
                    System.out.println(" Consumer have received '" + message + "'");
                }
            };
            //自动回复队列应答 -- RabbitMQ中的消息确认机制
            channel.basicConsume("firstQueue", true, consumer);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
