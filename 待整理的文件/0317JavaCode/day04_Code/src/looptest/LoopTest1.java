package looptest;

public class LoopTest1 {
    public static void main(String[] args){
        /* while 语法
        初始化语句
        while(循环条件){
            循环体;
            迭代语句;
        }
        */
        int result = 0;
        int i = 1;
        while(i <= 5){
            result += 1;
            i++;
        }
        System.out.println("result: " + result);
        System.out.println("i: " + i); // 此时i的值是？
    }
}
