package main;

public class ArrayTest6 {

    public static void main(String[] args){
        // 静态初始化1, 方便简洁，使用灵活，功能更强大
        int[] arr = new int[]{1,2,3,4,5,6}; // 右面的[]中不允许加上长度信息
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // 静态初始化2，虽然简单，但是使用受限，声明和创建初始化必须在同一条语句上。
        int[] arr2 = {11,22,33,44,55,66,77};
        for(int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();

        //arr2 = {1,2,3};
        arr2 = new int[]{1,2,3};
    }
}
