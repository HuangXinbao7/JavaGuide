package com.atguigu.javase.inheritance;

/**
 * 继承 : 从现有类创建子类, 现有类称为父类(体现顺序), 基类(子类以父类为基础), 超类(在子类中使用super来标识父类).
 * 子类一旦继承父类, 就会继承父类的所有成员(构造器除外). 进而可以简化子类的写法, 并且让类和类之间关系更紧密.
 * Java中只支持单继承 : 一个子类只能有一个直接父类
 * java中是支持多层继承 : 一个子类可以有多个间接父类.
 *
 * 子类可以继承父类的私有成员. 但是只是有所有权, 没有直接使用权.
 * 在父类中提供公共的get/set方法就可以让子类间接访问了
 *
 * 方法覆盖(override), 也称为重写或重置
 * 子类对父类的方法不满, 重新写方法, 这样会导致子类方法覆盖父类方法, 创建子类对象执行方法,将执行子类方法.
 * 要求2点 :
 *      1) 子类的覆盖方法和父类的被覆盖方法的方法签名完全一致
 *             返回值类型, 方法名, 参数列表(参数数据类型, 参数的个数, 参数的顺序)
 *      2) 子类的覆盖方法的访问权限修饰要大于等于父类的方法的访问权限修饰
 *             原因是子类是父类的扩展, 不可以缩小
 *
 *  所谓重写, 不是指在子类中, 而是在第三方类中看待子类时, 子类重写父类的方法后只能看到子类方法
 *
 *  super : 表示在当前类中使用时, 它代表的是父类的标识.
 *      super.属性和方法. 向上追朔, 如果直接父类中没有此成员, 会继续向上搜索, 直到找到为止.
 *  this : 表示当前对象(整体).
 *
 *  如果子类中有和父类重名的属性, 对于子类和第三方类来说, 都一样, 都是有2个. 所有属性是共存的.
 *
 * @Override注解的作用 : 请求编译器作方法覆盖条件的检查, 提高可读性和安全性.
 *
 * 访问控制修饰符
 *  public      全局
 *  protected   本类      同包不同类       不同包子类
 *  default     本类      同包不同类
 *  private     本类
 *
 *  如果类中没有提供任何构造器, 编译会自动添加一个缺省构造器
 *  如果类中有提供了构造器, 编译器就不添加缺省构造器了
 *      结论 : 所有类必须有构造器
 *
 *  在子类的所有构造器中, 编译器会默认隐式的硬加一个语句 super() 并且必须在第一行. 为了保证父类的无参构造器必须先执行.
 *  子类构造器中硬加的super()作用就是调用父类无参构造器. 如果父类没有无参构造器, 子类就出错!!!
 *
 *  如果父类中没有无参构造器, 子类的构造器中必须显式的调用父类有参构造
 *
 *  子类构造器中的第一行 要么是this(...) 要么是super(...)
 *      如果第一行什么也没有, 就是super()
 *      super(...) 作用是直接的显式的调用父类构造器
 *      this(...) 作用是显式调用本类重载构造器, 而重载的构造器也是如此, 最终效果它也一定会调用到父类构造器
 *
 *      super(...)是对父类构造的直接调用, this(...)是对父类构造的间接调用
 *          结论 : 子类构造中必须要先调用父类构造. 体现的逻辑永远是 先父后子.
 *
 */
public class Person {

    private String name; // 成员一旦私有修饰, 只能在本类中访问.
    private int age;
    private String gender;

    public Person() { // 缺省构造器的特点 : 修饰符和类一致, 无参, 无普通语句
        System.out.println("Person()...."); // 1
    }

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        System.out.println("Person(全)..."); // 2
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String say() {
        return "姓名 : " + name + ", 年龄 : "    + age + ", 性别 : " + gender;
    }
}
