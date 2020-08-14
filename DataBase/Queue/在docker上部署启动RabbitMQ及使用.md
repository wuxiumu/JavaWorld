# 在docker上部署启动RabbitMQ及使用

一、docker上部署启动RabbitMQ

1、查询rabbitmq镜像

docker search rabbitmq:management
2、拉取rabbitmq镜像

docker pull rabbitmq:management
3、创建并启动容器

3.1创建和启动
docker run -d --hostname my-rabbit --name rabbit -p 8080:15672 rabbitmq:management
其中：

--hostname：指定容器主机名称
--name:指定容器名称
-p:将mq端口号映射到本地
3.2备选启动同时设置用户和密码
docker run -d --hostname my-rabbit --name rabbit -e RABBITMQ_DEFAULT_USER=admin -e RABBITMQ_DEFAULT_PASS=admin -p 15672:15672 -p 5672:5672 -p 25672:25672 -p 61613:61613 -p 1883:1883 rabbitmq:management
注意：

 15672：控制台端口号

 5672：应用访问端口号
此处的端口访问是有区别的，控制台端口用于管理rabbitmq，应用访问端口号为rabbitclient等应用访问。

3.3查看rabbitmq运行状况：
docker logs rabbit

4、访问

    http://localhost:15672

5、登录

    默认账户名：guest
    
    密码：guest

提醒，如果关闭计算机时未停止这个启动的容器，再次启动docker时会出现无法访问15672的情况，此时只需停止并移除这个容器，然后重启一次docker，重新执行启动rabbitmq容器的命令即可。

二、使用RabbitMQ

1、创建sender

a、构建消息提供者类sender

package org.vertx.vertx.rabbitmq.example;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Send {
	
	private final static String QUEUE_NAME = "hello";
	 
	  public static void main(String[] argv)throws java.io.IOException, TimeoutException {
		  ConnectionFactory factory = new ConnectionFactory();
		  factory.setUsername("guest");
		  factory.setPassword("guest");
		  factory.setHost("localhost");
		  factory.setPort(5672);
		  factory.setVirtualHost("/");
		  Connection connection = factory.newConnection();
		  Channel channel = connection.createChannel();
		  channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		  String message = "Hello World!";
		  channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
		  System.out.println(" [x] Sent '" + message + "'");
		  channel.close();
		  connection.close();
	  }
}
    b、启动后可查看消息队列。

    c、访问链接
    
    http://127.0.0.1:15672/#/queues
    
     可见，RabbitMQ management中name为hello的消息产生一条。



2、创建receiver

a、创建消息接收方的类receiver。

package org.vertx.vertx.rabbitmq.example;
import com.rabbitmq.client.*;
import java.io.IOException;
public class MyConsumer {
	
	  private final static String QUEUE_NAME = "hello";
	 
	  public static void main(String[] argv) throws Exception {
	    ConnectionFactory factory = new ConnectionFactory();
	    factory.setUsername("guest");
		factory.setPassword("guest");
		factory.setHost("localhost");
		factory.setPort(5672);
		factory.setVirtualHost("/");
		factory.setConnectionTimeout(600000); // in milliseconds
		factory.setRequestedHeartbeat(60); // in seconds
		factory.setHandshakeTimeout(6000); // in milliseconds
		factory.setRequestedChannelMax(5);
		factory.setNetworkRecoveryInterval(500); 
	    
	    Connection connection = factory.newConnection();
	    Channel channel = connection.createChannel();
	 
	    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
	    System.out.println("Waiting for messages. ");
	 
	    Consumer consumer = new DefaultConsumer(channel) {
	      @Override
	      public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
	          throws IOException {
	        String message = new String(body, "UTF-8");
	        System.out.println(" [x] Received '" + message + "'");
	      }
	    };
	    channel.basicConsume(QUEUE_NAME, true, consumer);
	  }

}
b、启动receiver并访问链接

c、运行后可接收到消息



d、访问管理器查看消息队列

http://127.0.0.1:15672/#/queues



消息队列中hello的消息条数为0，已发送至接收方。
————————————————
版权声明：本文为CSDN博主「小召123566」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_39617052/java/article/details/79723849