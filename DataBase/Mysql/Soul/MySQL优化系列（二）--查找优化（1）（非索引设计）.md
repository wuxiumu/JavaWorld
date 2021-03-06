一、明确搜索优化的整体思路以及查询优化的因素
（1）思路
索引优化、查询优化、查询缓存、服务器设置优化、操作系统和硬件优化、应用层面优化（web服务器、缓存）等等。这些齐头并进，才能实现mysql高性能
（2）因素
①、是否向数据库请求了不需要的数据。
即不要轻易使用select * from，能明确多少数据就查多少个
②、mysql是否扫描额外的记录
查询是否扫描了过多的数据。衡量指标：响应时间；扫描的行数；返回的行数。可以大致反映mysql在内部执行查询时需要多少数据，并可以推算出查询运行的时间。
**这三个指标都会记录到mysql的慢日志中，所以检查慢日志记录是找出扫描行数过多的查询的好办法。**
**响应时间：**=服务时间（真正处理这个查询花费的时间）+排队时间（服务器因为等待某些资源而没有真正执行查询的时间。可能是等io操作完成，也可能是等待行锁等）
**扫描的行数和返回的行数：**分析查询时，查看该查询扫描的行数非常有帮助
**扫描的行数和访问类型：**在explain语句中的type列反应了访问类型。访问类型有多种，从全表扫描(all)到索引扫描（index）到范围扫描（range）到唯一索引查询到常数引用等。
**如果发现查询需要扫描大量的数据但只返回少数的行，那么通常可以尝试下面的技巧去优化它：**
使用索引覆盖扫描
改变表结构。例如使用单独的汇总表
重写这个复杂的查询，让mysql优化器能够以更优化的方式执行这个查询。
③、查询方式
a、一个复杂查询 or多个简单查询
设计查询的时候一个需要考虑的重要问题是，是否需要将一个复杂的查询分成多个简单的查询。
b、切分查询
将大查询分为小查询，每个查询功能完全一样，只完成一部分，每次只返回一部分查询结果。
c、分解关联查询
让缓存的效率更高。
将查询分解后，执行单个查询可以减少锁的竞争。
在应用层做关联，可以更容易对数据库进行拆分，更容易做到高性能和可扩展。
查询本身的效率也可能会有所提升
可以减少荣誉记录的查询。
更进一步，这样做相当于在应用中实现了哈希关联，而不是使用mysql的嵌套循环关联
（3）查询的流程
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190110152320852.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NoZW54aWFvMTk4ODY2NjY2,size_16,color_FFFFFF,t_70)
1、客户端发送一条查询给服务器
2、服务器先检查查询缓存，如果命中了缓存，则立刻返回存储在缓存中的结果，否则进入下一阶段
3、服务器进行sql解析，预处理，再由优化器生成对应的执行计划
4、mysql根据优化器生成的执行计划，调用存储引擎的api来执行查询
5、将结果返回给客户端。
二、优化查询前的几个工具说明
**（1）查看mysql整体状态**
show status like ‘xxx’;—显示状态信息
show variables —显示系统变量
show innodb status;—显示innodb存储引擎的状态
show processlist —查看当前sql执行，包括执行状态、是否锁表等
mysqladmin variables -u username -p password ----显示系统变量
mysqladmin extended-status -u username -p password —显示状态信息
mysqlld -verbose --help 查看状态变量及帮助
**（2）开启慢查询日志**
**1. 在配置文件my.cnf或my.ini中在[mysqld]一行下面加入两个配置参数**
log-slow-queries=/data/mysqldata/slow-query.log
long_query_time=10
log-queries-not-using-indexes
log-slow-queries参数为慢查询日志存放的位置，一般这个目录要有mysql的运行帐号的可写权限，一般都将这个目录设置为mysql的数据存放目录；
long_query_time=2中的2表示查询超过两秒才记录；
在my.cnf或者my.ini中添加log-queries-not-using-indexes参数，表示记录下没有使用索引的查询。
**2. 查看日志启动状态：show variables like “slow%”;**
**3. 设置慢日志开启: set global slow_query_log = ON;**
**4. 查询long_query_time 的值 ：
show variables like “long%”;**
**5. 为了方便测试，可以将修改慢查询时间为3秒。（小点容易比较，毕竟mysql处理那么快）**
**6.以后就往我们设置的日志路径去访问日志即可：**
**（3）explain查询分析**
**使用explain关键字可以模拟优化器执行sql查询语句**从而知道mysql是如何处理你的sql语句的。可以帮你分析你的查询语句或是表结构的性能瓶颈。
通过explain命令可以得到：
表的读取顺序
数据读取操作的操作类型
哪些索引可以使用
哪些索引被实际使用
表之间的引用
每张表有多少行被优化器查询
EXPLAIN查询出来的字段解析：
1）Table：显示这一行的数据是关于哪张表的
2）possible_keys：显示可能应用在这张表中的索引。如果为空，没有可能的索引。可以为相关的域从where语句中选择一个合适的语句。
之处mysql能使用哪个索引在表中找到记录，查询涉及到的字段上若存在索引，则该索引将被列出，但不一定被查询使用，因为mysql内部优化器有自己的抉择。
该列完全独立于EXPLAIN输出所示的表的次序。这意味着在possible_keys中的某些键实际上不能按生成的表次序使用。

