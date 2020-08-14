public class TeacherTest5 {

    public static void main(String[] args){

        Teacher t1 = new Teacher();
        Teacher t2 = new Teacher();

        t2.name = "宁姐";
        t2.age = 22;
        t2.gender = "女";

        System.out.println(t1.say());
        System.out.println(t2.say());
    }
}
