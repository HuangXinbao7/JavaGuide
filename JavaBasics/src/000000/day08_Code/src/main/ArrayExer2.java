package main;

// 练习2：创建一个36个元素的char数组，前26个保存所有大写字母，后10个保存所有数字字符'0'~'9'，并遍历打印输出
public class ArrayExer2 {

    public static void main(String[] args){
        char[] arr = new char[36];

        // 数组的处理，前26个保存所有大写字母
        for(int i = 0; i < 26; i++){
            arr[i] = (char)('A' + i);
        }
        // 数组的处理，后10个保存所有数字字符'0'~'9'
        for(int i = 26; i < arr.length; i++){
            //arr[i] = (char) ('0'+i-26);
            arr[i] = (char) (48 + i - 26);
        }

        // 数组的遍历，专门用于访问数组元素
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}
