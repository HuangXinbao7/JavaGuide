package com.atguigu.javase.homework;

public class StudentTask {

    /**
     * 找出3年级没有及格的同学, 倒序显示前2个....
     * 使用集合
     */
    public static void main(String[] args) {

        // 保存学生对象
        ArrayList<Student> stuList = new ArrayList<>();
        String[] surnames = {"李", "王", "赵", "张", "刘", "杨", "曹"};    // 姓
        String[] names = {"刚", "伟", "丽", "娜", "琳", "宁", "旭", "阳", "帅"}; // 名

        for (int i = 0; i < 20; i++) {
            int id = i + 1;
            // 获取随机的姓的索引下标
            int index1 = (int) (Math.random() * 2000) % surnames.length;
            // 获取随机的名的索引下标
            int index2 = (int) (Math.random() * 2000) % names.length;

            String name = surnames[index1] + names[index2];
            int grade = (int) (Math.random() * 6 + 1); // 随机的1~6
            double score = (int) (Math.random() * 101);
            stuList.add(new Student(id, name, grade, score));
        }
        // 遍历所有学生信息
        for (Student tmp : stuList) {
            System.out.println(tmp.say());
        }

        System.out.println("****************************************");
        System.out.println("3年级并且不及格的所有同学: ");
        // 找出3年级并且不及格的所有同学，存放在 failList中
        ArrayList<Student> failList = new ArrayList<>();
        // 使用增强for遍历集合比使用传统for的代码简便多了
        // if(stuList.get(i).getGrade() == 3 && stuList.get(i).getScore() < 60) {
        for (Student stu: stuList) {
            if(stu.getGrade() == 3 && stu.getScore() < 60) {
                failList.add(stu);
                System.out.println(stu);
            }
        }

        System.out.println("****************************************");
        System.out.println("分数倒序排序: ");
        // 调用现有工具类 Collections 的 sort() 方法，并传入匿名比较对象，重写了比较方法。
        Collections.sort(failList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                // 从小到大排序
                // double类型数据运算，放大100倍
                return -(int)(o1.getScore() * 100 - o2.getScore() * 100);
            }
        });
        /*
        // 传统排序方法
        // 缺点：需要调用的层次较多，代码比较繁琐
        for (int i = 0; i < failList.size(); i++) {
            for (int j = i + 1; j < failList.size(); j++) {
                if(failList.get(i).getScore() > failList.get(j).getScore()) {
                    Student tmp = failList.get(i);
                    failList.set(i, failList.get(j));
                    failList.set(j, tmp);
                }
            }
        }
        */
        for (Student tmp: failList) {
            System.out.println(tmp);
        }

        System.out.println("****************************************");
        System.out.println("只显示前两个：");
        // 最后结果的遍历
        // 3年级没有及格的同学, 倒序显示前2个
        for (int i = 0; i < failList.size(); i++) {
            if (i == 2) break; // 如果元素个数大于2，则遍历到第三个元素时（不打印）终止循环
            System.out.println(failList.get(i));
        }
    }


    // Student 使用内部类形式
    static class Student {
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

        public String say() {
            return "学号: " + id + ", 姓名: " + name + ", 年级: " + grade + ", 分数: " + score;
        }

        @Override
        public String toString() {
            return say();
        }
    }
}
