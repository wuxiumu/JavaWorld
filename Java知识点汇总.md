#  一、基本数据类型
Java*共有*8种*原生类型，分别是*byte, short, int, long, float, double, char, boolean*，不包含字符串*String*。在*Java*中，所有整型都是有符号数，没有unsigned关键字。特别注意*char*是两个字节的，范围是*0～65535*，存的是*Unicode*编码。*short*是两个字节，*int*是四个字节，*long*是八个字节，类型大小是固定的，与平台无关。*



```java
package knowledge;



 



/



 * Created by gzx on 16-12-27.



 */



public class BasicTypeDemo {



    public static void main(String[] args){



        System.out.println("Byte");



        System.out.println(Byte.MIN_VALUE); // -128



        System.out.println(Byte.MAX_VALUE); // 127



 



        System.out.println("Short");



        System.out.println(Short.MIN_VALUE); // -32768



        System.out.println(Short.MAX_VALUE); // 32767



 



        System.out.println("Character");



        System.out.println((int)Character.MIN_VALUE); // 0



        System.out.println((int)Character.MAX_VALUE); // 65535



 



        System.out.println("Integer");



        System.out.println(Integer.MIN_VALUE); // -2147483648



        System.out.println(Integer.MAX_VALUE); // 2147483647



 



        System.out.println("Long");



        System.out.println(Long.MIN_VALUE); // -9223372036854775808



        System.out.println(Long.MAX_VALUE); // 9223372036854775807



 



        System.out.println("Float");



        System.out.println(Float.MIN_VALUE); // 1.4E-45, 最小精度值，而不是最小值(-Float.MAX_VALUE)



        System.out.println(Float.MAX_VALUE); // 3.4028235E38



 



        System.out.println("Double");



        System.out.println(Double.MIN_VALUE); // 4.9E-324，最小精度值，而不是最小值(-Double.MAX_VALUE)



        System.out.println(Double.MAX_VALUE); // 1.7976931348623157E308



    }



}
```



​    *这些基本类型有对应的包装类。*int->Integer*称为装包，*Integer->int*称为拆包。而且会自动装包和自动拆包，是由编译器支持的，会自动插入指令，虚拟机不知。前六个基本类型的包装类都继承自*Number*。*



```java
package knowledge;



 



import java.util.ArrayList;



/



 * Created by gzx on 16-12-27.



 */



public class WrapperDemo {



    public static void main(String[] args){



        ArrayList<Integer> arrayList = new ArrayList<Integer>();



 



        // 自动装箱，int转化为Integer



        int data = 10;



        arrayList.add(data);



 



        // 自动拆箱，Integer转化为int



        int ret = arrayList.get(0);



 



        // 自动装包，本质是new Integer(a)。-128 ～ 127都相等，有唯一的对象



        Integer a = 127;



        Integer b = 127;



        System.out.println(a == b); // true



 



        // 手动生成新的实例



        Integer c = new Integer(1);



        Integer d = new Integer(1);



        System.out.println(c == d); // false



 



    }



}
```

# 二、字符串

​    String*底层使用*char[]*存储，Unicode\*编码，\*而且所有需要改变字符串状态的方法都\*通过创建新的字符串实例返回，\*不会改变字符串的底层数据，即状态不可变，线程安全。另String用了final修饰，即不可以再被继承。如果字符串需要频繁修改，使用StringBuilder\*，主要有\*append\*方法。String\*比较有用的方法有：*

substring(int beginIndex,int endIndex)*：获得两个索引之间的子串，不包含*endIndex

charAt(int index)*：某个位置的*char

compareTo(String other) :*实现了*Comparable<String>*接口*

indexOf(String str)*：子串首次出现的位置*

trim():*去除字符串前后的空白*

toLowerCase()

toUpperCase()

*静态方法：*

String.format(String fmt, Object… ) :*格式化字符串，后跟不定参数*



```java
package knowledge;



 



/



 * Created by gzx on 16-12-27.



 */



public class StringDemo {



    public static void main(String[] args){



        /*



            String相关方法



         */



        String str = "hello world";



        for(int i = 0; i < str.length(); i++){



            System.out.printf("'%c' ", str.charAt(i));



        }



        System.out.println();



        System.out.println(str.substring(3, 7)); // lo w



        System.out.println(str.compareTo("you are here")); // -17, h - y



        System.out.println(str.indexOf("wo")); // 6



        System.out.println(str.toUpperCase()); // HELLO WORLD



        System.out.println(str); // hello world



 



        /*



            字符串格式化



         */



        String format = "you are %s";



        System.out.println(String.format(format, str)); // you are hello world



    }



}
```

##   正则表达式的使用：

先编译模式Pattern，再匹配文本，得到matcher，最后通过matcher.find()寻找所有结果，以及匹配的模式中的所有加括号的组。



```java
import java.util.regex.Matcher;



import java.util.regex.Pattern;



 



/



 * Created by jessin on 17-2-26.



 */



public class PatternDemo {



    public static void main(String[] args){



        // 预先编译



        String str = "\\$(\\w+)\\((\\d+)\\)";



        Pattern pattern = Pattern.compile(str);



        String text = "hello $natureOrder(123) if you like this ,please use $indexOrder(99);";



        // 生成编译类



        Matcher matcher = pattern.matcher(text);



        // 得到所有的匹配结果



        while(matcher.find()){



            // 整个匹配的字符串：$function(argument)



            System.out.println(matcher.group());



            // 第一个()的内容：函数名function



            System.out.println(matcher.group(1));



            // 第二个括号的内容：数字argument



            System.out.println(matcher.group(2));



            // 将所有的匹配项删除，必须赋值才能起作用



            text = text.replace(matcher.group(), "field");



//            $natureOrder(123)



//            natureOrder



//            123



//            $indexOrder(99)



//            indexOrder



//            99



        }



        System.out.println(text);



        // hello field if you like this ,please use field;



    }



}
```





# 三、标准输入和格式化输出

​    *这里主要是从键盘和文件读入数据，将数据格式化输出到控制台或者文件。*

java.util.Scanner*提供了标准输入，比较有用的方法有*

Scanner(InputStream input) :*初始化一个*Scanner*实例*

String nextLine() : 读入一行，不论是否有空格

String hasNext() :*是否还有字符串*

String next() :*以空格作为分隔符*

String hasNextInt()

String nextInt() :*读入一个整数*

String hasNextDouble()

String nextDouble()*：读入一个*double

标准输入：new Scanner(System.in)

从文件输入：new Scanner(new File(filename))

格式化输出到控制台：System.out.printf(fmt, object...)

格式化输出到文件：PrintWriter(new File(filename))

printer.printf(fmt, object...)

printer.close()



