package com.atguigu.javase.polymorphism;

public class PersonTest {

    /**
     * 参数的引用指向的对象实体不明确！好处是方法的兼容性更好
     * 一个引用指向的对象至少是一个家族（如Person及其子类）。
     */
    public static void test(Person p){     // 多态参数方法：可以实际接收Person及其子类的对象
        System.out.println(p.say());
        //p.spring();   // 多态副作用

        // 类型转换（造型）
        // 造型有风险，必须加判断（判断顺序：先判断子类，再判断父类）
        // instanceof：判断左面的引用指向的对象实体是不是右侧类型的实体（对象）
        // 对象的判断顺序必须从最子类到最父类
        if(p instanceof BeiJing) {
            ((BeiJing)p).liuBird();
        }else if(p instanceof Chinese) {
            Chinese ch = (Chinese)p;    // 这里不是强制转换！！，叫造型。把对象“看成”是某种新的类型
            ch.spring();                // 造型后的对象有特有方法
        }else if(p instanceof American) {
            ((American)p).thanks();     // 点运算的优先级高于双引号
        }else {
            System.out.println("普通人一枚");
        }
    }


    public static void main(String[] args) {
        Chinese p1 = new Chinese("张三", 30, "男", "牛");
        American p2 = new American("Jack",40, "male", true);
        Person p3 = new Person("某人", 50, "男");
        BeiJing p4 = new BeiJing("老炮", 30, "男", "");

        test(p1);
        test(p2);
        test(p3);
        test(p4);
    }


    public static void main2(String[] args) {
        // 多态应用：多态数组，使用父类类型声明的数组，可保存各种不同子类对象。
        // 特点是兼容性好
        Person[] arr = new Person[5];
        arr[0] = new Chinese("张三", 30, "男", "牛");
        arr[1] = new American("John", 40, "male", true);
        arr[2] = new Person("某人", 20, "未知");
        arr[3] = new American("Rose", 25, "female", false);
        arr[4] = new Chinese("李四", 38, "女", "猪");

        for (Person tmp: arr) {
            System.out.println(tmp.say());
        }
        System.out.println("***********************************");

        // 排序
        for(int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j].getAge() < arr[j + 1].getAge()) {
                    Person tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }

        // 遍历
        for(Person tmp: arr) {
            System.out.println(tmp.say());
        }
        System.out.println("***********************************");
    }


    public static void main1(String[] args) {
        // 本态引用：子类对象赋值给子类类型引用变量
        Chinese ch = new Chinese("小明", 18, "男", "羊");
        // 多态引用：子类对象赋值给父类类型的引用变量
        Person person = new Chinese("小红", 17, "女", "凤");
        //person.spring();    // 编译器要检查person引用类型的类中是否有此方法，Person 类中没有 spring() 方法
        // Person类中有 sayHello() 方法
        person.sayHello();                  // 你好，吃了吗
        System.out.println(person.say());   // 姓名：小红, 年龄：17, 性别：女, 属相：凤

        person = new American("Jack", 35, "male", true);

        // ***** 虚拟方法调用：多态引用调用覆盖方法
        // 1） 编译时检查父类类型
        // 2) 运行时执行之类类型
        person.sayHello();      // 对象实体最重要
        System.out.println(person.say());

        //person.spring();    // 多态副作用：编译器认为引用类型中没有此方法，多态引用时不可以访问子类特有成员。
        //person.thanks();    // 多态副作用：编译器无法确定引用的具体类型。

        System.out.println(person.getName());
    }
}

