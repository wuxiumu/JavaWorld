https://www.cnblogs.com/qyf2199/p/12104922.html

**单项选择题**

1.瀑布模型的存在问题是（ B ）

  A．用户容易参与开发     B．缺乏灵活性

  C．用户与开发者易沟通    D．适用可变需求

2.开发软件所需高成本和产品的低质量之间有着尖锐的矛盾，这种现象称做(  C )

 A.软件工程                B.软件周期

 C.软件危机                D.软件产生

3.数据耦合、公共耦合、标记耦合、控制耦合的耦合性从低到高的顺序是（ B  ）

A.数据、公共、标记、控制      B.数据、标记、控制、公共

C.控制、数据、标记、公共      D.控制、数据、公共、标记

4.在SD方法中全面指导模块划分的最重要的原则是( D  )

 A.程序模块化               B.模块高内聚

 C.模块低耦合               D.模块独立性

5．软件测试的目的是（ B  ）。

A． 评价软件的质量           B. 发现软件的错误

C． 找出软件的所有错误         D. 证明软件是正确的

6．在设计测试用例时，（ A  ）是用得最多的一种黑盒测试方法。

A． 等价类划分  B. 边界值分析   C. 因果图    D. 判定表

\7. 需求分析最终结果是产生( B )。

A. 项目开发计划       B. 需求规格说明书

C. 设计说明书       D. 可行性分析报告

\8. Jackson图中，模块框之间若有直线连接，表示它们之间存在(B )。

A. 调用关系  B. 组成关系   C. 链接关系     D. 顺序执行关系

\9. 软件详细设计的主要任务是确定每个模块的( C )。

A. 功能    B. 外部接口 C. 算法和使用的数据结构   D. 编程

10．为了提高软件的可维护性，在编码阶段应注意（  D ）

A.保存测试用例和数据             B.提高模块的独立性

C.文档的副作用                   D.养成好的程序设计风格

11．设年利率为i，现存入p元，若计复利，n年后可得钱数为（B）

A．p﹡(1+i﹡n)                    B．p﹡(i+1)n

C．p﹡(1+i)﹡n                    D．p﹡(i+n)

12．在考察系统的一些涉及时序和改变的状态时，要用动态模型来表示。动态模型着重于系统的控制逻辑，它包括两个图：一个是事件追踪图，另一个是（ A   ）。

A ．状态图   B. 数据流图  C. 系统结构图 D. 时序图

\13. 对象实现了数据和操作的结合，使数据和操作( C  )于对象的统一体中。

A. 结合     B. 隐藏     C. 封装      D. 抽象

\14. 软件详细设计的主要任务是确定每个模块的( A )。

A. 算法和使用的数据结构    B. 外部接口 C. 功能    D. 编程

\15. 软件结构图中，模块框之间若有直线连接，表示它们之间存在( A )。

A. 调用关系  B. 组成关系   C. 链接关系  D. 顺序执行关系

\16. 需求分析最终结果是产生( B )。

A. 项目开发计划        B. 需求规格说明书

C. 设计说明书         D. 可行性分析报告

\17. 在详细设计阶段，经常采用的工具有( A  )。

A. PAD      B. SA      C. SC      D. DFD

18.因计算机硬件和软件环境的变化而作出的修改软件的过程称为( C  )

 A.教正性维护                       B.适应性维护

 C.完善性维护                       D.预防性维护

20．为了提高软件的可维护性，在编码阶段应注意（  D  ）

A.保存测试用例和数据              B.提高模块的独立性

C.文档的副作用                   D.养成好的程序设计风格

 

1．面向对象开发方法包括OOA、OOD和OOP三部分。

2．效益分有形效益和无形效益两种。有形效益可用纯收入、货币时间的价值、投资回收期等指标进行度量；无形效益主要从性质上、心理上进行衡量，很难直接进行量的比较。

3.从应用特点的角度来看，我们可以把高级语言分为基础语言、结构语言和专用语言三类。

**设计题**

已知有如下的伪代码程序:

​          START

​           I:=1;

​           WHILE i:<=n-1 DO

​              min:=A[i];

​               j:=i+1;

​               WHILEj<=n DO

​                 IF min>A[j]

​                   THEN

​                     BLOCK

​                       temp:=min;

​                       min:=A[j];

​                       A[j]:=temp;

​                     ENDBLOCK

​                   ENDIF;

​                   j:=j+1;

​                 ENDDO

​                 i:=i+1;

​                ENDDO

​                STOP

要求：请用盒图描述。．

![img](https://img2018.cnblogs.com/i-beta/1806053/201912/1806053-20191226223444716-541031295.png)

 

 

**软件工程期末试题（二）**

一, 判断题(正确的在括号内打上"√",错误的打上"×".每题1.5分,共15分)
Warnier方法也是一种面向数据结构的设计方法,其逻辑更严格.(×)
PAD图在设置了五种基本控制结构后,还允许递归调用. (×)  你
为了加快软件维护作业的进度,应尽可能增加维护人员的数目.(×)
当验收测试通过,软件开发就完成了.(×)
完成测试作业后,为了缩短源程序的长度应删除程序中的注解.(×)
系统结构图是精确表达程序结构的图形表示法.因此,有时也可以将系统结构图当作系统流程图使用.(×)
在程序调试时,找出错误的位置和性质比改正该错误更难.(√)
以对象,类,继承和通信为基础的面向对象设计方法(OOD)也是常见的软件概要设计方法之一.(√)
二,单项选择题(每小题2分,共10分)
试判断下列叙述中,哪 个(些)是正确的(D)
a,软件系统中所有的信息流都可以认为是事务流
b,软件系统中所有的信息流都可以认为是变换流
c,事务分析和变换分析的设计步骤是基本相似的
A,a B,b C,c D,b和c
进行需求分析可使用多种工具,但(B)是不适用的.
A,数据流图 B,PAD图 C,判定表 D,数据词典
在详细设计阶段,经常采用的工具有(A).
A,PAD B,SA C,SC D,DFD
详细设计的结果基本决定了最终程序的(C)
A,代码的规模 B,运行速度 C,质量 D,可维护性
使用白盒测试方法时,确定测试数据应根据(A)和指定的覆盖标准.
A,程序的内部逻辑 B,程序的复杂程度
C,该软件的编辑人员 D,程序的功能
三,多项选择题(每题2分,共10分.注:正确得2分,漏选得1分,多选,错选不得分.)
(ABCD)可以作为模块.
A,子程序 B,函数 C,过程 D,编译文件
下面哪些测试属于黑盒测试(BCD).
A,路径测试 B,等价类划分 C,边界值分析 D,错误推测 E,循环测试
下列属于度量效益方法的是(ABCD).
A,货币的时间价值 B,投资回收期 C,收入 D,投资回报率
软件维护的策略包括(BCD).
A,定期检测维护 B,改正性维护 C,适应性维护 D,完善性维护
下列属于软件测试过程的是(ABE).
A,单元测试 B,组装测试 C,内核测试 D,法律验证 E,确认测试
**四,简答题(每题6分,共24分)
**1、耦合性和内聚性有几种类型 其耦合度,内聚强度的顺序如何
答案:低:非直接耦合,数据耦合,标记耦合,控制耦合,外部耦合,公共耦合,内容耦合:高
强:功能内聚,信息内聚,通信内聚,过程内聚,时间内聚,逻辑内聚,偶然内聚:弱
2、请举例说明什么是多态,什么是重载
答案:多态性是指子类对象可以像父类对象那样使用,同样的消息既可以发送给父类对象也可以发送给子类对象.也就是说,在类等级的不同层次中可以共享(公用)一个行为(方法)的名字,然而不同层次中的每个类却各自按自己的需要来实现这个行为.当对象接收到发送给它的消息时,根据该对象所属于的类动态选用在该类中定义的实现算法.
3、重载是指一个类中有多个同名的方法,但在操作数个数或类型上有区别.
例: public class A{
int age;
String name;
public void setValue(int i) {
age=i; }
public void setValue(String s) {
name=s; }
4、什么是数据字典 简述数据字典与数据流图的关系.
答案:数据字典是关于数据的信息的集合,对数据流程图中的各个元素做完整的定义与说明,是数据流程图的补充工具.(2分)数据流图和数据字典共同构成系统的逻辑模型,没有数据字典数据流图就不严格,然而没有数据流图数据字典也难于发挥作用. 数据流图和对数据流图中每个元素的精确定义放在一起,才能共同构成系统的规格说明.(3分)
5、简述编码风格的重要性.
答案:阅读程序是软件开发和维护过程中的一个重要组成部分,程序实际上也是一种供人阅读的文章.应当在编写程序时讲求程序的风格,这将大量地减少人们读程序的时间.良好的编码风格有助于编写出可靠而又容易维护的程序,编码的风格在很大程度上决定着程序的质量.
面向对象的测试和传统开发方法的测试有什么不同
答案:(1)二者都可以分成四个阶段进行.但传统测试最小单元是模块,而在面向对象环境下,最小的可测试的单元是封装了的类或对象,而不是程序模块.(2)因为面向对象软件没有一个层次的控制结构,所以传统的自顶向下和自底向上的组装策略意义不大. 每次将一个操作组装到类中(像传统的增殖式组装那样)常常行不通,因为在构成类的各个部件之间存在各种直接的和非直接的交互.对于面向对象系统的组装测试,存在两种不同的测试策略.



 

 

**软件工程期末试卷（三）**

2004年下半年期末考试

（开放教育本科）计算机科学与技术专业

《软件工程》试题B

​                             2005年1月

| 题 号 | 一   | 二   | 三   | 四   | 五   | 六   | 总 分 |
| ----- | ---- | ---- | ---- | ---- | ---- | ---- | ----- |
| 分 数 |      |      |      |      |      |      |       |

 

一、填空题（每空1分，共20分）

1． 软件生存周期一般可分为__________、可行性研究、__________、设计编码、__________、运行与维护阶段。

2． IPO图由__________、__________和__________三个框组成。

3． 软件＝__________＋__________。

4． 软件测试的方法有__________和__________（即黑盒法）。

5． Jackson图除了可以表达程序结构外，还可以表达__________。

6． 详细设计的工具有图形工具、__________和__________。

7． __________和__________共同构成系统的逻辑模型。

8． 成本估计方法主要有__________、__________和算法模型估计三种类型。

9． 在需求分析阶段常用的图形工具有__________、__________、__________三种。

答案：填空题（每空1分，共20分）

1、问题定义  需求分析  测试

2、输入  处理  输出

3、程序  文档

4、分析方法  非分析方法

5、数据结构

6、表格工具  语言工具

7、数据流图  数据字典

8、自顶向下估计  自底向上估计

9、层次方框图  Warnier图  IPO图

 

二、单项选择题（每小题2分，共10分）

1. 系统流程图是描绘（  ）的传统工具。

​    A、逻辑系统   B、数据结构   C、状态变迁   D、物理系统

1. 下列模块独立性最强的是（  ）

​    A、非直接耦合  B、数据耦合  C、公共耦合  D、内容耦合

1. 下列哪个阶段不属于软件生存周期的三大阶段（  ）。

  A、计划阶段           B、开发阶段

  C、编码阶段           D、维护阶段

1. 常见的软件概要设计方法有3大类，其中以数据流图为基础构造模块结构的是（  ）。

A、  Jackson方法和LCP（Wanier）逻辑构造方法

B、 结构化设计方法（SD）

C、 面向对象设计方法（OOD）

D、快速原型法

1. 使用白盒测试方法时，确定测试数据应根据（  ）和指定的覆盖标准。

A、程序的内部逻辑           B、程序的复杂程度

C、该软件的编辑人员          D、程序的功能

答：1、D 2、A  3、C  4、A  5、A

三、多项选择题（每题2分，共10分）

1. （  ）可以作为模块。

 A、子程序    B、函数    C、过程    D、编译文件

1. 关于内容耦合的描述正确的是（  ）。

A、 内容耦合是最高程度的耦合

B、 高级语言一般设计成允许内容耦合的形成

C、 应该尽量使用内容耦合

D、 如果一个模块可以直接调用另一模块，则可以称为内容耦合

1. 下列属于度量效益方法的是（  ）。

A、货币的时间价值       B、投资回收期

B、收入            D、投资回报率

1. 软件维护的策略包括（   ）。

A、 定期检测维护

B、 改正性维护

C、 适应性维护

D、 完善性维护

1. 下列不属于软件测试过程的是（   ）。

A、单元测试   B、组装测试    C、内核测试   D、法律验证

答：1、ABCD  2、AD  3、ABC  4、BCD 5、CD

 

四、判断题（正确的在括号内打上“√”，错误的打上“×”。每题2分，共20分）

1. Warnier方法也是一种面向数据结构的设计方法，其逻辑更严格。（   ）
2. PAD图在设置了五种基本控制结构后，还允许递归调用。   （   ）
3. 为了加快软件维护作业的进度，应尽可能增加维护人员的数目。(   )
4. 当验收测试通过，软件开发就完成了。(    )
5. 完成测试作业后，为了缩短源程序的长度应删除程序中的注解。(    )
6. 在进行总体设计时应加强模块间的联系。（    ）
7. 系统结构图是精确表达程序结构的图形表示法。因此，有时也可以将系统结构图当作系统流程图使用。（    ）
8. 用黑盒法测试时，测试用例是根据程序内部逻辑设计的。（    ）
9. 在程序调试时，找出错误的位置和性质比改正该错误更难。（    ）
10. 以对象、类、继承和通信为基础的面向对象设计方法（OOD）也是常见的软件概要设计方法之一。（    ）

答：1—5：√√×××      6—10： ×××√√

 

五、简答题（每题5分，共20分）

1． 什么是软件危机?为什么会产生软件危机?

答：软件危机是指软件在开发和维护过程 遇到的一系统严重问题,主要包含二方面的问题,一是如何开发利用软件,三是如何维护数量不断膨胀的已有软件.产生软件危机的原因,一方面与软件本身的特点有关,另一方面和软件开发与维护的方法不正确有关。

 

2． 什么是软件的生存周期？包括哪几个部分？

答：个软件从定义到开发、使用和维护，直到最终被废弃，要经历一个漫长的时期，通常把软件经历的这个漫长的时期称为生存周期。软件生存周期就是从提出软件产品开始，直到该软件产品被淘汰的全过程。它包括制定计划、需求分析、软件设计、程序编写、软件测试、运行维护等。

3． 什么是黑盒测试法？

答：黑盒测试法把程序看成一个黑盒子，完全不考虑程序的内部结构和处理过程，它只检查程序功能是否能按照规格说明书的规定正常使用，程序是否能适当地接收输入数据，产生正确地输出信息。

 

4． 耦合性和内聚性有几种类型? 其耦合度、内聚强度的顺序如何？

答：低：非直接耦合® 数据耦合®标记耦合® 控制耦合®外部耦合® 公共耦合®内容耦合 ：高

强：功能内聚® 信息内聚® 通信内聚® 过程内聚® 时间内聚® 逻辑内聚®   巧合内聚：弱  

 

六、分析设计题（共20分）

1. （8分）假设开发某个计算机应用系统的投资额为3000元，该计算机应用系统投入使用后，每年可以节约1000元，5年内可能节约5000元。3000元是现在投资的钱，5000元是5年内节省的钱，假定年利率为12%，请计算该系统的纯收入，投资回收期，投资回收率。

答：

| 年   | 节省 | 利率  | 现在价值 | 累计现在价值 |
| ---- | ---- | ----- | -------- | ------------ |
| 1    | 1000 | 1．12 | 892.86   | 892.86       |
| 2    | 1000 | 1.25  | 800.00   | 1692.86      |
| 3    | 1000 | 1.40  | 714.29   | 2407.15      |
| 4    | 1000 | 1.57  | 636.94   | 3044.09      |
| 5    | 1000 | 1.76  | 568.18   | 3612.27      |

计算该系统的纯收：3612.27-3000=612.27

投资回收期：3+（3000-2407.15）/(3044.09-2407.15)=3.93

投资回收率为r

3000=1000/（1+r）+1000/(1+r)2+1000/(1+r)3+1000/(1+r)4+1000/(1+r)5

解得r=20%

 

1. 求一组数组中的最大数, 数组表示为A（n） ，n＝1，2……n的自然数。(12分)

1)  请画出程序流程图（4分）

2)  请画出该算法的N-S图（4分）