```java
package knowledge;



import java.io.FileNotFoundException;



import java.io.PrintWriter;



import java.util.Scanner;



import java.io.File;



/



 * Created by gzx on 16-12-27.



 */



public class ScannerDemo {



    public static void main(String[] args) throws FileNotFoundException{



        /*



             从文件格式化输入



         */



        Scanner in = new Scanner(new File("/home/gzx/hello.txt")); // 将参数改为System.in可以从键盘输入



        // 文件内容：hello 123 31313.111



        while(in.hasNext()){



            System.out.println(in.next()); // hello



            System.out.println(in.nextInt()); // 123



            System.out.println(in.nextDouble()); //31313.111



        }



        /*



             格式化输出到控制台



         */



        int data = 1234;



        double hello = -1234.13214134;



        System.out.printf("整数是%d\n", data); // 1234



        System.out.printf("浮点数是%7.3f\n", hello); // -1234.132



        /*



             格式化输出到文件



         */



        String outName = "out.txt"; // 保存hello : world



        File outFile = new File(outName);



        System.out.println(outFile.getAbsolutePath());



        



        PrintWriter printer = new PrintWriter(outFile); // FileNotFoundException



        printer.printf("%s : %s\n", "hello", "world");



        printer.close();



    }



}
```

### 

# 四、数组

​    *数组创建(new)时的元素是默认值，数字是*0*，布尔是*false*，对象是*null*。也可以在创建数组时初始化，但不能指定数组的大小，大小将由初始值的个数确定。数组是对象，有*length*属性，可以赋值给另一个数组。数组有对应的工具类Arrays。*

*数组转化为字符串：*

Arrays.toString(type[] arr)

*二维数组快速输出：*

Arrays.deepToString(type[][] arr)

*数组拷贝：*

newArr= Arrays.copyOf(type[] arr, int len) :不管数组大小，生成新的数组，与原来数组没有任何关系。

*数组排序：*

Arrays.sort(type[] arr)

*数组二分查找，检查是否有该元素，没有则返回*-1*：*

Arrays.binarySearch(type[] arr, int v)

*数组整体赋值：*

Arrays.fill(type[] arr, type v)



```java
package knowledge;



 



import java.util.Arrays;



 



/



 * Created by gzx on 16-12-27.



 */



public class ArrayDemo{



    public static void main(String[] args) {



        /*



            默认值为null，在堆中，接下来需要一一赋值



         */



        int [] intArr = new int[10];



        System.out.println(intArr[0]); // 0



        double[] doubleArr = new double[10];



        System.out.println(doubleArr[0]); // 0.0



        String[] stringArr = new String[10];



        System.out.println(stringArr[0]); // null



 



        // 数组初始化，数组是对象，有length属性，可以相互赋值



        int[] intArr2 = {1, 3, 5, 7};



        System.out.println(intArr2.length); // 4



        // 匿名数组赋值，不能指定大小，可以把new int[]去掉变为数组初始化



        int[] intArr3 = new int[] {1, 2, 3, 4, 5};



        System.out.println(intArr3.length); // 5



 



        /*



            二维数组



         */



        int[][] intArr4 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};



        for(int i = 0; i < intArr4.length; i++){



            for(int j = 0; j < intArr4[i].length; j++){



                System.out.printf(intArr4[i][j] + " ");



            }



            System.out.println();



        }



 



        int size = 10;



        int[][] intArr5 = new int[size][size];



        System.out.println(intArr5[0][0]); // 0



 



        String[] stringArr2 = new String[]{"hello", "world", "long", "int", "string", "turn"};



        /*



            Arrays.sort



         */



        Arrays.sort(stringArr2);



        for(int i = 0; i < stringArr2.length; i++){



            System.out.print(stringArr2[i] + " "); // hello int long string turn world



        }



        System.out.println();



 



        System.out.println(Arrays.binarySearch(stringArr2, "turn")); // 4



        /*



            Arrays.toString



         */



        System.out.println(Arrays.toString(stringArr2)); // [hello, int, long, string, turn, world]



        /*



            Arrays.deepToString : 二维数组



         */



        System.out.println(Arrays.deepToString(intArr4)); // [[1, 2, 3], [4, 5, 6], [7, 8, 9], [10, 11, 12]]



        /*



            Arrays.copyOf : 获得新的数组，并返回，新增加的空间填null



         */



        String[] copyStringArr2 = Arrays.copyOf(stringArr2, stringArr2.length * 2);



        // [hello, int, long, string, turn, world, null, null, null, null, null, null]



        System.out.println(Arrays.toString(copyStringArr2));



 



        /*



            Arrays.fill



         */



        String[] stringArr3 = new String[3];



        Arrays.fill(stringArr3, "no");



        System.out.println(Arrays.toString(stringArr3)); // [no, no, no]



    }



}
```

### 

# 五、类

​    *因为对象在堆中创建，类的成员变量默认有初始值。而局部变量一般在栈中，必须在操作前明确初始化，否则编译不通过。Java\*中的类是要加上包名的，构成的全名才是类名（运行时用java 全名）。当有冲突时，用全名就可以了。包之间没有任何关系。*类有三个特性：封装、继承、多态。封装最主要体现在权限上，*Java*中有四种权限：*private,default,protected,public*。其中修饰类只能是*public*或者*default*。*private*只能在本类可见，*default*是包权限，*protected*是包权限*+*子类权限（子类成员方法可以直接使用，而静态方法中可以通过生成子类的实例来访问，但不可以使用父类实例来访问，见下面代码），*public*是所有权限。继承的话会继承所有成员，包括私有成员，当然子类可以有和父类同名成员，但是父类的成员会被隐藏。子类可以覆盖父类的方法。多态主要体现在覆盖上。覆盖方法时权限不能缩小，抛出的异常不能增多，子类中的返回值可以是父类返回值的子类型，其他如形参都必须保持一致。多态的实现机制是每个类维护一张方法表，如果有覆盖，则表里的方法被替换掉。具体要看引用指向的类型，这一点非常重要，赋值给的类型只是在操作时有些方法可能不能调用。*

#### 

#### 5.1测试继承自Object的方法和保护权限



```java
package knowledge2;



 



/



 * Created by gzx on 16-12-27.



 */



public class Worker {



    private int data;



    // 测试不同包下的保护权限



    protected int getData(){



        return data;



    }



}
```



