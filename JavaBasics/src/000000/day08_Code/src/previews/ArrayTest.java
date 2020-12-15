package previews;

public class ArrayTest {

    public static void main(String args[]) {

        // 此时的内存状态：main方法压栈到栈内存，并创建一个局部变量 s
        int[] s;

        // 此时的内存状态：在堆内存中，创建一个新的int[]对象，大小为10且默认初始化值为0
        s = new int[10];
        // int[] s = new int[10];
        // 基本数据类型数组如果内有赋初始值
        // java自动给它们赋默认值

        // 使用 for 循环赋值并打印
        for(int i = 0; i < 10; i++){
            // 此时的内存状态：在堆内存中，给每个数值中的元素赋值
            s[i] = 2*i+1;
            System.out.println(s[i]);
        }
    }
}
