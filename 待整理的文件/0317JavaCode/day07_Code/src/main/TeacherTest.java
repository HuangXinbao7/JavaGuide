package main;

public class TeacherTest {

    // 定义一个方法，测试对象的传递
    public static void test(Teacher4 t){    // 通过方法的参数可以传递对象
        System.out.println();
    }

    // 对象传递
    public static void main(String[] args) {
        Teacher4 t = new Teacher4("宁姐", 20, "女");
        System.out.println(t.say());
    }


    // 练习：在测试类中 new Teacher3(); 让它say出来的是 "姓名：小明, 年龄：18, 性别：男"
    public static void main5(String[] args) {
        Teacher3 t = new Teacher3();
        System.out.println(t.say());
    }


    // 构造器之间的间接调用即连环调用，
    // 但是必须保证有一个构造器中是没有 this() 的，防止无限循环的递归调用
    public static void main4(String[] args) {
        // 先调用2个参数的构造器
        // 在2个参数的构造器中，又调用3个参数的构造器，第三个属性的赋值被写死在构造器中
        Teacher2 t1 = new Teacher2("小明", 30);
        System.out.println(t1.say());
    }


    // 构造器测试
    public static void main3(String[] args) {
        // 调用无参构造器
        Teacher2 t1 = new Teacher2();
        // 无参构造器初始化的都是默认值
        System.out.println(t1.say());

        // 2个参数的构造器
        Teacher2 t2 = new Teacher2("小明", 18);
        System.out.println(t2.say());

        // 全参构造器，所有属性都被初始化
        Teacher2 t3 = new Teacher2("小明", 28, "男");
        System.out.println(t3.say());
    }


    // set 和 get
    public static void main2(String[] args) {
        Teacher2 t2 = new Teacher2();
        // t2.name = "宁姐"; 是直接赋值
        // t2.setName("宁姐"); 是方法调用
        //t2.name = "宁姐";   // 在测试类中无法直接修改对象的属性
        t2.setName("宁姐");   // 通过方法调用完成间接的属性赋值
        //t2.age = 20;
        t2.setAge(20);
        //t2.gender = "女";
        t2.setGender("女");

        // 间接访问读取类中私有化的成员变量的属性值
        System.out.println(t2.getName());
        System.out.println(t2.getAge());
        System.out.println(t2.getGender());
    }


    public static void main1(String[] args) {
        // 根据类模板创建对象
        Teacher t1 = new Teacher();     // 无参构造方法

        t1.name = "佟刚";
        t1.age = 40;
        t1.gender = "男";

        System.out.println(t1.name);
        System.out.println(t1.age);
        System.out.println(t1.gender);

        t1.lesson();
        t1.eat("肉");
        System.out.println(t1.say());

        Teacher t2 = new Teacher();
        t2.name = "宁姐";
        t2.age = 20;
        t2.gender = "女";

        System.out.println(t2.say());
    }
}
