# [MySQL查询语句的45道练习](https://www.cnblogs.com/aqxss/p/6563625.html)

一、设有一数据库，包括四个表：

学生表（Student）、课程表（Course）、成绩表（Score）以及教师信息表（Teacher）。

四个表的结构分别如表1-1的表（一）~表（四）所示，数据如表1-2的表（一）~表（四）所示。用SQL语句创建四个表并完成相关题目。

1、 查询Student表中的所有记录的Sname、Ssex和Class列。

```
SELECT name,ssex,class FROM student
```

2、 查询教师所有的单位即不重复的Depart列。

```
SELECT distinct depart FROM teacher
```

3、 查询Student表的所有记录。

```
SELECT * FROM student
```

4、 查询Score表中成绩在60到80之间的所有记录。

```
SELECT * FROM score WHERE degree between 60 and 80
```

5、 查询Score表中成绩为85，86或88的记录。

```
SETECT * FROM score WHERE degree in (85,86,88)
```

6、 查询Student表中“95031”班或性别为“女”的同学记录。

```
SELECT * FROM student WHERE class=95031 OR Ssex='女'
```

7、 以Class降序查询Student表的所有记录。

```
SELECT * FROM student ORDER BY class DESC
```

8、 以Cno升序、Degree降序查询Score表的所有记录。

```
SELECT * FROM score ORDER BY cno ASC,degree DESC
```

9、 查询“95031”班的学生人数。

```
SELECT count(*) FROM student WHERE class=95031
```

10、   查询Score表中的最高分的学生学号和课程号。（子查询或者排序）

```
SELECT sno,cno FROM score WHERE degree=(SELECT max(degree) FROM score)
SELECT sno,cno FROM score ORDER BY degree DESC LIMIT 0,1
```

11、   查询每门课的平均成绩。

```
SELECT cno,avg(degree) FROM score GROUP BY cno
```

12、   查询Score表中至少有5名学生选修的并以3开头的课程的平均分数。

```
SELECT avg(degree) FROM score WHERE cno LIKE '3%' and cno IN (SELECT cno FROM score GROUP BY cno HAVING count(*)>=5)

SELECT avg(degree) FROM score WHERE cno LIKE '3%' AND GROUP BY cno HAVING count(*)>=5
```

13、   查询分数大于70，小于90的Sno列。

```
select` `Sno ``from` `Score ``where` `degree>70 ``and` `degree<90
```

14、   查询所有学生的Sname、Cno和Degree列。

```
select` `Sname, Cno,Degree ``from` `Score , student ``where` `Score.Sno=student.Sno
```

15、   查询所有学生的Sno、Cname和Degree列。

```
select` `Sno,Cname,Degree ``from` `Score , Course ``where` `Score.Cno=Course.Cno
```

16、   查询所有学生的Sname、Cname和Degree列。

```
select` `Sname,Cname,Degree ``from` `student,course,score ``where` `student.Sno=score.Sno ``and` `course.Cno=score.Cno
join` `.. ``on` `写法：``select` `Sname,Cname,Degree ``from` `student ``join` `score ``on` `student.Sno=score.Sno ``join` `course ``on` `course.Cno=score.Cno
```

17、   查询“95033”班学生的平均分。

```
select` `avg``(degree) ``as` `'class=95033'` `from` `Score ``where` `Sno ``in` `(``select` `Sno ``from` `Student ``where` `Class=``'95033'` `) 　
```

18、 假设使用如下命令建立了一个grade表：

create table grade(low int(3),upp int(3),rank char(1))

insert into grade values(90,100,’A’)

insert into grade values(80,89,’B’)

insert into grade values(70,79,’C’)

insert into grade values(60,69,’D’)

insert into grade values(0,59,’E’)

现查询所有同学的Sno、Cno和rank列。

```
select` `Sno,Cno,rank ``from` `Score,grade ``where` `degree ``between` `low ``and` `upp
```

19、查询选修“3-105”课程的成绩高于“109”号同学成绩的所有同学的记录。

```
<span style=``"color: #000000; font-size: 15px"``>109同学，选修是3-105课的</span>
select` `* ``from` `score ``where` `Cno=``'3-105'` `and` `degree>(``select` `max``(degree ) ``from` `Score ``where` `Sno=``'109'` `and` `Cno=``'3-105'` `)
<span style=``"font-size: 15px"``>109同学，没有选修3-105课</span>
select` `* ``from` `score ``where` `Cno=``'3-105'` `and` `degree>(``select` `max``(degree ) ``from` `Score ``where` `Sno=``'109'``)
```

and `degree<( ``select` `max``(degree ) ``from` `Score ``where` `sno ``in` `(``select` `Sno ``from` `score ``group` `by` `Sno ``having` `count``(*)>1))`

