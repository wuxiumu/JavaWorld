# MySQL进阶学习笔记二

1、高级查询
(1)了解笛卡尔积：笛卡尔乘积是指在数学中，两个集合X和Y的笛卡尔积（Cartesian product），又称直积，表示为X × Y，第一个对象是X的成员而第二个对象是Y的所有可能有序对的其中一个成员，笛卡尔积在SQL中的实现方式既是交叉连接(Cross Join)。所有连接方式都会先生成临时笛卡尔积表，笛卡尔积是关系代数里的一个概念，表示两个表中的每一-行数据任意组合。

(2) 关联查询（连接查询）

      (a)内连接：内连接与连接顺序无关
    
         关联表中都出现的字段值最终才能出现再结果集中

SELECT * FROM app_order_base a,app_order_details b WHERE a.id=b.goods_id
SELECT * FROM app_order_base a INNER JOIN app_order_details b on a.id=b.goods_id
#通用列字段名称必须一致，可以去掉重复字段
SELECT * FROM app_order_base a INNER JOIN app_order_details USING(id)  
      (b)外连接：有主从表之分，与连接顺序有关

         依次遍历主表中记录，与从表中记录进行匹配;如果匹配到则连接展 示，否则以null填充。
    
         左外连接：left[outer] join on

SELECT * FROM app_order_base a LEFT JOIN app_order_details b on a.id=b.goods_id
         右外连接：right[outer] join on

SELECT * FROM app_order_base a RIGHT JOIN app_order_details b on a.id=b.goods_id
         自然连接(特殊连接)：

         自然连接肯定是等值连接，但是等值连接不一定是自然连接

SELECT * FROM app_order_base NATURAL JOIN app_order_details;
         查看数据库编码

#查看数据库编码 
SHOW VARIABLES LIKE '%char%'
(3)子查询（嵌套查询）：

         嵌套查询：将一个查询的结果当作另一个查询的条件或者结果集。
    
         子查询比较接近思考方式，最自然的查询。
    
     分类
    
         (a)单行子查询:子查询的结果有一条
    
         (b)多行子查询:子查询的结果有多条

in:   in(value,value)
any:  =any 相当于in   
      >any 大于最小值  
      <any 小于最大值
all： >all 大于最大值
      <all 小于最小值
#in和exists的区别：
   in 先执行子查询，将结果返回给主查询，主查询继续执行
   exists 先执行主查询，将主查询的值依次在子查询中进行匹配，根据是否匹配返回true和false，如果是true值连接展示，否则不展示
#多表和子查询
   子查询 --->查询条件和结果放在一张表中。
          查询结果分布于多张表
   关联查询
(4)联合查询：

     关键字：union/union all union可以去除重复

2、存储引擎和事务
(1)存储引擎（show ENGINES）：数据库底层软件组织，dbms通过存储引擎实现对数据的操作，MySQL核心就是存储引擎。

        MySQL中可以设置多种存储引擎，不同的存储引擎在索引，存储，以及策略上是不同的。
    
        数据库存储引擎是数据库底层软件组织，数据库管理系统(DBMS)使用数据引擎进行创建、查询、更新和删除数据。不同的存储引擎提供不同的存储机制、素引技巧、锁定水平等功能，使用不同的存储引擎，还可以获得特定的功能。Mysql 的核心就是存储引擎。
    
        InnoDB是事务型数据库的首选，执行安全性数据库，行锁定和外键。mysql5.5 之后默认使用。
    
        MyISAM插入速度和查询效率较高，但不支持事务。
    
        MEMORY将表中的数据存储在内存中，速度较快。

各个存储引擎的不同之处：

功能

MyISAM

MEMORY

InnoDB

Archive

存储限制

256TB

RAM

64TB

None

支持事务

N

N

Y

N

支持全文索引

Y

N

N

N

支持数索引

Y

Y

Y

N

支持哈希索引

N

Y

N

N

支持数据缓存

