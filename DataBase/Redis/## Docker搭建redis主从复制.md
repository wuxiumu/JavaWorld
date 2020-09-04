## Docker搭建redis主从复制

### 一、安装Redis

搜索redis镜像

```
docker search redis
```

拉取镜像

```
docker pull  redis
```

下载完成后，我们就可以在本地镜像列表里查到REPOSITORY为redis

```
docker images redis
```

运行容器

```
docker run -p 6379:6379 -v $PWD/data:/data  -d redis redis-server --appendonly yes

docker run -p 6380:6379 -v $PWD/data:/data  -d redis redis-server --appendonly yes

```

命令说明：
-p 6379:6379 : 将容器的6379端口映射到主机的6379端口
-v $PWD/data:/data : 将主机中当前目录下的data挂载到容器的/data
redis-server --appendonly yes : 在容器执行redis-server启动命令，并打开redis持久化配置
连接容器

```
docker exec -it 43f7a65ec7f8 redis-cli
docker exec -it f4bbbb4accc9 redis-cli
```

查看容器

```
 172.17.0.1:6379> info



    # Server



    redis_version:3.2.0



    redis_git_sha1:00000000



    redis_git_dirty:0



    redis_build_id:f449541256e7d446



    redis_mode:standalone



    os:Linux 4.2.0-16-generic x86_64



    arch_bits:64



    multiplexing_api:epoll



    ...
```

### 二、主从复制

1.运行redis镜像

**首先使用docker启动3个redis容器服务，分别使用到6379、6380、6381端口**

```
docker run --name redis-6379 -p 6379:6379 -d redis redis-server



docker run --name redis-6380 -p 6380:6379 -d redis redis-server



docker run --name redis-6381 -p 6381:6379 -d redis redis-server

docker run --name redis-6382 -p 6382:6379 -d redis redis-server
```

2.配置redis集群

使用如下命令查看容器内网的ip地址等信息

```
docker inspect containerid（容器ID）
```

![img](https://img-blog.csdnimg.cn/20190609101658159.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM2ODUwODEz,size_16,color_FFFFFF,t_70)

3个redis的内网ip地址为：

```
redis-6379    172.17.0.2 



redis-6380	  172.17.0.3 



redis-6381    172.17.0.4 
```

进入docker容器内部，查看当前redis角色（主master还是从slave）（命令：info replication）

```
[root@localhost /]# docker exec -it 007f7ab412b9 redis-cli

docker exec -it 46b42caead67 redis-cli
docker exec -it 0230656272e3 redis-cli
docker exec -it f4bbbb4accc9 redis-cli

127.0.0.1:6379> info replication

# Replication
role:master
connected_slaves:0
master_repl_offset:3860
repl_backlog_active:1
repl_backlog_size:1048576
repl_backlog_first_byte_offset:2
repl_backlog_histlen:3859
127.0.0.1:6379> 

```

可以看到当前3台redis都是master角色，使用redis-cli命令修改redis-6380、redis-6381的主机为172.17.0.2:6379

```
SLAVEOF 172.17.0.2 6379
SLAVEOF 172.17.0.6 6379

```

再次查看redis-6379主机info，已经有两个从机了.

![img](https://img-blog.csdnimg.cn/20190609102037197.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM2ODUwODEz,size_16,color_FFFFFF,t_70)

测试

主

![img](https://img-blog.csdnimg.cn/20190609102206395.png)

从1

![img](https://img-blog.csdnimg.cn/20190609102230164.png)

从2

![img](https://img-blog.csdnimg.cn/2019060910224789.png)

至此，redis下的主从配置就ok了。