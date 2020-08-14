## redis基础命令1

1、字符串简单操作

- 设置
- 获取
- 删除
- 自增
- 增加指定值
- 从偏移量开始的值设置为指定值

2、列表操作

1. *截取指定片段，包含偏移量*
2. *列表阻塞操作*

3、集合

1. *组合和关联集合*
2. *转移元素*
3. *返回集合数量*

4、散列

1. *批量操作*

5、有序集合

1. *交集和并集*
2. *设置为取最小数，而不是相加*
3. *指定分数内的数量*

*线程池*

事务处理

为键设置过期时间

排序：sort命令

发布和订阅

```
redis-cli
redis-cli -h host -p port -a password
避免中文乱码了
redis-cli --raw 
```

### key

```
SET runoobkey redis
GET runoobkey
DEL KEY_NAME
DUMP KEY_NAME
MGET KEY1 KEY2 .. KEYN
RENAME OLD_KEY_NAME NEW_KEY_NAME
 
SETEX mykey 60 redis
TTL mykey
GET mykey

Expire KEY_NAME TIME_IN_SECONDS
Expireat KEY_NAME TIME_IN_UNIX_TIMESTAMP
PEXPIRE key milliseconds
PEXPIREAT KEY_NAME TIME_IN_MILLISECONDS_IN_UNIX_TIMESTAMP

EXISTS job  
SETNX job "programmer" 
PSETEX mykey 1000 "Hello"

INCR KEY_NAME
INCRBY KEY_NAME INCR_AMOUNT
DECR KEY_NAME 
DECRBY KEY_NAME DECREMENT_AMOUNT

APPEND KEY_NAME NEW_VALUE
```

### String 20

```
GETRANGE mykey 0 -1
Redis Getrange 命令用于获取存储在指定 key 中字符串的子字符串。字符串的截取范围由 start 和 end 两个偏移量决定(包括 start 和 end 在内)。

```

### Hash 14

```
Redis Hdel 命令用于删除哈希表 key 中的一个或多个指定字段，不存在的字段将被忽略。
HDEL KEY_NAME FIELD1.. FIELDN 
Redis Hexists 命令用于查看哈希表的指定字段是否存在。
Redis Hget 命令用于返回哈希表中指定字段的值。
Redis Hgetall 命令用于返回哈希表中，所有的字段和值。
Redis Hincrby 命令用于为哈希表中的字段值加上指定增量值。
HINCRBY KEY_NAME FIELD_NAME INCR_BY_NUMBER 
Redis Hincrbyfloat 命令用于为哈希表中的字段值加上指定浮点数增量值。
Redis Hkeys 命令用于获取哈希表中的所有域（field）。
Redis Hlen 命令用于获取哈希表中字段的数量。
Redis Hmget 命令用于返回哈希表中，一个或多个给定字段的值。
Redis Hmset 命令用于同时将多个 field-value (字段-值)对设置到哈希表中。
Redis Hset 命令用于为哈希表中的字段赋值 。
Redis Hsetnx 命令用于为哈希表中不存在的的字段赋值 。
Redis Hvals 命令返回哈希表所有域(field)的值。

Redis HSCAN 命令用于迭代哈希表中的键值对。
```



### List  17

```
Redis Lpush 命令将一个或多个值插入到列表头部。 如果 key 不存在，一个空列表会被创建并执行 LPUSH 操作。 当 key 存在但不是列表类型时，返回一个错误。
Redis Rpush 命令用于将一个或多个值插入到列表的尾部(最右边)。
Redis Llen 命令用于返回列表的长度。 如果列表 key 不存在，则 key 被解释为一个空列表，返回 0 。 如果 key 不是列表类型，返回一个错误。
Redis Rpop 命令用于移除列表的最后一个元素，返回值为移除的元素。
Redis Lpop 命令用于移除并返回列表的第一个元素。
Redis Lpushx 将一个值插入到已存在的列表头部，列表不存在时操作无效。
Redis Rpushx 命令用于将一个值插入到已存在的列表尾部(最右边)。如果列表不存在，操作无效。



```



### Set  15



### sorted set  20

