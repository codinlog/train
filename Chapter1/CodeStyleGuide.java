/**
 * Copyright
 */
/**
 * 包名统一使用小写，点分隔符之间有且仅有一个自然语义的英语单词。包名统一使用
 * 单数形式，但是类名如果有复数含义，类名可以使用复数形式。
 */
package com.code.style;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.lang.ThreadLocal;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author
 * @date
 * 描述
 */
//!一个java源文件最多包含一个public类，并且这个类必须与源文件名相同
//!java文件不包含public类，这个类就无须于java文件名相同
//!main不一定必须包含在public类中，但是要想运行main方法，无论类标识符如何，类名与文件名都必须相同
//!面向对象的特征？
//!抽象
//!封装
//!继承
//!多态
public class CodeStyleGuide {
    /** 中括号是数组类型的一部分，数组定义如下:String[] args */
    //!String
    //!Integer
    //!Long
    //!...
    //!基本数据类型？
    //!任意大小
    //!BigInteger
    //!BigDecimal
    //!在运算中 BigInteger 类型可以准确地表示任何大小的整数值
    //!BigDecimal 类支持任何精度的浮点数，可以用来精确计算货币值
    public static void main(String[] args) {

    }
}

/***************************************** */
/**
 * 1.命名规约
 */
/*******************************************/

/**
 * 类名使用 UpperCamelCase 风格，必须遵从驼峰形式 ，（领域模型 的相关命名除外:DO / BO / DTO / VO)
 */
// !领域模型(domainmodel):描述业务用例实现的对象模型。它是对业务角色和业务实体之间应该如何联系和协作以执行业务的一种抽象
// ! 1.DO（ Data Object）：与数据库表结构一一对应，通过DAO层向上传输数据源对象
// ! 2.TO（Data Transfer Object）：数据传输对象，Service或Manager向外传输的对象
// ! 3.DAO（Data Access Object）：数据访问对象，对于该数据库表、某个实体的增删改查
// ! 4.BO（Business Object）：业务对象，由Service层输出的封装业务逻辑的对象
// ! 5.AO（ Application Object）：应用对象，在Web层与Service层之间抽象的复用对象模型，极为贴近展示层，复用度不高
// ! 6.VO（View Object）：显示层对象，通常是Web向模板渲染引擎层传输的对象
//! +---------------+        +--------------------+
//! |               |        |                    |
//! |    展示层      |        |    ProfileVO       |
//! |               |        |                    |
//! +---------------+        +----------^---------+
//!                                     |
//!                                     |  转换为视图
//!                                     |
//! +---------------+        +----------+---------+
//! |               |        |                    |
//! |     业务层     |        |    ProfileBO       |
//! |               |        |                    |
//! +---------------+        +----------+---------+
//!                                     |
//!                        BO业务       |
//!                                     +-----------------+
//!                                     |                 |
//! +---------------+        +----------v---------+   +---v-----------------+
//! |               |        |                    |   |                     |
//! | service/core层|        |    ProfileDTO      |   |    StudentDTO       |
//! |               |        |                    |   |                     |
//! +---------------+        +--------------------+   +---+-----------------+
//!                                                       |
//!                                                       |
//!                                                       |
//!                                                       |                +----------------+
//!                                                       |                |                |
//!                                                       |                |    DO:Student  |
//!                        +------------------------------v-+              |                |
//! +---------------+      |                                |              +--------^-------+
//! |               |      |           StudentDAO           |                       |
//! |     DAO层     |      |   query  insert  delete        |                       |
//! |               |      |                                +-----------------------+
//! +---------------+      +-----------------+--------------+        组装
//!                                          |
//!                                          | 访问数据库
//!                                          |
//!                                          |
//! +---------------+              +---------v----------+
//! |               |              |                    |
//! |     DB层      |              |      Student表     |
//! |               |              |                    |
//! +---------------+              +--------------------+

