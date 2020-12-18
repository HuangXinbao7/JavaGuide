package com.atguigu.javase.interfacetest;

/**
 * 获取对象的途径 :
 *      1) new
 *      2) 通过工厂方法
 *      3) 反序列化
 *      4) 反射
 *      5) 直接在内存中开空间(Unsafe)
 *
 * 工厂方法 : 通过方法获取对象, 可能的场景 : 无法找到要创建的对象的类
 *      创建对象太复杂.
 */
interface Worker {
    void work();
}

class Teacher implements Worker {
    public void work() {
        System.out.println("老师在工作");
    }
}
class Farmer implements Worker {
    public void work() {
        System.out.println("农民在耕地");
    }
}

class Factory {

    public static Worker getTeacher() {
        return new Teacher();
    }

    public static Worker getFarmer() {
        return new Farmer();
    }
}

public class FactoryTest {
    public static void main(String[] args) {
        // 要想获取对象, 不能直接创建, 因为对象创建太复杂了. 间接找工厂要
        Worker teacher = Factory.getTeacher(); // 对于使用者来说, 方法中什么时候创建,怎么创建, 不知道.
        teacher.work();
        Worker farmer = Factory.getFarmer();
        farmer.work();
    }
}
