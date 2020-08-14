package main;

// 写一个Person类, name, age, weight. 写方法 void call(), void chiji()
// 使用对象关联技术, 让Person拥有一台手机, 在测试类中调用call,和chiji方法.
public class Person {

    private String name;
    private int age;
    private double weight;
    private Phone myPhone;

    public Person() {
        this("某人", 20, 60, new Phone("Android", 5.0));
    }

    public Person(String name, int age, double weight, Phone myPhone){
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.myPhone = myPhone;
    }

    public void setMyPhone(Phone myPhone){
        this.myPhone = myPhone;
    }

    public Phone getMyPhone(){
        return myPhone;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    public void setWeight(double weight){
        this.weight = weight;
    }

    public double getWeight(){
        return weight;
    }

    public String say(){
        return "姓名：" + name + ", 年龄：" + age + ", 体重：" + weight + ", 我的手机 : " + myPhone.say();
    }

    public void call(){
        System.out.println(name + "使用手机[" + this.myPhone.say() + "]打电话");
    }

    public void chiji() {
        System.out.println(name + "使用手机[" + this.myPhone.say() + "]玩吃鸡...");
    }
}
