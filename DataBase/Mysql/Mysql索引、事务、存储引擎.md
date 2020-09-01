## 文章目录
- Mysql索引、事务、存储引擎
- 索引
	- 索引的作用
	- 索引的优缺点
	- 索引的分类
	- 创建索引的原则依据
	- 外键与候选键
	- 查看索引
	- 表的文件分类
- 事务
	- 概念
	- 数据库设计三大范式
	- 事务的ACID特点
        - 原子性（Atomicity）
        - 一致性（Consistency）
        - 隔离性（Isolation）
        - 持久性（Durability）
    - 事务控制
    - 事务的控制方法
    - 事务处理命令控制事务
- 存储引擎
	- MyISAM的介绍
		- MyISAM概念
	- InnoDB
        - InnoDB的特点
        - InnoDB适用生产场景
        - 修改存储引擎
## 索引
### 索引的作用
设置了合适的索引之后，数据库利用各种快速的定位技术，能够大大加快查询速率
特别是当表很大时，或者查询涉及到多个表时，使用索引可使查询加快成干倍
可以降低数据库的IO成本，并且索引还可以降低数据库的排序成本
通过创建唯一性索引保证数据表数据的唯一性
可以加快表与表之间的连接
在使用分组和排序时，可大大减少分组和排序时间

### 索引的优缺点

- 优点 ： 可以快速的找到所需要的的资源
- 缺点 ：占用空间

### 索引的分类

```
mysql> create database school;
Query OK, 1 row affected (0.01 sec)

mysql> use school;
Database changed
mysql> create table info(id int(2),name varchar(10));
Query OK, 0 rows affected (0.07 sec)

mysql> create index id_index on info(id);
Query OK, 0 rows affected (0.02 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> desc info;
+-------+-------------+------+-----+---------+-------+
| Field | Type        | Null | Key | Default | Extra |
+-------+-------------+------+-----+---------+-------+
| id    | int(2)      | YES  | MUL | NULL    |       |
| name  | varchar(10) | YES  |     | NULL    |       |
+-------+-------------+------+-----+---------+-------+
2 rows in set (0.00 sec)
```

### 普通索引

这是最基本的索引类型，而且它没有唯一性之类的限制
创建不同索引的方式

```
create index index_name on table table_name(column(length));		'直接创建，length是可选项'
alter table table_name add index index_name(column(length)); 		'修改表当时创建'
create table 'table'(id int(3) not null  auto_increment,name varchar(10) not null,score decimal(5,2),address varchar(50) default '未知',primary key ('id'),index index_name(id(length)))  '创建表时创建'

mysql> create table num (id int,index id_index(id));
Query OK, 0 rows affected (0.01 sec)

mysql> alter table info add index name_index (name);
Query OK, 0 rows affected (0.00 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> create table name(id int(3) not null auto_increment,name varchar(10) not null,score decimal(5,2),address varchar(50) default '未知',primary key(id),index name_index (name));
Query OK, 0 rows affected (0.04 sec)

```
### 唯一性索引

这种索引和前面的“普通索引”基本相同，但有一个区别：索引列的所有值都只能出现一次，即必须唯一
创建唯一索引的方式
```
create unique index index_name on table_name(column(length));
alter table table_name add unqiue index_name(column(length));
mysql> create table num(id int(3) not null auto_increment primary key,name varchar(10) not null,scoore decimal(5,2),address varchar(50) default '未知');
Query OK, 0 rows affected (0.02 sec)

mysql> create unique index index_name on num(name);
Query OK, 0 rows affected (0.04 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> alter table num add unique index name_index (name);                                         
Query OK, 0 rows affected (0.04 sec)
Records: 0  Duplicates: 0  Warnings: 0
```
### 主键索引
主键是一种唯一性索引，但它必须指定为" primary key"
一个表只能有一个主键，不允许有空值
创建主键索引的方式

```
create table tablename([...],primary key(列的列表))； 
alter table tablename add primary key(列的列表)；
create table 'table_name' (id int(11) not null auto_increment,name char(10) not null,primary key (id));
```
### 全文索引
MySQL从3.23.23版开始支持全文索引和全文检索。在 MySQL中全文索引的索引类型为 FULLTEXT，全文索引可以在 ARCHAR或者TEXT类型的列上创建

```
create fulltext index <索引的名字> on tablename（列的列表）;
```
### 单列索引与多列索引
索引可以是单列上创建的索引，也可以是在多列上创建的索引
最左原则，从左往右依次执行
创建组合索引的方式

