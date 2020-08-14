package homework.studentTest;

public class Student {

    private String name;
    private int age;
    private double score;

    public Student(){
        this("小明",21,99);
    }

    public Student(String name, int age, double score){
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public void lesson(Computer com){
        System.out.println(name + "正在使用: [" + com.say() + "]");
    }
}
