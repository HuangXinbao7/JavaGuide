class Person {

    // 属性，或成员变量
    String name;
    int age;
    boolean isMarried;

    // 方法，或函数
    public void walk(){
        System.out.println("人走路。。。");
    }

    public String display() {
        return "名字是：" + name + ", 年龄是： " + age + ", Married：" + isMarried;
    }
}
