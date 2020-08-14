## Docker安装Memcached

## 1 下载

下载镜像



```ruby
$ docker pull memcached:1.5.16
```

## 2 启动



```ruby
$ docker run --name my-memcache -p 11211:11211 -d memcached:1.5.16
docker run --name my-memcache -p 11212:11211 -d memcached

```

默认启动 `memcached`设置的最大容量是 `64M`,设置其他的容量，如 `128M`



```ruby
$ docker run --name my-memcache -p 11211:11211 -d memcached:1.5.16 memcached -m 128
docker run --name my-memcache -p 11212:11211 -d memcached memcached -m 128

```

## 3 常用命令

使用`telnet`连接`memcached`，如果没有可以先安装



```ruby
$ yum install -y telnet
```

连接



```ruby
$ telnet 127.0.1.1 11211
```

连接后使用 `stats`可以查看运行信息，含义如下：

| 参数                  | 含义                                                         |
| :-------------------- | :----------------------------------------------------------- |
| pid                   | memcache服务器进程ID                                         |
| uptime                | 服务器已运行秒数                                             |
| time                  | 服务器当前Unix时间戳                                         |
| version               | memcache版本                                                 |
| pointer_size          | 操作系统指针大小                                             |
| rusage_user           | 进程累计用户时间                                             |
| rusage_system         | 进程累计系统时间                                             |
| curr_connections      | 当前连接数量                                                 |
| total_connections     | Memcached运行以来连接总数                                    |
| connection_structures | Memcached分配的连接结构数量                                  |
| cmd_get               | get命令请求次数                                              |
| cmd_set               | set命令请求次数                                              |
| cmd_flush             | flush命令请求次数                                            |
| get_hits              | get命令命中次数                                              |
| get_misses            | get命令未命中次数                                            |
| delete_misses         | delete命令未命中次数                                         |
| delete_hits           | delete命令命中次数                                           |
| incr_misses           | incr命令未命中次数                                           |
| incr_hits             | incr命令命中次数                                             |
| decr_misses           | decr命令未命中次数                                           |
| decr_hits             | decr命令命中次数                                             |
| cas_misses            | cas命令未命中次数                                            |
| cas_hits              | cas命令命中次数                                              |
| cas_badval            | 使用擦拭次数                                                 |
| auth_cmds             | 认证命令处理的次数                                           |
| auth_errors           | 认证失败数目                                                 |
| bytes_read            | 读取总字节数                                                 |
| bytes_written         | 发送总字节数                                                 |
| limit_maxbytes        | 分配的内存总大小（字节）， 例如默认是 `67108864`，即 67108864 / 1024 / 1024 = `64M` |
| accepting_conns       | 服务器是否达到过最大连接（0/1）                              |
| listen_disabled_num   | 失效的监听数                                                 |
| threads               | 当前线程数                                                   |
| conn_yields           | 连接操作主动放弃数目                                         |
| bytes                 | 当前存储占用的字节数，即`使用量`                             |
| curr_items            | 当前存储的数据总数                                           |
| total_items           | 启动以来存储的数据总数                                       |
| evictions             | LRU释放的对象数目                                            |
| reclaimed             | 已过期的数据条目来存储新数据的数目                           |

清除所有的缓存



```undefined
flush_all
```

退出



```undefined
quit
```



作者：QuincyZ
链接：https://www.jianshu.com/p/5d336c342d71
来源：简书
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。