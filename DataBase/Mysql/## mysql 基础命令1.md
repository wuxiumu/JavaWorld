## mysql 基础命令1

数据库（Database）是按照数据结构来组织、存储和管理数据的仓库。

- **数据库:** 数据库是一些 关联表 的集合。
- **数据表:** 表是 数据的矩阵。在一个数据库中的表看起来像一个简单的电子表格。
- **列:** 一列(数据元素) 包含了相同类型的数据, 例如邮政编码的数据。
- **行：**一行（=元组，或记录）是一组相关的数据，例如一条用户订阅的数据。
- **冗余**：存储两倍数据，冗余降低了性能，但提高了数据的安全性。
- **主键**：主键是唯一的。一个数据表中只能包含一个主键。你可以使用主键来查询数据。
- **外键：**外键用于关联两个表。
- **复合键**：复合键（组合键）将多个列作为一个索引键，一般用于复合索引。
- **索引：**使用索引可快速访问数据库表中的特定信息。索引是对数据库表中一列或多列的值进行排序的一种结构。类似于书籍的目录。
- **参照完整性:** 参照的完整性要求关系中不允许引用不存在的实体。与实体完整性是关系模型必须满足的完整性约束条件，目的是保证数据的一致性。

```
CREATE DATABASE 数据库名;
drop database <数据库名>;
use DATABASE;
```

## 数值类型

| 类型         | 大小                                     | 范围（有符号）                                               |                        范围（无符号）                        |      用途       |
| :----------- | :--------------------------------------- | :----------------------------------------------------------- | :----------------------------------------------------------: | :-------------: |
| TINYINT      | 1 byte                                   | (-128，127)                                                  |                           (0，255)                           |    小整数值     |
| SMALLINT     | 2 bytes                                  | (-32 768，32 767)                                            |                         (0，65 535)                          |    大整数值     |
| MEDIUMINT    | 3 bytes                                  | (-8 388 608，8 388 607)                                      |                       (0，16 777 215)                        |    大整数值     |
| INT或INTEGER | 4 bytes                                  | (-2 147 483 648，2 147 483 647)                              |                      (0，4 294 967 295)                      |    大整数值     |
| BIGINT       | 8 bytes                                  | (-9,223,372,036,854,775,808，9 223 372 036 854 775 807)      |               (0，18 446 744 073 709 551 615)                |   极大整数值    |
| FLOAT        | 4 bytes                                  | (-3.402 823 466 E+38，-1.175 494 351 E-38)，0，(1.175 494 351 E-38，3.402 823 466 351 E+38) |         0，(1.175 494 351 E-38，3.402 823 466 E+38)          | 单精度 浮点数值 |
| DOUBLE       | 8 bytes                                  | (-1.797 693 134 862 315 7 E+308，-2.225 073 858 507 201 4 E-308)，0，(2.225 073 858 507 201 4 E-308，1.797 693 134 862 315 7 E+308) | 0，(2.225 073 858 507 201 4 E-308，1.797 693 134 862 315 7 E+308) | 双精度 浮点数值 |
| DECIMAL      | 对DECIMAL(M,D) ，如果M>D，为M+2否则为D+2 | 依赖于M和D的值                                               |                        依赖于M和D的值                        |     小数值      |

------

## 日期和时间类型

表示时间值的日期和时间类型为DATETIME、DATE、TIMESTAMP、TIME和YEAR。

## 字符串类型

字符串类型指CHAR、VARCHAR、BINARY、VARBINARY、BLOB、TEXT、ENUM和SET。

```
CREATE TABLE table_name (column_name column_type);
CREATE TABLE IF NOT EXISTS `runoob_tbl`(
   `runoob_id` INT UNSIGNED AUTO_INCREMENT,
   `runoob_title` VARCHAR(100) NOT NULL,
   `runoob_author` VARCHAR(40) NOT NULL,
   `submission_date` DATE,
   PRIMARY KEY ( `runoob_id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE table_name ;
INSERT INTO table_name ( field1, field2,...fieldN )
                       VALUES
                       ( value1, value2,...valueN );
              
 SELECT column_name,column_name
FROM table_name
[WHERE Clause]
[LIMIT N][ OFFSET M]
```