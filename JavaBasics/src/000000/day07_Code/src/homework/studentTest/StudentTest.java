package homework.studentTest;


//Student和Computer对象传递练习
public class StudentTest {

    public static void main(String[] args) {

        Student s = new Student("小明",21,98);
        Computer com = new Computer("R5-3550H",16);

        System.out.println("computer say: " + com.say());
        s.lesson(com);
    }
}
