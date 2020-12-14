package com.atguigu.javase.abstracttest;

/**
 * 具体类：对某种（具体）事物的抽象定义
 * 抽象类：对某类不同种事物的抽象定义
 * 抽象类使用 abstract 关键字修饰, 抽象类可以包含抽象方法
 * 抽象方法：被 abstract 修饰，并且只有方法声明，没有方法体的方法，不能执行。
 * 抽象类不能实例化（不能创建对象），是因为抽象类中可能包含抽象方法，而抽象方法不能执行。
 * 如果类是一个具体类，不允许包含抽象方法
 *
 * 抽象类专门用于被具体子类继承，具体子类要重写父类中的所有抽象方法。
 *
 * 抽象方法表示这类事物应该具有某种行为，又不能把行为具体化，所以把这个具体化任务留给子类，让子类去实现
 * 不能用 abstract 修饰属性、私有方法、构造器、静态方法、final的方法。
 *
 * 编写抽象类Pet，属性：名字，年龄，体重；抽象方法：speak，eat
 * 编写Bird类继承Pet，特有属性：flySpeed
 * 编写Cat类继承Pet，特有属性：颜色
 * 编写Dog类继承Pet，特有属性：品种
 * 创建6个元素的数组，分别存放2个Cat、3个Dog和2个Bird对象。
 * 将数组元素按重量倒序排序，然后打印各对象的字符串表示（toString）
 */
public abstract class Pet {

    private String name;
    private int age;
    private double weight;

    // 子类专供
    public Pet() {
    }

    // 子类专供
    public Pet(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    // 重写 toString() 方法
    @Override
    public String toString() {
        return "名字：" + name + ", 年龄：" + age + ", 体重：" + weight;
    }

    // 抽象方法必须被子类重写
    public abstract void speak();   // 抽象方法，纯虚方法
    public abstract void eat();     // 抽象方法
}