如果该列是NULL，则没有相关的索引。在这种情况下，可以通过检查WHERE子句看是否能引用某些列或适合索引的列来提高你的查询性能。如果是这样，创造一个适当的索引并且再次用EXPLAIN检查查询
3）key：实际使用的索引。
如果为NULL，则没有使用索引。MYSQL很少会选择优化不足的索引，此时可以在SELECT语句中使用USE INDEX（index）来强制使用一个索引或者用IGNORE INDEX（index）来强制忽略索引。
4）key_len：使用的索引的长度。
在不损失精确性的情况下，长度越短越好

表示索引中使用的字节数，可通过该列计算查询中使用的索引的长度（key_len显示的值为索引字段的最大可能长度，并非实际使用长度，即key_len是根据表定义计算而得，不是通过表内检索出的）

不损失精确性的情况下，长度越短越好
5）ref：显示索引的哪一列被使用了，如果可能的话，是一个常数。
表示上述表的连接匹配条件，即哪些列或常量被用于查找索引列上的值
6）rows：MySQL认为必须检索的用来返回请求数据的行数
表示MySQL根据表统计信息及索引选用情况，估算的找到所需的记录所需要读取的行数
7）select_type：查询中每个select子句的类型
(1) SIMPLE(简单SELECT,不使用UNION或子查询等)
(2) PRIMARY(查询中若包含任何复杂的子部分,最外层的select被标记为PRIMARY)
(3) UNION(UNION中的第二个或后面的SELECT语句)
(4) DEPENDENT UNION(UNION中的第二个或后面的SELECT语句，取决于外面的查询)
(5) UNION RESULT(UNION的结果)
(6) SUBQUERY(子查询中的第一个SELECT)
(7) DEPENDENT SUBQUERY(子查询中的第一个SELECT，取决于外面的查询)
(8) DERIVED(派生表的SELECT, FROM子句的子查询)
(9) UNCACHEABLE SUBQUERY(一个子查询的结果不能被缓存，必须重新评估外链接的第一行)
8）type：这是最重要的字段之一
显示查询使用了何种类型。从最好到最差的连接类型为NULL、system、const、eq_ref、ref、range、index和ALL。
null:在优化过程中分解语句，执行时甚至不用访问表或索引，例如从一个索引列里选取最小值可以通过单独索引查找完成。
system、const:可以将查询的变量转为常量，如id=1;id为主键或者唯一键。当mysql对查询某部分进行优化，并转换成一个常量时，使用这些类型访问。如将主键置于where列表中，mysql就能将该查询转换为一个常量，system是const类型的特例，当查询的表只有一行的情况下，使用system
eq_ref：访问索引，返回某单一行的数据（通常在联接时出现，查询使用的索引为主键或唯一键）。类似ref，区别就在使用的索引是唯一索引，对于每个索引键值，表中只有一条记录匹配，简单来说，就是夺标联接中使用primary key 或者unique key作为关联条件
ref：访问索引,返回某个值的所有数据.(可以返回多行) 通常使用=时发生。表示上述表的连接匹配条件，即哪些列或常量被用于查找索引列上的值
range：
这个连接类型使用索引返回一个范围中的行，比如使用>或<查找东西，并且该字段上建有索引时发生的情况(注:不一定好于index)。只检索给定范围的行，使用一个索引来选择行。

index：
以索引的顺序进行全表扫描，优点是不用排序,缺点是还要全表扫描。index与ALL区别为index类型只遍历索引树

ALL：
全表扫描，应该尽量避免。 MySQL将遍历全表以找到匹配的行。
9）Extra：关于MYSQL如何解析查询的额外信息，主要有以下几种
using index：
只用到索引,可以避免访问表.。表示查询在索引树中就可查找所需数据, 不用扫描表数据文件, 往往说明性能不错

using where：
使用到where来过虑数据. 不是所有的where clause都要显示using where. 如以=方式访问索引.

using tmporary：
查询有使用临时表, 一般出现于排序, 分组和多表 join 的情况, 查询效率不高, 建议优化.

using filesort：
用到额外的排序. (当使用order by v1,而没用到索引时,就会使用额外的排序)。MySQL中无法利用索引完成的排序操作称为“文件排序”

range checked for eache record(index map:N)：
没有好的索引.

Using join buffer：
改值强调了在获取连接条件时没有使用索引，并且需要连接缓冲区来存储中间结果。如果出现了这个值，那应该注意，根据查询的具体情况可能需要添加索引来改进能。

