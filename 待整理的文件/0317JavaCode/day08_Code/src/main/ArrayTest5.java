package main;

public class ArrayTest5 {

    public static void main(String[] args){
        char[] arr = new char[26];

        // 数组的处理，专门用于给数组元素赋值
        for(int i = 0; i < arr.length; i++){
            arr[i] = (char)('a' + i);
        }

        // 数组的遍历，专门用于访问数组元素
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
