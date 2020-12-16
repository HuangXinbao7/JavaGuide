package com.atguigu.javase.innerclass;

/**
 * 内部类 ： 在类中再定义其他类
 *      1) 成员内部类 : 声明在类中方法外的内部类
 *          1) 普通成员内部类 : 没有static修饰
 *          2) 嵌套类 : 被static修饰
 *      2) 局部内部类 : 声明在方法中的内部类
 *          1) 普通局部内部类
 *          2) 匿名内部类(超重点)
 */
class Outer { // 顶级类只能被public和default修饰

    private int num = 10;

    // 成员内部类, 隶属于外部类对象的. 在内部类中可以随意访问外部类成员.
    // 和对象关联类似, 但是比对象关联好用, 因为可以访问私有成员. 对象关联只能使用关联对象的公共成员.
    class Inner1 { // 支持所有访问权限修饰符
        // 成员内部类不允许声明静态属性.
        private int num = 100;

        public int getNum() {
            return num;
        }

        public void inner1Test1() {
            // this可以加类限定, 更清晰明确
            System.out.println("成员内部类的属性 : " + Inner1.this.num); // 100
            System.out.println("成员内部类访问外部类属性 : " + Outer.this.num); // 10
            outerTest2();
        }
    }

    public void outerTest1() {
        System.out.println("外部类方法");
        // 如果想要调用内部类方法
        Inner1 inner1 = this.new Inner1(); // 通过当前类对象new一个内部类对象
        inner1.inner1Test1();
        System.out.println(this.num); // 10
        System.out.println(inner1.num); // 100
    }

    private void outerTest2() {
        System.out.println("私有方法");
    }

    // 嵌套类, 加static修饰, 本质上和外部类是平级的
    // static仅仅表示它和外部类的关系
    public static class Inner2 {
        public static String name;

        private int id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

}

interface MyInterface {
    String getInfo();
}

interface MyInterface2 {
    void test();
}

public class InnerTest {

    public static void main(String[] args) {
        // 什么情况下 ? 临时的想要用某个接口的对象.而且对象也是一次性使用
        new MyInterface2() {
            @Override
            public void test() {
                System.out.println("匿名内部类的test");
            }
        }.test(); // 匿名内部类的匿名对象, 一次性使用

        Object o = new Object() { // 匿名内部类是Object的直接子类
            public String toString() {
                return "我是匿名内部类对象";
            }
        };
        System.out.println(o);
    }

    public static void main4(String[] args) {
        // 匿名内部类, 没有类名, 不能后期创建对象, 在声明的同时必须马上创建唯一对象.
        // 匿名内部类通常就是和接口配合.接口中的方法通常也不多.
        /*
        new 父类|接口() {
            类体部分, 类体相当于new后面的父类或接口的实现子类.
        };
        */
        //class Xxx implements MyInterface{};
        //MyInterface mi = new Xxx(); 相当于以上两个语句合体.
        MyInterface mi = new MyInterface() { // 因为没有类名, 所以必须多态.
            @Override
            public String getInfo() {
                return "我是匿名内部类的实现方法体";
            }
        };
        System.out.println(mi.getInfo());
    }

    public static void test() {
        //new Inner3();
    }

    public static void main3(String[] args) {
        // 普通局部内部类, 类的定义写在方法中, 不可以加访问控制修饰
        final class Inner3 {
            private int id;
            @Override
            public String toString() {
                return "Inner3{" +
                        "id=" + id +
                        '}';
            }
        };
        Inner3 inner3 = new Inner3();
        inner3.id = 200;
        System.out.println(inner3);
    }

    public static void main2(String[] args) {
        Outer outer = new Outer();
        //outer.outerTest1();
        //Outer.Inner1 inner1 = new Outer.Inner1(); // 误解成是静态成员.
        //Outer.Inner1 inner1 = new outer.Inner1(); // 会误解成是一个方法. 难道不是构造方法吗? 不是!! 构造方法<cinit>
        Outer.Inner1 inner1 = (new Outer()).new Inner1();// 外部类对象.new, 因为内部类依赖外部类对象
        inner1.inner1Test1();

        System.out.println(inner1.getNum());

        Outer.Inner2.name = "一个名字";
        System.out.println(Outer.Inner2.name);
        // 创建嵌套类对象
        Outer.Inner2 oi2 = new Outer.Inner2(); // 直接创建
        System.out.println(oi2);
    }
}
