# PHP 使用rabbitmq 入门教程

关于消息队列，从前年开始断断续续看了些资料，想写很久了，但一直没腾出空，近来分别碰到几个朋友聊这块的技术选型，是时候把这块的知识整理记录一下了。

市面上的消息队列产品有很多，比如老牌的 ActiveMQ、RabbitMQ ，目前我看最火的 Kafka ，还有 ZeroMQ ，去年底阿里巴巴捐赠给 Apache 的 RocketMQ ，连 redis 这样的 NoSQL 数据库也支持 MQ 功能。总之这块知名的产品就有十几种，就我自己的使用经验和兴趣只打算谈谈 RabbitMQ、Kafka 和 ActiveMQ ，本文先讲 RabbitMQ ，在此之前先看下消息队列的相关概念。

# 什么叫消息队列

消息（Message）是指在应用间传送的数据。消息可以非常简单，比如只包含文本字符串，也可以更复杂，可能包含嵌入对象。

消息队列（Message Queue）是一种应用间的通信方式，消息发送后可以立即返回，由消息系统来确保消息的可靠传递。消息发布者只管把消息发布到 MQ 中而不用管谁来取，消息使用者只管从 MQ 中取消息而不管是谁发布的。这样发布者和使用者都不用知道对方的存在。

# 为何用消息队列

从上面的描述中可以看出消息队列是一种应用间的异步协作机制，那什么时候需要使用 MQ 呢？

以常见的订单系统为例，用户点击【下单】按钮之后的业务逻辑可能包括：扣减库存、生成相应单据、发红包、发短信通知。在业务发展初期这些逻辑可能放在一起同步执行，随着业务的发展订单量增长，需要提升系统服务的性能，这时可以将一些不需要立即生效的操作拆分出来异步执行，比如发放红包、发短信通知等。这种场景下就可以用 MQ ，在下单的主流程（比如扣减库存、生成相应单据）完成之后发送一条消息到 MQ 让主流程快速完结，而由另外的单独线程拉取MQ的消息（或者由 MQ 推送消息），当发现 MQ 中有发红包或发短信之类的消息时，执行相应的业务逻辑。

以上是用于业务解耦的情况，其它常见场景包括最终一致性、广播、错峰流控等等。

1.什么是MQ
消息队列（Message Queue，简称MQ），从字面意思上看，本质是个队列，FIFO先入先出，只不过队列中存放的内容是message而已。
其主要用途：不同进程Process/线程Thread之间通信。
为什么会产生消息队列？有几个原因：

不同进程（process）之间传递消息时，两个进程之间耦合程度过高，改动一个进程，引发必须修改另一个进程，为了隔离这两个进程，在两进程间抽离出一层（一个模块），所有两进程之间传递的消息，都必须通过消息队列来传递，单独修改某一个进程，不会影响另一个；

不同进程（process）之间传递消息时，为了实现标准化，将消息的格式规范化了，并且，某一个进程接受的消息太多，一下子无法处理完，并且也有先后顺序，必须对收到的消息进行排队，因此诞生了事实上的消息队列；

关于消息队列的详细介绍请参阅：
《Java帝国之消息队列》
《一个故事告诉你什么是消息队列》
《到底什么时候该使用MQ》

MQ框架非常之多，比较流行的有RabbitMq、ActiveMq、ZeroMq、kafka，以及阿里开源的RocketMQ。本文主要介绍RabbitMq。

本教程pdf及代码下载地址：
代码：https://download.csdn.net/download/zpcandzhj/10585077
教程：https://download.csdn.net/download/zpcandzhj/10585092
2.RabbitMQ