```
create table user（name varchar(9),age int(3),sex tinyint(1),INDEX user(name,age,sex));
```
### 创建索引的原则依据
表的主键、外键必须有索引
数据量超过300行的表应该有索引
经常与其他表进行连接的表，在连接字段上应该建立索引
唯一性太差的字段不适合建立索引
更新太频繁地字段不适合创建索引
经常出现在 Where子句中的字段，特别是大表的字段，应该建立索引
索引应该建在选择性高的字段上
索引应该建在小字段上，对于大的文本字段甚至超长字段，不要建索引

### 外键与候选键
外键：主表中的外键是令一张表的主键

候选键：除了主键之外都是候选键

查看索引
```
show index from tablename;
show keys from tablename;

mysql> show index from num;
+-------+------------+------------+--------------+-------------+-----------+-------------+----------+--------+------+------------+---------+---------------+
| Table | Non_unique | Key_name   | Seq_in_index | Column_name | Collation | Cardinality | Sub_part | Packed | Null | Index_type | Comment | Index_comment |
+-------+------------+------------+--------------+-------------+-----------+-------------+----------+--------+------+------------+---------+---------------+
| num   |          0 | PRIMARY    |            1 | id          | A         |           0 |     NULL | NULL   |      | BTREE      |         |               |
| num   |          0 | name_index |            1 | name        | A         |           0 |     NULL | NULL   |      | BTREE      |         |               |
+-------+------------+------------+--------------+-------------+-----------+-------------+----------+--------+------+------------+---------+---------------+
2 rows in set (0.00 sec)

mysql> show keys from num;
+-------+------------+------------+--------------+-------------+-----------+-------------+----------+--------+------+------------+---------+---------------+
| Table | Non_unique | Key_name   | Seq_in_index | Column_name | Collation | Cardinality | Sub_part | Packed | Null | Index_type | Comment | Index_comment |
+-------+------------+------------+--------------+-------------+-----------+-------------+----------+--------+------+------------+---------+---------------+
| num   |          0 | PRIMARY    |            1 | id          | A         |           0 |     NULL | NULL   |      | BTREE      |         |               |
| num   |          0 | name_index |            1 | name        | A         |           0 |     NULL | NULL   |      | BTREE      |         |               |
+-------+------------+------------+--------------+-------------+-----------+-------------+----------+--------+------+------------+---------+---------------+
2 rows in set (0.00 sec)
```


删除索引
```
drop index index_name on table_name;
alter table table_name drop index index_name;

mysql> drop index name_index on num;
Query OK, 0 rows affected (0.01 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> show index from num;
+-------+------------+----------+--------------+-------------+-----------+-------------+----------+--------+------+------------+---------+---------------+
| Table | Non_unique | Key_name | Seq_in_index | Column_name | Collation | Cardinality | Sub_part | Packed | Null | Index_type | Comment | Index_comment |
+-------+------------+----------+--------------+-------------+-----------+-------------+----------+--------+------+------------+---------+---------------+
| num   |          0 | PRIMARY  |            1 | id          | A         |           0 |     NULL | NULL   |      | BTREE      |         |               |
+-------+------------+----------+--------------+-------------+-----------+-------------+----------+--------+------+------------+---------+---------------+
1 row in set (0.00 sec)

mysql> alter table num add unique index name_index (name);
Query OK, 0 rows affected (0.02 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> alter table num drop index name_index;
Query OK, 0 rows affected (0.02 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> show index from num;
+-------+------------+----------+--------------+-------------+-----------+-------------+----------+--------+------+------------+---------+---------------+
| Table | Non_unique | Key_name | Seq_in_index | Column_name | Collation | Cardinality | Sub_part | Packed | Null | Index_type | Comment | Index_comment |
+-------+------------+----------+--------------+-------------+-----------+-------------+----------+--------+------+------------+---------+---------------+
| num   |          0 | PRIMARY  |            1 | id          | A         |           0 |     NULL | NULL   |      | BTREE      |         |               |
+-------+------------+----------+--------------+-------------+-----------+-------------+----------+--------+------+------------+---------+---------------+
1 row in set (0.00 sec)
```

表的文件分类
表的结构文件
表的数据文件
表的索引文件
myisam不支持事务，但经常被访，被读取性能较好

