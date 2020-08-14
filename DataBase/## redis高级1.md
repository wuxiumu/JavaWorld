## redis高级1

```
Redis SAVE 命令用于创建当前数据库的备份。
该命令将在 redis 安装目录中创建dump.rdb文件。
CONFIG GET dir
创建 redis 备份文件也可以使用命令 BGSAVE，该命令在后台执行。

方法一：通过配置文件（/etc/redis.conf）进行设置

CONFIG set requirepass "runoob"
CONFIG get requirepass
AUTH password
```