class NameStyleGuide {
    /** 常量命名全部大写，单词间用下划线隔开，力求语义表达完整清楚，不要嫌名字长 */
    private static final int USER_NAME_MAX_LENGTH = 20;
    //!存储位置分配
    //!左值 右值？
    //!位置表达式(左值) => 数据单元的内存
    //!值表达式(右值) => 存储单元地址中的数据
    //!栈：存放基本类型的变量数据和对象的引用，但对象本身不存放在栈中，而是存放在堆（new 出来的对象）或者常量池中（字符串常量对象存放在常量池中)
    //!堆：存放所有new出来的对象
    //!静态域：存放静态成员（static定义的）
    //!常量池：存放字符串常量和基本类型常量（public static final）
    class Memory{
        static final int A = 10;//常量池
        static final String B = "B";//常量池
        //成员变量存储在堆中的对象里面，由垃圾回收器负责回收
        int c =  10;
        //"D" 位于常量池
        // D 引用位于堆
        String D = "D";
        String F = "D";
        //! D == F true
        // "D" 位于常量池
        // new String 位于堆
        // D1 引用位于堆
        //!String D = new String("D");产生几个对象？
        String D1 = new String("D");
        int day;
        int month;
        int year;
        Memory(int d, int m, int y) {
            //d，m，y为局部变量存储在栈中，且它们的类型为基础类型，因此它们的数据也存储在栈中
            //day,month,year为成员变量，它们存储在堆中(new Memory)里面。当BirthDate构造方法执行完之后，d,m,y将从栈中消失。
            day = d;
            month = m;
            year = y;
        }
        //形式参数是局部变量，局部变量的数据存在于栈内存中。栈内存中的局部变量随着方法的消失而消失。
        void method(String s) {
            // 100 为字面量
            // i为局部变量，引用和值存在栈中。当方法change执行完成后，i就会从栈中消失。
            int i = 100;
            int m = 100;
            //!在栈中创建一个变量为a的引用
            //!查找有没有字面值为100的地址
            //!没找到，就开辟一个存放100这个字面值的地址，然后将ai向3的地址。
            //!处理int m = 100；在创建完i的引用变量后，由于在栈中已经有100这个字面值，便将m直接指向100的地址
            //!i与m同时均指向100
        }

        public static void main(String[] args){
            //局部变量，基础类型，引用和值都存在栈中
            int date = 9;
            //m为对象引用，存在栈中，对象(new Memory)存在堆中
            Memory m = new Memory(1,2,3);
        }
    }
    /**
     * 方法名、参数名、成员变量、局部变量都统一使用 lowerCamelCase 风格，必须遵从驼峰形式
     */
    private String userName;

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 代码中的命名均不能以下划线或美元符号开始，也不能以下划线或美元符号结束, 命名严禁使用拼音与英文混合的方式，更不允许直接使用中文的方式
     */
    private String $userName;
    private String userName$;
    private String _userName;
    private String userName_;
    private String 用户名;
    private String yonghuName;
    private String yonghuming;
}

/**
 * Service/DAO 层方法命名规约
 */
interface UserDAO {
    /**
     * 获取单个对象的方法用 get 做前缀
     *
     * @return
     */
    String getId();

    /**
     * 获取多个对象的方法用 list 做前缀
     * 
     * @return
     */
    String[] listIds();

    /**
     * 插入的方法用 save（推荐）或 insert 做前缀
     *
     * @param id
     */
    void saveId(String id);

    /**
     * 修改的方法用 update 做前缀
     * 
     * @param id
     */
    void updateId(String id);
}

/**
 * 领域模型命名规约
 */
/**
 * 数据对象：xxxDO，xxx 即为数据表名
 */
class UserDO {
    // !todo
}

/**
 * 数据传输对象：xxxDTO，xxx 为业务领域相关的名称
 */
class QueryUserDTO {
    // !todo
}

/**
 * POJO 类中布尔类型的变量，都不要加 is,否则部分框架解析会引起序列化错误
 */
// !POJO（Plain Ordinary Java Object）简单的Java对象，实际就是普通JavaBeans,其中有一些属性及其getter
// !setter方法的类,没有业务逻辑，有时可以作为VO(value -object)或dto(Data Transform Object)来使用
class User {
    private boolean man;
    private String name;
    private int age;

    public boolean isMan() {
        return this.man;
    }

}

/**
 * 抽象类命名使用 Abstract 或 Base 开头；异常类命名使用 Exception 结尾；测试类 命名以它要测试的类的名称开始，以 Test 结尾。
 * 杜绝完全不规范的缩写，避免望文不知义。
 */
//!访问修饰
//!public
//!protected
//!default
//!private
abstract class AbstractCodeStyleGuide {
    //!抽象方法不能用private、static、synchronized、native访问修饰符修饰
    abstract void method();
}