## 事务
### 概念
事务是一种机制、一个操作序列，包含了一组数据库操作命令，并且把所有的命令作为一个整体一起向系统提交或撤销操作请求，即这一组数据库命令要么都执行，要么都不执行
事务是一个不可分割的工作逻辑单元，在数据库系统上执行并发操作时，事务是最小的控制单元
适用于多用户同时操作的数据库系统的场景，如银行、保险公司及证券交易系统等等
通过事务的整体性以保证数据的一致性
如果事务成功了一部分，一部分未成功，则执行回滚，回到事务的起点，重新开始操作

### 数据库设计三大范式
第一范式（确保每列保持原子性）
第一范式是最基本的范式。如果数据库表中的所有字段值都是不可分解的原子值。

第二范式（确保表中的每列都和主键相关）
第二范式在第一范式的基础之上更进一层。第二范式需要确保数据库表中的每一列都和主键相关，而不能只与主键的某一部分相关（主要针对联合主键而言）。也就说在一个数据库表中，一个表中只能保存一种数据，不可以把多种数据保存在同一张数据库表中。

第三范式（确保每列都和主键列直接相关，而不是间接相关）
第三范式需要确保数据表中的每一列数据都和主键直接相关，而不能间接相关。

### 事务的ACID特点
原子性（Atomicity）
事务是一个完整的操作，事务的各元素是不可分的（原子的）
事务中的所有元素必须作为一个整体提交或回滚
如果事务中的任何元素失败，则整个事务将失败

一致性（Consistency）
当事务完成时，数据必须处于一致状态！
    在事务开始之前，数据库中存储的数据处于一致状态；
    在正在进行的事务中，数据可能处于不一致的状态；
    当事务成功完成时，数据必须再次回到已知的一致状态

隔离性（Isolation）
对数据进行修改的所有并发事务是彼此隔离的，这表明事务必须是独立的，它不应以任何方式依赖于或影响其他事务
修改数据的事务可以在另一个使用相同数据的事务开始之前访问这些数据，或者在另一个使用相同数据的事务结束之后访问这些数据

持久性（Durability）
事务持久性指不管系统是否发生故障，事务处理的结果都是永久的
一旦事务被提交，事务的效果会被永久地保留在数据库中

事务控制
MySQL事务默认是自动提交的，当sql语句提交时事务便自动提交
事务控制语句
```
begin或start transaction		'一个事务开始'
commit				'提交一个事务'
rollback				'回滚一个事务'
savepoint identifier			'存档点'
release savepoint identifier			'删除存档点'
rollback to identifier				'回滚到identifier存档点'
set transaction					'设置事务'
```
### 事务的控制方法
手动对事务进行控制的方法
事务处理命令控制
bein：开始一个事务
commit：提交一个事务
rollback：回滚一个事务

使用set设置事务处理方式
set autocommit=0：禁止自动提交
set autocommit=1：开启自动提交 //默认状态

事务处理命令控制事务
```
mysql> use school;
Database changed
mysql> create table info(id int(5)) engine=innodb;
Query OK, 0 rows affected (0.03 sec)

mysql> select * from info;
Empty set (0.00 sec)
mysql> begin; //开始事务
Query OK, 0 rows affected (0.01 sec)

mysql> insert into info value(1);
Query OK, 1 row affected (0.00 sec)

mysql> insert into info value(2);
Query OK, 1 row affected (0.00 sec)

mysql> commit; //提交事务
Query OK, 0 rows affected (0.00 sec)

mysql> select * from info;
+------+
| id   |
+------+
|    1 |
|    2 |
+------+
2 rows in set (0.00 sec)
```

```
mysql> begin;
Query OK, 0 rows affected (0.00 sec)

mysql> insert into info value(3);
Query OK, 1 row affected (0.00 sec)

mysql> rollback;
Query OK, 0 rows affected (0.01 sec)

mysql> select * from info;
+------+
| id   |
+------+
|    1 |
|    2 |
+------+
2 rows in set (0.00 sec)
```

存储引擎 innodb （前提）
两种事务开始
begin;
set autocommit=1;
START TRANSACTION

三种情况结束事务
commit;
set autocommit=1;
rollback;

### 存储引擎
MySQL中的数据用各种不同的技术存储在文件中，每一种技术都使用不同的存储机制、索引技巧、锁定水平并最终提供不同的功能和能力，这些不同的技术以及配套的功能在 MySQL中称为存储引擎
存储引擎就是 MySQL将数据存储在文件系统中的存储方式或者存储格式

目前 MySQL常用的两种存储引擎
MyISAM
InnoDB

