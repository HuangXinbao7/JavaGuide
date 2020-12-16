// package com.atguigu.javase.array;

public class ArrayTest {

    public static void main(String[] args) {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 20);
        }
        // 遍历
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        // 0 1 2 3 4  5 6  7
        //11 4 6 9 18 5 9 16
        // 反转, 头变尾,
        // 循环数组长度一半, 首尾交换
        for (int i = 0; i < arr.length / 2; i++) {
            // 交换i位置和arr.length - 1 - i位置
            int tmp = arr[i]; // 临时变量必须使用数组元素类型.
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = tmp;
        }
        // 遍历
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        // 把int数组反转

    }

    public static void main7(String[] args) {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 20);
        }
        // 遍历
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        // 0 1 2 3 4  5 6  7
        //11 4 6 9 18 5 9 16
        // 找最大值 : 找最大值的位置(下标)
        int maxIndex = 0; // 假设下标为0的元素最大
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[maxIndex]) { // 如果i位置的值大于maxIndex位置的值
                maxIndex = i; // 记录i位置到maxIndex中.
            }
        }
        System.out.println("max : " + arr[maxIndex]);

        // 使用下标的方式找出最小值
        int minIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }
        System.out.println("min : " + arr[minIndex]);

    }

    public static void main6(String[] args) {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 20);
        }
        // 遍历
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        //  0 1  2  3 4 5 6  7
        // 13 16 13 5 1 2 19 2
        // 找最大值
        int max = 0x80000000 ; // 1000 0000 0000 0000 0000 0000 0000 0000 // 无法直接获取某个元素的值.
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("max = " + max);
        // 最小值
        int min = 0x7FFFFFFF;// 0111 1111 ....;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("min = " + min);
        // 找出能被7整除的数的最大值
        int max7 = 0x80000000; // 让它的值为最小, 这样只要是整数就一定会比它大, 从而刷新它的值.
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 7 == 0) {
                if (arr[i] > max7) {
                    max7 = arr[i];
                }
            }
        }
        if (max7 == 0x80000000) { // 如果它的值保持了初始值, 说明这个变量没有被刷新过, 说明if一直为假, 也说明没有符合条件的数
            System.out.println("没有能被7整除的数");
        } else {
            System.out.println("能被7整除的最大值 : " + max7);
        }
        // 找出能被7整除的数的最小值
        int min7 = 0x7FFFFFFF;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 7 == 0) {
                if (arr[i] < min7) {
                    min7 = arr[i];
                }
            }
        }
        if (min7 != 0x7FFFFFFF) {
            System.out.println("min7 = " + min7);
        } else {
            System.out.println("没有能被7整除的数");
        }
    }

    public static void main5(String[] args) {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 20);
        }
        // 遍历
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        //  0 1  2  3 4 5 6  7
        // 13 16 13 5 1 2 19 2
        // 找最大值
        int max = arr[0]; // 先假定第一个元素的值最大
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) { // 如果某元素的值比最大值还大
                max = arr[i]; // 刷新最大值为某个值.
            }
        }
        System.out.println("max : " + max); // 统计运算最后出结果
        // 找出数组中的最小值.
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("min = " + min);

    }

    public static void main4(String[] args) {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 20);
        }
        // 遍历
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        // 0 1 2 3 4  5  6  7
        //18 9 4 6 14 17 16 18
        // 求所有能被７整除的数的平均值
        int sum = 0;
        int count = 0; // 计数
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 7 == 0) {
                sum += arr[i];
                count++;
            }
        }
        if (count == 0) {
            System.out.println("没有能被7整除的数");
        } else {
            int avg = sum / count;
            System.out.println("avg : " + avg);
        }
        // 求所有能被5整除的数的平均值.
    }

    public static void main3(String[] args) {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 20);
        }
        // 遍历
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        //0 1 2 3  4 5  6  7
        //7 1 8 18 3 17 10 6
        // 求平均值, 先求和
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        int avg = sum / arr.length;
        System.out.println("avg : " + avg);
    }

    public static void main2(String[] args) {
        // 随机数
        double random1 = Math.random(); // [0~1)随机浮点数
        System.out.println(random1);
        // 100以内的随机浮点数
        double random2 = Math.random() * 100;
        System.out.println(random2);
        // 100以内的随机整数
        int random3 = (int) (Math.random() * 100);
        System.out.println(random3);
        // 练习 : 产生一个随机的[30~70)之间的整数
        int random4 = (int)(Math.random() * 40 + 30);
        System.out.println(random4);
    }

    public static void main1(String[] args) {
        // 数组的声明和创建, 元素类型[] 数组名 = new 元素数据类型[长度];
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 2 * i + 1;
        }
        // 遍历
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        // 求和
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println("sum : " + sum);
        // 求平均值
        int avg = sum / arr.length;
        System.out.println("avg : " + avg);
    }
}