3)  请用PAD图来表示该算法（4分）

答：（1）

![img](https://img2018.cnblogs.com/i-beta/1806053/201912/1806053-20191226223734223-415482750.png)

 

 

（2）

![img](https://img2018.cnblogs.com/i-beta/1806053/201912/1806053-20191226223748785-1483684535.png)

（3）

 ![img](https://img2018.cnblogs.com/i-beta/1806053/201912/1806053-20191226223816503-1860386444.png)

 

 

一、  简答题（25%， 每小题5分）：

1．请简要说明需求分析的三个层次包括那些主要内容。

软件需求包括三个不同的层次—业务需求、用户需求和功能需求—也包括非功能需求。

业务需求反映了组织机构或客户对系统、产品高层次的目标要求。

用户需求文档描述了用户使用产品必须要完成的任务。

功能需求定义了开发人员必须实现的软件功能，使得用户能完成他们的任务，从而满足了业务需求。

 

2．为什么要设计独立性强的模块以及如何判断模块的独立性？

  第一3分，耦合1分，内聚1分

模块独立性强，则：（1）系统容易开发（2）系统可靠性高（3）系统容易维护

判断模块独立性的基本原则：“耦合小，内聚大”

3．若现有类已经进行了彻底的测试，为什么必须对从现有类中实例化的子类进行重新测试？

   使用的场景：3分．  2分

   因为父类和子类的运行环境是不同的。

   另外，如果是多重继承会显著地增加派生类的复杂程度，导致一些难以发现的隐含错误。

 

 

4．要开发质量“非常好”的软件，请从软件工程的角度分析其利与弊。

   利：3分；弊：2分

   利：容易维护，用户比较满意

   弊：成本高，周期长

5、采用面向对象方法设计软件系统时，子系统的划分常采用水平划分或垂直划分的方式，请说明这两种划分所得子系统的特点。

  c/s:3分,p2p：2分

水平划分系统的p2p： 每个字系统可以调用任意其他子系统，比c/s复杂，可能死锁。

垂直划分c/s：客户端调用服务器端，服务器提供服务，并返回结果。客户端需要知道服务器的接口，而服务器不必知道客户端接口。

 

二、  应用题（45%，1-3每小题10分，4小题15分）

 

1．公司计划采用新技术开发一款新的手机软件产品，希望尽快占领市场，假设你是项目经理，你会选择哪种软件过程模型？为什么？

  选模型：5分；原因：5分

选用模型：可采用增量模型/增量+ 原形/螺旋模型等等。但如果采用快速开发则不太适宜。

分析原因：技术相对比较新，而且需要快速占领市场，所以应短期内出现产品的原形或者是可用的子系统。

2．请根据下面的任务安排表，画出任务网络图、甘特图、标识关键路径和阶段里程碑位置。

| 任务名称     | 起始日期    | 结束日期    |
| ------------ | ----------- | ----------- |
| 需求分析     | 2008．3．1  | 2008．3．13 |
| 测试计划     | 2008．3．13 | 2008．3．15 |
| 概要设计     | 2008．3．13 | 2008．3．16 |
| 详细设计     | 2008．3．16 | 2008．3．20 |
| 编码         | 2008．3．20 | 2008．3．26 |
| 测试方案设计 | 2008．3．16 | 2008．3．19 |
| 产品测试     | 2008．3．26 | 2008．3．30 |
| 文档整理     | 2008．3．28 | 2008．3．30 |

 

任务网络图：

![img](https://img2018.cnblogs.com/i-beta/1806053/201912/1806053-20191226224003908-1543069443.png)

 

 

![img](https://img2018.cnblogs.com/i-beta/1806053/201912/1806053-20191226224037939-880653813.png)

任务网络图3分

甘特图3分

标识关键路径2分

阶段里程碑位置2分。

 

 

3．设有一个程序，读入三个整数，代表三角形的三条边。输出表明三角形是不规则的、等腰的或等边的。请采用黑盒的等价类划分方法，设计一组测试用例。

  不规则：3 4 5

等腰：3 3 4

等边：3 3 3

其他：1 9 2

 

  不规则的3分

等腰3分

等边3分

其他1分

 

4．设计一个简化的网上个人银行查询系统，用户可以通过Internet查询自己帐户的收支明细、余额和修改密码。

（一）采用结构化方法：7分

1）请画出E-R图2分

DFD图的第0层和第1层。3分

2）编写两个关键词条的数据字典。2分

![img](https://img2018.cnblogs.com/i-beta/1806053/201912/1806053-20191226224138044-865921579.png)

 

 ![img](https://img2018.cnblogs.com/i-beta/1806053/201912/1806053-20191226224206517-1755573243.png)

 

 

 ![img](https://img2018.cnblogs.com/i-beta/1806053/201912/1806053-20191226224233216-234167854.png)

 

 

数据字典：

 

名称：帐号

别名：无

何处使用/如何使用：登陆帐户时需要输入

描述：帐户的唯一标识，每个帐户对应一个帐号

   帐号= 12个数字

名称：帐户密码

别名：无

何处使用/如何使用：登陆帐户时输入；修改密码时输入，修改成功后保存到帐户数据库

描述：密码=*6个字母*

 

（二）采用面向对象方法：8分

1）请画出系统的用例图；2分

 ![img](https://img2018.cnblogs.com/i-beta/1806053/201912/1806053-20191227133627764-1318269594.png)

 

 

 

 

 

2）识别出系统的主要类2分

User、Account、DetailItem

主要要包括用户、帐户、收支明细等类。

并画其中的二个类图（包含主要属性和操作）。2分

 

 

 

3）画一个UML时序图，描述一次通过网上银行查询余额的具体交互。2分

 

 ![img](https://img2018.cnblogs.com/i-beta/1806053/201912/1806053-20191227133653823-1594918622.png)

 

 

 

 

 

**软件工程期末试卷（五）**

一、填空题

1．软件开发模型有 瀑布模型、螺旋模型、第四代技术模型、   原型模型  、构件组装模型、混合模型。

  2．可行性研究一般可以从   经济   可行性、    技术 可行性、运行可行性、法律可行性和开发可行性等方面来研究。

  3．现在向银行存款，年利率为i，若希望在n年后从银行得到F元，现在应该存入的钱数为  F/(1+i)n    。

  4．数据流图的基本符号包括数据输入的源点和数据输出的汇点  加工  数据流  数据存储文件

  5．Jackson图除了可以表达程序结构外，还可以表达  数据结构    ，它首先要分析 数据结构    ，并用适当的工具来描述。

  6．详细设计的工具有  图形工具      、表格工具和   语言工具    。

  7．IPO图由  输入    、处理和   输出   三个框组成。这个图的特点是能够直观的显示三者之间的关系。

  8．面向对象技术是一整套关于如何看待  软件系统     和现实世界      的关系，以什么观点来研究问题并进行分析求解，以及如何进行系统构造的软件方法学。面向对象方法是一种运用对象、  类  、继承  、 封装、聚集、消息传送、多态性等概念来构造系统的软件开发方法。

 

二、单项选择题

  1．下列（   A ）属于系统软件。

1. WINDOWS 2000
2. Word
3. Flash
4. 3D MAX

 

2．下列哪个图是N－S图的构件（  C  ）。

![img](https://img2018.cnblogs.com/i-beta/1806053/201912/1806053-20191227134025749-1422784667.png)

 

 

 

3．对于螺旋模型，下列（   D  ）不是利用笛卡尔坐标表达的活动。

A. 制定计划    B. 实施工程

　 C. 风险分析    D. 程序编码

 

三、多项选择题

  1．软件危机可以表现为（ ABCD    ）。

A． 产品不符合用户的需要

B． 软件产品的质量差

C． 软件的可维护性差

D． 软件的价格昂贵

  2．Jackson图中一般可能包括（  ABCD   ）。

A．表头

B．表体

C．表名

D．字段名

  3．关于内容耦合的描述正确的是（ AD ）。

   A、内容耦合是最高程度的耦合

   B、应该尽量使用内容耦合

   C、高级语言一般设计成允许内容耦合的形式

   D、如果一个模块有多个入口，可能发生内容耦合

4．下列属于不标准的书写格式（ BCD ）。

   A、书写时适当使用空格分隔

   B、一行写入多条语句

   C、嵌套结构不使用分层缩进的写法

   D、程序中不加注释

 

四、判断题（正确的在括号内打上“√”，错误的打上“”） 

1.软件生存周期是从软件开始开发到开发结束的整个时期。（×  ）

 2.系统流程图是一个典型的描述逻辑系统的传统工具。（ ×  ）

3.数据流图和数据字典共同构成系统的逻辑模型。（ √  ）

4.扇出是一个模块直接调用的模块数目，一般推荐的扇出为3或4。（ √  ）

5.耦合用于衡量一个模块内部的各个元素彼此结合的紧密程度。（  ×）

  6.程序运行过程中出现错误叫做容错。                （ × ）

  7.软件测试的目的是证明程序没有错误。               （  × ）

  8.白盒测试法是将程序看成一个透明的盒子，不需要了解程序的内部结构和处理过程。

​                                   （  × ）

  五、问答题

1．什么是软件生存周期。

答：一个软件从定义到开发、使用和维护，直到最终被废弃，要经历一个漫长的时期，通常把软件经历的这个漫长的时期称为生存周期。软件生存周期就是从提出软件产品开始，直到该软件产品被淘汰的全过程。

2．在需求分析阶段，建立目标系统的逻辑模型的具体做法是什么。

答：系统流程图是描述物理系统的传统工具。它的基本思想是用图形符号以黑盒子形式描绘系统里的每个部件（程序、文件、数据库、表格、人工过程等）。系统流程图表达的是部件的信息流程，而不表示对信息进行加工处理的控制过程。

 

3．为什么数据流图要分层？

答：这了表达数据处理过程的数据加工情况，用一个数据流图是不够的。为表达稍为复杂的实际问题，需要按照问题的层次结构进行逐步分解，并以分层的数据流图反映这种结构关系。

4．软件的质量反应为哪些方面的问题？

答：软件需求是度量软件质量的基础，不符合需求的软件就不具备质量。

在各种标准中定义了一些开发准则，用来指导软件人员用工程化的方法来开发软件。

如果不遵守这些开发准则，软件质量就得不到保证。

往往会有一些隐含的需求没有明确地提出来。如果软件只满足那些精确定义了的需求而没有满足这些隐含的需求，软件质量也不能保证。

软件质量是各种特性的复杂组合。它随着应用的不同而不同，随着用户提出的质量要求不同而不同。

 

**软件工程期末试卷（六）**

软件工程导论试题

一．选择

1、瀑布模型把软件生命周期划分为八个阶段：问题的定义、可行性研究、软件需求分析、系统总体设计、详细设计、编码、测试和运行、维护。八个阶段又可归纳为三个大的阶段：计划阶段、开发阶段和( C)。
A、详细计划 B、可行性分析

C、 运行阶段 D、 测试与排错

2、从结构化的瀑布模型看，在它的生命周期中的八个阶段中，下面的几个选项中哪个环节出错，对软件的影响最大(C )。
A、详细设计阶段 B、概要设计阶段

C、 需求分析阶段 D、 测试和运行阶段

3、在结构化的瀑布模型中，哪一个阶段定义的标准将成为软件测试中的系统测试阶段的目标(A )。
A、 需求分析阶段 B、 详细设计阶段

C、 概要设计阶段 D、 可行性研究阶段

4、软件工程的出现主要是由于(C )。
A.程序设计方法学的影响 B.其它工程科学的影响

C. 软件危机的出现 D.计算机的发展

5、软件工程方法学的目的是：使软件生产规范化和工程化，而软件工程方法得以实施的主要保证是(C )
A、 硬件环境        B、软件开发的环境
C、软件开发工具和软件开发的环境 D、 开发人员的素质

6、软件开发常使用的两种基本方法是结构化和原型化方法，在实际的应用中，它们之间的关系表现为 ( B)
A、 相互排斥 B、 相互补充

C、 独立使用 D、 交替使用

7、UML是软件开发中的一个重要工具，它主要应用于哪种软件开发方法(C )
A、基于瀑布模型的结构化方法 B、基于需求动态定义的原型化方法
C、基于对象的面向对象的方法 D、基于数据的数据流开发方法

8、在下面的软件开发方法中，哪一个对软件设计和开发人员的开发要求最高(B )
A、结构化方法 B、原型化方法 C、面向对象的方法 D、控制流方法

9、结构化分析方法是一种预先严格定义需求的方法，它在实施时强调的是分析对象的(B )
A、控制流 B、数据流 C、程序流 D、指令流

10、软件开发的结构化生命周期方法将软件生命周期划分成(A )
A、 计划阶段、开发阶段、运行阶段 B、 计划阶段、编程阶段、测试阶段
C、 总体设计、详细设计、编程调试 D、需求分析、功能定义、系统设计

11、软件开发中常采用的结构化生命周期方法，由于其特征而一般称其为(A )
A、 瀑布模型 B、 对象模型 C、 螺旋模型 D、 层次模型

12、软件开发的瀑布模型，一般都将开发过程划分为：分析、设计、编码和测试等阶段，一般认为可能占用人员最多的阶段是( C)
A、 分析阶段 B、 设计阶段 C、 编码阶段 D、 测试阶段

二.填空

21．系统流程图是描述物理模型的传统工具，用图形符号表示系统中各个元素表达了系统中各种元素之间的(　信息流动　)情况。

　　　　[解析]系统流程图是描述物理系统的传统工具，用图形符号表示系统中的各个元素，如人工处理、数据处理、数据库、文件、设备等，表达了元素之间的信息流动的情况。

　　22．成本效益分析的目的是从(　经济　)角度评价开发一个项目是否可行。

　　　　　　　　[解析]成本效益分析首先是估算将要开发的系统的开发成本，然后与可能取得的效益进行比较和权衡，其目的是从经济角度评价开发一个新的软件项目是否可行。

23．自顶向下结合的渐增式测试法，在组合模块时有两种组合策略：深度优先策略和(　宽度优先策略　) 。

　　　　[解析]渐增式测试法有自顶向下结合和自底向上结合两种组装模块的方法，其中自顶向下集成是构造程序结构的一种增量式方式，不需要编写驱动模块，只需要编写桩模块。它从主控模块开始，按照软件的控制层次结构，以深度优先或宽度优先的策略，逐步把各个模块集成在一起。

　　24．独立路径是指包括一组以前没有处理的语句或条件的一条路径。从程序图来看，一条独立路径是至少包含有一条(　在其他独立路径中未有过　)的边的路径。

　　　　[解析]在基本路径测试中，以详细设计或源程序为基础，导出控制流程图的拓扑结构——程序图，在计算了程序图的环路复杂性之后，确定只包含独立路径的基本路径图，其中独立路径是包括一组以前没有处理的语句或条件的一条路径。从程序图来看，一条独立路径是至少包含有一条在其他独立路径中未有过的边的路径。

　　25．汇编语言是面向(　机器　) 的，可以完成高级语言无法完成的特殊功能，如与外部设备之间的一些接口工作。

　　　　[解析]汇编语言属于低级语言，是一种面向机器的语言，它与高级语言相比有许多优越性：如操作灵活，可以直接作用到硬件的最下层，完成与外部设备的接口工作等，是能够利用计算机硬件特性直接控制硬件设备的唯一语言。

　　26．在JSP方法中解决结构冲突的具体办法是(　中间数据结构或中间文件　)。

　　　　[解析]JSP方法是面向数据结构的设计方法。它定义了一组以数据结构为指导的映射过程，根据输入、输出的数据结构，按一定的规则映射成软件的过程描述，在JSP方法中解决结构冲突的具体办法是引入中间数据结构或中间文件，将冲突部分分隔开来，建立多个程序结构，再利用中间文件把它们联系起来，构成一个系统的整体。

　　27．详细设计的任务是确定每个模块的内部特性，即模块的算法、(　使用的数据　)。

　　　　[解析]详细设计的基本任务是为每个模块进行详细的算法设计，为模块内的数据结构进行设计，确定每个模块的内部特性，包括模块的算法和使用的数据。对数据库进行物理设计等。

　　28．所有软件维护申请报告要按规定方式提出，该报告也称( 　软件问题 )报告。

　　　　[解析]在软件维护的流程中，第一步就是制定维护申请报告，也称为软件问题报告，它是维护阶段的一种文档，由申请维护的用户填写。

　　29．有两类维护技术：在开发阶段使用来减少错误、提高软件可维护性的面向维护的技术；在维护阶段用来提高维护的效率和质量的(　维护支援　)技术。

　　　　[解析]面向维护的技术涉及软件开发的所有阶段，能够减少软件错误，提高软件的可维护性。而维护支援技术则包含信息收集，错误原因分析，维护方案评价等项，是在软件维护阶段用来提高维护效率和质量的技术。

　　30．科学工程计算需要大量的标准库函数，以便处理复杂的数值计算，可供选择的语言有：(　FORTRAN语言)、PASCAL语言、C语言和PL/1语言。

　　　 [解析]计算机语言根据不同行业的需求，使用的侧重点也不尽相同，在办公管理方面，一些数据库语言如FOXPRO、ORICAL有很多的应用，在工程行业，计算机语言的科学计算能力就显得格外重要，如MATLAB、PL/1、FORTRAN语言都是工程计算中常用的语言。

三．判断

1．软件的开发与运行经常受到硬件的限制和制约。(√)

2．模块内的高内聚往往意味着模块间的松耦合。(√ )

3．Jackson图只能表达程序结构，不能表达数据结构。(X)


上述数据流图表示数据A和B同时输入变换成C。(X )

5．软件的质量好坏主要由验收人员负责，其他开发人员不必关心。(X )

6．判定覆盖不一定包含条件覆盖，条件覆盖也不一定包含判定覆盖。(√)

7.应该尽量使用机器语言编写代码，提高程序运行效率，而减少高级语言的使用。(X)

8．UML只能应用于软件系统模型的建立。(X)

9．容错就是每个程序采用两种不同的算法编写。(X)

10．软件测试的目的是为了无一遗漏的找出所有的错误。(X)

**四、名词解释题****(****本大题共****5****小题，每小题****3****分，共****15****分****)**

　　31.软件开发环境

　　32.错误推测法

　　33.黑盒测试法

　　34.软件质量保证

　　35.瀑布模型

31．经济可行性

　　　　解：进行开发成本的估算以及了解取得效益的评估，确定要开发的项目是否值得投资开发。

　　　　[解析]对于一个系统所必须要衡量的是经济上是否合算，经济可行性的范围很广，包括效益分析、潜在市场前景等。

　　32．社会可行性

　　　　解：要开发的项目是否存在任何侵犯、妨碍等责任问题，要开发项目目的运行方式在用户组织内是否行得通，现有管理制度、人员素质、操作方式是否可行。

　　　　[解析]社会可行性包括合同、责任、侵权等技术人员不甚了解的诸多问题。

　　33．投资回收期

　　　　解：投资回收期就是使累计的经济效益等于最初的投资费用所需的时间。

　　　　[解析]通常我们用投资回收期来衡量一个开发项目的价值，投资回收期越短，就越快获得利润。

　　34．对应关系

　　　　解：即有直接因果关系在程序中可以同时处理。

　　　　[解析]对应关系是指数据单元在数据内容上、数量上和顺序上有直接的因果关系，对于重复的数据单元，重复的次序和次数都相同才有对应关系。

　　35．结构冲突

　　　　解：输入数据与输出数据结构找不到对应关系的情况，称为结构冲突。

　　　 [解析]使用JSP方法时会遇到此类结构冲突问题，对此，Jackson提出了引入中间数据结构或中间文件的办法，将冲突部分分隔开来，建立多个程序结构，再利用中间文件把它们联系起来，构成一个系统的整体。

五、图 a 中，模块 G 为判定，判断涉及到模块 B、F、G，请指出设计中的错误，再根据

改进模 块图的基本原则，画出 1～2 个改进方案(不改变模块 G 的判断关系)，并说明是按照

哪条基本 原则进行改进的。

![img](https://img2018.cnblogs.com/i-beta/1806053/201912/1806053-20191227134131152-763112367.png)

 

 

 

解：图 b 为一个改进方案，将模块 G 的位置提高，使其作用范围为控制范围的子集，减

少模块 之间的联系。

40．请使用PAD图和PDL语言描述在数组A（1）～A（10）中找最大数的算法。

　　　　解：PDL语言：

　　　　N=1

　　　　WHILE N<=10 DO

　　　　IF A（N）<=A（N+1） MAX =A（N+1）;

　　　　ELSE MAX =A（N） ENDIF;

　　　　N=N+1;

　　　　ENDWHILE;

　　　　PAD图：

![img](https://img2018.cnblogs.com/i-beta/1806053/201912/1806053-20191227134153141-1171803332.png)

 

 

 

[解析]人工查找时，是从第一个元素开始查找，用当前元素与下一个元素比较，将较大者作为当前元素又与下一元素比较，如此循环，直到数组末尾。

　　41．根据下列条件使用等价类划分法设计测试用例。

　　　 某一8位微机，其八进制常数定义为：以零开头的数是八进制整数，其值的范围是-177～177，如05，0127，-065

　　　　解：（1）划分等价类并编号，如下表示：（4分）

![img](https://img2018.cnblogs.com/i-beta/1806053/201912/1806053-20191227134217404-1762451658.png)

 

 

 

 　　　（2）为合理等价类设计测试用例,表中有两个合理等价类,设计两个例子（2分）

![img](https://img2018.cnblogs.com/i-beta/1806053/201912/1806053-20191227134228124-944381217.png)

 

 

 

 　　　（3）为不合理等价类测试用例,至少设计一个测试用例（2分）

![img](https://img2018.cnblogs.com/i-beta/1806053/201912/1806053-20191227134259104-711637323.png)

 

 

 

　　　　[解析]等价类划分属于黑盒测试的一种，它将输入数据域按有效的或无效的划分成若干个等价类，测试每个等价类的代表值就等于对该类其他值的测试，这样用少量有代表性的例子代替大量测试目的相同的例子，可以有效提高测试效率。本题划分了3个合理等价类，9个不合理等价类进行测试，取到了预期的效果。

42．某电器集团公司下属的厂包括技术科、生产科等基层单位。现在想建立一个计算机辅助企业管理系统，其中：

　　　　生产科的任务是：

　　　　（1）根据销售公司转来的内部合同（产品型号、规格、数量、交获日期）制定车间月生产计划。

　　　　（2）根据车间实际生产日报表、周报表调整月生产计划

　　　　（3）以月生产计划为以及，制定产品设计（结构、工艺）及产品组装月计划。

　　　　（4）将产品的组装计划传达到各科，将组装月计划分解为周计划，下达给车间

　　　　技术科的任务是：

　　　　（1）根据生产科转来的组装计划进行产品结构设计，产生产品装配图给生产科，产生外购需求计划给供应科，并产生产品自制物料清单。

　　　　（2）根据组装计划进行产品工艺设计，根据产品自制物料清单产生工艺流程图给零件厂。 试写出以上系统中生产科和技术科处理的软件结构图。

　　　　解：

![img](https://img2018.cnblogs.com/i-beta/1806053/201912/1806053-20191227134343777-533575069.png)

 

 

 

画出生产科图的给6分，画出技术科的给4分。

　　　 [解析]软件结构图是软件系统的模块层次结构，反映了整个系统的功能实现，即将来程序的控制层次体系，软件结构往往用树状或网状结构的图形来表示，其主要内容有模块及模块的控制关系，根据题意，可绘制出生产科和技术科的软件结构图，其中生产科的结构图深度和宽度均为4，技术科的结构图的深度和宽度均为3。

 

 

 

**软件工程期末试卷（七）**

一、判断题（每题2分，共30分）

1.螺旋模型是在瀑布模型和增量模型的基础上增加了风险分析活动。（对）

2.数据字典是对数据流图中的数据流，加工、数据存储、数据的源和终点进行详细定义。（错）

3.JAVA语言编译器是一个CASE工具。（对）。

4.软件是指用程序设计语言（如PASCAL ,C,VISUAL BASIC 等）编写的程序，软件开发实际上就是编写程序代码。（错）

5.软件模块之间的耦合性越弱越发。（对）

6.数据库设计说明书是一个软件配置项（对）

7.在面向对象的软件开发方法中，每个类都存在其相应的对象，类是对象的实例，对象是生成类的模板。（错）

8.过程描述语言可以用于描述软件的系统结构。（错）

9.如果通过软件测试没有发现错误，则说明软件是正确的。（错）

10.快速原型模型可以有效地适应用户需求的动态变化。（对）

11.模块化，信息隐藏，抽象和逐步求精的软件设计原则有助于得到高内聚，低耦合度的软件产品。（对）

12.集成测试主要由用户来完成。（错）

13.确认测试计划应该在可行性研究阶段制定（错）

14.白盒测试无需考虑模块内部的执行过程和程序结构，只要了解模块的功能即可。（错）

15.软件概要设计包括软件系统结构设计以及数据结构和数据库设计。（对）

二。单选题（每题2分，共20分）

1.瀑布模型的关键不足在于（2）
（1）过于简单（2）不能适应需求的动态变更（3）过于灵活（4）各个阶段需要进行评审

2.在面向对象软件开发方法中，类与类之间主要有以下结构关系（1）
（1）继承和聚集（2）继承和一般（3）聚集和消息传递（4）继承和方法调用

3.以下哪一项不是软件危机的表现形式(3)
(1）成本高（2）生产率低(3)技术发展快（4）质量得不到保证

4.以下哪一项不是面向对象的特征（4）
（1）多态性（2）继承性（3）封装性（4）过程调用

5.面向对象模型主要由以下哪些模型组成（1）
（1）对象模型、动态模型、功能模型(2)对象模型、数据模型、功能模型（3）数据模型、动态模型、功能模型（4）对象模型、动态模型、数据模型

6.软件可行性研究一般不考虑（4）
（1）是否有足够的人员和相关的技术来支持系统开发（2）是否有足够的工具和相关的技术来支持系统开发（3）待开发软件是否有市场、经济上是否合算（4）待开发的软件是否会有质量问题

7.软件维护的副作用主要有以下哪几种（3）
（1）编码副作用、数据副作用、测试副作用（2）编码副作用、数据副作用、调试副作用（3）编码副作用、数据副作用、文档副作用（4）编码副作用、文档副作用、测试副作用

8.软件项目计划一般不包括以下哪项内容（4）
（1）培训计划（2）人员安排（3）进度安排（4）软件开发标准的选择和制定

9.以下哪一项不属于面向对象的软件开发方法（3）
（1)coad方法(2)booch方法(3)jackson方法(4)omt方法

10.以下哪种测试方法不属于白盒测试技术（2）
（1）基本路径测试（2）边界值分析测试（3）循环覆盖测试（4）逻辑覆盖测试

三。简答题（每题5分，共25分）

1.分析软件危机产生的主要原因有哪些？
答：导致软件危机的主要原因有：
（1）软件日益复杂和庞大（2）软件开发管理困难和复杂（3）软件开发技术落后（4）生产方式落后（5）开发工具落后（6）软件开发费用不断增加
1 个要点1分，只要答上5个要点得5分！

2.说明结构化程序设计的主要思想是什么？
答：（1）自顶向下、逐步求精的程序设计方法（2分）（2）使用3种基本控制结构、单入口、单出口来构造程序。（3分）

3.软件测试包括哪些步骤？说明这些步骤的测试对象是什么？
答：（1）单元测试，测试对象对单元模块（2分）（2）集成测试，测试对象为组装后的程序模块（2分）（3）确认测试，测试对象为可运行的目标软件系统（1分）

4.需求 分析与软件设计二个阶段任务的主要区别是什么？
答：需求分析定义软件的用户需求，即定义待开发软件能做什么（2.5分）
软件设计定义软件的实现细节以满足用户需求，即研究如何实现软件。（2.5分）

5.说明软件测试和调试的目的有何区别？
答：测试的目的是判断和发现软件是否有错误（2。5分）调试的目的是定位软件错误并纠正错误。（2.5分）

**软件工程期末试卷（八）**

**选择**

1.开发软件所需高成本和产品的低质量之间有着尖锐的矛盾，这种现象称做(C)

 A.软件工程                            B.软件周期

 C.软件危机                            D.软件产生

2.研究开发所需要的成本和资源是属于可行性研究中的(B)研究的一方面。

 A.技术可行性                          B.经济可行性

 C.社会可行性                          D.法律可行性

\3. 下列属于用白盒技术设计测试用例的是（B）

A．错误推测                         B．逻辑覆盖

C．等价类划分                        D．因果图

4.模块的内聚性最高的是( D)

 A.逻辑内聚                            B.时间内聚

 C.偶然内聚                            D.功能内聚

5.在SD方法中全面指导模块划分的最重要的原则是(D)

 A.程序模块化                          B.模块高内聚

 C.模块低耦合                          D.模块独立性

6.软件详细设计主要采用的方法是(D)

 A.模块设计                            B.结构化设计

 C.PDL语言                            D.结构化程序设计

\7. 根据对软件开发机构调查的结果可知，各类维护活动所占的比重是（A）

A．完善性占50％，适应性占25％，校正性占21％，其他维护占4％

B．完善性占25％，适应性占50％，校正性占21％，其他维护占4％

C．完善性占21％，适应性占25％，校正性占50％，其他维护占4％

D．完善性占21％，适应性占50％，校正性占25％，其他维护占4％

8.不适合作为科学工程计算的语言是(D)

 A. Pascal                              B. C

 C. Fortran                              D. Prolog

9.黑盒测试在设计测试用例时，主要需要研究(A)

 A.需求规格说明与概要设计说明            B.详细设计说明

 C.项目开发计划                         D.概要设计说明与详细设计说明

10.若有一个计算类型的程序，它的输入量只有一个X，其范围是［-1.0，1.0］，现从输入的角度考虑一组测试用例：-1.001，-1.0，1.0，1.001。设计这组测试用例的方法是(C)

 A.条件覆盖法                          B.等价分类法

 C.边界值分析法                         D.错误推测法

11.下列属于维护阶段的文档是(B)

 A.软件规格说明                         B.用户操作手册

 C.软件问题报告                         D.软件测试分析报告

12.快速原型模型的主要特点之一是(B)

 A.开发完毕才见到产品                   B.及早提供全部完整的软件产品

 C.开发完毕后才见到工作软件           D.及早提供工作软件

13.因计算机硬件和软件环境的变化而作出的修改软件的过程称为(B)

 A.教正性维护                       B.适应性维护

 C.完善性维护                       D.预防性维护

\14. 面向对象方法学的出发点和基本原则是尽可能模拟人类习惯的思维方式，分析、设计和实现一个软件系统的方法和过程，尽可能接近于人类认识世界解决问题的方法和过程。因此面向对象方法有许多特征，如软件系统是由对象组成的；（A）；对象彼此之间仅能通过传递消息互相联系；层次结构的继承。　　

A．开发过程基于功能分析和功能分解

　B．强调需求分析重要性

　C．把对象划分成类，每个对象类都定义一组数据和方法

　D．对既存类进行调整

\15. 在软件详细设计过程中不采用的工具为（A）

A．判定表                           B．PDL

C．数据流图                         D．IPO图

\16. 两个模块之间传递的是同一个数据结构的地址，这种耦合方式称为（C）

A．控制耦合                         B．公共耦合

C．标记耦合                         D．数据耦合

\17. 软件需求不应包括（B）

A．功能要求                         B．环境需求

C．标准实现的空间需求                 D．用户界面要求

18.下列文档与维护人员有关的有(D)

 A.软件需求说明书                   B.项目开发计划

 C.概要设计说明书                   D.操作手册

19.采用Gantt图表示软件项目进度安排，下列说法中正确的是(D)

 A.能够反映多个任务之间的复杂关系

 B.能够直观表示任务之间相互依赖制约关系

 C.能够表示哪些任务是关键任务

 D.能够表示子任务之间的并行和串行关系

 

 

1、软件的特点包括（A）。

A． 软件具有抽象性

B． 在软件的运行和使用期间，也存在类似硬件的老化问题

C． 软件的开发与维护对硬件存在依赖性

D． 软件的开发费用在逐渐下降

 

2.需求分析的基本原则包括（A）。

A． 必须能够表达和理解问题的数据域和功能域

B． 自顶向下、逐层分解问题

C． 修正系统开发计划

D． 要给出系统的逻辑视图和物理视图

 

![img](https://img2018.cnblogs.com/i-beta/1806053/201912/1806053-20191227134649170-1186722082.png)

 

 

 

![img](https://img2018.cnblogs.com/i-beta/1806053/201912/1806053-20191227134701767-214269692.png)

 

 

 

5.耦合的强弱取决于（A）。

A． 模块间接口的复杂程度

B． 调用模块的方式

C． 通过接口的信息

D． 模块内部各个元素彼此之间的紧密结合程度

 

**填空**

1. 软件工程是从（ 软件开发技术 ）和（软件工程  ）两个方面研究如何运用工程学的基本原理和方法来更好地开发和维护计算机软件的一门学科。
2. 数据流图的基本符号包括（ 箭头 ）、（圆或椭圆）、（双杠）、（方框）。
3. 现在存入银行P元，年利率为i，n年后可得钱数为（ p*(1+n*j) ）。
4. 把程序从一个硬件或软件环境中转移到另一种配置环境称为软件的（可移植性）。
5. 在软件的详细设计中，根据控制流程从上到下，从左到右展开的设计工具是（_PDL图）。
6. 一个模块拥有的直属下级模块的个数称为（桩模块），一个模块的直接上级模块的个数称为（驱动模块）。
7. 大型软件测试包括（单元测试）、（集成测试）、确认测试和（驱动测试 ）四个步骤。
8. UML的定义包括（UML语义）和（UML标志法）两个部分。
9. 详细设计的工具有（图形）、（表格）和语言工具。
10. 提高软件质量和可靠性的技术大致可分为两类，一类是（避开技术），另一类是（容错技术）。
11. 白盒法包括多种具体设计程序测试用例的方法，主要目的是提高测试的（效率）。

**简答**

1．软件就是程序。（F）

2．信息隐蔽是指模块中所包括的信息不允许其它不需要这些信息的模块调用。（F）

3．性能测试是为了检验系统的能力最高能达到什么实际的限度，让系统处于资源的异常数量、异常频率、异常批量的条件下运行测试系统的承受能力。（F）

**4．** 用户需求经常是变化的，因为软件是灵活的，所以总可以满足用户的需求。（F）

5．简述需求分析方法应遵循的基本原则？

答：1.必须能够表达和理解问题的数据域和功能域。2.可以把一个复杂的问题按功能进行分解并可逐层细化。3.建模

6．模块间的耦合性包括哪些类型？按强弱排列。

答：耦合有以下几种，他们之间的耦合度由高到低排列：

 1.内容耦合：如一个功能模块直接访问另一个功能模块的内容，则这两个功能模块称为内容耦合。2.公共耦合：如一个功能模块都访问统一全局数据结构，则称之为公共耦合。3.外部耦合：如一个功能模块都访问统一全局数据项，则称之为外部耦合。4.控制耦合：如一个功能模块明显的把开关量、名字等信息送入另一个功能模块，控制另一功能模块的功能，则称为控制耦合。5.标记耦合：如一个功能模块共享了某个记录，而不是简单变量，即这些功能模块都需某一数据的子结构时，就需要按该记录的结构进行操作，并通过参数表来传递记录信息，这样的耦合称为标记耦合。6.数据耦合：如一个功能模块访问另一功能模块，被访问的功能模块的输入和输出都是数据项参数，则这两个功能模块为数据耦合。7.非直接耦合：若两个功能模块没有直接关系，他们之间的联系完全是通过主程序的控制和调用来实现的，便称这两个功能模块为非直接耦合，独立性最强。

 

7．什么是黑盒测试法？

答：黑盒测试法又称功能测试或数据驱动测试，该方法把被测试对象看成一个不透明的黑盒子。测试人员完全不考虑程序内部结构和处理过程，只在程序的接口处进行测试，依据需求说明书，检查程序是否满足功能要求，是否能很好的接受数据，并产生正确的输出。

8．CMM模型包括哪些等级？

答：1.初始级 2.可重复级 3.已定义级 4.已管理级 5.优化级

 

 

 

 

**软件工程期末试卷（九）**

软件工程期末试卷(A)

**说明：本试卷为****04****级计算机专业（专升本）软件工程期末试卷，总计****100****分，时间****100****分钟**

**一、选择题：（每题****1****分，共****20****分）（将答案写在题号前的（）中）**

（ C  ）1.  软件是（   ）。

A. 处理对象和处理规则的描述  B. 程序

C. 程序及其文档            D. 计算机系统

（ B  ）2. 软件需求规格说明的内容不应包括（   ）。

A. 主要功能           B. 算法的详细描述

C. 用户界面及运行环境     D. 软件的性能

（ B  ）3. 程序的三种基本控制结构是（   ）。

A. 过程、子程序和分程序    B. 顺序、选择和重复

C. 递归、迭代和回溯       D. 调用、返回和转移

( Ｄ ) 4. 面向对象的分析方法主要是建立三类模型，即(   )。
       A) 系统模型、ER模型、应用模型
        B) 对象模型、动态模型、应用模型
        C) Ｅ-Ｒ模型、对象模型、功能模型
        D) 对象模型、动态模型、功能模型
 ( C ) 5. 在E-R模型中，包含以下基本成分(    )。
        A) 数据、对象、实体
        B) 控制、联系、对象
        C) 实体、联系、属性
         D) 实体、属性、操作
 (  A ) 6. 各种软件维护的类型中最重要的是(   )。
       A) 完善性维护  B) 纠错性维护     C) 适应性维护   D) 预防性维护
(  B ) 7．软件测试的目标是（   ）。

A. 证明软件是正确的       B. 发现错误、降低错误带来的风险

C. 排除软件中所有的错误     D. 与软件调试相同

（ D ）8．软件生命周期中所花费用最多的阶段是（    ）

A．详细设计  B．软件编码  C．软件测试   D．软件维护

（ C ）9．若有一个计算类型的程序，它的输入量只有一个X，其范围是[-1.0, 1.0]，现从输入的角度考虑一组测试用例：-1.001, -1.0, 1.0, 1.001.设计这组测试用例的方法是（    ）

A．条件覆盖法  B．等价分类法  C．边界值分析法   D．错误推测法

（ D ）10、详细设计的基本任务是确定每个模块的(     )设计

A．功能   B.调用关系   C.输入输出数据    D.算法

（ A ）11．设函数C（X）定义问题X的复杂程序，函数E（X）确定解决问题X需要的工作量（时间）。对于两个问题P1和P2，如果C（P1）>C（P2）显然E（P1）>E（P2）,则得出结论E（P1+P2）>E（P1）+E（P2）就是：（    ）

 A．模块化的根据 B．逐步求精的根据 C．抽象的根据  D．信息隐藏和局部化的根据

（ D ）12．下面几种白箱测试技术，哪种是最强的覆盖准则 （   ）

 A．语句覆盖  B．条件覆盖  C．判定覆盖   D．条件组合覆盖

（ A ）13．面向数据流的设计方法把（      ）映射成软件结构。

 A．数据流   B．系统结构   C．控制结构    D．信息流

（ A ）14.内聚程度最低的是(   )内聚

A.偶然    B.过程   C.顺序   D.时间

（ A ）15.确定测试计划是在(    )阶段制定的.

A．总体设计   B.详细设计   C.编码    D.测试

（ D ）16．需求分析的产品是（   ）

​      A．数据流程图案 B．数据字典 C．判定表 D．需求规格说明书

（ C ）17．数据字典是软件需求分析阶段的最重要工具之一，其最基本的功能是（   ）

A．数据库设计  B．数据通信  C．数据定义  D．数据维护

( D )18.(    )引入了“风险驱动”的思想，适用于大规模的内部开发项目。

​      A．增量模型  B．喷泉模型   C．原型模型  D．螺旋模型

（ D ）19．模块的内聚性最高的是（   ）

 A．逻辑内聚  B．时间内聚   C．偶然内聚   D．功能内聚

( D )20.提高测试的有效性非常重要,成功的测试是指(    )

A.证明了被测试程序正确无误  B. 说明了被测试程序符合相应的要求

C.未发现被测程序的错误    D.发现了至今为止尚未发现的错误

 

**二．判断题（每题****1****分，共****10****分）将答案写在题号前的（**  **）中，正确用****√****，****错误用****χ。**

（ × ）1、开发软件就是编写程序。

（ ×　）２、系统测试的主要方法是白盒法，主要进行功能测试、性能测试、安全性测试及可靠性等 测试。

（ × ）3、编程序时应尽可能利用硬件特点以提高程序效率.

（ × ）4、软件需求分析的任务是建立软件模块结构图。

（ **√** ）5、尽可能使用高级语言编写程序

（ × ）6、以结构化分析方法建立的系统模型就是数据流图。

（ × ）7、进行总体设计时加强模块间的联系。

（ × ）8、编码时尽量多用全局变量.

（ **√** ）9、用CASE环境或程序自动生成工具来自动生成一部分程序.

（ × ）10、软件测试是要发现软件中的所有错误。

 

**三、填空题（每题****1****分，共****5****分）：将结果填在（**   **）**

1、将下面的关系按继承关系、聚集关系或普通关联进行分类。

小汽车---------红旗轿车            （  继承  ）

小汽车---------驾驶员             （ 普通关联 ）

班级------------学生              （  聚集  ）

 

2、将下列各项分为类或类的实例

我的汽车                  （  实例  ）

交通工具                  （  类  ）

 

 

**三、简答题：（每题****5****分，共****25****分）**

 

\1. 软件生命期各阶段的任务是什么？
   答：软件生命期分为7个阶段：
   1、问题定义：要解决的问题是什么

2、可行性研究：确定问题是否值得解，技术可行性、经济可行性、操作可行性

3、需求分析：系统必须做什么

4、总体设计：系统如何实现，包括系统设计和结构设计

5、详细设计：具体实现设计的系统

6、实现：编码和测试

7、运行维护：保证软件正常运行。

 

   2、软件重用的效益是什么？
   答：1、软件重用可以显著地改善软件的质量和可靠性。

2、软件重用可以极大地提高软件开发的效率。

3、节省软件开发的成本，避免不必要的重复劳动和人力、财力的浪费。



   3、 自顶而下渐增测试与自底而上渐增测试各有何优、缺点？
   答：
   ①　自顶而下渐增测试

   优点：不需要测试驱动程序，能够在测试阶段的早期实现并验证系统的主要功能，而且能够尽早发现上层模块的接口错误。

   缺点：需要存根程序，底层错误发现较晚。

   ②　自底而上渐增测试

   优点与缺点和自顶而下渐增测试相反。

 

   4 、 提高可维护性的方法有哪些？
   答：在软件工程的每一阶段都应该努力提高系统的可维护性，在每个阶段结束前的审查和复审中，应着重对可维护性进行复审。
   在需求分析阶段的复审中，应对将来要扩充和修改的部分加以注明。在讨论软件可移植性问题时，要考虑可能要影响软件维护的系统界面。
   在软件设计的复审中，因从便于修改、模块化和功能独立的目标出发，评价软件的结构和过程，还应对将来可能修改的部分预先做准备。
   在软件代码复审中，应强调编码风格和内部说明这两个影响可维护性的因素。
   在软件系统交付使用前的每一测试步骤中都应给出需要进行预防性维护部分的提示。
   在完成每项维护工作后，都应对软件维护本身进行仔细认真的复审。
   为了从根本上提高软件系统的可维护性，人们正试图通过直接维护软件规格说明来维护软件 ，同时也在大力发展软件重用技术。

 

简述软件测试要经过哪几个步骤，每个步骤与什么文档有关。

【解答】

测试过程按 4 个步骤进行，即单元测试（模块测试）、集成测试（子系统测试和系统测试）、确认测试（验收测试）和平行运行。

单元测试集中对用源代码实现的每一个程序单元进行测试，与其相关的文档是单元测试计划和详细设计说明书。

集成测试把已测试过的模块组装起来，主要对与设计相关的软件体系结构的构造进行测试。与其相关的文档是集成测试计划和软件需求说明书。

 

确认测试则是要检查已实现的软件是否满足了需求规格说明中确定了的各种需求，以及软件配置是否完全、正确。与其相关的文档是确认测试计划和软件需求说明书。

平行运行把已经经过确认的软件纳入实际运行环境中，与其他系统成份组合在一起进行测试。与其相关的文档：用户指南、使用手册等。

 

**四、应用题（每题****8****分，共****40****分）**

**假设一家工厂的采购部每天需要一张定货报表，报表按零件编号排序，表中列出所有需要再次定货的零件。对于每个需要再次定货的零件应该列出下述数据：零件编号，零件名称，定货数量，目前价格，主要供应者，次要供应者。零件入库或出库称为事务，通过放在仓库中的CRT终端把事务报告给定货系统。当某种零件的库存数量少于库存量临界值时就应该再次定货。要求：画出系统的数据流图。** 

**![img](https://img2018.cnblogs.com/i-beta/1806053/201912/1806053-20191227134758416-136888234.png)**

 

 

 

**![img](https://img2018.cnblogs.com/i-beta/1806053/201912/1806053-20191227134834767-1846354369.png)**

 

 

 ![img](https://img2018.cnblogs.com/i-beta/1806053/201912/1806053-20191227134939702-123588984.png)

 

 

 

3、:输入三整数,判断是否构成三角形,如构成三角形,则输出三条边的值,否则输出”不能构成三角形”. 要求:1.用程序流程图表示该问题的算法；2.计算程序复杂度； 3.设计路径覆盖的测试用例。

答：（1）

 ![img](https://img2018.cnblogs.com/i-beta/1806053/201912/1806053-20191227135021691-776016980.png)

 

 （2）

 ![img](https://img2018.cnblogs.com/i-beta/1806053/201912/1806053-20191230155353795-451786572.png)

 

（3）

 ![img](https://img2018.cnblogs.com/i-beta/1806053/201912/1806053-20191228160826646-1967512049.png)

 

 

4、某航空公司规定，乘客可以免费托运重量不超过30kg的行李。当行李重量超过30kg时，对头等舱的国内乘客超重部分每公斤收费4元，对其他舱的国内乘客超重部分每公斤收费6元，对外国乘客超重部分每公斤收费比国内乘客多一倍，对残疾乘客超重部分每公斤收费比正常乘客少一半。用判定树表示与上述每种条件组合相对应的计算行李费的算法.

答案:

![img](https://img2018.cnblogs.com/i-beta/1806053/201912/1806053-20191227135124332-43029761.png)

 

 

 

5、一个软件公司有许多部门，分为开发部门和管理部门两种，每个开发部门开发多个软件产品，每个部门由部门名字唯一确定。该公司有许多员工，员工分为经理，工作人员和开发人员。

开发部门有经理和开发人员，管理部门有经理和工作人员。每个开发人员可参加多个开发项目，每个开发项目需要多个开发人员，每位经理可主持多个开发项目，建立该公司的对象模型。

**![img](https://img2018.cnblogs.com/i-beta/1806053/201912/1806053-20191227135200342-1822146946.png)**

 

 

 

 

 

**(****十****)****软件工程专项训练**

**选择**

① 软件生命周期中所花费用最多的阶段是（D）

A． 详细设计B．软件编码C．软件测试D．软件维护

②可行性分析是在系统开发的早期所做的一项重要的论证工作，它是决定该系统是否开发

的决策依据，因必须给出（B）的回答。

A．确定B．行或不行C．正确D．无二义

③下列关于瀑布模型的描述正确的是（C）。

A. 瀑布模型的核心是按照软件开发的时间顺序将问题简化。

B. 瀑布模型具由于良好的灵活性。

C. 瀑布模型采用结构化的分析与设计方法，将逻辑实现与物理实现分开。

D. 利用瀑布模型，如果发现问题则修改的代价很低。

④ 详细设计的结果基本决定了最终程序的（C）

A．代码的规模B．运行速度C．质量D．可维护性

⑤ 结构化程序设计主要强调的是（D）

A． 程序的规模B． 程序的效率C． 程序设计语言的先进性D． 程序易读性

⑥ 程序的三种基本控制结构是（B）

A．过程、子程序和分程序B．顺序、选择和重复C．递归、堆栈和队列D．调用、返回和转移

⑦ 确认软件的功能是否与需求规格说明书中所要求的功能相符的测试属于（C）

A、集成测试B、恢复测试C、验收测试D、单元测试

⑧ 面向对象技术中，对象是类的实例。对象有三种成份：（A）、属性和方法(或操作)。

A.  标识 B.  规则 C. 封装D. 消息

⑨ 下面关于面向对象方法中消息的叙述，不正确的是（B）。

A. 键盘、鼠标、通信端口、网络等设备一有变化，就会产生消息

B．操作系统不断向应用程序发送消息，但应用程序不能向操作系统发送消息

C. 应用程序之间可以相互发送消息

D．发送与接收消息的通信机制与传统的子程序调用机制不同

⑩ 面向对象程序设计中的数据隐藏指的是（D）。

A． 输入数据必须输入保密口令

B．数据经过加密处理

C. 对象内部数据结构上建有防火墙

D．对象内部数据结构的不可访问性

 

 

 

 

 

答案：①D ②B ③C ④C ⑤D ⑥B ⑦C ⑧A ⑨B ⑩D

1.程序设计属于软件开发过程（ C）阶段。

A、设计B、编程C、实现D、编码

2.结构设计是一种应用最广泛的系统设计方法，是以（A）为基础、自顶向下、逐步求精

和模块化的过程。

A、数据流B、数据流图C、数据库D、数据结构

\3. 结构化程序设计主要强调程序的（ C）。

A、效率B、速度C、可读性D、大小

4.分析员是（B ）

A、户中系统的直接使用者B、用户和软件人员的中间人

C、软件的编程人员D、用户和软件人员的领导

\5. 程序的三种基本控制结构的共同特点是（ D）。

A、不能嵌套使用B、只能用来写简单的程序

C、已经用硬件实现D、只有一个入口和一个出口

\6. 软件生产过程中，需求信息由（D ）给出。

A、程序员B、项目管理者C、软件分析设计人员D、软件用户

7.与设计测试数据无关的文档是（D ）。

A、需求说明书B、设计说明书C、源程序D、项目开发设计

8.结构化分析SA 方法以数据流图、（B ）和加工说明等描述工具，即用直观的图和简洁的语言来描述软系统模型。

A、DFD 图B、数据字典C、IPO 图D、PAD 图

9.面向数据流的软件设计方法，一般是把数据流图中数据流划分为（B），再将数据流图映射为软件结构。

A、数据流和事务流B、交换流和事务流

C、信息流和控制流D、交换流和数据流

10.总体设计的结果是提供一份（A）。

A、模块说明书B、框图C、程序D、数据结构

 

 

答案：1. C 2. A 3. C 4. B 5. D 6. D 7. D 8. B 9. B 10. A

\1. 软件是（C ）。

A.  处理对象和处理规则的描述  B. 程序

C.  程序及其文档 D. 计算机系统

\2. 软件需求规格说明的内容不应包括（B ）。

A. 主要功能 B. 算法的详细描述

C. 用户界面及运行环境 D. 软件的性能

\3. 程序的三种基本控制结构是（B ）。

A. 过程、子程序和分程序 B. 顺序、选择和重复

C. 递归、迭代和回溯 D. 调用、返回和转移

\4. 面向对象的分析方法主要是建立三类模型，即( D)。

A) 系统模型、ER 模型、应用模型

B) 对象模型、动态模型、应用模型

C) Ｅ-Ｒ模型、对象模型、功能模型

D) 对象模型、动态模型、功能模型

\5. 在E-R 模型中，包含以下基本成分( C)。

A) 数据、对象、实体

B) 控制、联系、对象

C) 实体、联系、属性

D) 实体、属性、操作

\6. 各种软件维护的类型中最重要的是(A )。

A) 完善性维护B) 纠错性维护C) 适应性维护D) 预防性维护

7．软件测试的目标是（B ）。

A. 证明软件是正确的 B. 发现错误、降低错误带来的风险

C. 排除软件中所有的错误 D. 与软件调试相同

8．软件生命周期中所花费用最多的阶段是（ D）

A．详细设计B．软件编码C．软件测试D．软件维护

9．若有一个计算类型的程序，它的输入量只有一个X，其范围是[-1.0, 1.0]，现从

输入的角度考虑一组测试用例：-1.001, -1.0, 1.0, 1.001.设计这组测试用例的方法是（ C）

A．条件覆盖法B．等价分类法C．边界值分析法D．错误推测法

10、详细设计的基本任务是确定每个模块的( D)设计

A．功能B.调用关系C.输入输出数据D.算法

11．设函数C（X）定义问题X 的复杂程序，函数E（X）确定解决问题X 需要的工

作量（时间）。对于两个问题P1 和P2，如果C（P1）>C（P2）显然E（P1）>E（P2）,则得

出结论E（P1+P2）>E（P1）+E（P2）就是：（ A）

A．模块化的根据B．逐步求精的根据C．抽象的根据D．信息隐藏和局部化的根据

12．下面几种白箱测试技术，哪种是最强的覆盖准则（D ）

A．语句覆盖B．条件覆盖C．判定覆盖D．条件组合覆盖

13．面向数据流的设计方法把（A ）映射成软件结构。

A．数据流B．系统结构C．控制结构D．信息流

14.内聚程度最低的是(A )内聚

A.偶然B.过程C.顺序D.时间

15.确定测试计划是在( A)阶段制定的.

A．总体设计B.详细设计C.编码D.测试

16．需求分析的产品是（D ）

A．数据流程图案B．数据字典C．判定表D．需求规格说明书

17．数据字典是软件需求分析阶段的最重要工具之一，其最基本的功能是（C ）

A．数据库设计B．数据通信C．数据定义D．数据维护

18.(D )引入了“风险驱动”的思想，适用于大规模的内部开发项目。

A．增量模型B．喷泉模型C．原型模型D．螺旋模型

19．模块的内聚性最高的是（D ）

A．逻辑内聚B．时间内聚C．偶然内聚D．功能内聚

20.提高测试的有效性非常重要,成功的测试是指(D )

A.证明了被测试程序正确无误B. 说明了被测试程序符合相应的要求

C.未发现被测程序的错误D.发现了至今为止尚未发现的错误__

 

 

 

答案：1.C 2.B 3.B 4.Ｄ 5.C 6.A 7.B 8.D 9.C 10.D 11.A 12.D 13.A 14.A 15.A  16.D  17.C  18.D  19.D  20.D

 

**1****．**软件危机的事实使人们意识到：计算机要推广使用，其关键在于_________技术的革新。 您的答案为：　　　；正确答案为：**软件开发**  **2****．**所谓“用户要求”是指软机系统必须满足的_________和限制。 您的答案为：　　　；正确答案为：**所有性质**  **3****．**软件工程技术中，控制复杂性的两个基本手段是“分解”和_________。 您的答案为：　　　；正确答案为：**抽象**  **4****．**Jackson法的设计原则是：是程序结构同_________相对应。 您的答案为：　　　；正确答案为：**数据结构**  **5****．**编程的目标是编写出逻辑上正确又易于_________的程序。 您的答案为：　　　；正确答案为：**易于阅读（和易于维护）**  **6****．**检验是软件开发过程中不可缺少的部分，检验的目的在于_________。 您的答案为：　　　；正确答案为：**发现错误并及时纠正**  **7****．**在联合测试时，采用先独立测试每一模块，然后在连到一起运行，这种方式称为_________联调。 您的答案为：　　　；正确答案为：**非渐增式**  **8****．**适合于作为概念性数据模型的所谓第二代数据模型是_________。 您的答案为：　　　；正确答案为：**ER模型(概念数据模型)**  **9****．**面向对象的开发，最大的优点是帮助分析者、设计者及用户清楚地表述_________，便于互相进行交流通讯。 您的答案为：　　　；正确答案为：**抽象概念**  **10****．**程序评价和测试系统PET的主要功能是支持对FORTRAN程序采用白盒法测试，可以监视测试的_________。 您的答案为：　　　；正确答案为：**实际覆盖程度**  

补充日期: **2003-10-30 11:11:11**

选择：**1****．**软件规模可按源程序行数的多少进行分类，所谓大型软件，通常是指源程序行数为( ) A．5 ～ 50K 　 B．50 ～100K 　 C．1M 　 D．1 ～ 10M 您的答案为：　　　；正确答案为：**B**  **2****．**在软件生命期中，占工作量比例最大的是( ) A．可行性研究 　　 B．建立系统的结构 　　 C．编写程序 　　 D．维护 您的答案为：　　　；正确答案为：**D**  **3****．**用SA方法获得的需求说明书有四部分，用于描述系统由那些部分组成、各部分间有何联系等，是在( ) A．一套分层的数据流图 　 B．一本数据词典 　 C．一组小说明　　 D．补充材料 您的答案为：　　　；正确答案为：**A**  **4****．**SA方法在描述方式上的特点，是尽量采用( ) A．自然语言 　 B．形式语言 　 C．图形表示 　 D．表格 您的答案为：　　　；正确答案为：**C**  **5****．**决定软件系统中各个模块的外特性，即其输入输出和功能是( ) 的任务。 A．需求分析 　 B．概要设计 　 C．详细设计 　 D．编程阶段 您的答案为：　　　；正确答案为：**B**  **6****．**用于概要设计所采用的描述手段是( ) A．DFD 　 B．SC 　 C．框图 　 D．数据结构图 您的答案为：　　　；正确答案为：**B**  **7****．**一个模块传送给另一模块的参数是由单个数据项组成的数组，它属于( ) A．数据型 　 B．复合型　 C．内容型 　 D．公共型 您的答案为：　　　；正确答案为：**A**  **8****．**在概要设计的设计文档中，对每个模块的描述内容包括( ) A．功能、界面、输入、输出 B．界面、输入、输出、过程 C．界面、过程、限制和约束 D．功能、界面、过程、注释 您的答案为：　　　；正确答案为：**D**  **9****．**根据SP方法的要点规定，程序最后要由( ) 审定。 A．专家 　 B．谁编谁审 　 C．主程序员 　 D．资料员 您的答案为：　　　；正确答案为：**C**  **10****．**结构化程序图（FC）中的箭头是用于表示( ) A．控制流 　 B．数据流 　 C．数据/控制 　 D．调用关系 您的答案为：　　　；正确答案为：**A**  **11****．**结构化程序之所以有可能验证其正确性是由于( ) A．只有三种基本结构　 B．有限制地使用GOTO语句　 C．程序内部有“内部文档”　 D．选择良好数据结构和算法 您的答案为：　　　；正确答案为：**A**  **12****．**提高程序可读性的有力手段是( ) A．选好一种程序设计语言 　B．显式说明一切变量　　C．使用三种标准控制语句 　D．给程序加注释 您的答案为：　　　；正确答案为：**D**  **13****．**通过对软件的测试，可以证明( ) A．程序正确性　 B．错误不存在　 C．错误存在 　D．不含有隐患 您的答案为：　　　；正确答案为：**C**  **14****．**某程序功能说明中列出“规定每个运动员参赛项目为1～3项”，应用黑盒法中的等价分类法确定等价类是( ) A．1≤项目数≤3 　B．项目数<1　　 C．项目数>3 　D．以上都是 您的答案为：　　　；正确答案为：**D**  **15****．**程序功能说明中指出：由三个输入数据表示一个三角形的三条边长。根据黑盒法中的边缘值分析法设计测试用例，应选( ) A．a=3,b=4,c=5 　　B．a=1,b=2,c=4　　C．上述A、B项都应选上　　 D．a=1,b=2,c=3 您的答案为：　　　；正确答案为：**D**  **16****．**软件维护，可按不同的维护目的而分类，为了适应硬件环境或软件环境的变更对软件作修改是( ) A．纠正性维护　 B．适应性维护　　C．完善性维护　 D．预防性维护 您的答案为：　　　；正确答案为：**B**  **17****．**决定软件工程方法论所有步骤的关键目标是提高软件的( ) A．可移植性 　B．可靠性 　　C．可维护性　　 D．效率 您的答案为：　　　；正确答案为：**C**  **18****．**数据库设计全过程中的关键是( ) A．分析用户要求 　B．建立概念性数据模型　　C．逻辑设计　　D．物理设计 您的答案为：　　　；正确答案为：**B**  **19****．**作为面向对象分析的基础，由问题领域中的对象所组成，用ER图来描述的是( ) A．消息模型 　　　B．处理模型　　 　C．状态模型 　　D．瀑布模型 您的答案为：　　　；正确答案为：**B**  **20****．**在下列软件工具中，可用于支持概要设计的工具是( ) A．PSL/PSA系统 　　B．SDL/PAD系统　　 C．AIDES系统 　　D．Tektronix工具箱 您的答案为：　　　；正确答案为：**C**

 

 

**简答**

​    **1.**   **什么软件？软件按功能进行划分，可以划分成哪几类？按工作方式进行分类，可以划分成哪几类？**

答：软件是由计算机程序、程序使用的数据以及说明的各种文档组成。按功能进行划分可以分为：系统软件、支撑软件、应用软件；按软件工作方式进行分类可以分为：实时处理软件、分时处理软件、交互式软件和批处理软件。

​    **2.**   **软件危机产生的原因是什么？**

答：软件危机的原因：

a)   软件不同与硬件，是逻辑部件；

b)   软件规模庞大，逻辑结构复杂；

c)   软件开发人员和管理人员只重视设计程序而轻视用户的需求分析，导致最后研制出的软件产品无法满足用户的需求；

