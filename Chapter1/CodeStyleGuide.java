/**
 * Copyright
 */
/**
 * 包名统一使用小写，点分隔符之间有且仅有一个自然语义的英语单词。包名统一使用
 * 单数形式，但是类名如果有复数含义，类名可以使用复数形式。
 */
package com.code.style;

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

// ! 是否应在接口加上前缀I?
interface IProxyFactory {
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
    SUCCESS, UNKOWN_REASON
}
/***************************************** */
/**
 * 2.常量定义
 */
/***************************************** */
/**
 * 不允许出现任何魔法值（即未经定义的常量）直接出现在代码中
 */

 
/***************************************** */