```
选了多门课程并且是这个课程下不是最高分的
select` `* ``from` `score a ``where` `Sno ``in` `(``select` `Sno ``from` `score ``group` `by` `Sno ``having` `count``(*)>1) ``and` `degree<( ``select` `max``(degree ) ``from` `Score b ``where` `b.cno = a.cno)
```

21、查询成绩高于学号为“109”、课程号为“3-105”的成绩的所有记录。

```
Select` `* ``from` `score ``where` `degree>(``select` `degree ``from` `Score ``where` `Sno=``'109'` `and` `Cno=``'3-105'` `)
```

22、查询和学号为108、101的同学同年出生的所有学生的Sno、Sname和Sbirthday列。

```
select` `sno,sname,sbirthday ``from` `student ``where` `year``(sbirthday) = (``select` `year``(sbirthday) ``from` `student ``where` `sno=``'108'``)
select` `sno,sname,sbirthday ``from` `student ``where` `year``(sbirthday) = (``select` `year``(sbirthday) ``from` `student ``where` `sno=``'101'``)
```

23、查询“张旭“教师任课的学生成绩。

```
select` `Sno,degree ``from` `score,Course ``where` `score.Cno=Course.Cno ``and` `Course.Tno= (``select` `Tno ``from` `Teacher ``where` `Tname=``'张旭'` `)
select` `degree ``from` `score ``where` `Cno ``in` `(``select` `cno ``from` `course ``where` `Tno= (``select` `Tno ``from` `Teacher ``where` `Tname=``'张旭'` `) )
```

24、查询选修某课程的同学人数多于5人的教师姓名。

```
select` `Tname ``from` `Teacher, Course ``where` `Teacher.Tno=Course.Tno ``and` `Course.Cno =(``select` `Cno ``from` `Score ``group` `by` `Cno ``having` `count``(*)>5)
select` `Tname ``from` `Teacher ``where` `tno=( ``select` `Tno ``from` `Course ``where` `cno=( ``select` `Cno ``from` `Score ``group` `by` `Cno ``having` `count``(*)>5 ))
```

25、查询95033班和95031班全体学生的记录。

```
select` `* ``from` `student ``where` `class ``in` `(``'95033'``,``'95031'``)
```

26、 查询存在有85分以上成绩的课程Cno.

```
select` `Cno ``from` `score ``where` `degree>85
```

27、查询出“计算机系“教师所教课程的成绩表。

```
select` `* ``from` `course ``where` `cno ``in` `(``select` `cno ``from` `course ``where` `tno ``in` `(``select` `tno ``from` `teacher ``where` `Depart=``'计算机系'``))
```

28、查询“计算 机系”与“电子工程系“不同职称的教师的Tname和Prof。

```
select` `Tname,Prof ``from` `Teacher ``where` `Depart =``'计算机系'` `and` `Prof ``not` `in``( ``select` `Prof ``from` `Teacher ``where` `Depart =``'电子工程系'``)<br>``union` `<br>``select` `Tname,Prof ``from` `Teacher ``where` `Depart =``'电子工程系'` `and` `Prof ``not` `in``( ``select` `Prof ``from` `Teacher ``where` `Depart =``'计算机系'``)
```

29、查询选修编号为“3-105“课程且成绩至少高于选修编号为“3-245”的同学的Cno、Sno和Degree,并按Degree从高到低次序排序。

any:代表括号中任意一个成绩就可以

```
select` `Cno,Sno,Degree ``from` `score ``where` `cno=``'3-105'` `and` `degree >``any``(``select` `degree ``from` `score ``where` `cno=``'3-245'` `) ``order` `by` `degree ``desc
```

30、查询选修编号为“3-105”且成绩高于选修编号为“3-245”课程的同学的Cno、Sno和Degree.

all:代表括号中的所有成绩

```
select` `Cno,Sno,Degree ``from` `score ``where` `cno=``'3-105'` `and` `degree >``all``(``select` `degree ``from` `score ``where` `cno=``'3-245'` `) ``order` `by` `degree ``desc
```

31、 查询所有教师和同学的name、sex和birthday.

```
select` `tname,tsex,tbirthday ``from` `Teacher ``union` `select` `sname,ssex,sbirthday ``from` `Student
```

32、查询所有“女”教师和“女”同学的name、sex和birthday.

```
select` `Tname,Tsex,Tbirthday ``from` `Teacher ``where` `Tsex=``'女'` `union` `select` `Sname,Ssex,Sbirthday ``from` `Student ``where` `Ssex=``'女'
```

33、 查询成绩比该课程平均成绩低的同学的成绩表。

```
select` `* ``from` `score a ``where` `degree < (``select` `avg``(degree) ``from` `score b ``where` `b.cno=a.cno)
```

34、 查询所有任课教师的Tname和Depart.