//! +---------------------------------------+
//! |            类修饰符                    |
//! +-------------+-------------------------+
//! |   public	  |                         |
//! +---------------------------------------+
//! |  abstract   |   不能被实例化            |
//! +---------------------------------------+
//! |   final     |   不能再声明子类          |
//! +-------------+-------------------------+
//! |  default    |                         |
//! +-------------+-------------------------+
//! |  private    |                         |
//! +-------------+-------------------------+
//! | protected   |                         |
//! +-------------+-------------------------+
//! +----------------------------------------------------+
//! |                构造函数修饰符                        |
//! +--------------+-------------------------------------+
//! |  public	   |         可以从所有的类中访问           |
//! +----------------------------------------------------+
//! | protected    |      只能从自己的类和它的子类中访问     |
//! +----------------------------------------------------+
//! |  private     |          只能在本类中访问             |
//! +--------------+-------------------------------------+
//! +---------------------------------------------------------+
//! |                域/成员变量修饰符                          |
//! +---------------+-----------------------------------------+
//! |   public	    |          可以从所有的类中访问              |
//! +---------------------------------------------------------+
//! |  protected    |         只能从本类和它的子类中访问          |
//! +---------------------------------------------------------+
//! |   private     |            只能从本类中访问它              |
//! +---------------------------------------------------------+
//! |   static 	    |   对该类的所有实例只能有一个域值存在         |
//! +---------------------------------------------------------|
//! |  transient	|       不是一个对象持久状态的一部份          |
//! +---------------------------------------------------------+
//! |  volatile	    |          可以被异步的线程所修改            |
//! +---------------------------------------------------------+
//! |   final       |       必须对它赋予初值并且不能修改它        |
//! +---------------+-----------------------------------------+
//! +-------------------------------------------------------------------------+
//! |                           方法修饰符                                    |
//! |                                                                         |
//! +--------------------------+----------------------------------------------+
//! |       public	           |       可以从所有的类中访问它                    |
//! +-------------------------------------------------------------------------+
//! |      protected           |     只能从本类及其子类中访问它                   |
//! +-------------------------------------------------------------------------+
//! |       Private            |        只能从本类中访问它                       |
//! +-------------------------------------------------------------------------+
//! |       abstract   	       |     没有方法体，属于一个抽象类                   |
//! +-------------------------------------------------------------------------+
//! |        final             |           子类不能覆盖它                       |
//! +-------------------------------------------------------------------------+
//! |       static             |       被绑定于类本身而不是类的实例               |
//! +-------------------------------------------------------------------------|
//! |       native             |         该方法由其他编程语言实现                 |
//! +-------------------------------------------------------------------------|
//! |    asnchronized          |      在一个线程调用它之前必须先给它加             |
//! +--------------------------+----------------------------------------------+
//! +----------------------------------------------------------+
//! |              	 局部变量 修饰符                             |
//! +--------------+-------------------------------------------+
//! |  final	   |          必须对它赋予初值并且不能修改它       |
//! +----------------------------------------------------------+
//! | static       |                                           |
//! +--------------+-------------------------------------------+



class CodeStyleGuideException {
    // !todo
}

class CodeStyleGuideTest {
    // !todo
}

/**
 * 如果使用到了设计模式，建议在类名中体现出具体模式
 */

class UserFactory {
    // !todo
}

class UserProxy {
    // !todo
}

/**
 * 接口类中的方法和属性不要加任何修饰符号，并加上有效的 Javadoc
 * 注释。
 */
//!访问修饰
interface ProxyFactory {
    /**
     * 尽量不要在接口里定义变量，如果一定要定义变量，肯定是与接口方法相关，并且是整个应用的基础常量。
     */
    //!public static final
    String PROXY_NAME = "xxxxxxx";
    //!public
    //!abstract or static or default
    void fn();

    default void hi() {
        System.out.println("Hi");
    }
    //!final
    static void hello(){
        System.out.println("Hello");
    }
    //!实现多个接口，同名default，static函数？
}

/**
 * 对于 Service 和 DAO 类，基于 SOA 的理念，暴露出来的服务一定是接口，内部 的实现类用 Impl 的后缀与接口区别。
 */
interface CacheService {
    //!todo
}

class CacheServiceImpl implements CacheService {
    // !todo
}

/**
 * 如果是形容能力的接口名称，取对应的形容词做接口名（通常是–able 的形式）
 */
//!Comparable
//!Comparator
interface Comparable {
    // !todo
}

interface Translatable {
    // !todo
}

abstract class AbstractTranslator implements Translatable {
    // !todo
}

