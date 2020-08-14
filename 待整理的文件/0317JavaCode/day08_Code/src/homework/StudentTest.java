package homework;

/**
 * 测试类要求是公共的
 */
public class StudentTest {

    public static void main(String[] args){
        /*
        创建一个Student[] 包含20个元素
        用循环创建20个学生对象, 要求id从1~20, 姓名随机产生, 年级随机的[1~6], 分数随机的[0~100]分.遍历对象数组, 打印输出
        */
        Student[] stuArr = new Student[10];
        for (int i = 0; i < stuArr.length; i++){
            int id = i +1;
            String name = "小明";
            int grade = i % 6 + 1;
            double score = ((i + 1) * 10) % 101;    // 让未知数落在已知范围内

            stuArr[i] = new Student(id, name, grade, score);
        }

        // 遍历
        for (int i = 0; i < stuArr.length; i++){
            System.out.println(stuArr[i].say());
        }
    }
}
