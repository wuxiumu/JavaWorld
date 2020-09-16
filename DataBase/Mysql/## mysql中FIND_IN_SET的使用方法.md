## [mysql中FIND_IN_SET的使用方法](https://www.cnblogs.com/manongxiaobing/p/4682698.html)

**FIND_IN_SET和like的区别**

like是广泛的模糊匹配，字符串中没有分隔符，Find_IN_SET 是精确匹配，字段值以英文”,”分隔，Find_IN_SET查询的结果要小于like查询的结果。

```
SELECT * from test where FIND_IN_SET('20',btype)
```

