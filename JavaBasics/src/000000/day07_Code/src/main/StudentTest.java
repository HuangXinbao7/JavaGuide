package main;

public class StudentTest {

    /**
     * 在测试类中创建 Student 对象，并给对象的属性赋值，并打印所有属性值
     */
    public static void main(String[] args) {

        // 创建 Student 对象
        Student s = new Student();

        // 对象的属性赋值
        s.setName("小明");
        s.setAge(18);
        s.setScore(100);

        System.out.println(s.getName());
        System.out.println(s.getAge());
        System.out.println(s.getScore());


        // 调用方法
        s.study();
        System.out.println(s.say());

        // 调用非全参构造器
        Student s2 = new Student("小丽", 15);
        System.out.println(s2.say());

        // 调用全参构造器
        Student s3 = new Student("小刚", 18, 19);
        System.out.println(s3.say());
    }
}