d)   软件设计技术和管理技术落后，没有统一的软件质量管理规范；

e)   在软件的开发与维护关系问题上存在错误的概念，重视开发，而轻视维护。

​    **3.**   **简述软件工程的定义。**

答：软件工程是用科学知识和技术原理来定义、开发和维护软件的一门学科。采用工程的概念、原理、技术和方法来开发与维护软件，把经过时间考验而证明正确的管理技术和当前能够得到的最好的技术方法结合起来。

​    **4.**   **简述软件生存周期的定义及组成部分。**

答：一个软件从定义到开发、使用和维护，直到最终被废弃，要经历一个漫长的时期，通常把软件经历的这个漫长的时期称为软件生存周期。它包括制定计划（问题定义）、可行性研究、需求分析、总体设计、详细设计、程序编写（编码）、综合测试、运行维护等。

​    **5.**   **可行性研究的目的是什么？可以从哪些方面来考虑软件开发的可行性？**

答：可行性研究的目的是用最小的代价在尽可能短的时间内确定问题是否能够解决。主要从技术可行性、经济可行性、操作可行性和法律可行性4个方面考虑。

​    **6.**   **面向对象方法学的优点有哪些？**

答：面向对象方法学的优点：

（1）多角度模拟客观世界；

（2）具有较高的稳定性；

