package com.atguigu.javase.array;

/**
 * 可变参数 : 参数个数可变
 * 一个方法中最多一个可变参数, 并且只能放在参数列表最后
 */
public class VarArgsTest {

    /*
    public static int avg(int a, int b) {
        return (a + b) / 2;
    }

    public static int avg(int a, int b, int c) {
        return (a + b + c) / 3;
    }

    public static int avg(int a, int b, int c, int d) {
        return (a + b + c + d) / 4;
    }*/



    /* 这个方法不能和上面的共存
    public static int avg(int[] values) {
        int sum = 0;
        for (int i = 0; i < values.length; i++) {
            sum += values[i];
        }
        return sum / values.length;
    }*/

    // 一个方法中最多一个可变参数, 并且只能放在参数列表最后
    //public static int avg(String name, int id, int... values) { // values本质是数组
    public static int avg(int... values) { // values本质是数组
        int sum = 0;
        for (int i = 0; i < values.length; i++) {
            sum += values[i];
        }
        return sum / values.length;
    }
    public static void main(String... args) {
        System.out.println(avg(1, 8)); // 散数据也行, 散数据会做手脚
        System.out.println(avg(1, 8, 2)); // 编译器做手脚 : avg(new int[]{1, 8, 2})
        System.out.println(avg(1, 8, 2, 100));
        int[] arr = new int[]{3, 2, 7};
        System.out.println(avg(arr)); // 直接传数组也可以, 也不做手脚
        //System.out.println(avg(null)); // null也行 avg(null)
        System.out.println(avg(3)); // 1个也可
        System.out.println(avg()); // 0个参数, avg(new int[]{});
    }

}