```java
package knowledge;



 



import knowledge2.Worker;



 



/



 * Created by gzx on 16-12-27.



 */



public class DefaultClass extends Worker{



    public int getD(){ // 将方法名改为getData，而方法体改为super.getData()，可以实现权限的扩大。



        return getData();



    }



    // 默认继承Object的hashCode equals toString方法



    public static void main(String[] args){



        Worker worker = new Worker();



        // 下面注释的语句出错：保护属性不能用



        // worker.getData();



        Worker dc1 = new DefaultClass();



        DefaultClass dc2 = new DefaultClass();



        System.out.printf("%x\n", dc1.hashCode()); // 36baf30c



        // 不管怎样，引用对应的类型是不会变的，尽管受到所赋予对象能调用方法的限制



        System.out.println(dc1.equals((DefaultClass)dc1)); // true



        System.out.println(dc1.equals(dc2)); // false



        // toString



        System.out.println(dc1); // knowledge.DefaultClass@36baf30c



        // 向下转型



        System.out.println(((DefaultClass)dc1).getD()); // 0



        // 子类可以使用



        System.out.println(dc2.getData()); // 0



    }



}
```



​    Object*是所有类的超类，也就是所有类都继承*Object*的方法*:equals*，*toString*，*hashCode，clone*。*equals*默认是比较变量的地址(实际编程时所有变量的状态相同，就可以认为两个实例相等)。*equals\*相等时，则\*hashCode*必须相等。*toString*默认返回类名*@*哈希值。clone是protected权限，必须在子类扩大为public权限，这样才能实现对象拷贝。对于数组整体输出，可以使用Arrays.toString()，但是集合类可以直接输出，这两个都要求具体类覆盖其toString()方法。*



```java
public class Object {



    private static native void registerNatives();



    static {



        registerNatives();



    }



    public native int hashCode();



 



    public boolean equals(Object obj) {



        return (this == obj);



    }



    protected native Object clone() throws CloneNotSupportedException;



 



    public final native Class<?> getClass();



 



    public String toString() {



        return getClass().getName() + "@" + Integer.toHexString(hashCode());



    }



}
```



#### 

### 5.2测试覆盖



```java
package knowledge;



 



/



 * Created by gzx on 16-12-29.



 */



public class OverrideDemo {



    public static void main(String[] args){



 



    }



}



 



class Parent1{



    private int data = 1;



    protected Parent2 get(Parent2 c){



        return null;



    }



}



class Child1 extends Parent1{



    private int data = 2; // 还有继承自父类的属性data，这里不可见



    // 将参数类型Parent2改为Child2将不是覆盖，而是重载



    @Override



    public Child2 get(Parent2 d){



        return null;



    }



}



class Parent2{



}



class Child2 extends Parent2{



}
```

#### 

### 5.3 final关键字

​    *final\*修饰的类不能被继承，修饰的方法不能被覆盖。对于全局成员，final必须在定义时初始化，与默认值和static无关。而对于方法中的final，在操作前必须初始化。final修饰的变量只能被赋值一次。final的语义其实就是不可以改变引用的指向，但其指向的对象的状态仍然可以改变。这点与C++的顶层const类似。状态不改变的类称为不可变类。注意两者的区别。*
*



```java
package knowledge;



 



/



 * Created by gzx on 16-12-29.



 */



// final类，不可以继承，所有方法均为final



public final class FinalDemo {



    // 全局final成员必须初始化



    private final static int finalData = 1;



    private int data;



 



    public void setData(final int data){



        // 传值时已经初始化了，不可以再改变data



        // data = 2;



        this.data = data;



    }



    // 不可以覆盖



    public final int getData(){



        return data;



    }



 



    // 方法中的final局部变量



    public static void main(String[] args){



        final int hello;



       // System.out.println(hello); // 只要不操作hello，就可以不用初始化，与局部变量类似



        final FinalDemo finalDemo = new FinalDemo();



        // 只能赋值一次，但可以改变对象的状态



       // finalDemo = new FinalDemo();



        int data = 2;



        finalDemo.setData(data);



        System.out.println(finalDemo.getData()); // 2



    }



 



}
```

#### 

### 5.4类的初始化顺序

​    有几个原则。静态成员和成员属性一开始都有默认值，如0,false,null，这是在定义初始化之前的。静态成员是类级别的，所以在类加载时就已经初始化了，先定义初始化，然后运行静态块，且只初始化一次。数据成员定义时先初始化，然后才是构造函数。父类先于子类。某个实例是子类的实例，必然是父类的实例，这是instanceof的语义。如果子类覆盖了父类的方法，然后在父类的构造函数中调用，这时调用的是子类的覆盖方法，但是方法中有多个父子都有的同名的数据成员，则使用子类的，方法体在哪个类中，就使用哪个类的属性，即使存在隐藏，且与权限无关。

​     初始化的顺序：
​    父类静态数据成员
​    父类静态块
​    静态数据成员
​    静态数据块  // 上述四个在类第一次加载时初始化， 且只初始化一次，构造子类实例会自动加载父类静态
​    父类数据成员定义时初始化
​    父类构造函数 // 如果这时调用了子类的覆盖函数，则由于未初始化，为默认值
​    子类数据成员定义时初始化
​    子类构造函数

```java
package knowledge;



 



/



 * Created by gzx on 16-12-30.



 */



public class InitDemo {



    public static void main(String[] args){



        Parent parent = new Parent();



        System.out.println("------------------------------------------------");



        Parent child = new Child();



        /*



                运行结果：



                parent static block staticData = 2



                parent constructor data = 1 name = parent name



                parent getData name = parent name staticData = 2



                1



                true



                false



                ------------------------------------------------



                child static block staticData = 3



                parent constructor data = 1 name = parent name



                child getData name = null staticData = 3



                0



                true



                true



                child constructor data = 2 name = child name



         */



    }



}



class Parent{



    private int data = 1;



    private String name = "parent name";



    private static int staticData = 2;



    static {



        System.out.println("parent static block staticData = " + staticData);



    }



    public Parent(){



        System.out.println("parent constructor data = " + data + " name = " + name);



        System.out.println(getData()); // 子类引用时，调用的是子类的方法



        System.out.println(this instanceof Parent);



        System.out.println(this instanceof Child);



    }



    public int getData(){



        System.out.println("parent getData name = " + name + " staticData = " + staticData);



        return data;



    }



}



class Child extends Parent{



    private int data = 2;



    private String name = "child name";



    private static int staticData = 3;



    static {



        System.out.println("child static block staticData = " + staticData);



    }



    public Child(){



        System.out.println("child constructor data = " + data + " name = " + name);



    }



    public int getData(){



        System.out.println("child getData name = " + name + " staticData = " + staticData);



        return data;



    }



}
```

### 

### 5.5 命令行编译和运行