/**
 * 枚举类名建议带上 Enum 后缀，枚举成员名称需要全大写，单词间用下划线隔开。
 */
enum DealStatusEnum {
    SUCCESS,
    UNKOWN_REASON,
}
//!枚举单例
//!单例模式

class SingletonSample{
    //!非static内部类static方法、变量
    //!内部类分为静态内部类，成员内部类，局部内部类，匿名内部类四种
    static class Singleton{
        private static Singleton sInstance ;
        // 懒汉式，线程不安全
        public static Singleton getInstance1() {
            if(null == sInstance ){
                sInstance = new Singleton();
            }
            return sInstance;
        }
        // 懒汉式，线程安全
        //!synchronized加锁对象？
        public static synchronized Singleton getInstance2() {
            if (null == sInstance) {
                sInstance = new Singleton();
            }
            return sInstance;
        }
        // 饿汉式
        //!在类装载时就实例化
        //!classloader?
        static Singleton sInstance1 = new Singleton();
        // 双检锁/双重校验锁
        //!volatile?
        private volatile static Singleton sInstance2;
        public static synchronized Singleton getInstance3(){
            if (null != sInstance2) {
                synchronized (Singleton.class) {
                    if (null == sInstance2) {
                        sInstance2 = new Singleton();
                    }
                }
            }
            return sInstance2;
        }
        // 枚举
        //!反射?
        public enum SingletonEnum {
            INSTANCE;
            private final Singleton SINGLETON;
            SingletonEnum(){
                SINGLETON = new Singleton();
            }
        }
        // 登记式/静态内部类
        private static class SingletonHolder {
            private static final Singleton INSTANCE = new Singleton();
        }
        //!访问权限？
        public static  Singleton getInstance4() {
            return SingletonHolder.INSTANCE;
        }
    }
}
/***************************************** */
/**
 * 2.常量定义
 */
/***************************************** */
class ConstVariableDefine {
    ConstVariableDefine(String consts){
        /**
         * 不允许出现任何魔法值（即未经定义的常量）直接出现在代码中
         */
        /**
         * 在一个 switch块内，每个 case要么通过 break/return等来终止，要么注释说明程序将继续执行到哪一个 case为止；在一个
         * switch块内，都必须包含一个 default语句并且 放在最后，即使它什么代码也没有。
         */
        switch (consts) {
            case "A": {

            }
            break;
            case "B": {

            }
            break;
            case "C":
            case "D":
            case "E": {

            }
            break;
            default: {

            }
            break;
        }
    }

    /**
     * long或者 Long初始赋值时，必须使用大写的 L，不能是小写的
     */
    private long longNum = 123456L;
    /**
     * 常量功能进行归类，分开维护。如：缓存：CacheConsts下；系统配置：ConfigConsts下。
     * 常量的复用层次有五层：1.跨应用共享常量、2.应用内共享常量、3.子工程内共享常量、4.包 内共享常量、5.类内共享常量。
     *  1） 跨应用共享常量：放置在二方库中，通常是 client.jar中的 constant目录下。
     *  2） 应用内共享常量：放置在一方库的 modules中的constant目录下。
     *  3） 子工程内部共享常量：即在当前子工程的 constant目录下。
     *  4） 包内共享常量：即在当前包下单独的 constant目录下。
     *  5） 类内共享常量：直接在类内部 private static final定义。
     */
    /**
     * 如果变量值仅在一个范围内变化用 Enum类。如果还带有名称之外的延伸属性，必须 使用 Enum类
     */
    public enum WeekEnum {
        MONDAY(1),
        TUESDAY(2),
        WEDNESDAY(3),
        THURSDAY(4),
        FRIDAY(5),
        SATURDAY(6),
        SUNDAY(7);
        private final int value;
        WeekEnum(int value){
            this.value = value;
        }
    }
}
/***************************************** */