MySQL存储引擎是 MySQL数据库服务器中的组件，负责为数据库执行实际的数据I/O操作

MySQL系统中，存储引擎处于文件系统之上，在数据保存到数据文件之前会传输到存储引擎，之后按照各个存储引擎的存储格式进行存储

### MyISAM的介绍
#### MyISAM概念
MyISAM存储引擎是 MySQL关系数据库系统5.5版本之前默认的存储引擎，前身是ISAM
ISAM是一个定义明确且历经时间考验的数据表格管理方法，在设计之时就考虑到数据库被查询的次数要远大于更新的次数
#### ISAM的特点
​    优点：ISAM执行读取操作的速度很快
​    优点：不占用大量的内存和存储资源
​    缺点：不支持事务处理
​    缺点：不能够容错
MyISAM管理非事务表，是lSAM的扩展格式
提供ISAM里所没有的索引和字段管理的大量功能
MyISAM使用一种表格锁定的机制，以优化多个并发的读写操作
MyISAM提供高速存储和检索，以及全文搜索能力，受到web开发的青睐

MyISAM

不支持事务，也不支持外键
访问速度快
对事务完整性没有要求
表级锁定形式，数据在更新时锁定整个表
数据库在读写过程中相互阻塞
    会在数据写入的过程阻塞用户数据的读取
    也会在数据读取的过程中阻塞用户的数据写入
可通过key_buffer_size来设置缓存索引，提高访问性能，减少磁盘I/O的压力
    但缓存只会缓存索引文件，不会缓存数据
釆用 MyISAM存储引擎数据单独写入或读取，速度过程较快且占用资源相对少
MyISAM存储引擎它不支持外键约束，只支持全文索引
每个MyISAM在磁盘上存储成三个文件，每一个文件的名字以表的名字开始，扩展名指出文件类型
MyISAM在磁盘上存储成三个文件
    .frm文件存储表定义
    数据文件的扩展名为.MYD（ MYData）
    索引文件的扩展名是.MYI（ MYIndex）

MyLAM支持的存储格式

静态表，动态表，压缩表

MyISAM适用的生产场景

公司业务不需要事务的支持
一般单方面读取数据比较多的业务，或单方面写入数据比较多的业务
MyISAM存储引擎数据读写都比较频繁场景不适合
使用读写并发访问相对较低的业务
数据修改相对较少的业务
对数据业务一致性要求不是非常高的业务
服务器硬件资源相对比较差

### InnoDB
#### InnoDB的特点
支持事务：支持4个事务隔离级别
行级锁定，但是全表扫描仍然会是表级锁定
读写阻塞与事务隔离级别相关
具有非常高效的缓存特性：能缓存索引，也能缓存数据
表与主键以簇的方式存储
支持分区、表空间，类似 oracle数据库
支持外键约束，5.5以前不支持全文索引，5.5版本以后支持全文索引
对硬件资源要求还是比较高的场合

#### InnoDB适用生产场景
业务需要事务的支持
行级锁定对高并发有很好的适应能力，但需确保查询是通过索引来完成
业务数据更新较为频繁的场景，如：论坛，微博等
业务数据一致性要求较高，例如：银行业务
硬件设备内存较大，利用 Innodb较好的缓存能力来提高内存利用率，减少磁盘I/O的压力

企业选择存储引擎依据
需要考虑毎个存儲引擎提供了哪些不同的核心功能及应用场景

支持的字段和数据类型

所有引擎都支持通用的数据类型

但不是所有的引擎都支持其它的字段类型，如二进制对象

锁定类型：不同的存储引擎支持不同级别的锁定

表锁定

行锁定

索引的支持

建立索引在搜索和恢复数据库中的数据的时候能够显著提高性能

不同的存储引擎提供不同的制作索引的技术

有些存储引擎根本不支持索引

事务处理的支持

事务处理功能通过提供在向表中更新和插入信息期间的可靠性

可根据企业业务是否要支持事务选择存储引擎

修改存储引擎
方法一：alter table修改

alter table table_name engine=引擎；

方法二：修改my.cnf，指定默认存储引擎并重启服务

default-storage-engine=InnoDB

方法三：create table创建表时指定存储引擎

create table 表名（字段） engine=引擎

方法四：Mysql_convert_table_firmat转化存储引擎

Mysql_convert_table_format-user=root–password=密码–sock=/tmp/mysql.sock-engine=引擎 库名 表名 (5.7版本被移除)