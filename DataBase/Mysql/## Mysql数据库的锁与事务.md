## Mysql数据库的锁与事务

## 并发控制

为什么需要锁呢，这时因为应用程序往往是面向多个用户的，当多个用户同时对同一条数据进行操作时，就会产生并发控制的问题。解决这个问题的一个办法，就是让这些具有修改性质的操作串行化执行，这个时候，**锁（Lock)**和**事务(Transaction)**就会被派上用场了。

## 读写锁

读锁、写锁也叫**共享锁(shared lock)**与**排他锁(exclusive lock)**

- 读锁:读锁是**共享的，互相不阻塞**。即支持多个用户同时查询同一个资源。
- 写锁: 写锁是**互斥的，排他的**。一个时间内，只能有一个线程操作同一条数据，其他线程想获取这条数据的写权限，必须等待处理写锁的线程释放资源，否则将会一直阻塞。

## 锁粒度

锁的颗粒度是并发控制中需要关注的重点，锁的颗粒度越小，那么支持的并发量也就越高。在理想的情况下，我们更希望只对修改的数据片进行精确的锁定。而锁的颗粒度越小，同时也意味着，它将占用更多的资源(获取锁、检查锁是否已经解除、释放锁)。在Mysql中，不同的存储引擎支持不同的锁策略。经典的如:**MyISAM，它是支持表锁的，而现今主流的InnoDB，则同时支持表锁与行锁**。

## 表锁 table lock

表锁是Mysql中最基本的锁策略，并且是开销最小的策略。表锁会锁住整张表，一个用户在对表进行写操作时(insert、delete、update等)前，需要先获取写锁，这时就会阻塞其他用户对该表的写操作。
 注意:ALTER TABLE之类的操作，MYSQL会使用表锁，而忽略存储引擎之间的锁机制。

## 行级锁 row lock

行级锁可以最大程度地支持并发处理，同时也带来了巨大的开销。InnoDB存储引擎实现了行级锁。

## 事务 Transaction

事务是一组原子性的SQL操作，或者说是一个独立的工作单元。如果开启事务后，其中任何一条语句无法正常执行，那么所有的语句都不会执行。即事务内的语句，要么全部执行成功。要么全部执行失败。
 事务特性如下:
 A atomicity 原子性:一个事务被视为不可分割的最小工作单元。整个事务中的所有操作要么全部提交成功，要么全部失败回滚，不可能只执行其中的一部分操作，这便是事务的原子性。
 C consistency 一致性:数据库总是从一个一致性的状态转换到另一个一致性的状态，即事务没有提交之前所做的操作不会被保存到数据库中。
 I isolation 隔离性:一个事务未提交前所做的操作对其他事务不可见。
 D durability 持久性:一旦事务提交，那么所做的修改就会永久保存到数据库中。

## 事务的隔离级别

- **READ UNCOMMITTED** 未提交读
   在READ UNCOMMITTED级别下，事务中的修改，即使没有提交，对其他事务都是可见的。事务可以读取未提交的数据，这也被称为脏读。这个级别会导致很多问题，实际应用中不推荐使用。
- **READ COMMITTED** 提交读
   大多数数据库系统的默认隔离级别是READ COMMITTED（注意，MySQL不是）。READ COMMITTED满足前面提到的隔离性的简单定义:一个事务开始时，只能看到已提交的事务所做的修改。但是如果在此级别下执行两次同样的查询，可能会得到不一样的结果，这便是不可重复读。
- **REPEATABLE READ** 可重复读
   REPEATABLE READ 解决了脏读和不可重复读的问题。该级别保证了同一事务中多次读取同样记录的结果是一致的。但是仍会产生一个幻读的问题，所谓幻读，是指当某个事务在读取某个范围内的记录时，另一个事务在该范围插入了新的记录，当之前的事务再次读取该范围的记录时，会产生幻行。InnoDB存储引擎使用了多版本并发控制MVCC解决了幻读的问题。
   此级别是MySQL默认的事务隔离级别。
- **SERIALIZABLE**(可串行化)
   SERIALIZABLE是最高的级别，它通过强制事务串行执行，避免了前面说的幻读、不可重复读、幻读的问题。它会为每一行读取的数据上锁，在高并发场景中，可能导致大量的超时与锁争用问题。
   实际应用中使用的较少。



作者：AbstractCulture
链接：https://www.jianshu.com/p/e293e4756f04
来源：简书
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

**注意：**

1、索引需要占用**磁盘空间**，因此在创建索引时要考虑到磁盘空间是否足够

2、创建索引时需要**对表加锁**，因此实际操作中需要在业务空闲期间进行

https://www.jianshu.com/p/c82148473235