package main;

// 写一个Phone类, 包含属性os, screen.
// 写一个Person类, name, age, weight. 写方法 void call(), void chiji()
// 使用对象关联技术, 让Person拥有一台手机, 在测试类中调用call,和chiji方法.
public class PersonAndPhoneTest {

    public static void main(String[] args){

        Phone ph = new Phone("IOS", 5.8);
        Person p = new Person("张三", 30, 60, ph);

        p.call();
        p.chiji();

        System.out.println(p.say());
    }
}