/**
 * 3. 格式规约
 */

 class CodeFormatStyle{
    public static void main(String args[]){
        // 缩进 4 个空格
        String say = "hello";
        // 运算符的左右必须有一个空格
        int flag = 0;
        // 关键词 if 与括号之间必须有一个空格，括号内的与左括号，与右括号不需要空格
        if (flag == 0) {
            System.out.println(say);
        }
        if (flag == 1) {
            System.out.println("world");
            // 左大括号前加空格且不换行；左大括号后换行 if (flag == 1) {
            System.out.println("world");
            // 右大括号前换行，右大括号后有 else，不用换行
        } else {
            System.out.println("ok");
            // 在右大括号后直接结束，则必须换行
        }
        /**
         * 单行字符数限制不超过 120 个，超出需要换行，换行时遵循如下原则：
         * 1） 第二行相对第一行缩进 4 个空格，从第三行开始，不再继续缩进，参考示例。
         * 2） 运算符与下文一起换行。
         * 3） 方法调用的点符号与下文一起换行。
         * 4） 在多个参数超长，逗号后进行换行。
         * 5） 在括号前不要换行。
         */
        StringBuffer sb = new StringBuffer();
        //超过 120 个字符的情况下，换行缩进 4 个空格，并且方法前的点符号一起换行
        sb.append("zi")
            .append("xin")
            .append("huang")
            .append("huang")
            .append("huang");
        // 方法参数在定义和传入时，多个参数逗号后边必须加空格。
        method("a", "b", "c");
        // 文件编码设置为 UTF-8; 换行符使用 Unix格式，
        // 没有必要增加若干空格来使某一行的字符与上一行的相应字符对齐。
        int a = 3;
        long b = 4L;
        float c = 5F;
        //!StringBuffer
        //!StringBuilder
        //!String
        StringBuffer sb1 = new StringBuffer();
        // 方法体内的执行语句组、变量的定义语句组、不同的业务逻辑之间或者不同的语义 之间插入一个空行。相同业务逻辑和语义之间不需要插入空行。
    }

    static void method(String a, String b, String c){

    }
 }
/***************************************** */
/**
 * 4. OOP规则
 */
//!类初始化顺序
//!：静态代码块和静态成员变量 > 构造代码块和普通成员变量 > 构造方法。

// class Base {
//     String name = "Hello";
//     Integer id = getId();

//     Integer getId() {
//         return new Random(System.currentTimeMillis()).nextInt(1000);
//     }
// }

// class Derived extends Base {
//     String name = "Hi";

//     @Override
//     Integer getId() {
//         return name.length();
//     }
// }

// /**
//  * @author qr
//  */
// public class Main {