​    javac 中的-d选项用于指定生成的类放在哪个文件夹下，并在该文件夹下生成包目录。如果不指定，则class文件与java源码文件在同一个目录，不会生成包目录。javac和java都有-cp选项。这个选项用于指定class字节码文件的目录（这个目录下有完整的类包目录），或者指定对应的jar库（必须指定到具体的jar，不能只指定到jar所在的目录）。当然，这个选项可以通过设置一个环境变量CLASSPATH替代，对于Linux，分隔符为:。有一个区别，javac会自动查找当前目录，而java则只认定指定的cp选项，没有设置当前目录(.)，则可能会出错。-cp使得在任何目录下都可以运行java程序。javac编译的文件以.java为后缀。java 运行的类必须给出是全名，且有正确的main函数，类是public。

新建两个类：

/home/gzx/test/src/a/A.java



```java
package a;



import b.B;



public class A{



	public static void main(String[] args){



		new B().print();



	}



}
```

/home/gzx/test/src/b/B.java : 这个类用到了 [guava-17.0.jar](http://central.maven.org/maven2/com/google/guava/guava/17.0/guava-17.0.jar)里面的类

```java
package b;



import com.google.common.base.Joiner;



public class B{



	public void print(){



		StringBuilder stringBuilder = new StringBuilder("hello");



        	// 字符串连接器，以|为分隔符，同时去掉null元素



        	Joiner joiner1 = Joiner.on("|").skipNulls();



        	// 构成一个字符串foo|bar|baz并添加到stringBuilder



        	stringBuilder = joiner1.appendTo(stringBuilder, "foo", "bar", null, "baz");



        	System.out.println(stringBuilder);



	}



}
```



同时在test目录下新建bin和lib文件夹，将jar包放到lib中，最终test目录结构如下：

![img](https://img-blog.csdn.net/20161230143435180?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvYWNfZGFvX2Rp/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center)

#### 5.5.1 逐个文件编译

​    由于类A用到了类B(import)，存在依赖关系。这里先生成类B：



```crystal
javac -d bin -cp lib/guava-17.0.jar src/b/B.java
```

再编译类A：



```groovy
javac -d bin  -cp bin src/a/A.java
```

结果如下：

![img](https://img-blog.csdn.net/20161230143744119?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvYWNfZGFvX2Rp/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center)

在bin目录下生成了完整的类目录结构

运行命令：



```crystal
java -cp bin:lib/guava-17.0.jar a.A
```

结果：

![img](https://img-blog.csdn.net/20161230143837901?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvYWNfZGFvX2Rp/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center)

##### 5.5.2 多个依赖文件同时编译

​    也可以同时编译有依赖关系的类

```crystal
javac -d bin -cp lib/guava-17.0.jar src/a/A.java src/b/B.java
```

运行：

```crystal
java -cp bin:lib/guava-17.0.jar a.A
```

##### 5.5.3 将jar移动到自动查找的路径

​    由于javac和java命令会自动查找jre/lib/ext下的jar包，因而把guava-17.0.jar移动到jre/lib/ext下，则不需要引用这个jar包。不推荐这种方法。

![img](https://img-blog.csdn.net/20161230144055683?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvYWNfZGFvX2Rp/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center)

## 

## 六、抽象类和接口

​    *抽象类，主要是类中有实现不了的抽象方法，加*abstract*，不用写出方法体。或者所有方法都实现了，还可以添加*abstract*关键字，形成抽象类，希望被扩展。接口有*public接口和default*接口，成员属性默认全部是*public final static\*，方法全部是\*public*。接口主要是使得实现类符合某一规范，如要进行排序，则必须实现*Comparable*接口，或者提供*Comparator*比较器。有些接口没有任何内容，称为标记接口。*接口之间可以存在继承关系，用\*extends\*，表示扩展一个接口。\*不实现抽象方法或者接口的方法，则还是抽象类。抽象类不可以实例化，但可以用匿名类实例化。*



```java
public interface Comparable<T> {



    public int compareTo(T o);



}



public interface Comparator<T> {



    int compare(T o1, T o2);



}
```



​    *上面是两个常用的易混淆的接口。通常第一个是在类实现时实现的，作为类的默认排序方式。但由于一个类可能有多种排序标准，故可以在排序时提供比较器。两个接口待实现的方法原型也不一样。第一个有*To*，加上this，仅仅需要一个参数，第二个要两个参数。*Comparator*的实现者通常又称为函数对象，因为里面只有函数，没有任何成员属性。*



```java
public interface Cloneable {



}
```



​    *要实现对象的拷贝，则必须实现*Clonable*接口，这是个标记接口，不然调用clone时会抛出异常。同时我们需要覆盖*Object\*类的\*clone()\*方法，且由于该方法是\*protected\*，我们必须将其权限扩大为\*public*，这样才能在其他包下使用。在覆盖方法中直接调用*super.clone()*就可以了，这种拷贝默认是浅拷贝，即直接复制所有成员。如果是不可变类或者成员属性都是原始类型则没事，但如果有引用类型的成员属性，则需要对这些引用类型分别调用其*clone()*方法，实现深度拷贝，从而得到两个独立的副本。*



```java
package knowledge;



 



/



 * Created by gzx on 16-12-27.



 */



// 必须实现cloneable标记接口，否则clone时会抛出异常



public class CloneDemo implements Cloneable{



    private int data;



    private int next;



    public CloneDemo(){



        data = 1;



        next = 2;



    }



 



    void setData(int data){



        this.data = data;



    }



    void setNext(int next){



        this.next = next;



    }



    @Override



    public String toString(){



        return "data = " + data + " next = " + next;



    }



 



    // 重载Object的方法，权限扩大为public，并调用父类的clone方法，如果有引用，则要一一clone



    @Override



    public Object clone() throws CloneNotSupportedException{



        return super.clone();



    }



 



    public static void main(String[] args){



        CloneDemo cloneDemo = new CloneDemo();



        CloneDemo cloneDemo2 = null;



        try {



            cloneDemo2 = (CloneDemo)cloneDemo.clone();



        } catch (CloneNotSupportedException e) {



            e.printStackTrace();



        }



        System.out.println(cloneDemo == cloneDemo2); // false



        cloneDemo2.setData(2);



        System.out.println(cloneDemo); // data = 1 next = 2



        System.out.println(cloneDemo2); // data = 2 next = 2



    }



}
```

## 

##  

```java
import java.io.*;



import java.util.HashMap;



import java.util.Map;



 



/



 * Created by jessin on 17-2-26.



 */



abstract class AbstractLineProcessor {



    protected abstract void processLine(String line);



    public abstract int getAns();



    public void processFile(String filename){



        BufferedReader bf = null;



        try {



             bf = new BufferedReader(new FileReader(filename));



            String line = null;



            while((line = bf.readLine()) != null){



                processLine(line);



            }



        } catch (IOException e) {



            e.printStackTrace();



        }



        finally{



            if(bf != null){



                try {



                    bf.close();



                } catch (IOException e) {



                    e.printStackTrace();



                }



            }



        }



    }



}



class NumberLineProcessor extends AbstractLineProcessor{



    private int ans;



    protected void processLine(String line) {



        for(char aChar : line.toCharArray()){



            if(Character.isDigit(aChar)){



                ans++;



            }



        }



    }



 



    public int getAns() {



        return ans;



    }



}



 



class LetterLineProcessor extends AbstractLineProcessor{



    private int ans;



    protected void processLine(String line) {



        for(char aChar : line.toCharArray()){



            if(aChar >= 'a' && aChar <= 'z' || aChar >= 'A' && aChar <= 'Z'){



                ans++;



            }



        }



    }



 



    public int getAns() {



        return ans;



    }



}



public class Main{



    public static void main(String[] args){



        final Map<String, AbstractLineProcessor> map = new HashMap<String, AbstractLineProcessor>();



        map.put("number", new NumberLineProcessor());



        map.put("letter", new LetterLineProcessor());



 



        // 匿名内部类，实现对一行进行所有的行处理，最后得到结果



        AbstractLineProcessor all = new AbstractLineProcessor(){



 



            protected void processLine(String line) {



                for(AbstractLineProcessor lineProcessor : map.values()){



                    lineProcessor.processLine(line);



                }



            }



 



            public int getAns() {



                return 0;



            }



        };



        all.processFile("hello.txt");



        for(AbstractLineProcessor lineProcessor : map.values()){



            System.out.println(lineProcessor.getAns());



        }



    }



}
```

## 七、内部类

​    *除了静态内部类以外，内部类可以访问外部类的成员属性，与其权限无关。这也是编译器的杰作。编译器会把外部类作为内部类的构造函数的一个参数，并在内部类的实例化处传递外部类的*this*，这样内部类内部会有这个*this*的*final*成员属性。*

### 

### 7.1全局内部类

​    *全局内部类编译后得到一个叫做外部类名*$*内部类名的文件。*



```java
package knowledge;



 



import java.awt.event.ActionEvent;



import java.awt.event.ActionListener;



import java.util.Date;



import javax.swing.Timer;



 



/



 * Created by gzx on 16-12-27.



 */



public class TalkingClock {



    private int interval;



    private boolean beep;



    public TalkingClock(int interval, boolean beep){



        this.interval = interval;



        this.beep = beep;



    }



    public void start(){



        ActionListener printer = new TimePrinter();



        Timer timer = new Timer(interval, printer);



        timer.start();



    }



    



    public class TimePrinter implements ActionListener {



        // 内部类可以直接使用外部类的属性beep



        @Override



        public void actionPerformed(ActionEvent e) {



            // 这里其实是TalkingClock.this.beep



            if(!beep){



                return;



            }



            // this 出现在这里，则是TimePrinter的实例



            Date now = new Date();



            System.out.println("time : " + now);



        }



    }



 



    /*



        每隔一秒，打印出日期，无限循环



        time : Thu Dec 29 14:36:35 CST 2016



        time : Thu Dec 29 14:36:36 CST 2016



        time : Thu Dec 29 14:36:37 CST 2016



     */



    public static void main(String[] args){



        new TalkingClock(1000, true).start();



        while(true){



        }



    }



}
```



### 

### 7.2局部内部类

​     *局部内部类定义在方法中，包含匿名内部类。这里有一个约束，也就是方法中的局部变量被局部内部类访问时，一般要用*final*修饰，因为方法结束后局部变量也被释放掉了，内部类中会有该属性。如果不用*final*修饰，则方法体中不能出现任何改变变量的方法，否则编译出错。*



```java
package knowledge;



 



import javax.swing.*;



import java.awt.event.ActionEvent;



import java.awt.event.ActionListener;



import java.util.Date;



 



/



 * Created by gzx on 16-12-27.



 */



public class TalkingClock2 {



    // 局部类不能改变beep



    public void start(int interval, boolean beep){



        Timer timer = null;



        // 类必须放在前面，否则下面语句会提示找不到类



        class TimerPrinter implements ActionListener {



            @Override



            public void actionPerformed(ActionEvent e) {



                if(!beep){



                    return;



                }



                // 出错



                // beep = false;



                System.out.println("time : " + new Date());



            }



        }



        // 出错



        //beep = true;



        timer = new Timer(interval, new TimerPrinter());



        timer.start();



    }



 



    public static void main(String[] args){



        new TalkingClock2().start(1000, true);



        while(true){}



    }



}
```

### 

### 7.3匿名内部类

​    *匿名内部类，没有类名，不能有构造函数，且必须将实参在实现时给出，只能有一个实例，类似*Lambda*表达式，闭包。*



```java
package knowledge;



 



import javax.swing.*;



import java.awt.event.ActionEvent;



import java.awt.event.ActionListener;



import java.util.Date;



import java.util.HashSet;



import java.util.Hashtable;



import java.util.TreeSet;



 



/



 * Created by gzx on 16-12-27.



 */



public class TalkingClock3 {



    public void start(int interval, boolean beep){



        Timer timer = null;



        // 匿名内部类，这里不需要出现类名，同时不能有构造函数。对于接口，用默认的无参构造函数。对于抽象类，可以是带实参的构造函数，且在()里面提供



        // 出错



        //beep = true;



        timer = new Timer(interval, new  ActionListener(){



                                    @Override



                                    public void actionPerformed(ActionEvent e) {



                                        if(!beep){



                                            return;



                                        }



                                        // 出错



                                        // beep = false;



                                        System.out.println("time : " + new Date());



                                    }



                                }



        );



        timer.start();



    }



    public static void main(String[] args){



        new TalkingClock3().start(1000, true);



        while(true){}



    }



}
```

### 

### 7.4静态内部类

​     *静态内部类，没有外部类实例的*this*，不能访问任何外部类非静态成员或方法。静态内部类的好处是可以避免与其他类命名冲突。*



```java
package knowledge;



 



/



 * Created by gzx on 16-12-27.



 */



public class StaticClassDemo {



    public static Pair minmax(double[] data){



        double min = Double.MAX_VALUE;



        double max = Double.MIN_VALUE;



        for(double tmp : data){



            if(min > tmp){



                min = tmp;



            }



            else if(max < tmp){



                max = tmp;



            }



        }



        return new Pair(min, max);



    }



    



    // 静态内部类不能访问实例属性，没有外部类实例的this



    public static class Pair{



        private double min, max;



        public Pair(double min, double max){



            this.min = min;



            this.max = max;



        }



        public double getMin() {



            return min;



        }



        public double getMax() {



            return max;



        }



    }



    



    public static void main(String[] args){



        double[] data = {10, 1324.12, 2134.11, -132.32};



        StaticClassDemo.Pair pair = StaticClassDemo.minmax(data);



        System.out.println(pair.getMin());



        System.out.println(pair.getMax());



    }



}
```

## 

## 八、异常体系

​    *所有异常都是*Throwable(不是接口，也不是抽象类，是普通类，可以直接使用)*的子类，有两个派系：*Error*和*Exception*。*Exception*可以分为*RuntimeException*和*IOException*。*Error*一般是系统级别的错误，这种错误是我们无法解决的，而*RuntimeException*是程序的逻辑错误，一般是可以解决的，例如数组越界，空指针，错误类型转换等，这类错误我们无需显式处理。*RuntimeException\*和\*Error\*称为未检查异常，而其他异常称为检查异常。*

​    *可以使用*throw new Exception(message)*抛出异常。当一个方法抛出检查异常时，如果当前方法可以解决，用*try-catch-finally\*捕获。否则使用\*throws*向其他调用者继续抛出。未检查异常可以不用做任何处理，直接抛出。*



```java
package knowledge;



 



/



 * Created by gzx on 16-12-29.



 */



public class ExceptionDemo {



    // 运行时异常（继承RuntimeException）不用处理



    public static void main(String[] args){



        throw new NullPointerException("just test"); // 直接抛出异常



    }



}
```

## 

## 九、泛型

​    *泛型类似*C++*中的模板。但是*Java*中的泛型是在编译器层面实现的，在虚拟机中不管具体的参数如何，都只有一个对应的类，参数会被擦掉，变成*Object*。泛型分为泛型类和泛型方法。泛型类在类名后加*<T>*，而对于泛型方法则在返回类型前加*<T>*。*

*泛型类：*



```java
package knowledge;



 



/



 * Created by gzx on 16-12-27.



 */



// 泛型类



public class GenericDemo<T> {



    private T first;



    private T second;



 



    public T getFirst() {



        return first;



    }



 



    public void setFirst(T first) {



        this.first = first;



    }



 



    public T getSecond() {



        return second;



    }



 



    @Override



    public String toString() {



        return "GenericDemo{" +



                "first=" + first +



                ", second=" + second +



                '}';



    }



 



    public void setSecond(T second) {



        this.second = second;



    }



 



    public static void main(String[] args){



        GenericDemo<Integer> pair = new GenericDemo<Integer>(); // 后面尖括号的类型可以去掉，类型自动推导



        pair.setFirst(100);



        pair.setSecond(100);



        System.out.println(pair); // GenericDemo{first=100, second=100}



    }



}
```

泛型方法：

```java
package knowledge;



 



/



 * Created by gzx on 16-12-27.



 */



public class MethodDemo {



    public <T> T getData(T data){



        return data;



    }



    public static void main(String[] args){



        // 自动推导类型



        System.out.println(new MethodDemo().getData(10)); // 10



    }



}
```



? extends classA*表示*classA*或*classA*的子类*

? super classA*表示*classA*或*classA*的父类*

*对于某些函数，对于泛型参数有一些约束，如*

public static<T extends Comparable<? super T> > T min(T[] data)

*表示*T*必须实现*Comparable<K>*接口，且*K*是*T*的父类。也就是父类*K implements Comparable<K>*，然后*T extends K*，从而T extends* Comparable<K>

*而且对于有关系的子类*subclass*和父类*superclass*，*ArrayList<subclass>\*和\*ArrayList<superclass>*没有任何关系，不能赋值。但是*List<subclass>= ArrayList<subclass>\*是成立的。*

## 

## 十、集合框架

​    *集合主要有两大派系：*Collection*和*Map*。其中*Collection*包含*List*、*Queue*、*Set*。*List*包含*ArrayList*和*LinkedList*，有序集合。*Queue*包含*PriorityQueue*，有序集合。*Set*包含*HashSet*和*TreeSet*，无序集合。*Collection*实现了*Iterable*接口。用*add/get(index)*添加元素，用*set(index,value)*设置元素，用*remove*删除元素。而*Map*包含*HashMap*和*TreeMap*。集合体系提供了接口和抽象类，抽象类主要给类库扩展者使用，而接口提供给用户使用。遍历*Collection可以用iterator*方法，返回*Iterator*接口的实例，或者for each。而*Map*使用*put*和*get*添加获取值，一般使用*keySet*和*entrySet*方法遍历，进而获得*key-value*。*

​    LinkedList*用链表实现的。*ArrayList*用动态数组实现的，当达到一定程度时，会重新分配新的数组，并拷贝旧的数组值。*HashSet/HashMap*使用拉链法实现，底层是数组头加链表实现，使用*hashCode*映射到对应的数组（应当尽量减少碰撞，减少链表的长度）。*TreeSet/TreeMap*使用红黑树实现，是一种高效的排序树状结构。*PriorityQueue*使用堆实现，默认是小根堆。如果不要求有序则使用*Hash*更加高效。哈希要注意对象的*hashCode*和*equals*方法，而排序要注意实现*Comparable*接口，或者提供Comparator比较器。*

​    *所有的集合类都直接保存引用，无论从集合处（内部）还是从数组处（外部）改变集合中对象的状态都将引起变化，因为引用是一样的，其结果对于集合的语义而言是不可预知的。所以不要改变集合中对象的状态，尽量用匿名构造，这样就不会有问题。但可以整体替换对象，把对象看成一个原子。*

​    *Collections提供了一些算法和集合的常用操作：*

​    *Collections.sort(list)：主要对List类型进行排序，可以指定比较器*

​    *Collections.binarySearch(list, key, comparrator)：二分查找元素*

​    *Collections.copy(list to, list from) : 复制列表*

​    *Collections.min(colleciton, comparator)*

Collections.max(colleciton, comparator)

​    *除此之外，还有早期的位于上述架构之外的集合，如*Vector*，*HashTable*，*Properties*，*Stack*等集合。*Vector\*和\*HashTable都*进行了同步。如果是单线程，用*ArrayList*等会更高效。*



```java
public interface Collection<E> extends Iterable<E> {



    int size();



    boolean isEmpty();



    boolean contains(Object o);



    Iterator<E> iterator();



    Object[] toArray();



    <T> T[] toArray(T[] a);



    boolean add(E e);



    boolean remove(Object o);



    boolean addAll(Collection<? extends E> c);



    boolean removeAll(Collection<?> c);



    void clear();



}
```



```java
public interface Map<K,V> {



    int size();



    boolean isEmpty();



    boolean containsKey(Object key);



    boolean containsValue(Object value);



    V get(Object key);



    V put(K key, V value);



    V remove(Object key);



    void putAll(Map<? extends K, ? extends V> m);



    void clear();



    Set<K> keySet();



    Collection<V> values();



    Set<Map.Entry<K, V>> entrySet();



}
```



​    *显然*Collection*和*Map*所拥有的方法是不一样的，如*add*对应*put*，*contians*对应*containsKey*和*containsValue*，*iterator*对应*keySet*和*entrySet*。*



```java
package knowledge;



import java.util.*;



 



/



 * Created by gzx on 16-12-28.



 */



public class CollectionDemo {



    public static void main(String[] args){



        /*



            所有集合初始化



         */



        ArrayList<Person> arrayList = new ArrayList<Person>();



        LinkedList<Person> linkedList = new LinkedList<Person>();



        PriorityQueue<Person> pq = new PriorityQueue();



        HashMap<Person, Integer> hashMap = new HashMap<Person, Integer>();



        TreeMap<Person, Integer> treeMap = new TreeMap<Person, Integer>();



        HashSet<Person> hashSet = new HashSet<Person>();



        TreeSet<Person> treeSet = new TreeSet<Person>();



 



        /*



            测试数据



         */



        Person[] persons = {



                new Person("B13080128", "gzx", 23, "2013"),



                new Person("B13080127", "qqy", 23, "2013"),



                new Person("B13080129", "lcq", 24, "2013"),



                new Person("B13080126", "gjj", 23, "2013"),



                new Person("B13080130", "xt", 23, "2013")



        };



        int[] scores = {88, 76, 99, 92, 70};



 



        for(int i = 0; i < persons.length; i++){



            arrayList.add(persons[i]);



            linkedList.add(persons[i]);



 



            // 添加到队尾，满时返回false



            boolean flag = pq.offer(persons[i]);



            if(!flag){



                System.out.println("full");



            }



 



            hashMap.put(persons[i], scores[i]);



            treeMap.put(persons[i], scores[i]);



            hashSet.add(persons[i]);



            treeSet.add(persons[i]);



        }



        /*



         所有的集合类都直接使用引用，从集合处还是从数组处改变集合中对象的状态将引起变化，



         其结果对于集合的语义而言是不可预知的，所以不要改变集合中对象的状态



         可以整体替换对象



          */



       // persons[1].setId("Number0");



 



        /*



            ArrayList



         */



        System.out.println("ArrayList");



        arrayList.remove(0);



        // 数组访问不能越界 抛出IndexOutOfBoundsException



        // System.out.println(arrayList.get(5));



        Iterator<Person> arrayListIterator = arrayList.iterator();



        // 检查当前指针是否有元素，开始时指向第一个元素



        while(arrayListIterator.hasNext()){



            // 输出当前指针指向的元素，并移动到下一个元素



            System.out.println(arrayListIterator.next());



            /*



                  Person{id='B13080127', name='qqy', age=23, grade='2013'}



                  Person{id='B13080129', name='lcq', age=24, grade='2013'}



                  Person{id='B13080126', name='gjj', age=23, grade='2013'}



                  Person{id='B13080130', name='xt', age=23, grade='2013'}



             */



        }



        System.out.println("sort arraylist");



        // collections.sort(list)：专门用来对list进行排序



        Collections.sort(arrayList);



        for(Person p : arrayList){



            System.out.println(p);



            /*



                Person{id='B13080126', name='gjj', age=23, grade='2013'}



                Person{id='B13080127', name='qqy', age=23, grade='2013'}



                Person{id='B13080129', name='lcq', age=24, grade='2013'}



                Person{id='B13080130', name='xt', age=23, grade='2013'}



             */



        }



        /*



            链表 LinkedList：操作对应的iteartor能够起变化



         */



        System.out.println("LinkedList");



        Iterator<Person> linkedListIterator = linkedList.listIterator();



        // 指向第二项



        linkedListIterator.next();



        // 指向第三项



        linkedListIterator.next();



        // 删除当前指针的前一项，即第二项



        linkedListIterator.remove();



        for(Person person : linkedList){



            System.out.println(person);



            /*



                    Person{id='B13080126', name='gjj', age=23, grade='2013'}



                    Person{id='B13080128', name='gzx', age=23, grade='2013'}



                    Person{id='B13080129', name='lcq', age=24, grade='2013'}



                    Person{id='B13080130', name='xt', age=23, grade='2013'}



             */



        }



        // equals



        Person p1 = new Person("B13080133", "xt", 23, "2013");



        System.out.println(linkedList.contains(p1)); // true



        System.out.println("sort linkedlist");



        Collections.sort(linkedList);



        for(Person p : linkedList){



            System.out.println(p);



            /*



                Person{id='B13080126', name='gjj', age=23, grade='2013'}



                Person{id='B13080127', name='qqy', age=23, grade='2013'}



                Person{id='B13080129', name='lcq', age=24, grade='2013'}



                Person{id='B13080130', name='xt', age=23, grade='2013'}



             */



        }



 



        /*



            PriorityQueue : 底层用queue数组实现，contains使用equals比较



         */



        System.out.println("PriorityQueue");



        // 两个方法为空时，都返回null



        // 获得队头元素并删除



        System.out.println(pq.poll()); // Person{id='B13080126', name='gjj', age=23, grade='2013'}



        // 获得队头元素，不删除



        System.out.println(pq.peek()); // Person{id='B13080127', name='qqy', age=23, grade='2013'}



        try {



            Person tmp = (Person)persons[0].clone();



            tmp.setId("setId");



            // 用equals()比较



            // tmp.setAge(13);



            System.out.println(pq.contains(tmp)); // true



            // 按照compare(To)排序，允许有相等的元素



            pq.offer(tmp);



            while(!pq.isEmpty()){



                System.out.println(pq.poll());



                /*



                    Person{id='B13080127', name='qqy', age=23, grade='2013'}



                    Person{id='B13080128', name='gzx', age=23, grade='2013'}



                    Person{id='B13080129', name='lcq', age=24, grade='2013'}



                    Person{id='B13080130', name='xt', age=23, grade='2013'}



                    Person{id='setId', name='gzx', age=23, grade='2013'}



                 */



            }



        } catch (CloneNotSupportedException e) {



            e.printStackTrace();



        }



 



        /*



            HashMap：看hashCode和equals起作用的数据成员，以此来判重



         */



        System.out.println("HashMap");



        try {



            Person tmp = (Person)persons[0].clone();



            tmp.setId("newId");



            // 键不替换，覆盖值，因为哈希值与ID无关



            hashMap.put(tmp, 59);



            Set<Map.Entry<Person, Integer> > keyValue = hashMap.entrySet();



            for(Map.Entry<Person, Integer> it : keyValue){



                System.out.println(it.getKey() + " : " + it.getValue());



                //it.getKey().setAge(1000);



                /*



                    Person{id='B13080128', name='gzx', age=23, grade='2013'} : 59



                    Person{id='B13080127', name='qqy', age=23, grade='2013'} : 76



                    Person{id='B13080130', name='xt', age=23, grade='2013'} : 70



                    Person{id='B13080129', name='lcq', age=24, grade='2013'} : 99



                    Person{id='B13080126', name='gjj', age=23, grade='2013'} : 92



                 */



            }



        } catch (CloneNotSupportedException e) {



            e.printStackTrace();



        }



 



        /*



               TreeMap：看比较器Comparable(Comparator)中的数据成员，以此来去重



         */



        System.out.println("TreeMap");



        try {



            Person tmp = (Person)persons[0].clone();



            tmp.setName("kitty");



            // 键不替换，覆盖，只和ID有关，不管名字是否其变化



            treeMap.put(tmp, 100);



            // 改变已经存在的实例的键，结果不可知，下面注释去掉将出现部分值为null



            // persons[0].setId("AAAA");



            for(Person person : treeMap.keySet()){



                System.out.println(person + " : " + treeMap.get(person));



                /*



                    Person{id='B13080126', name='gjj', age=23, grade='2013'} : 92



                    Person{id='B13080127', name='qqy', age=23, grade='2013'} : 76



                    Person{id='B13080128', name='gzx', age=23, grade='2013'} : 100



                    Person{id='B13080129', name='lcq', age=24, grade='2013'} : 99



                    Person{id='B13080130', name='xt', age=23, grade='2013'} : 70



                 */



            }



        } catch (CloneNotSupportedException e) {



            e.printStackTrace();



        }



 



        /*



            HashSet/TreeSet 有两种遍历方法：for each 和 iterator



            分别与HashMap和TreeMap去重方法类型



         */



        System.out.println("HashSet");



        Iterator<Person> it2 = hashSet.iterator();



        while(it2.hasNext()){



            System.out.println(it2.next());



            /*



                Person{id='B13080128', name='gzx', age=23, grade='2013'}



                Person{id='B13080127', name='qqy', age=23, grade='2013'}



                Person{id='B13080130', name='xt', age=23, grade='2013'}



                Person{id='B13080129', name='lcq', age=24, grade='2013'}



                Person{id='B13080126', name='gjj', age=23, grade='2013'}



             */



        }



 



        try {



            Person tmp = (Person)persons[0].clone();



            tmp.setId("changeId");



            System.out.println(hashSet.contains(tmp)); // true



            hashSet.remove(tmp);



            System.out.println(hashSet.contains(persons[0])); // false



            Iterator<Person> it3 = hashSet.iterator();



            while(it3.hasNext()){



                System.out.println(it3.next());



                /*



                    Person{id='B13080127', name='qqy', age=23, grade='2013'}



                    Person{id='B13080130', name='xt', age=23, grade='2013'}



                    Person{id='B13080129', name='lcq', age=24, grade='2013'}



                    Person{id='B13080126', name='gjj', age=23, grade='2013'}



                 */



            }



        } catch (CloneNotSupportedException e) {



            e.printStackTrace();



        }



 



        /*



            TreeSet



         */



        System.out.println("TreeSet");



        Iterator<Person> it4 = treeSet.iterator();



        for(Person p : treeSet){



            System.out.println(p);



            /*



                Person{id='B13080126', name='gjj', age=23, grade='2013'}



                Person{id='B13080127', name='qqy', age=23, grade='2013'}



                Person{id='B13080128', name='gzx', age=23, grade='2013'}



                Person{id='B13080129', name='lcq', age=24, grade='2013'}



                Person{id='B13080130', name='xt', age=23, grade='2013'}



             */



        }



        try {



            Person tmp = (Person)persons[0].clone();



            tmp.setAge(50);



            // 如果改变ID，则不会被删除掉



           // tmp.setId("newId");



            System.out.println(treeSet.contains(tmp)); // true



            treeSet.remove(tmp);



            System.out.println(treeSet.contains(persons[0])); // false



            Iterator<Person> it5 = treeSet.iterator();



            while(it5.hasNext()){



                System.out.println(it5.next());



                /*



                    Person{id='B13080126', name='gjj', age=23, grade='2013'}



                    Person{id='B13080127', name='qqy', age=23, grade='2013'}



                    Person{id='B13080129', name='lcq', age=24, grade='2013'}



                    Person{id='B13080130', name='xt', age=23, grade='2013'}



                 */



            }



        } catch (CloneNotSupportedException e) {



            e.printStackTrace();



        }



    }



}



class Person implements Comparable<Person>, Cloneable{



    private String id;



    private String name;



    private int age;



    private String grade;



 



    public Person(String id, String name, int age, String grade){



        this.id = id;



        this.name = name;



        this.age = age;



        this.grade = grade;



    }



 



    public String getId() {



        return id;



    }



 



    public void setId(String id) {



        this.id = id;



    }



 



    public String getName() {



        return name;



    }



 



    public void setName(String name) {



        this.name = name;



    }



 



    public int getAge() {



        return age;



    }



 



    public void setAge(int age) {



        this.age = age;



    }



 



    public String getGrade() {



        return grade;



    }



 



    public void setGrade(String grade) {



        this.grade = grade;



    }



 



    @Override



    public Object clone() throws CloneNotSupportedException {



        return super.clone();



    }



 



    // equals 和 hashCode要保持一致



    // 不比较id



    @Override



    public boolean equals(Object o) {



        if(o == null){



            return false;



        }



        if (this == o) return true;



        if (!(o instanceof Person)) return false;



 



        Person person = (Person) o;



        return Objects.equals(name, person.name) && Objects.equals(age, person.age) && Objects.equals(grade, person.grade);



    }



 



    @Override



    public int hashCode() {



        // Object...



        int result = Objects.hash(name, age, grade);



        return result;



    }



 



    // 只比较id



    @Override



    public int compareTo(Person o) {



        return id.compareTo(o.id);



    }



 



    @Override



    public String toString() {



        return "Person{" +



                "id='" + id + '\'' +



                ", name='" + name + '\'' +



                ", age=" + age +



                ", grade='" + grade + '\'' +



                '}';



    }



}
```



​    *从上述例子可以看出，*TreeSet*和*TreeMap*去重的关键是看比较器的compare方法，影响contains或者containsKey的结果。而*HashSet*和*HashMap*去重主要看*equals*方法。其他集合包含某元素看*equals*。实现这些方法时注意选好相关属性。建议查看源码的相关方法。注意*equals为true*时，*hashCode*必须相等。*

## 

## 十一、多线程

​    未完待续。。。



参考文献：

Java核心技术卷I 第九版