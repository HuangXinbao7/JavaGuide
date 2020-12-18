package com.atguigu.javase.abstracttest;

/**
 *   具体类 : 对某种事物的抽象定义
 *   抽象类 : 对某类不同种事物的抽象定义
 *   抽象类使用abstract关键字修饰, 抽象类可以包含抽象方法
 *   抽象方法 : 被abstract修饰 , 并且只有方法声明, 没有方法体的方法. 不能执行.
 *   抽象类不能创建对象, 因为抽象类中可能包含抽象方法, 而抽象方法不能执行.
 *   如果类是一个具体类, 不允许包含抽象方法.
 *
 *   抽象类专门用于被具体子类继承。具体子类要重写父类中的所有抽象方法。
 *
 *   抽象方法表示 这类事物应该具有这种行为, 又不好把行为具体化, 把任务遗留给子类, 让子类去实现.
 *   不能用abstract修饰属性、私有方法、构造器、静态方法、final的方法。
 *
 *   编写抽象类Pet, 属性:名字,年龄,体重;  抽象方法speak,eat
     * 编写Bird类继承Pet,特有属性:flySpeed
     * 编写Cat类继承Pet,特有属性:颜色
     * 编写Dog类继承Pet,特有属性:品种
     * 创建6个元素的数组，分别存放2个Cat、2个Dog和2个Bird对象
     * 将数组元素按重量倒序排序，然后打印各对象的字符串表示（toString）
 */
public abstract class Pet {

    private String name;
    private int age;
    private double weight;

    public Pet() {// 子类专供
    }

    // 子类专供
    public Pet(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }

    // 抽象方法表示 这类事物应该具有这种行为, 又不好把行为具体化, 把任务遗留给子类, 让子类去实现.
    public abstract void speak(); // 抽象方法, 纯虚方法

    public abstract void eat();
}
