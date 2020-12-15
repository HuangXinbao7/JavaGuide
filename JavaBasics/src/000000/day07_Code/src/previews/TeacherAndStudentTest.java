package previews;

public class TeacherAndStudentTest {

    public static void main(String[] args){

        Teacher t1 = new Teacher();
        Student s1 = new Student();

        t1.name = "李明";
        t1.profession = "培训";
        t1.curriculum = "大数据";
        t1.teachAge = 20;

        s1.name = "小明";
        s1.age = 21;
        s1.courses = "大数据";
        s1.hobby = "编程";

        t1.showInfo();
        s1.showInfo();
    }
}
