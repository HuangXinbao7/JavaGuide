public class TeacherTest {

    public static void main(String[] args){
        // 使用已经准备好的类，可以创建对象
        Teacher t = new Teacher();  // 创建一个对象，依据类模板，使用关键字 new
        t.name = "李明";
        t.age = 30;
        t.gender = "男";

        // 对象成员，必须通过 对象.成员 的方法来访问
        System.out.println(t.name);     // 打印对象的属性 name
        System.out.println(t.age);      // 打印对象的属性 age
        System.out.println(t.gender);   // 打印对象的属性 gender

        // 对象方法
        t.lesson();
        t.eat("包子"); // 方法调用：方法名(实参)

        String s = t.say();
        System.out.println(s);
    }
}
