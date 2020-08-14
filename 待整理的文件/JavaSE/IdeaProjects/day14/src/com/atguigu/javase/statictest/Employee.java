package com.atguigu.javase.statictest;

/**
 * 静态：在内存中确定的存在，类在内存中一旦加载就不会再删除，也不会重新加载
 * 非静态：在内存中不确定的存在，只要有 new 操作符就会产生对象，并且对象随时可能变成垃圾
 *
 */
public class Employee {
    // 所有的静态块和静态属性的显式赋值最终会合体，形成一个特殊的方法 <clinit>
    static {
        System.out.println("static 2...");
        num = 10000;
        //System.out.println(num);    // 不允许访问的原因是此属性还在初始化中，值还没有确定
    }

    // 判断属性是否是静态只有一个依据：这个数据是否能共享，必须独享就是非静态。
    // 静态成员因为直接隶属于类，所以不需要创建对象就能通过类直接使用。
    // 静态属性，隶属于类，依赖类的存在而存在。也称为类属性，类变量
    public static String company = "atguigu";   // 此属性是在方法区中的类模板中开辟的空间
    // 静态方法，隶属于类，也称为类方法
    public static void setCompany(String com) {
        company = com;  // 静态成员之间可以互访
    }
    private static int num;     // 审视这个语句, 其实它是两个语句, 一个是声明, 一个是赋值, 声明是最先执行
    private static Employee emp;    // 默认缺省值0

    public static void test() {
        // 静态环境中不可以直接访问非静态成员，也不可以使用 this关键字，调用这个方法的调用者不是对象
        // 静态环境中如果想要访问非静态成员，必须创建对象，通过对象再访问，因为对象属性依赖于对象的存在而存在
        emp = new Employee();
        emp.name = "某员工";
        emp.age = 25;
        emp.salary = 10000;
        System.out.println(emp);
    }

    // 静态语句块，静态初始化块
    // 也可以把静态语句块称为类初始化器
    static {    // 这其实就是方法，有JVM调用，在类加载执行时仅有的一次
        System.out.println("static{}...");
        System.out.println("Hello");
        num = 1000;
        System.out.println(num);
    }

    // 对象属性：隶属于每个对象的，必须先new好对象，才能访问
    // 非静态：和对象相关
    private int id;     // 员工id号，随着员工的入职而赋予一个值，通常这个值不需要指定
    private String name;
    private int age;
    private double salary;


    // 非静态语句块，和对象相关，在对象创建时进行初始化工作的，和构造器类似，也是在创建对象时执行仅有的一次
    // 也称为对象初始化器
    {
        System.out.println("non static {}");    // 非静态语句块先于构造器执行
        // 非静态块的执行和构造器无关，调用哪个构造器都会引发非静态块执行
    }

    // 构造器作用：给对象进行初始化的，跟类没关系，绝对的非静态
    public Employee() {
        System.out.println("Employee()");
    }

    // 不是全参构造
    public Employee(String name, int age, double salary) {
        // 在非静态环境中是可以直接访问静态成员的，类比对象先存在
        this.name = name;   // 把静态属性的当前值赋值给对象的id属性，并且num再自增1
        this.age = age;
        this.salary = salary;
        System.out.println("Employee(有参)...");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
