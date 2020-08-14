## MySQL数据库视图：视图定义、创建视图、修改视图

关系型数据库中的数据是由一张一张的二维关系表所组成，简单的单表查询只需要遍历一个表，而复杂的多表查询需要将多个表连接起来进行查询任务。对于复杂的查询事件，每次查询都需要编写MySQL代码效率低下。为了解决这个问题，数据库提供了视图（view）功能。

## **0 视图相关的MySQL指令**

| 操作指令           | 代码                                                         |
| ------------------ | ------------------------------------------------------------ |
| 创建视图           | `CREATE VIEW 视图名(列1，列2...) AS SELECT (列1，列2...) FROM ...;` |
| 使用视图           | `当成表使用就好`                                             |
| 修改视图           | `CREATE OR REPLACE VIEW 视图名 AS SELECT [...] FROM [...];`  |
| 查看数据库已有视图 | `>SHOW TABLES [like...];`（可以使用模糊查找）                |
| 查看视图详情       | `DESC 视图名`或者`SHOW FIELDS FROM 视图名`                   |
| 视图条件限制       | `[WITH CHECK OPTION]`                                        |

## **1 视图**

百度百科定义了什么是视图，但是对缺乏相关知识的人可能还是难以理解或者只有一个比较抽象的概念，笔者举个例子来解释下什么是视图。

*朕想要了解皇宫的国库的相关情况，想知道酒窖有什么酒，剩多少，窖藏多少年，于是派最信任的高公公去清点，高公公去国库清点后报给了朕；朕又想知道藏书情况，于是又派高公公去清点并回来报告给朕，又想知道金银珠宝如何，又派高公公清点。。。过一段时间又想知道藏书情况，高公公还得重新再去清点，皇上问一次，高公公就得跑一次路。*

*后来皇上觉得高公公不容易，就成立了国库管理部门，小邓子负责酒窖，小卓子负责藏书，而小六子负责金库的清点。。。后来皇上每次想了解国库就直接问话负责人，负责人就按照职责要求进行汇报。*
![视图](https://img-blog.csdn.net/20170318153958211?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbW94aWdhbmRhc2h1/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

安排专人管理后，每次皇上想要了解国库情况，就不必让高公公每次都跑一趟，而是指定的人员按照指定的任务完成指定的汇报工作就可以了。

和数据库相对应，每次进行查询工作，都需要编写查询代码进行查询；而视图的作用就是不必每次都重新编写查询的SQL代码，而是通过视图直接查询即可。因此：

> **视图是虚拟表，本身不存储数据，而是按照指定的方式进行查询。**

比如，我们希望从前文提到的四张表，order_baisc,order_details，user和product中查找所有记录，需要写入代码指令：
![查询](https://img-blog.csdn.net/20170318154707703?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbW94aWdhbmRhc2h1/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
想再次查询这几个表中uid为u0001的用户的记录，有需要键入一次操作指令：
![查询](https://img-blog.csdn.net/20170318154840803?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbW94aWdhbmRhc2h1/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
也就是说，每次查询都得重新键入查询指令SQL代码，这种费时费力的体力活，对于时间就是生命的你我来说，是不划算的。所以借助视图，来执行相同或相似的查询。

## **2 创建视图**

**2.1 创建视图create view**
创建视图的代码为：

```
>CREATE VIEW 视图名(列1，列2...)
 AS SELECT (列1，列2...)
 FROM ...;123
```

可以看到，创建视图和查询相比，增加了前面的`CREATE VIEW 视图名 AS`

**2.2 视图运用**

> 使用视图和使用表完全一样，只需要把视图当成一张表就OK了。**视图是一张虚拟表。**

eg：创建order_baisc,order_details，user和product的查询视图，并通过视图查找uid为u0001的记录：
![创建视图](https://img-blog.csdn.net/20170318155228367?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbW94aWdhbmRhc2h1/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

**2.3 修改视图CREATE OR REPLACE VIEW**

修改和创建视图可以使用代码：

```
CREATE OR REPLACE VIEW 视图名 AS SELECT [...] FROM [...];1
```

eg:
![修改视图](https://img-blog.csdn.net/20170318155945767?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbW94aWdhbmRhc2h1/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

**2.4 查看视图**
**(1)查看数据库中有哪些视图 show tables**
前面提到，视图就是虚拟的表，因此，查看视图的方法和查看表的方法是一样的：

```
>SHOW TABLES;1
```

![查看视图](https://img-blog.csdn.net/20170320111112130?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbW94aWdhbmRhc2h1/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

通过`show tables;`反馈得到所有的表和视图。同样的，我们可以通过模糊检索的方式专门查看视图，这个时候，视图的命令统一采用的优势就体现出来了。
**（2）查看视图详情**
查看视图详情的方法有两种，一种是和查看表详情一样使用`desc 视图名`，另外一种方法是`show fields from 视图名`：

```
>DESC 视图名;
或者
>SHOW FIELDS FROM 视图名;123
```

![查看视图详情](https://img-blog.csdn.net/20170320112149745?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbW94aWdhbmRhc2h1/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

两种方法得到的详情都是一毛一样的。

## **3 视图与数据变更**

**3.1 表格数据变更**
将表product中的数据进行更新，在通过视图检索：

![视图与数据变更](https://img-blog.csdn.net/20170320113002561?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbW94aWdhbmRhc2h1/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

可以看到表格数据变化后，在通过视图检索，得到的结果也同步发生了变化，因此，在此证明了：

> **视图不是表，不保存数据，知识一张虚拟表；**

**3.2 通过视图变更数据**

- （1）插入数据

```
>INSERT INTO v_order(pid,pname,price) VALUES('p010','柴油','34');1
```

在此查询视图，发现插入了数据。

![视图变更数据](https://img-blog.csdn.net/20170320113217656?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbW94aWdhbmRhc2h1/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

- （2）跨表插入数据
  通过上图，我们可以看到，跨表插入数据系统反馈报错，提示不能修改超过一个表的数据。

> **因此，可以通过视图插入数据，但是只能基于一个基础表进行插入，不能跨表更新数据。**

- **（3）WITH CHECK OPTION**
  如果在创建视图的时候制定了“WITH CHECK OPTION”，那么更新数据时不能插入或更新不符合视图限制条件的记录。

  eg:对表product创建一个单价超过3000的视图，并加上“WITH CHECK OPTION”，之后插入一个价格为42的记录：

  ![“WITH CHECK OPTION”](https://img-blog.csdn.net/20170320113942203?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbW94aWdhbmRhc2h1/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

  可以看到系统提示错误CHECK OPTION FAILED。因为视图限制了价格要高于3000.
  后面再次尝试了不加“WITH CHECK OPTION”的视图，后者可以成功插入。

  同样的，在不加“WITH CHECK OPTION”的情况下，通过视图修改记录，也可以成功执行：
  ![修改记录](https://img-blog.csdn.net/20170320114436178?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbW94aWdhbmRhc2h1/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

通过视图修改，可能导致数据无故消失，因此：

> **没有特殊的理由，建议加上“WITH CHECK OPTION”命令。**





> **注意点：**
> \1. 视图不是表，不直接存储数据，是一张虚拟的表；
> \2. 一般情况下，在创建有条件限制的视图时，加上“WITH CHECK OPTION”命令。