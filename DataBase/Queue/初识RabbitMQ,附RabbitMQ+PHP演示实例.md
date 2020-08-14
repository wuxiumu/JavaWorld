# [初识RabbitMQ,附RabbitMQ+PHP演示实例](https://www.cnblogs.com/miketwais/p/RabbitMQ.html)

RabbitMQ是一个在AMQP基础上实现的企业级消息系统。何谓消息系统，就是消息队列系统，消息队列是“”消费-生产者模型“”的一个典型的代表，一端往消息队列中不断写入消息，而另一端则可以读取或者订阅队列中的消息。

what？消费-生产者模型？对，没错！就是大学操作系统课程里面的“消费者-生产者模式”，记得当时被这个问题坑的不轻啊。

在项目中，将一些无需即时返回且耗时的操作提取出来，进行了异步操作，而这种异步处理的方式大大的节省了服务器的请求时间，从而提高了系统的吞吐量。而且不影响服务器做其他相应，不独占服务器资源。

如：注册用户这种服务，它可能解耦成好几种独立的服务（账号验证，邮箱验证码，手机短信码等）。它们作为消费者，等待用户输入数据，在前台数据提交之后会经过分解并发送到各个服务所在的url，分发的那个角色就相当于生产者。消费者在获取数据时候有可能一次不能处理完，那么它们各自有一个请求队列，那就是内存缓冲区了。做这项工作的框架叫做消息队列。

又比如：电商系统中的订单处理系统，传统处理模式是：下订单的时候，订单系统可能会调用库存系统的接口，这样两个系统之间存在一个严重依赖关系，如果库存系统宕机，那么整个流程都会受到影响。现在大多公司的处理方法是：引入消息队列，下完订单，订单系统完成持久化处理，将消息写入消息队列，返回用户订单下单成功。

对库存系统来说，采用拉/推的方式，获取下单信息，库存系统根据下单信息，进行库存操作。这样实现了两个系统间的解耦。

即使在下单时库存系统不能正常使用。也不影响正常下单，因为下单后，订单系统写入消息队列就不再关心其他的后续操作了。

 给一张结构图：

