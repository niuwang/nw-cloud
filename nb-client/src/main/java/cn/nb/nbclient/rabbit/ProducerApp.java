package cn.nb.nbclient.rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ProducerApp {
    private static final String EXCHANGE_NAME = "logs";
    /**
     *
     * @param args
     * @throws IOException
     * @throws TimeoutException
     */
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = null;
        Channel channel = null;
        try {
            //创建连接工厂
            ConnectionFactory factory = new ConnectionFactory();
            //设置RabbitMQ地址
            factory.setHost("localhost");
//            factory.setPort(15672);
//            factory.setUsername("guest");
//            factory.setPassword("guest");
//            factory.setVirtualHost("test_vhosts");

            //创建与RabbitMQ服务器的TCP连接
            connection = factory.newConnection();
            //创建一个通道
            channel = connection.createChannel();


            //交换器类型：
            //direct （直连）
            //topic （主题）
            //headers （标题）
            //fanout （分发）也有翻译为扇出的。
            //channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
            //生成随机的q队列name
            //String queueName = channel.queueDeclare().getQueue();
            //b表示是否持久化，b1表示建立的tcp是否只适用于当前tcp连接，b2表示队列不再使用是否删除这个队列，map队列的一些参数信息
            channel.queueDeclare("ccc", true, false, false, null);
            channel.queueBind("ccc", EXCHANGE_NAME, "");
            //      分发消息
            for(int i = 0 ; i < 5; i++){
                String message = "你好! " + i;
                channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
                System.out.println(" Sent message:'" + message + "'");
            }
            //默认方式
            //声明一个队列-- 在RabbitMQ中，队列声明是幂等性的（一个幂等操作的特点是其任意多次执行所产生的影响均与一次执行的影响相同），
            //也就是说，如果不存在，就创建，如果存在，不会对已经存在的队列产生任何影响。
            // //channel.queueDeclare("firstQueue", true, false, false, null);
            // //String message = "First Message";
            //发送消息到队列中
            // //channel.basicPublish("", "firstQueue", null, message.getBytes());
            // //System.out.println("Send Message is:'" + message + "'");

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            //关闭连接
            if (channel != null) {
                channel.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