```
select` `Tname,Depart ``from` `Teacher ``where` `tno ``in` `(``select` `tno ``from` `course )
```

35 、 查询所有未讲课的教师的Tname和Depart.

```
select` `Tname,Depart ``from` `Teacher ``where` `Tno ``not` `in` `(``select` `Tno ``from` `Course ``where` `cno ``in` `(``select` `cno ``from` `score ))
```

36、查询至少有2名男生的班号。

```
select` `class ``from` `student ``where` `ssex=``'男'` `group` `by` `class ``having` `count``(*)>1
```

37、查询Student表中不姓“王”的同学记录。

```
select` `* ``from` `Student ``where` `Sname ``not` `like` `'王%%'
```

38、查询Student表中每个学生的姓名和年龄。

```
select` `Sname, ``year``(now())-``year``(sbirthday) ``from` `Student
```

39、查询Student表中最大和最小的Sbirthday日期值。

```
select` `Max``(Sbirthday ),``Min``(Sbirthday ) ``from` `Student
```

40、以班号和年龄从大到小的顺序查询Student表中的全部记录。

```
select` `* ``from` `Student ``order` `by` `class ``desc``, Sbirthday
```

41、查询“男”教师及其所上的课程。

```
select` `Tname,Cname ``from` `course,teacher ``where` `course.tno= teacher.tno ``and` `teacher.Tsex=``'男'
```

42、查询最高分同学的Sno、Cno和Degree列。

```
select` `Sno,Cno,Degree ``from` `score ``where` `degree=(``select` `max``(degree) ``from` `score)
```

排序写法：

```
select` `Sno,Cno,Degree ``from` `score ``order` `by` `degree ``desc` `limit 0,1
```

43、查询和“李军”同性别的所有同学的Sname.

```
select` `Sname ``from` `Student ``where` `Ssex = (``select` `Ssex ``from` `Student ``where` `Sname=``'李军'``)
```

44、查询和“李军”同性别并同班的同学Sname.

```
select` `Sname ``from` `Student ``where` `Ssex = (``select` `Ssex ``from` `Student ``where` `Sname=``'李军'` `) ``and` `class=( ``select` `class ``from` `student ``where` `Sname=``'李军'``)
```

45、查询所有选修“计算机导论”课程的“男”同学的成绩表。

```
select` `Sno,Cno,degree ``from` `score ``where` `Cno=( ``select` `Cno ``from` `course ``where` `Cname=``'计算机导论'``) ``and` `Sno ``in` `(``select` `Sno ``from` `student ``where` `Ssex=``'男'``)
```

好文要顶 

```
#建学生信息表student
create table student
(
sno varchar(20) not null primary key,
sname varchar(20) not null,
ssex varchar(20) not null,
sbirthday datetime,
class varchar(20)

);
#建立教师表
create table teacher
(
tno varchar(20) not null primary key,
tname varchar(20) not null,
tsex varchar(20) not null,
tbirthday datetime,
prof varchar(20),
depart varchar(20) not null

);
#建立课程表course
create table course
(
cno varchar(20) not null primary key,
cname varchar(20) not null,
tno varchar(20) not null,
foreign key(tno) references teacher(tno)

);
#建立成绩表
create table score
(
sno varchar(20) not null primary key,
foreign key(sno) references student(sno),
cno varchar(20) not null,
foreign key(cno) references course(cno),
degree decimal

);

#添加学生信息
insert into student values('108','曾华','男','1977-09-01','95033');
insert into student values('105','匡明','男','1975-10-02','95031');
insert into student values('107','王丽','女','1976-01-23','95033');
insert into student values('101','李军','男','1976-02-20','95033');
insert into student values('109','王芳','女','1975-02-10','95031');
insert into student values('103','陆君','男','1974-06-03','95031');




#添加教师表
insert into teacher values('804','李诚','男','1958-12-02','副教授','计算机系');
insert into teacher values('856','张旭','男','1969-03-12','讲师','电子工程系');
insert into teacher values('825','王萍','女','1972-05-05','助教','计算机系');
insert into teacher values('831','刘冰','女','1977-08-14','助教','电子工程系');

#添加课程表
insert into course values('3-105','计算机导论','825');
insert into course values('3-245','操作系统','804');
insert into course values('6-166','数字电路','856');
insert into course values('9-888','高等数学','831');
#添加成绩表

insert into score values('103','3-245','86');
insert into score values('105','3-245','75');
insert into score values('109','3-245','68');
insert into score values('103','3-105','92');
insert into score values('105','3-105','88');
insert into score values('109','3-105','76');
insert into score values('103','3-105','64');
insert into score values('105','3-105','91');
insert into score values('109','3-105','78');
insert into score values('103','6-166','85');
insert into score values('105','6-166','79');
insert into score values('109','6-166','81');
```

