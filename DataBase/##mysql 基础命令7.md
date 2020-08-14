## mysql 基础命令7

```
mysql> CREATE TEMPORARY TABLE SalesSummary (
     product_name VARCHAR(50) NOT NULL
      , total_sales DECIMAL(12,2) NOT NULL DEFAULT 0.00
      , avg_unit_price DECIMAL(7,2) NOT NULL DEFAULT 0.00
      , total_units_sold INT UNSIGNED NOT NULL DEFAULT 0
);
Query OK, 0 rows affected (0.00 sec)

mysql> INSERT INTO SalesSummary
     (product_name, total_sales, avg_unit_price, total_units_sold)
    VALUES
    ('cucumber', 100.25, 90, 2);

mysql> SELECT * FROM SalesSummary;
+--------------+-------------+----------------+------------------+
| product_name | total_sales | avg_unit_price | total_units_sold |
+--------------+-------------+----------------+------------------+
| cucumber     |      100.25 |          90.00 |                2 |
+--------------+-------------+----------------+------------------+
1 row in set (0.00 sec)
```

当你使用 **SHOW TABLES**命令显示数据表列表时，你将无法看到 SalesSummary表。

如果你退出当前MySQL会话，再使用 **SELECT**命令来读取原先创建的临时表数据，那你会发现数据库中没有该表的存在，因为在你退出时该临时表已经被销毁了。

```
DROP TABLE SalesSummary;
```