![img](https://images2017.cnblogs.com/blog/489086/201708/489086-20170829135051968-316242301.png)

几个概念说明：

Broker：简单来说就是消息队列服务器实体。
　　Exchange：消息交换机，它指定消息按什么规则，路由到哪个队列。
　　Queue：消息队列载体，每个消息都会被投入到一个或多个队列。
　　Binding：绑定，它的作用就是把exchange和queue按照路由规则绑定起来。
　　Routing Key：路由关键字，exchange根据这个关键字进行消息投递。
　　vhost：虚拟主机，一个broker里可以开设多个vhost，用作不同用户的权限分离。
　　producer：消息生产者，就是投递消息的程序。
　　consumer：消息消费者，就是接受消息的程序。
　　channel：消息通道，在客户端的每个连接里，可建立多个channel，每个channel代表一个会话任务。

消息队列的使用过程大概如下：

（1）客户端连接到消息队列服务器，打开一个channel。
　　（2）客户端声明一个exchange，并设置相关属性。
　　（3）客户端声明一个queue，并设置相关属性。
　　（4）客户端使用routing key，在exchange和queue之间建立好绑定关系。
　　（5）客户端投递消息到exchange。

exchange接收到消息后，就根据消息的key和已经设置的binding，进行消息路由，将消息投递到一个或多个队列里。

exchange也有几个类型，完全根据key进行投递的叫做Direct交换机，例如，绑定时设置了routing key为”abc”，那么客户端提交的消息，只有设置了key为”abc”的才会投递到队列。对key进行模式匹配后进行投递的叫做Topic交换机，符号”#”匹配一个或多个词，符号”*”匹配正好一个词。例如”abc.#”匹配”abc.def.ghi”，”abc.*”只匹配”abc.def”。还有一种不需要key的，叫做Fanout交换机，它采取广播模式，一个消息进来时，投递到与该交换机绑定的所有队列。

RabbitMQ支持消息的持久化，也就是数据写在磁盘上，为了数据安全考虑，我想大多数用户都会选择持久化。消息队列持久化包括3个部分：
　　（1）exchange持久化，在声明时指定durable => 1
　　（2）queue持久化，在声明时指定durable => 1
　　（3）消息持久化，在投递时指定delivery_mode => 2（1是非持久化）

如果exchange和queue都是持久化的，那么它们之间的binding也是持久化的。如果exchange和queue两者之间有一个持久化，一个非持久化，就不允许建立绑定。

 

好了，讲了这么多基本讲清楚了RabbitMQ的应用场景和好处，下面我们在windows平台上练一把手，更直观的来看看RabbitMQ到底是什么？

那么我蛮来安装RabbitMQ+PHP环境：

1.安装RabbitMQ

 安装RabbitMQ之前首先要安装Erlang语言开发包，下载地址：http://www.erlang.org/download/otp_win32_R15B.exe 默认安装即可

　  配置环境变量 ERLANG_HOME C:\Program Files (x86)\erl5.9 

   添加到PATH  %ERLANG_HOME%\bin;

 下载安装RabbitMQ，下载地址：http://www.rabbitmq.com/releases/rabbitmq-server/v3.3.4/rabbitmq-server-3.3.4.exe 

   配置环境变量 C:\Program Files (x86)\RabbitMQ Server\rabbitmq_server-2.8.0

   添加到PATH %RABBITMQ_SERVER%\sbin;

 然后到dos里面切换到RabbitMQ目录下，执行rabbitmq-plugins.bat enable rabbitmq_management， 安装完成之后以管理员身份启动 rabbitmq：输入命令：

　　rabbitmq-service.bat stop

　　rabbitmq-service.bat install

　　rabbitmq-service.bat start

然后，浏览器中输入:127.0.0.1:15672,用户名密码是guest ,如果能登陆就说明安装成功。

 ![img](https://images2017.cnblogs.com/blog/489086/201708/489086-20170829132100858-1776767208.png)

 

2.接下来要安装php的amqp扩展

先用phpinfo()查看php版本信息，及![img](https://images2017.cnblogs.com/blog/489086/201708/489086-20170829132326062-1025265463.png),![img](https://images2017.cnblogs.com/blog/489086/201708/489086-20170829132348030-612947039.png)信息

最后根据上面的信息去下载相应的amqp版本：http://pecl.php.net/package/amqp

据上面信息我们的是32位非线程安全版本![img](https://images2017.cnblogs.com/blog/489086/201708/489086-20170829132529499-353294487.png)

加压后：

![img](https://images2017.cnblogs.com/blog/489086/201708/489086-20170829132611312-429795215.png)

将php_amqp.dll复制到php/ext，同时在php.ini中添加如下代码：

[amqp]  

extension=php_amqp.dll 

然后将rabbitmq.1.dll复制到php根目录C:/xampp/php/，同时修改apache配置文件httpd.conf，添加如下代码：

\# rabbitmq

LoadFile "C:/xampp/php/rabbitmq.1.dll" 

最后重启看看是否已经加载了amqp模块：

![img](https://images2017.cnblogs.com/blog/489086/201708/489086-20170829132910249-780510378.png)

 

---------------------------------到这里为止，安装已经结束-------------------------------------------------

 

RabbitMQ+PHP展示实例

新建rabbit_consumer.php作为消费者

![img](https://images.cnblogs.com/OutliningIndicators/ExpandedBlockStart.gif)

[![复制代码](https://common.cnblogs.com/images/copycode.gif)](javascript:void(0);)

```
<?php 
//配置信息 
$conn_args = array( 
    'host' => '127.0.0.1',  
    'port' => '5672',  
    'login' => 'guest',  
    'password' => 'guest', 
    'vhost'=>'/' 
);   
$e_name = 'e_linvo'; //交换机名 
$q_name = 'q_linvo'; //队列名 
$k_route = 'key_1'; //路由key 
 
//创建连接和channel 
$conn = new AMQPConnection($conn_args);   
if (!$conn->connect()) {   
    die("Cannot connect to the broker!\n");   
}   
$channel = new AMQPChannel($conn);   
 
//创建交换机    
$ex = new AMQPExchange($channel);   
$ex->setName($e_name); 
$ex->setType(AMQP_EX_TYPE_DIRECT); //direct类型  
$ex->setFlags(AMQP_DURABLE); //持久化 
echo "Exchange Status:".$ex->declare()."\n";   
   
//创建队列    
$q = new AMQPQueue($channel); 
$q->setName($q_name);   
$q->setFlags(AMQP_DURABLE); //持久化  
echo "Message Total:".$q->declare()."\n";   
 
//绑定交换机与队列，并指定路由键 
echo 'Queue Bind: '.$q->bind($e_name, $k_route)."\n"; 
 
//阻塞模式接收消息 
echo "Message:\n";   
while(True){ 
    $q->consume('processMessage');   
    //$q->consume('processMessage', AMQP_AUTOACK); //自动ACK应答  
} 
$conn->disconnect();   
 
/**
 * 消费回调函数
 * 处理消息
 */ 
function processMessage($envelope, $queue) { 
    $msg = $envelope->getBody(); 
    echo $msg."\n"; //处理消息 
    $queue->ack($envelope->getDeliveryTag()); //手动发送ACK应答 
}
?>
```

[![复制代码](https://common.cnblogs.com/images/copycode.gif)](javascript:void(0);)

 

 新建rabbit_publisher.php作为生产者

![img](https://images.cnblogs.com/OutliningIndicators/ContractedBlock.gif) View Code

测试一下：

先起一个窗口同样切换到php目录，输入:php c:/xampp/htdocs/RabbitMQ/rabbit_consumer.php

运行消费者

![img](https://images2017.cnblogs.com/blog/489086/201708/489086-20170829133654265-1409224522.png)

 

然后再起一个dos窗口，切换到php根目录，输入以下命令：php c:/xampp/htdocs/RabbitMQ/rabbit_publisher.php

运行生产者

![img](https://images2017.cnblogs.com/blog/489086/201708/489086-20170829133300233-140980760.png)

消费者接收到消息

 ![img](https://images2017.cnblogs.com/blog/489086/201708/489086-20170829133705749-397710033.png)

 这样就模拟了队列对消息的处理，希望我们通过这篇文章对RabbitMQ的认识都能有一定的提升。

 另外给出官网的php使用指南：http://www.rabbitmq.com/tutorials/tutorial-one-php.html