（3）重用性好；

（4）适合开发大型软件。

​    **7.**   **需求分析的主要方法是什么？用这种方法进行需求分析的主要步骤有哪些？**

答：需求分析的方法有面向数据流的分析方法、面向数据结构的分析方法、面向对象分析方法和动态分析方法等，主要采用面向数据流的分析方法。主要步骤包括：（1）分析数据流图；（2）用户审查；（3）细化数据流图；（4）修订开发计划；（5）复审开发计划。

​    **8.**   **细化数据流图需要遵循哪些基本原则？**

答：细化数据流图需要遵循的原则有：

a)   在分层细化时必须保持数据的连续性，也就是说细化前后对应功能的输入/输出数据必须相同。

b)   把一个功能进一步分解成子功能，这些子功能必须有独立的功能，否则，就不需要再分解了。

​     **9.**   **什么是对象？什么是类？什么是消息？**

答：现实世界中客观存在的事物都被称为对象。具有相同或相似性质的对象的抽象被称为类。对象之间进行的通信被称为消息。

​    **10.** **什么是对象的封装？主要表现在哪些方面？**

答：封装就是把对象包起来，使外界只能看到对象的接口，而不能知道对象内部的具体内容。主要表现在：（1）有固定的接口；（2）保护内部实现 。

​    **11.** **简述过程设计语言（PDL）的特点。**

