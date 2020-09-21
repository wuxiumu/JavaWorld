## mysql 基础命令4

```

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `runoob_tbl`
-- ----------------------------
DROP TABLE IF EXISTS `runoob_tbl`;
CREATE TABLE `runoob_tbl` (
  `runoob_id` int(11) NOT NULL AUTO_INCREMENT,
  `runoob_title` varchar(100) NOT NULL,
  `runoob_author` varchar(40) NOT NULL,
  `submission_date` date DEFAULT NULL,
  PRIMARY KEY (`runoob_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `runoob_tbl`
-- ----------------------------
BEGIN;
INSERT INTO `runoob_tbl` VALUES ('1', '学习 PHP', '菜鸟教程', '2017-04-12'), ('2', '学习 MySQL', '菜鸟教程', '2017-04-12'), ('3', '学习 Java', 'RUNOOB.COM', '2015-05-01'), ('4', '学习 Python', 'RUNOOB.COM', '2016-03-06'), ('5', '学习 C', 'FK', '2017-04-05');
COMMIT;

-- ----------------------------
--  Table structure for `tcount_tbl`
-- ----------------------------
DROP TABLE IF EXISTS `tcount_tbl`;
CREATE TABLE `tcount_tbl` (
  `runoob_author` varchar(255) NOT NULL DEFAULT '',
  `runoob_count` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `tcount_tbl`
-- ----------------------------
BEGIN;
INSERT INTO `tcount_tbl` VALUES ('菜鸟教程', '10'), ('RUNOOB.COM ', '20'), ('Google', '22');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
```

- **INNER JOIN（内连接,或等值连接）**：获取两个表中字段匹配关系的记录。
- **LEFT JOIN（左连接）：**获取左表所有记录，即使右表没有对应匹配的记录。
- **RIGHT JOIN（右连接）：** 与 LEFT JOIN 相反，用于获取右表所有记录，即使左表没有对应匹配的记录。

```
SELECT a.runoob_id, a.runoob_author, b.runoob_count FROM runoob_tbl a INNER JOIN tcount_tbl b ON a.runoob_author = b.runoob_author;
SELECT a.runoob_id, a.runoob_author, b.runoob_count FROM runoob_tbl a, tcount_tbl b WHERE a.runoob_author = b.runoob_author;
```

- **IS NULL:** 当列的值是 NULL,此运算符返回 true。

- **IS NOT NULL:** 当列的值不为 NULL, 运算符返回 true。

- **<=>:** 比较操作符（不同于 = 运算符），当比较的的两个值相等或者都为 NULL 时返回 true。

  ```
  root@host# mysql -u root -p password;
  Enter password:*******
  mysql> use RUNOOB;
  Database changed
  mysql> create table runoob_test_tbl
      -> (
      -> runoob_author varchar(40) NOT NULL,
      -> runoob_count  INT
      -> );
  Query OK, 0 rows affected (0.05 sec)
  mysql> INSERT INTO runoob_test_tbl (runoob_author, runoob_count) values ('RUNOOB', 20);
  mysql> INSERT INTO runoob_test_tbl (runoob_author, runoob_count) values ('菜鸟教程', NULL);
  mysql> INSERT INTO runoob_test_tbl (runoob_author, runoob_count) values ('Google', NULL);
  mysql> INSERT INTO runoob_test_tbl (runoob_author, runoob_count) values ('FK', 20);
   
  mysql> SELECT * from runoob_test_tbl;
  +---------------+--------------+
  | runoob_author | runoob_count |
  +---------------+--------------+
  | RUNOOB        | 20           |
  | 菜鸟教程       | NULL         |
  | Google        | NULL         |
  | FK            | 20           |
  +---------------+--------------+
  4 rows in set (0.01 sec)
  
  mysql> SELECT * FROM runoob_test_tbl WHERE runoob_count = NULL;
  Empty set (0.00 sec)
  mysql> SELECT * FROM runoob_test_tbl WHERE runoob_count != NULL;
  Empty set (0.01 sec)
  
  mysql> SELECT * FROM runoob_test_tbl WHERE runoob_count IS NULL;
  +---------------+--------------+
  | runoob_author | runoob_count |
  +---------------+--------------+
  | 菜鸟教程       | NULL         |
  | Google        | NULL         |
  +---------------+--------------+
  2 rows in set (0.01 sec)
   
  mysql> SELECT * from runoob_test_tbl WHERE runoob_count IS NOT NULL;
  +---------------+--------------+
  | runoob_author | runoob_count |
  +---------------+--------------+
  | RUNOOB        | 20           |
  | FK            | 20           |
  +---------------+--------------+
  2 rows in set (0.01 sec)
  ```

  