//     public static void main(String[] args) {
//         new Derived();
//     }
// }

 class Oop{
     /**
      * 避免通过一个类的对象引用访问此类的静态变量或静态方法
      */
     public static  String sHello = "Helo";//AOSP
     public static  int MAX_COUNT = 10;

     public static void method(){

     }
     /**
      * 所有的覆写方法，必须加@Override注解。
      */
    @Override
    public String toString() {

    }

    /**
     * 相同参数类型，相同业务含义，才可以使用 Java的可变参数，
     * 避免使用 Object 可变参数必须放置在参数列表的最后。（尽量不用可变参数编程）
     */
    public User getUsers(String type, Integer... ids){

    }

    /**
     * 对外暴露的接口签名，原则上不允许修改方法签名，避免对接口调用方产生影响。接
     * 口过时必须加@Deprecated注解，并清晰地说明采用的新接口或者新服务是什么。
     */
    interface InterfaceSample {
        /**
         * @deprecated why which
         */
        void method1();

        void method2();
    }

    void method2(String decode){
        /**
        * 不能使用过时的类或方法。
        */
        String url =   java.net.URLDecoder.decode(decode);
        /**
         * Object的 equals方法容易抛空指针异常，应使用常量或确定有值的对象来调用 equals。 推荐使用
         * java.util.Objects#equals （JDK7 引入的工具类）
         */
        "test".equals(url);
        /**
         * 所有的相同类型的包装类对象之间值的比较，全部使用 equals方法比较。 对于 Integer var=?在-128 至 127
         * 之间的赋值，Integer对象是在 IntegerCache.cache产生，会复用已有对象，这个区间内的 Integer值可以直接使用==进行
         * 判断，但是这个区间之外的所有数据，都会在堆上产生，并不会复用已有对象，推荐使用 equals方法进行判断。
         */
        Integer i1 = 10;
        Integer i2 = 128;
        i1.equals(i2);
        boolean eq = i1 == i2;
        /**
         * 关于基本数据类型与包装数据类型的使用标准如下：
         * 1） 所有的 POJO类属性必须使用包装数据类型。
         * 2） RPC方法的返回值和参数必须使用包装数据类型。
         * 3） 所有的局部变量【推荐】使用基本数据类型。
         */
        class User {
            private Long id;
            private Integer age;
            private String name;
            /**
             * 定义 DO/DTO/VO等 POJO类时，不要设定任何属性默认值。
             */
            private Date createTime = new Date();
            //getter
            //setter
            /**
             * POJO类必须写 toString方法
             */
            @Override
            public String toString() {

            }
            /**
             * 当一个类有多个构造方法，或者多个同名方法，这些方法应该按顺序放置在一起， 便于阅读。
             */
            /**
             * 类内方法定义顺序依次是：公有方法或保护方法 > 私有方法 > getter/setter 方法。 说明：公有方法
             */
            /**
             * setter方法中，参数名称与类成员变量名称一致
             */
            void setId(Long id){
                this.id = id;
            }
            /**
             * 在 getter/setter方法中，尽量不要增加业务逻辑，增加排查问题的难度
             */
            Long getId(){
                if(null == this.id){
                    return -1L;
                }else{
                    return this.id;
                }
            }
        }
        /**
         * 序列化类新增属性时，请不要修改 serialVersionUID字段，避免反序列失败；
         */
        //!序列化?
        /**
         * final可提高程序响应效率，声明成 final的情况：
         *  1） 不需要重新赋值的变量，包括类属性、局部变量。
         *  2） 对象参数前加final，表示不允许修改引用的指向。
         *  3） 类方法确定不允许被重写。
         */
        /**
         * 类成员与方法访问控制从严：
         *  1） 如果不允许外部直接通过 new来创建对象，那么构造方法必须是 private。
         *  2） 工具类不允许有 public或 default构造方法。
         *  3） 类非 static成员变量并且与子类共享，必须是 protected。
         *  4） 类非static成员变量并且仅在本类使用，必须是 private。
         *  5） 类 static成员变量如果仅在本类使用，必须是 private。
         *  6） 若是static成员变量，必须考虑是否为 final。
         *  7） 类成员方法只供类内部调用，必须是 private。
         *  8） 类成员方法只对继承类公开，那么限制为protected。
         */
        class SerialSample implements Serializable {
            static final long serialVersionUID = 123456789L;
            //Override method
            /**
             * 构造方法里面禁止加入任何业务逻辑，如果有初始化逻辑，请放在 init方法中。
             */
            SerialSample(){
                init();
            }
            void init(){

            }
            /**
             * 循环体内，字符串的联接方式，使用 StringBuilder的 append方法进行扩展
             */
            void method1() {
                StringBuilder sb = new StringBuilder();
                for(;;){
                    sb.append("Hello");
                }
            }
            
            /**
             * 慎用 Object的 clone方法来拷贝对象 对象的 clone方法默认是浅拷贝，若想实现深拷贝需要重写 clone方法实现属性对象的拷贝。
             */
            @Override
            protected Object clone(){
                return this;
            }
        }
    }
}
 /**************************************** */
 /**
  * 5.集合处理
  */

class CollectionSample{
    /**
     * 关于 hashCode和 equals的处理，遵循如下规则：
     *  1） 只要重写 equals，就必须重写 hashCode。
     *  2） 因为Set存储的是不重复的对象，依据 hashCode和 equals进行判断，所以 Set存储的 对象必须重写这两个方法。
     *  3） 如果自定义对象做为Map的键，那么必须重写 hashCode和 equals。
     */
    //!线程安全集合?
    //!转换为线程安全集合?
    private Set<String> stringSet;
    private HashMap<String,String> stringHashMap;

