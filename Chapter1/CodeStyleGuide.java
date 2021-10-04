/**
 * Copyright
 */
/**
 * 包名统一使用小写，点分隔符之间有且仅有一个自然语义的英语单词。包名统一使用
 * 单数形式，但是类名如果有复数含义，类名可以使用复数形式。
 */
package com.code.style;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import com.code.util.Utils;

/**
 * @author
 * @date
 */
// !一个java源文件最多包含一个public类，并且这个类必须与源文件名相同
// !java文件不包含public类，这个类就无须于java文件名相同
// !main不一定必须包含在public类中，但是要想运行main方法，无论类标识符如何，类名与文件名都必须相同
public class CodeStyleGuide {
    /** 中括号是数组类型的一部分，数组定义如下:String[] args */
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
// +---------------+        +--------------------+
// |               |        |                    |
// |    展示层      |        |    ProfileVO       |
// |               |        |                    |
// +---------------+        +----------^---------+
//                                     |
//                                     |  转换为视图
//                                     |
// +---------------+        +----------+---------+
// |               |        |                    |
// |     业务层     |        |    ProfileBO       |
// |               |        |                    |
// +---------------+        +----------+---------+
//                                     |
//                        BO业务       |
//                                     +-----------------+
//                                     |                 |
// +---------------+        +----------v---------+   +---v-----------------+
// |               |        |                    |   |                     |
// | service/core层|        |    ProfileDTO      |   |    StudentDTO       |
// |               |        |                    |   |                     |
// +---------------+        +--------------------+   +---+-----------------+
//                                                       |
//                                                       |
//                                                       |
//                                                       |                +----------------+
//                                                       |                |                |
//                                                       |                |    DO:Student  |
//                        +------------------------------v-+              |                |
// +---------------+      |                                |              +--------^-------+
// |               |      |           StudentDAO           |                       |
// |     DAO层     |      |   query  insert  delete        |                       |
// |               |      |                                +-----------------------+
// +---------------+      +-----------------+--------------+        组装
//                                          |
//                                          | 访问数据库
//                                          |
//                                          |
// +---------------+              +---------v----------+
// |               |              |                    |
// |     DB层      |              |      Student表     |
// |               |              |                    |
// +---------------+              +--------------------+

class NameStyleGuide {
    /** 常量命名全部大写，单词间用下划线隔开，力求语义表达完整清楚，不要嫌名字长 */
    private static final int USER_NAME_MAX_LENGTH = 20;
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
interface UserDao {
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

}

/**
 * 数据传输对象：xxxDTO，xxx 为业务领域相关的名称
 */
class QueryUserDto {

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

abstract class AbstractCodeStyleGuide {

}

class CodeStyleGuideException {

}

class CodeStyleGuideTest {

}

/**
 * 如果使用到了设计模式，建议在类名中体现出具体模式
 */

class UserFactory {

}

class UserProxy {

}

/**
 * 接口类中的方法和属性不要加任何修饰符号（public 也不要加），保持代码的简洁 性，并加上有效的 Javadoc
 * 注释。尽量不要在接口里定义变量，如果一定要定义变量，肯定是 与接口方法相关，并且是整个应用的基础常量。
 */

interface ProxyFactory {
    static final String PROXY_NAME = "xxxxxxx";

    void fn();

    default void hi() {
        System.out.println("Hi");
    }
}

/**
 * 对于 Service 和 DAO 类，基于 SOA 的理念，暴露出来的服务一定是接口，内部 的实现类用 Impl 的后缀与接口区别。
 */
interface CacheService {
}

class CacheServiceImpl implements CacheService {
}

/**
 * 如果是形容能力的接口名称，取对应的形容词做接口名（通常是–able 的形式）
 */

interface Comparable {

}

interface Translatable {

}

abstract class AbstractTranslator implements Translatable {

}

/**
 * 枚举类名建议带上 Enum 后缀，枚举成员名称需要全大写，单词间用下划线隔开。
 */
enum DealStatusEnum {
    SUCCESS,
    UNKOWN_REASON,
}
/***************************************** */
/**
 * 2.常量定义
 */
/***************************************** */
/**
 * 不允许出现任何魔法值（即未经定义的常量）直接出现在代码中
 */

class ConstVariableDefine {
    ConstVariableDefine(String consts){
        switch (consts) {
            case "A": {

            }
            break;
            case "B": {

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
        SUNDAY(7)
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
        // 关键词 if 与括号之间必须有一个空格，括号内的 f 与左括号，0 与右括号不需要空格
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

    /**
     * 不能使用过时的类或方法。
     */

     void method2(String decode){
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
        bool eq = i1 == i2;
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
                    return -1;
                }else{
                    return this.id;
                }
            }
        }
        /**
         * 序列化类新增属性时，请不要修改 serialVersionUID字段，避免反序列失败；
         */
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
    }

}
 /**************************************** */