![img](https://img-blog.csdn.net/20180805223709614?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

开发语言：Erlang – 面向并发的编程语言。

![img](https://img-blog.csdn.net/20180805223717537?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

2.1.1.AMQP

AMQP是消息队列的一个协议。

![img](https://img-blog.csdn.net/20180805223724358?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

# RabbitMQ 特点

RabbitMQ 是一个由 Erlang 语言开发的 AMQP 的开源实现。

AMQP ：Advanced Message Queue，高级消息队列协议。它是应用层协议的一个开放标准，为面向消息的中间件设计，基于此协议的客户端与消息中间件可传递消息，并不受产品、开发语言等条件的限制。

RabbitMQ 最初起源于金融系统，用于在分布式系统中存储转发消息，在易用性、扩展性、高可用性等方面表现不俗。具体特点包括：

1. 可靠性（Reliability）
   RabbitMQ 使用一些机制来保证可靠性，如持久化、传输确认、发布确认。
2. 灵活的路由（Flexible Routing）
   在消息进入队列之前，通过 Exchange 来路由消息的。对于典型的路由功能，RabbitMQ 已经提供了一些内置的 Exchange 来实现。针对更复杂的路由功能，可以将多个 Exchange 绑定在一起，也通过插件机制实现自己的 Exchange 。
3. 消息集群（Clustering）
   多个 RabbitMQ 服务器可以组成一个集群，形成一个逻辑 Broker 。
4. 高可用（Highly Available Queues）
   队列可以在集群中的机器上进行镜像，使得在部分节点出问题的情况下队列仍然可用。
5. 多种协议（Multi-protocol）
   RabbitMQ 支持多种消息队列协议，比如 STOMP、MQTT 等等。
6. 多语言客户端（Many Clients）
   RabbitMQ 几乎支持所有常用语言，比如 Java、.NET、Ruby 等等。
7. 管理界面（Management UI）
   RabbitMQ 提供了一个易用的用户界面，使得用户可以监控和管理消息 Broker 的许多方面。
8. 跟踪机制（Tracing）
   如果消息异常，RabbitMQ 提供了消息跟踪机制，使用者可以找出发生了什么。
9. 插件机制（Plugin System）
   RabbitMQ 提供了许多插件，来从多方面进行扩展，也可以编写自己的插件。

# RabbitMQ 中的概念模型

消息模型

所有 MQ 产品从模型抽象上来说都是一样的过程：
消费者（consumer）订阅某个队列。生产者（producer）创建消息，然后发布到队列（queue）中，最后将消息发送到监听的消费者。

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly91cGxvYWQtaW1hZ2VzLmppYW5zaHUuaW8vdXBsb2FkX2ltYWdlcy81MDE1OTg0LTA2NmZmMjQ4ZDVmZjhlZWQucG5nP2ltYWdlTW9ncjIvYXV0by1vcmllbnQv)

RabbitMQ 基本概念

上面只是最简单抽象的描述，具体到 RabbitMQ 则有更详细的概念需要解释。上面介绍过 RabbitMQ 是 AMQP 协议的一个开源实现，所以其内部实际上也是 AMQP 中的基本概念：

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly91cGxvYWQtaW1hZ2VzLmppYW5zaHUuaW8vdXBsb2FkX2ltYWdlcy81MDE1OTg0LTM2N2RkNzE3ZDg5YWU1ZGIucG5nP2ltYWdlTW9ncjIvYXV0by1vcmllbnQv)

- Message
  消息，消息是不具名的，它由消息头和消息体组成。消息体是不透明的，而消息头则由一系列的可选属性组成，这些属性包括routing-key（路由键）、priority（相对于其他消息的优先权）、delivery-mode（指出该消息可能需要持久性存储）等。
- Publisher
  消息的生产者，也是一个向交换器发布消息的客户端应用程序。
- Exchange
  交换器，用来接收生产者发送的消息并将这些消息路由给服务器中的队列。
- Binding
  绑定，用于消息队列和交换器之间的关联。一个绑定就是基于路由键将交换器和消息队列连接起来的路由规则，所以可以将交换器理解成一个由绑定构成的路由表。
- Queue
  消息队列，用来保存消息直到发送给消费者。它是消息的容器，也是消息的终点。一个消息可投入一个或多个队列。消息一直在队列里面，等待消费者连接到这个队列将其取走。
- Connection
  网络连接，比如一个TCP连接。
- Channel
  信道，多路复用连接中的一条独立的双向数据流通道。信道是建立在真实的TCP连接内地虚拟连接，AMQP 命令都是通过信道发出去的，不管是发布消息、订阅队列还是接收消息，这些动作都是通过信道完成。因为对于操作系统来说建立和销毁 TCP 都是非常昂贵的开销，所以引入了信道的概念，以复用一条 TCP 连接。
- Consumer
  消息的消费者，表示一个从消息队列中取得消息的客户端应用程序。
- Virtual Host
  虚拟主机，表示一批交换器、消息队列和相关对象。虚拟主机是共享相同的身份认证和加密环境的独立服务器域。每个 vhost 本质上就是一个 mini 版的 RabbitMQ 服务器，拥有自己的队列、交换器、绑定和权限机制。vhost 是 AMQP 概念的基础，必须在连接时指定，RabbitMQ 默认的 vhost 是 / 。
- Broker
  表示消息队列服务器实体。

AMQP 中的消息路由

AMQP 中消息的路由过程和 Java 开发者熟悉的 JMS 存在一些差别，AMQP 中增加了 Exchange 和 Binding 的角色。生产者把消息发布到 Exchange 上，消息最终到达队列并被消费者接收，而 Binding 决定交换器的消息应该发送到那个队列。

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly91cGxvYWQtaW1hZ2VzLmppYW5zaHUuaW8vdXBsb2FkX2ltYWdlcy81MDE1OTg0LTdmZDczYWY3NjhmMjg3MDQucG5nP2ltYWdlTW9ncjIvYXV0by1vcmllbnQv)

