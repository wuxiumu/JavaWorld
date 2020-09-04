### 文章目录

- [一、Clickhouse 简介](https://blog.csdn.net/magicpenta/article/details/89193722?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-9.channel_param&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-9.channel_param#Clickhouse__2)

- [二、Clickhouse 安装](https://blog.csdn.net/magicpenta/article/details/89193722?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-9.channel_param&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-9.channel_param#Clickhouse__27)

- - [2.1 系统要求](https://blog.csdn.net/magicpenta/article/details/89193722?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-9.channel_param&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-9.channel_param#21__29)

  - [2.2 安装方式](https://blog.csdn.net/magicpenta/article/details/89193722?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-9.channel_param&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-9.channel_param#22__33)

  - - [2.2.1 rpm 包下载](https://blog.csdn.net/magicpenta/article/details/89193722?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-9.channel_param&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-9.channel_param#221_rpm__39)
    - [2.2.2 rpm 包安装](https://blog.csdn.net/magicpenta/article/details/89193722?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-9.channel_param&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-9.channel_param#222_rpm__60)

- [三、Clickhouse 启动与验证](https://blog.csdn.net/magicpenta/article/details/89193722?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-9.channel_param&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-9.channel_param#Clickhouse__81)

# 一、Clickhouse 简介

Clickhouse 是一个开源的面向联机分析处理（OLAP, On-Line Analytical Processing）的列式存储数据库管理系统。

Clickhouse 的优势：

- 写入快、查询快
- SQL 支持
- 简单方便，不依赖 Hadoop 技术栈
- 支持线性扩展
- 深度列存储
- 向量化查询执行
- 数据压缩
- 并行和分布式查询
- 实时数据更新

Clickhouse 的不足：

- 不支持事务
- 不适合典型的 K/V 存储
- 不适合 Blob/Document 存储
- 不支持完整的 Update/Delete 操作
- 非跨平台
- 并非查询资源控制不好处理
- 不支持二级索引

# 二、Clickhouse 安装

## 2.1 系统要求

Clickhouse 仅支持 Linux 操作系统，且机器 CPU 必须支持 SSE 4.2 指令集。

## 2.2 安装方式

Clickhouse 官方有现成的 Ubuntu 系统的安装包，但是对于其他操作系统的支持度较低，往往需要自己编译源码。

对于 Centos 用户来说，这简直是一个噩耗。所幸，有个第三方机构 Altinity 提供了完整的 rpm 包，支持在 Centos 下安装。

### 2.2.1 rpm 包下载

进入网站 https://packagecloud.io/Altinity/clickhouse ，发现首页有个 rpm 包列表。

乍看之下，会有点无所适从，不知道该下载哪一个。实际上，只需要以下 4 个 rpm 包即可：

- clickhouse-client-19.4.3.11-1.el6.x86_64.rpm
- clickhouse-server-19.4.3.11-1.el6.x86_64.rpm
- clickhouse-server-common-19.4.3.11-1.el6.x86_64.rpm
- clickhouse-common-static-19.4.3.11-1.el6.x86_64.rpm

注：下载的时候，需要注意适用的操作系统版本。如本例的 `el6`，适用于 Centos 6，而 `el7` 则适用于 Centos 7。

其中，几个包的作用如下表所示：

| 包名              | 作用                           |
| ----------------- | ------------------------------ |
| clickhouse-client | 包含 clickhouse 客户端交互工具 |
| clickhouse-common | 包含 clickhouse 服务端执行脚本 |
| clickhouse-server | 包含 clickhouse 服务端配置文件 |

### 2.2.2 rpm 包安装

下载完上述 rpm 包后，执行以下命令完成安装：

```
rpm -ivh clickhouse-client-19.4.3.11-1.el6.x86_64.rpm
rpm -ivh clickhouse-server-19.4.3.11-1.el6.x86_64.rpm
rpm -ivh clickhouse-server-common-19.4.3.11-1.el6.x86_64.rpm
rpm -ivh clickhouse-common-static-19.4.3.11-1.el6.x86_64.rpm
1234
```

安装后主要目录分布如下表：

| 路径                          | 说明                          |
| ----------------------------- | ----------------------------- |
| /etc/clickhouse-server        | clickhouse 服务端配置文件目录 |
| /etc/clickhouse-client        | clickhouse 客户端配置文件目录 |
| /var/lib/clickhouse           | clickhouse 默认数据目录       |
| /var/log/clickhouse-server    | clickhouse 默认日志目录       |
| /etc/init.d/clickhouse-server | clickhouse 服务端启动脚本     |

# 三、Clickhouse 启动与验证

安装完成后，我们需要手动启动服务：

```
sudo service clickhouse-server start
1
```

若启动正常，会在控制台输出如下信息：

```
Start clickhouse-server service: Path to data directory in /etc/clickhouse-server/config.xml: /var/lib/clickhouse/
DONE
12
```

现在，我们进入 Clickhouse 客户端交互界面：

```
[root@ck-master clickhouse-server]# clickhouse-client
ClickHouse client version 19.4.3.11.
Connecting to localhost:9000 as user default.
Connected to ClickHouse server version 19.4.3 revision 54416.

ck-master :)
123456
```

验证 SQL 是否正常执行：

```
ck-master :) select 1

SELECT 1

┌─1─┐
│ 1 │
└───┘

1 rows in set. Elapsed: 0.001 sec.
```