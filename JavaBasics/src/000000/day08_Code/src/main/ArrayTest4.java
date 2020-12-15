package main;

// 数组一旦创建，长度不允许修改，元素类型也无法更改！
public class ArrayTest4 {

    public static void main(String[] args){
        int[] arr = new int[6];

        System.out.println("数组长度：" + arr.length);

        arr[0] = 1;     // 数组元素的访问
        arr[1] = 3;
        arr[2] = 5;
        arr[3] = 7;
        arr[4] = 9;
        arr[5] = 11;    // 最后一个元素的下标是元素长度（个数）减1

        //arr.length = 20;
        //arr = new char[4];

        // 循环处理数组，循环非常适合用于处理数组
        for(int i = 0; i < 6; i++){
            arr[i] = 2*i+1;
        }

        // 遍历
        // 循环次数正好是数组长度
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
