package com.atguigu.javase.interfacetest;

// 实现标准的java接口 Comparable
class Student implements Comparable {
    private int id;
    private String name;
    private int grade;
    private double score;

    public Student() {
    }

    public Student(int id, String name, int grade, double score) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", score=" + score +
                '}';
    }

    // 重写java接口
    // 完成 this 和 o 的比较
    @Override
    public int compareTo(Object o) {
        /*
        // 排序依据：score
        if(this.score > ((Student)o).score) {
            return 1;
        } else if(this.score < ((Student)o).score) {
            return -1;
        }
        return 0;
        */


        // 排序依据：grade
        //if(this.grade > ((Student)o).grade) {
        //    return 1;
        //} else if(this.grade < ((Student)o).grade) {
        //    return -1;
        //}
        //return 0;

        // compareTo 实现的简化写法
        //return this.grade - ((Student)o).grade;       // 按年级排序
        return this.grade - ((Student)o).grade;         // 按分数排序
    }
}


// 可比较能力
public class ComparableTest {

    public static void main(String[] args) {
        Student[] arr = new Student[5];
        arr[0] = new Student(1, "小明", 5, 80);
        arr[1] = new Student(2, "小丽", 2, 90);
        arr[2] = new Student(3, "小刚", 1, 70);
        arr[3] = new Student(4, "小伟", 6, 100);
        arr[4] = new Student(5, "小芳", 4, 50);

        //int n = arr[0].compareTo(arr[1]);
        //System.out.println(n);

        // 遍历
        for(Student tmp: arr){
            System.out.println(tmp);
        }
        System.out.println("*******************");

        // 排序
        // 调用封装好的排序器，隐藏了排序方法的实现细节
        Sorter.bubble(arr);

        // 遍历
        for(Student tmp: arr){
            System.out.println(tmp);
        }
        System.out.println("*******************");


        String[] arrStr = {"cc", "12", "AQ", "32", "汉字", "777"};
         //Sorter.bubble(arrStr);
        Sorter.select(arrStr);        // 12 32 777 AQ cc 汉字

        for(String tmp: arrStr) {
            System.out.print(tmp + " ");
        }
        System.out.println();
    }
}
