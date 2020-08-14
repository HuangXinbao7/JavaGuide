package main;

public class ArrayTest3 {

    public static void main(String[] args){
        int[] arr = new int[6];

        // arr[-1] = 5; // 数组元素不可以越界访问
        arr[0] = 1;     // 数组元素的访问
        arr[1] = 3;
        arr[2] = 5;
        arr[3] = 7;
        arr[4] = 9;
        arr[5] = 11;    // 最后一个元素的下标是元素长度（个数）减1
        //arr[6] = 13;    // 这块空间存在，但是不能访问

        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
        System.out.println(arr[3]);
        System.out.println(arr[4]);
        System.out.println(arr[5]);
    }
}