    @Override
    public int hashCode(){
        return super.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    CollectionSample(){
        /**
        * ArrayList的subList结果不可强转成ArrayList
        *在 subList场景中，高度注意对原集合元素个数的修改，会导致子列表的遍历、增 加、删除均产生 ConcurrentModificationException 异常
        */

        List<String> list = new ArrayList<>();
        List<String> sublist = list.subList(1, 2);
        /**
         * 使用集合转数组的方法，必须使用集合的 toArray(T[] array)，传入的是类型完全 一样的数组，大小就是 list.size()。
         *  toArray带参方法，入参分配的数组空间不够大时，toArray方法内部将重新分配 内存空间，并返回新数组地址；
         * 如果数组元素大于实际所需，下标为[ list.size() ]的数组元素将被置为 null，其它数组元素保持原值
         */
        String[] arr= new String[list.size()];
        list.toArray(arr);
        /**
         *  toArray无参方法存在问题，此方法返回值只能是 Object[]
         */
        Object[] objs = list.toArray();
        /**
        * 使用工具类 Arrays.asList()把数组转换成集合时，不能使用其修改集合相关的方法，
        * 它的 add/remove/clear方法会抛出 UnsupportedOperationException异常。
        * asList的返回对象是一个 Arrays内部类，并没有实现集合的修改方法
        */
        List<String> list1 = Arrays.asList(arr);
        /**
        * 不要在 foreach循环里进行元素的 remove/add操作。
        * remove元素请使用 Iterator 方式，如果并发操作，需要对
        * Iterator对象加锁。
        */
        //err
        for(String item : list1){
            list1.remove(item);
        }
        //err
        list1.forEach((i) -> {
            list1.remove(i);
        });
        //err
        for(int i = 0 ; i < list1.size();i++){
            list1.remove(i);
        }
        //right
        for(int i = list1.size()-1;i >=0;i--){
            list1.remove(i);
        }
        Iterator<String> it = list1.iterator();
        //right
        while(it.hasNext()){
            String item = it.next();
            it.remove();
        }
        //err
        while(it.hasNext()){
            String item = it.next();
            list1.remove(item);
        }
        /**
         * 集合初始化时，尽量指定集合初始值大小。
         */
        /**
        * 使用 entrySet遍历 Map类集合 KV，而不是 keySet方式进行遍历。 说明：keySet其实是遍历了 2 次，一次是转为
        * Iterator对象，另一次是从 hashMap中取出 key所对应的 value。而 entrySet只是遍历了一次就把 key和 value都放到了
        * entry中，效 率更高。如果是 JDK8，使用 Map.foreach方法。 values()返回的是 V值集合，是一个
        * list集合对象；keySet()返回的是 K值集合，是 一个 Set集合对象；entrySet()返回的是 K-V值组合集合。
        */
        //┌─────────────────┬────────────┬────────────┬────────────┬─────────────┐
        //│                 │            │            │            │             │
        //│                 │     Key    │  Value     │   Super    │             │
        //├─────────────────┼────────────┼────────────┼────────────┼─────────────┤
        //│                 │            │            │            │             │
        //│    HashTable    │    !null   │   !null    │ Dictionary │  线程安全    │
        //├─────────────────┼────────────┼────────────┼────────────┼─────────────┤
        //│                 │            │            │            │             │
        //│ConcurrentHashMap│    !null   │   !null    │ AbstractMap│  分段锁技术  │
        //├─────────────────┼────────────┼────────────┼────────────┼─────────────┤
        //│                 │            │            │            │             │
        //│    TreeMap      │    !null   │    null    │ AbstractMap│  线程不安全  │
        //├─────────────────┼────────────┼────────────┼────────────┼─────────────┤
        //│                 │            │            │            │             │
        //│    HashMap      │     null   │    null    │ AbstractMap│  线程不安全  │
        //└─────────────────┴────────────┴────────────┴────────────┴─────────────┘
        /**
         * 创建线程或线程池时请指定有意义的线程名称，方便出错时回溯
         */
        //!线程的几种创建方式
        Thread thread = new Thread();
        thread.setName("name");
        /**
         * 线程池不允许使用 Executors去创建
         */
        Executors.newFixedThreadPool(12);
        Executors.newScheduledThreadPool(12);
        Executors.newCachedThreadPool();
        Executors.newSingleThreadScheduledExecutor();
        /**
         * 线程资源必须通过线程池提供，不允许在应用中自行显式创建线程。
         * ThreadPoolExecutor
         * -> newFixedThreadPool
         * -> newScheduledThreadPool
         * -> newCachedThreadPool
         * -> newSingleThreadScheduledExecutor
         */
    }
    
    /**
     * SimpleDateFormat 是线程不安全的类， 一般不要定义为 static变量，如果定义为 static，必须加锁，或者使用
     * DateUtils工具类
     */
    /**
     * JDK8 的应用，可以使用 Instant代替 Date，LocalDateTime代替 Calendar，
     * DateTimeFormatter代替Simpledateformatter
     */
    // !ThreadLocal?
    private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };
    /**
     * 高并发时，同步调用应该去考量锁的性能损耗
     */
    //!Java 锁?
    /**
     * 使用 CountDownLatch进行异步转同步操作，每个线程退出前必须调用 countDown 方法，线程执行代码注意 catch异常，确保
     * countDown方法可以执行，避免主线程无法执行 至 countDown方法，直到超时才返回结果。
     */
    //!CountDownLatch?
    /**
     * 避免 Random实例被多线程使用，虽然共享该实例是线程安全的，但会因竞争同一 seed 导致的性能下降。
     */
    //!ThreadLocalRandom
    /**
     * volatile解决多线程内存不可见问题。对于一写多读，是可以解决变量同步问题，
     */
    //!AtomicInteger
    //!AtomicLong
    //!LongAdder => 比AtomicLong性能更好（减少乐观锁的重试次数）
}
/**************************************** */
/**
* 6.异常
*/