答：PDL的特点是：（1）关键字应有固定语法，提供了结构化控制结构和语句说明；（2）用自然语言叙述系统处理功能，易于理解；（3）可以使用变通的语言编辑程序或文字处理系统，很方便地完成PDL的书写和编辑工作；（4）易于让计算机来处理。

​    **12.** **怎样从客户类的角度发现协作？**

答：可以通过对客户类提出如下问题来发现协作：

a)   类本身能够履行这个操作吗？

b)   如果不能，那么它需要什么？

c)   它从其他什么类中能够获得所需要的东西？ 

​    **13.** **简述软件质量的定义及在软件开发过程中管理软件质量的办法。**

答：软件质量指的是软件产品满足规定的和隐藏的与需求能力有关的全部特征和特性。管理软件质量的办法：（1）每个阶段都必须完成规定的文档，没有交出合格的文档就是没有完成该阶段的任务；（2）每个阶段结束前都要对所完成的文档、程序进行评审，以便尽早发现问题，改正错误。

​    **14.** **什么是白盒测试？什么是黑盒测试？**

答：白盒测试又称为结构测试，它的前提条件是可以看成将程序放在一个透明的白盒子中，也就是完全了解了软件系统的结构和整个处理过程。

黑盒测试又称为功能测试，它把程序看成是一个不透明的黑盒子，完全不去考虑程序的内部结构和处理过程。

​    **15.** **什么是软件维护？软件维护可以分为哪几类？**

答：软件维护是指在软件系统已经交付使用之后，软件使用人员为了适应新的要求、满足新的需要或为了改正软件中存在的错误而对软件系统进行修改的过程。可以分为纠错性维护、完善性维护、适应性维护和预见性维护。

​    **16.** **简述软件质量三要素及其具体包括的内容。**

答：软件质量要素可以分为三类，第一类要素表现软件的运行特征，包括正确性、可靠性、有效性、安全性和可用性；第二类要素表现软件承受修改的能力，包括可维护性、灵活性和可测试性；第三类要素表现软件对新环境的适应程度，包括可移植性、可重用性和可互操作性。