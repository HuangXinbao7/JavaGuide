package main;

// 在测试类中创建两个对象，一个是你的生日，另一个是今天的日期
public class MyDateTest {

    public static void main(String[] args) {
        MyDate m1 = new MyDate();
        System.out.println("我的生日：" + m1.say());

        MyDate m2 = new MyDate(2020, 4, 4);
        System.out.println("今天的日期：" + m2.say());
    }
}