/**
* 不要捕获 Java 类库中定义的继承自 RuntimeException 的运行时异常类，如： IndexOutOfBoundsException、
* NullPointerException，这类异常由程序员预检查 来规避，保证程序健壮性。
*/
/**
* 异常不要用来做流程控制，条件控制，因为异常的处理效率比条件分支低。
*/
/**
* 对大段代码进行 try-catch，这是不负责任的表现。catch时请分清稳定代码和非稳 定代码，稳定代码指的是无论如何不会出错的代码。对于非稳定代码的
* catch尽可能进行区分 异常类型，再做对应的异常处理。
*/
/**
* 捕获异常是为了处理它，不要捕获了却什么都不处理而抛弃之，如果不想处理它，请
* 将该异常抛给它的调用者。最外层的业务使用者，必须处理异常，将其转化为用户可以理解的 内容。
*/
/**
* 不能在 finally块中使用 return，finally块中的 return返回后方法结束执行，不会再执行 try块中的 return语句。
*/
/**
* finally块必须对资源对象、流对象进行关闭，有异常也要做 try-catch。 说明：如果 JDK7，可以使用
* try-with-resources方式。
*/
/**
* 捕获异常与抛异常，必须是完全匹配，或者捕获异常是抛异常的父类。
*/
/**
* 方法的返回值可以为 null，不强制返回空集合，或者空对象等，必须添加注释充分 说明什么情况下会返回 null值。调用方需要进行 null判断防止
* NPE问题
*/
class ExceptionSample{

    void method() {
        try (InputStream in = new FileInputStream("a.txt")) {

        } catch (IOException e) {

        } finally {

        }
    }
}
//!异常类型

/**************************************** */
/**
* 注释
*/
/**
* 类、类属性、类方法的注释必须使用 Javadoc规范，使用/**内容*/，
* 不得使用 //xxx方式。
*/
/**
* 所有的抽象方法（包括接口中的方法）必须要用 Javadoc 注释、除了返回值、参数、 异常说明外，还必须指出该方法做什么事情，实现什么功能。
*/
/**
* 所有的类都必须添加创建者信息。
*/
/**
* 所有的枚举类型字段必须要有注释，说明每个数据项的用途。
*/
/**
* 注释把问题说清楚。专有名词与关键字保持英文原文即可。
* TCP
*/
/**
 * 代码修改的同时，注释也要进行相应的修改，尤其是参数、返回值、异常、核心逻辑 等的修改。
 */

 /**
  *支持 3 种注释，分别是单行注释、多行注释和文档注释。文档注释以\/**开头，并以*\/
  *结束，可以通过 Javadoc生成 API 帮助文档，Java 帮助文档主要用来说明类、成员变量和方法的功能。
  */
  /**
   * @author 标识一个类的作者，一般用于类注释 @author description
   * @deprecated 指名一个过期的类或成员，表明该类或方法不建议使用 @deprecated description
   * {@docRoot} 指明当前文档根目录的路径 Directory Path
   * @exception 可能抛出异常的说明，一般用于方法注释 @exception exception-name explanation
   * {@inheritDoc} 从直接父类继承的注释
   * {@link} 插入一个到另一个主题的链接 {@link name text}
   * {@linkplain} 插入一个到另一个主题的链接，但是该链接显示纯文本字体
   * @param 说明一个方法的参数，一般用于方法注释 @param parameter-name explanation
   * @return 说明返回值类型，一般用于方法注释，不能出现再构造方法中 @return explanation
   * @see 指定一个到另一个主题的链接 @see anchor
   * @serial 说明一个序列化属性 @serial description
   * @serialData 说明通过 writeObject() 和 writeExternal() 方法写的数据 @serialData description
   * @serialField 说明一个 ObjectStreamField 组件 @serialField name type description
   * @since 说明从哪个版本起开始有了这个函数 @since release
   * @throws 和 @exception 标签一样.
   * {@value} 显示常量的值，该常量必须是 static 属性。
   * @version 指定类的版本，一般用于类注释
   */
/************************************** */