Impossible where：
这个值强调了where语句会导致没有符合条件的行。
（4）profiling查询分析：
通过慢查询可以知道哪些sql语句执行效率低下，通过explain可以得知sql语句的具体执行情况、索引使用等，还可以结合show命令查看执行状态。
若explain信息还不能满足，可以通过profiling命令得到更准确的sql执行消耗系统资源的信息。
profiling默认是关闭的，可以通过 select @@profiling 查看状态
打开profiling查询分析：set profiling =1
查看被执行的SQL语句的时间和ID：show profiles\G;
show profile for query 1; 得到对应SQL语句执行的详细信息
通过profiling资源耗费信息，我们可以采取针对性的优化措施。
**三、单表查询步步优化（暂不讨论索引，在下篇文章再详解索引）**
**（1）明确需要多少字段，要多少就写多少字段**
**（2）使用分页语句：limit start,count或者条件where子句。**有什么课限制的条件尽量加上，查一条就limit一条，做到不多拿不乱拿，明确子句的执行顺序
**1）limit语句的查询时间与起始记录的位置成正比**
**2）mysql的limit语句是很方便，但是对记录很多表并不适合直接使用。**
对limit分页性能优化分析:
**偏移量越大，查询越费时。**因为每条数据的实际存储长度不一样（所以必须要一次遍历，不能直接跳过前面的一部分）；哪怕是每条数据存储长度一样，如果之前有过delete操作，那索引上的排列就有gap；所以数据不是订场存储，不能像数组那样用index来访问，只能一次遍历，就导致偏移量越大越费时
利用自增主键，避免offset的使用
**（3）、如果是有序的查询，可用order by**
**（4）、开启查询缓存：**大多数的mysql服务器都开启了查询缓存。这是提高性能最有效的方法之一。当有很多相同的查询被执行了多次的时候，这些查询结果会被放到一个缓存中，这样，后续的相同的查询就不用操作表而直接访问缓存结果了。
**命中缓存条件：**
缓存存在一个hash表中，通过查询sql、查询数据库、客户端协议等作为key，在判断是否命中前，mysql不会解析sql，而是直接使用sql去查询缓存，sql任何字符上的不同，如空格、注释都会导致缓存不命中。
如果查询中有不确定数据，例如current_date()和now()函数，那么查询完毕后则不会被缓存，所以包含不确定数据的查询是肯定不会找到可用缓存的。
**工作流程：**
1）服务器接收sql,以sql和一些其他条件为key查找缓存表（额外性能消耗）
2）如果找到了缓存，则直接返回缓存（性能提升）
3）如果没有找到缓存，则执行sql查询，包括原来的sql解析、优化等
4）执行完sql查询结果以后，将sql查询结果存入缓存表（额外性能消耗）
**缓存使用的时机（并非任务情况使用缓存都是好的）：**
衡量打开缓存是否对系统有性能提升是一个整体的概念。
1）通过缓存命中率判断，缓存命中率=缓存命中次数/查询次数
2）通过缓存写入率，写入率=魂村写入次数/查询次数
3）通过命中-写入率判断，比率= 命中次数/写入次数。高性能mysql中称之为比较能反应性能提升的指数，一般来说达到3:1则算是查询缓存有效，而最好能够达到10:1。
**缓存参数配置：**
1）query_cache_type: 是否打开缓存：
可选项：OFF: 关闭；ON: 总是打开；DEMAND: 只有明确写了SQL_CACHE的查询才会吸入缓存
2）query_cache_size: 缓存使用的总内存空间大小,单位是字节,这个值必须是1024的整数倍,否则MySQL实际分配可能跟这个数值不同(感觉这个应该跟文件系统的blcok大小有关)
3）query_cache_min_res_unit: 分配内存块时的最小单位大小
4）query_cache_limit: MySQL能够缓存的最大结果,如果超出,则增加 Qcache_not_cached的值,并删除查询结果
**5）query_cache_wlock_invalidate:**
如果某个数据表被锁住,是否仍然从缓存中返回数据,默认是OFF,表示仍然可以返回
**6）缓存的一些整体参数：**
Qcache_free_blocks: 缓存池中空闲块的个数

Qcache_free_memory: 缓存中空闲内存量

Qcache_hits: 缓存命中次数

Qcache_inserts: 缓存写入次数

Qcache_lowmen_prunes: 因内存不足删除缓存次数

Qcache_not_cached: 查询未被缓存次数,例如查询结果超出缓存块大小,查询中包含可变函数等

Qcache_queries_in_cache: 当前缓存中缓存的SQL数量

Qcache_total_blocks: 缓存总block数
**减少碎片策略：
1）选择合适的block大小
2）使用 FLUSH QUERY CACHE 命令整理碎片.这个命令在整理缓存期间,会导致其他连接无法使用查询缓存**
PS: 清空缓存的命令式 RESET QUERY CACHE
**InnoDB与查询缓存：**
Innodb会对每个表设置一个事务计数器，里面存储当前最大的事务ID，当一个事务提交时，innodb会使用mvcc中系统事务id最大的事务id更新当前表的计数器。只有比这个最大id大额事务能使用查询u俺村，其他比这个ID小的事务则不能使用查询缓存。
另外，在innodb中，所有有枷锁操作的事务都不适用任何查询缓存。