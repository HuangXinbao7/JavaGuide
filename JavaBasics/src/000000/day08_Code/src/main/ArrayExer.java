package main;

// 练习: 创建一个26元素的char数组，保存所有大写字母，并遍历打印输出
public class ArrayExer {

    public static void main(String[] args){
        char[] arr = new char[26];

        // 数组的处理，专门用于给数组元素赋值
        for(int i = 0; i < arr.length; i++){
            arr[i] = (char)('A' + i);
        }

        // 数组的遍历，专门用于访问数组元素
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}