Exchange 类型

Exchange分发消息时根据类型的不同分发策略有区别，目前共四种类型：direct、fanout、topic、headers 。headers 匹配 AMQP 消息的 header 而不是路由键，此外 headers 交换器和 direct 交换器完全一致，但性能差很多，目前几乎用不到了，所以直接看另外三种类型：

1. direct

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly91cGxvYWQtaW1hZ2VzLmppYW5zaHUuaW8vdXBsb2FkX2ltYWdlcy81MDE1OTg0LTEzZGI2MzlkMmMyMmYyYWEucG5nP2ltYWdlTW9ncjIvYXV0by1vcmllbnQv)

消息中的路由键（routing key）如果和 Binding 中的 binding key 一致， 交换器就将消息发到对应的队列中。路由键与队列名完全匹配，如果一个队列绑定到交换机要求路由键为“dog”，则只转发 routing key 标记为“dog”的消息，不会转发“dog.puppy”，也不会转发“dog.guard”等等。它是完全匹配、单播的模式。

 2.fanout

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly91cGxvYWQtaW1hZ2VzLmppYW5zaHUuaW8vdXBsb2FkX2ltYWdlcy81MDE1OTg0LTJmNTA5YjdmMzRjNDcxNzAucG5nP2ltYWdlTW9ncjIvYXV0by1vcmllbnQv)

每个发到 fanout 类型交换器的消息都会分到所有绑定的队列上去。fanout 交换器不处理路由键，只是简单的将队列绑定到交换器上，每个发送到交换器的消息都会被转发到与该交换器绑定的所有队列上。很像子网广播，每台子网内的主机都获得了一份复制的消息。fanout 类型转发消息是最快的。

3.topic

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly91cGxvYWQtaW1hZ2VzLmppYW5zaHUuaW8vdXBsb2FkX2ltYWdlcy81MDE1OTg0LTI3NWVhMDA5YmRmODA2YTAucG5nP2ltYWdlTW9ncjIvYXV0by1vcmllbnQv)

topic 交换器通过模式匹配分配消息的路由键属性，将路由键和某个模式进行匹配，此时队列需要绑定到一个模式上。它将路由键和绑定键的字符串切分成单词，这些单词之间用点隔开。它同样也会识别两个通配符：符号“#”和符号“*”。#匹配0个或多个单词，*匹配不多不少一个单词。

1.安装RabbitMQ（在此说的安装是在Windows下安装）

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

![img](https://img-blog.csdnimg.cn/2019081514595936.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3BocF9senI=,size_16,color_FFFFFF,t_70)

2.接下来要安装php的amqp扩展

先用phpinfo()查看php版本信息，及![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9pbWFnZXMyMDE3LmNuYmxvZ3MuY29tL2Jsb2cvNDg5MDg2LzIwMTcwOC80ODkwODYtMjAxNzA4MjkxMzIzMjYwNjItMTAyNTI2NTQ2My5wbmc),![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9pbWFnZXMyMDE3LmNuYmxvZ3MuY29tL2Jsb2cvNDg5MDg2LzIwMTcwOC80ODkwODYtMjAxNzA4MjkxMzIzNDgwMzAtNjEyOTQ3MDM5LnBuZw)信息

最后根据上面的信息去下载相应的amqp版本：http://pecl.php.net/package/amqp

据上面信息我们的是32位非线程安全版本![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9pbWFnZXMyMDE3LmNuYmxvZ3MuY29tL2Jsb2cvNDg5MDg2LzIwMTcwOC80ODkwODYtMjAxNzA4MjkxMzI1Mjk0OTktMzUzMjk0NDg3LnBuZw)

加压后：

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9pbWFnZXMyMDE3LmNuYmxvZ3MuY29tL2Jsb2cvNDg5MDg2LzIwMTcwOC80ODkwODYtMjAxNzA4MjkxMzI2MTEzMTItNDI5Nzk1MjE1LnBuZw)

