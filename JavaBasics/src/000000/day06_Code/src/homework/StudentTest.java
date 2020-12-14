package homework;

public class StudentTest {

    public static void main(String[] args) {

        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();

        s1.name = "小明";
        s1.grade = "三年级";
        s1.score = 99;

        s2.name = "小红";
        s2.grade = "初三";
        s2.score = 90;

        s3.name = "小黑";
        s3.grade = "高三";
        s3.score = 98;

        System.out.println(s1.say());
        System.out.println(s2.say());
        System.out.println(s3.say());
    }
}

