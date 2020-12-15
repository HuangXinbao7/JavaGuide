package main;

/**
 * 构造器：无参构造器、有参构造器、构造器重载
 */
public class Teacher2 {

    // 成员变量的私有化
    // private 表示私有的意思，一旦私有，外部无法访问，只能在类内部访问
    // 这样的处理称为“封装”，即成员私有化
    private String name = "某老师";    // 字符串类型的属性如果没有显式赋值，默认值是 null
    private int age;                  // int型的缺省值是 0
    private String gender = "保密";


    // 无参构造器
    public Teacher2(){
        // 默认情况下，无参构造器是不需要赋值的
        // 但如果需要也是可以的，那么在创建对象的时候就自动的给属性赋值
        //this.name = "小明";
        //this.age = 8;
        //this.gender = "男";

    }

    // 2个参数的构造器
    public Teacher2(String name, int age){
        //this.name = name;
        //this.age = age;
        //// 其他属性在本构造器中不进行初始化，或写死，不使用参数
        //this.gender = "男";

        // 相当于是调用3个参数的构造器
        this(name, age, "男");   // 重载的构造器的调用，必须使用 this();
    }

    // 3参数全参构造器，也称全参构造器
    public Teacher2(String name, int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // 间接设置属性的方法，称为 set 方法
    // set 方法有参无返回值
    public void setName(String name){
        this.name = name;
    }

    // 间接获取属性值的方法，称为 get 方法
    // get 方法无参有返回值
    public String getName(){
        return name;
    }

    // 使用方法间接给属性赋值的好处是：可以加上逻辑判断，使数据得到保护
    public void setAge(int age) {
        // 对传入的参数加个判断。防止数据非法
        if(age > 0 && age < 100){
            this.age = age;
        }
    }

    public int getAge() {
        return age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }


    // 成员方法（member）
    public void lesson() {
        System.out.println("老师在上课");
    }

    public void eat(String some) {
        System.out.println("老师在吃 " + some);
    }

    public String say() {
        return "姓名：" + name + ", 年龄：" + age + ", 性别：" + gender;
    }
}