将php_amqp.dll复制到php/ext，同时在php.ini中添加如下代码：

[amqp]  

extension=php_amqp.dll 

然后将rabbitmq.1.dll复制到php根目录C:/xampp/php/，同时修改apache配置文件httpd.conf，添加如下代码：

\# rabbitmq

LoadFile "C:/xampp/php/rabbitmq.1.dll" 

最后重启看看是否已经加载了amqp模块：

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9pbWFnZXMyMDE3LmNuYmxvZ3MuY29tL2Jsb2cvNDg5MDg2LzIwMTcwOC80ODkwODYtMjAxNzA4MjkxMzI5MTAyNDktNzgwNTEwMzc4LnBuZw)

 

---------------------------------到这里为止，安装已经结束-------------------------------------------------

RabbitMQ+PHP展示实例

新建rabbit_consumer.php作为消费者

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
 \* 消费回调函数
 \* 处理消息
 */ 
function processMessage($envelope, $queue) { 
  $msg = $envelope->getBody(); 
  echo $msg."\n"; //处理消息 
  $queue->ack($envelope->getDeliveryTag()); //手动发送ACK应答 
}
?>

新建rabbit_publisher.php作为生产者

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
//$q_name = 'q_linvo'; //无需队列名 
$k_route = 'key_1'; //路由key 
 
//创建连接和channel 
$conn = new AMQPConnection($conn_args);  
if (!$conn->connect()) {  
  die("Cannot connect to the broker!\n");  
}  
$channel = new AMQPChannel($conn);  

//创建交换机对象   
$ex = new AMQPExchange($channel);  
$ex->setName($e_name);  
date_default_timezone_set("Asia/Shanghai");
//发送消息 
//$channel->startTransaction(); //开始事务  
for($i=0; $i<5; ++$i){ 
  sleep(1);//休眠1秒
  //消息内容 
  $message = "TEST MESSAGE!".date("h:i:sa");  
  echo "Send Message:".$ex->publish($message, $k_route)."\n";  
} 
//$channel->commitTransaction(); //提交事务 
 
$conn->disconnect();
?>

测试一下：

先起一个窗口同样切换到php目录，输入:php c:/xampp/htdocs/RabbitMQ/rabbit_consumer.php

运行消费者

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9pbWFnZXMyMDE3LmNuYmxvZ3MuY29tL2Jsb2cvNDg5MDg2LzIwMTcwOC80ODkwODYtMjAxNzA4MjkxMzM2NTQyNjUtMTQwOTIyNDUyMi5wbmc)

 

然后再起一个dos窗口，切换到php根目录，输入以下命令：php c:/xampp/htdocs/RabbitMQ/rabbit_publisher.php

运行生产者

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9pbWFnZXMyMDE3LmNuYmxvZ3MuY29tL2Jsb2cvNDg5MDg2LzIwMTcwOC80ODkwODYtMjAxNzA4MjkxMzMzMDAyMzMtMTQwOTgwNzYwLnBuZw)

消费者接收到消息

 ![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9pbWFnZXMyMDE3LmNuYmxvZ3MuY29tL2Jsb2cvNDg5MDg2LzIwMTcwOC80ODkwODYtMjAxNzA4MjkxMzM3MDU3NDktMzk3NzEwMDMzLnBuZw)

 这样就模拟了队列对消息的处理，希望我们通过这篇文章对RabbitMQ的认识都能有一定的提升。

 另外给出官网的php使用指南：http://www.rabbitmq.com/tutorials/tutorial-one-php.html


相关原文链接：

​            https://www.cnblogs.com/miketwais/p/RabbitMQ.html

​            https://www.jianshu.com/p/79ca08116d57

​            https://blog.csdn.net/hellozpc/article/details/81436980