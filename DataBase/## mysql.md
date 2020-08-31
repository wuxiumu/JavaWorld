## mysql 

```
指定端口
mysql -h127.0.0.1 -uroot -P3307 -p
主要分为：连接管理、解析与优化、存储引擎三部分。
储存引擎 
show engines
InnoDB 具备外键支持，事物存储
MyISAM 非事物
CSV
MEMORY
MERGE
创建表时设置存储引擎
CREATE TABLE aaa(i int)ENGINE=InnoDB
修改表存储引擎
ALERT TABLE aaa ENGINE=MyISAM


```

## Mysql性能优化二：索引优化                

https://www.cnblogs.com/lxwphp/p/10640475.html#top