package com.atguigu.javase.interfacetest;

class Student implements Comparable {

    private int id;
    private String name;
    private int grade;
    private double score;

    public Student() {
    }

    public Student(int id, String name, int grade, double score) {
        com.atguigu.javase.interfacetest.Student.this.id = id;
        Student.this.name = name;
        Student.this.grade = grade;
        Student.this.score = score;
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

    @Override
    public int compareTo(Object o) { // 完成this和o的比较
        /*
        if (this.score > ((Student)o).score) {
            return 1;
        } else if (this.score < ((Student)o).score) {
            return -1;
        }
        return 0;
        */
        /*
        if (this.grade > ((Student)o).grade) {
            return 1;
        } else if (this.grade < ((Student)o).grade) {
            return -1;
        }
        return 0;
        */
        //return this.grade - ((Student)o).grade;
        return -(int)(this.score * 100 - ((Student)o).score * 100);

    }
}

public class ComparableTest {

    public static void main(String[] args) {
        Student[] arr = new Student[5];
        arr[0] = new Student(1, "小明", 5, 80);
        arr[1] = new Student(2, "小丽", 2, 90);
        arr[2] = new Student(3, "小刚", 1, 70);
        arr[3] = new Student(4, "小伟", 6, 100);
        arr[4] = new Student(5, "小方", 4, 50);

        for (Student tmp : arr) {
            System.out.println(tmp);
        }
        System.out.println("***************************");
        //int n = arr[0].compareTo(arr[1]);
        //System.out.println(n);

        Sorter.bubble(arr);

        for (Student tmp : arr) {
            System.out.println(tmp);
        }
        System.out.println("***************************");

        String[] sarr = {"cc", "12", "AQ", "32", "汉字"};
        Sorter.bubble(sarr);

        for (int i = 0; i < sarr.length; i++) {
            System.out.println(sarr[i]);
        }
    }
}