N

N/A

Y

N

支持外键

N

N

Y

N

       mysql5.5以前默认存储引擎为MyISAM：支持全文搜索，不支持事务。
    
       mysql5.5+默认存储引擎为INNODB：支持事务、行级锁。

(2)事务：保持数据一致性，一组DML操作要么同时成功，要么同时失败。

 （a）事务的acid特性：

        原子性：放在同一事务的一组操作时不可分割的；
    
        一致性：在事务的执行前后整体的状态保持不变；
    
        隔离性：并发事务之间相互不干扰；
    
        持久性：事务执行之后将永久化到数据库；
    
    (b) 事务语法（数据库中）：MySQL默认采用事务自动提交。

#查看MySQL的事务自动提交
show variables like 'autocommit'
#修改自动提交
set autocommit = 0;  #手动提交事务
set autocommit = 1;  #自动提交事务
#显示开启事务(begin)：
start transaction;
#手动提交事务或回滚
commit; #提交
rollback #回滚  
  （c）并发事务产生的问题

        脏读：一个事务执行范围内读到了另一条未提交的数据；
    
        不可重复读：一个事务在只读范围内，被另一事务修改并提交事务，导致多次读取事务不一致的问题。
    
        幻读（虚读）：一个事务只读范围内，被另一事务删除或者添加数据，导致读取数据不一致问题。

（d)事务隔离级别：

        读未提交：不能处理任何问题；
    
        读已提交：解决脏读问题；
    
        可重复读：解决脏读和不可重复读问题；
    
        串行化：解决所有问题，效率较低；

#查看事务隔离级别
SELECT @@tx_isolation
#修改事务隔离级别
set session transaction isolation level
3、存储程序
(1)、运行于服务器端程序

(2)、优点：

     简化开发，执行效率较高，

(3)缺点：

     程序保存在服务器端，占用服务器资源
    
     数据迁移的时候考虑迁移所有的存储程序
    
     调试编写程序不方便

(4)、分类

     存储过程：服务器端运行的可重复调用的sql代码块，包含名称，输入输出参数，一组sql。

#修改结束标志
delimiter //;
#创建存储过程
create procedure sel_emp()
begin
 #sql
 select * from student;
end;

#存储过程调用
call sel_emp();

#参数的传入
delimiter //;
create procedure findEmpByNo(in eno int)
begin
selete * from emp where deptno = dno;
end;
call findEmpByNo(20);

#参数的输出
delimiter //;
create procedure findNameByNo(in eno int,out v_name varchar(20))
begin
  select ename into v_name from emp where empno = eno;
end;
call findNameByNo(7788,@v_name);
select @v_name;
        存储函数：存储在服务器端，有返回值，函数作为sql一部分使用。

delimiter //;
create function findNameByNo(eno int)
returns varchar(20) #返回值类型
DETERMINISTIC #确定的
begin
  declare v_name varchar(20);#与上边定义的一致
  select ename from where empon=eno;
  return v_name;
end;
#调用
select findNameByNo(7788);
函数和存储过程的区别：

关键字不同 
存储过程三种参数模式实现数据输入输出，函数有返回值返回数据 
存储过程可以作为单独个体执行，函数只能作为sql的一部分执行
触发器

存储程序，存储再服务器端
由事件（增删改）调用，不能传参
不要添加过多的触发器（降低效率）
存储程序中不能使用事务控制

#创建触发器
delimiter //;
create trigger tri_user
after delete
on userinfo for each row
begin
  #old  new 
  insert into user_bak values(old.uid,old.uname,old.password)
end;
4、清除表中数据的方式：
(1)、清空全部数据，不写日志，不可恢复，速度很快

　　 truncate table 表名;·

(2)、清空全部数据，写日志，可恢复，速度很慢

　　 delete from 表名;
————————————————
版权声明：本文为CSDN博主「King-Java」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/Java_xiaoxinxin/java/article/details/107319331