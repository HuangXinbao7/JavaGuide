package com.atguigu.javase.finaltest;

/**
 * final是最终的意思.
 *  final 修饰类, 表明这个类是终极类, 不允许子类扩展. 不能被继承
 *  final 修饰方法, 表明这个方法是终极完美方法, 不允许子类重写.
 *  final 修饰变量, 表明这个量是终极量, 它必须赋值唯一的一次, 不赋值不行, 赋多了也不行.
 *
 *  public static final 修饰的量 称为全局常量. 典型的就是Math.PI
 */
public final class Employee {

    public static final int NUM_BASE; // 全局常量

    static {
        num = 400; // 赋值时, 可以根据右侧的实际值推断
        System.out.println(Employee.num); // 此时无法确定是哪个num, 要想访问, 必须加限定
        NUM_BASE = 300;
    }

    private static int num = 1;

    static { // 静态语句块在类加载时执行仅有一次, 作用是对类进行初始化
        System.out.println("static.....");
        num = NUM_BASE;
        System.out.println(num); // 这里没问题, 就近原则
    }

    private final int ID; // 空final, blank final很危险, 因为它要求必须完成一次仅有的赋值
    private String name;
    private int age;
    private double salary;

    {
        // 在创建对象时执行仅有的一次, 先于构造器执行, 它的执行和构造器用哪个无关.
        this.ID = num++; // 这是非静态语句块的价值所在
        System.out.println("non static {}");
    }

    public Employee() { // 所有构造器中都必须给空final赋值
    }

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public final int getID() {
        return ID;
    }

    /*
    public void setId(int id) {
        this.id = id;
    }
    */

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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
