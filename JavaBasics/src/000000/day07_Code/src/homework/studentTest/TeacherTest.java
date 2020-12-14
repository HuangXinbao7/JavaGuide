package homework.studentTest;

public class TeacherTest {

    public static void main(String[] args){
        // new Teacher("大海", 25, "男").lesson(new Computer(4.0, 16)); // 参数中的对象是匿名对象, 匿名对象在传递对象时非常常用
        // 匿名对象适用于对象的一次性使用.
        homework.studentTest.Computer com = new homework.studentTest.Computer("R5-3550H", 16);
        homework.studentTest.Teacher t = new homework.studentTest.Teacher("小明", 30, "男", com);

        //t.setMyComputer(com);
        t.lesson(); // 虽然在方法内部用到了电脑, 但是不用传, 因为已经关联了
        t.film(); // 虽然在方法内部用到了电脑, 但是不用传, 因为已经关联了

        //t.com.cpu 这种表达合法么, 因为封装了, 所以用下面的
        String cpu = t.getMyComputer().getCpu();
        System.out.println(cpu);
    }
}
