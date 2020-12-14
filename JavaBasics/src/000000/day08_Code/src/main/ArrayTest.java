package main;

public class ArrayTest {

    public static void main(String[] args){
        // 声明：元素数据类型[] 数组名;
        int[] arr;  // 此时没有数组对象存在

        // 创建：new 元素数据类型[元素个数];
        // 在GC区中创建一个元素有5个的int型数组，数组对象创建好以后，所有
        arr = new int[5];

        // 数组元素的定位（访问），通过首地址（数组名）[偏移量（也称为下标，索引，脚标）]
        // 每一个元素都是一个小变量
        arr[2] = 4;
        arr[0] = 3;
        arr[arr[0]] = 1;
        arr[arr[2]] = 5;

        // 分析每一个元素的值
        System.out.println(arr[0]);     // 3
        System.out.println(arr[1]);     // 0
        System.out.println(arr[2]);     // 4
        System.out.println(arr[3]);     // 1
        System.out.println(arr[4]);     // 5
    }
}
