package com.atguigu.javase.array;

public class ArrayTest {

    // 快排算法
    public static void quick(int[] arr, int begin, int end){
        if(begin > end){
            return;
        }
        // 找key值
        int key = arr[begin];
        int keyIndex = begin;
        for(int i = begin + 1; i < end; i++){
            if(arr[i] < key){
                keyIndex++;
                // 交换keyIndex位置和i位置的值
                int tmp = arr[keyIndex];
                arr[keyIndex] = arr[i];
                arr[i] = tmp;
            }
        }
        // 循环结束后, keyIndex及左面保存了所有比key小的值. 开始的位置仍然还是key
        arr[begin] = arr[keyIndex];
        arr[keyIndex] = key;    // 此时分区完成,
        //
        quick(arr, begin, keyIndex);        // 左子列递归
        quick(arr, keyIndex + 1, end); // 右子列递归
    }

    // 快速排序
    public static void main(String[] args) {
        int[] arr = new int[8];
        for(int i = 0; i < arr.length; i++){    // 给数组元素赋值，必须使用经典for
            arr[i] = (int)(Math.random() * 20);
        }
        // 遍历数组
        for (int tmp : arr){
            System.out.print(tmp + " ");
        }
        System.out.println();
        // 0  1 2  3 4 5  6 7
        // 15 5 17 6 2 14 3 10
        // 快速排序
        //Arrays.sort(arr); // 底层用的就是快速排序
        quick(arr, 0, arr.length);

        // 遍历
        for(int tmp: arr){
            System.out.println(tmp + " ");
        }
        System.out.println();
    }

    // 排序: 选择排序
    public static void main8(String[] args) {
        int[] arr = new int[8];
        for(int i = 0; i < arr.length; i++){    // 给数组元素赋值，必须使用经典for
            arr[i] = (int)(Math.random() * 20);
        }
        // 使用foreach遍历数组
        for (int tmp : arr){
            System.out.print(tmp + " ");
        }
        System.out.println();
        // 0  1 2  3 4 5  6 7
        // 15 5 17 6 2 14 3 10
        // 选择排序：以位置为主导，让恰当的位置保存恰当的值
        for(int i = 0; i < arr.length - 1; i++){
            // 以i位置为基准位置，找出包括i位置在内到右面所有数中的最小值的下标
            int minIndex = i;   // 找出右面所有数据中的最小值的下标，初始值是基准位置
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;   // 保存值较小的元素的下标
                }
            }
            // minIndex 中保存的就是右侧最小值的下标，让它归位，归到基准位置
            int tmp = arr[i];
            arr[i] = arr[minIndex];     // 最关键操作，让最小值归位
            arr[minIndex] = tmp;
        }
        // 遍历排序后的数组
        for (int tmp: arr){
            System.out.print(tmp + " ");
        }
        System.out.println();
    }

    // 排序: 冒泡排序
    public static void main7(String[] args) {
        int[] arr = new int[8];
        for(int i = 0; i < arr.length; i++){    // 给数组元素赋值，必须使用经典for
            arr[i] = (int)(Math.random() * 20);
        }
        // 使用foreach遍历数组
        for (int tmp : arr){
            System.out.print(tmp + " ");
        }
        System.out.println();
        // 0  1 2  3 4 5  6 7
        // 15 5 17 6 2 14 3 10
        // 排序，升序
        // 冒泡排序: 思路是保证整体左小右大
        for (int i = 0; i < arr.length - 1; i++){       // 外层循环控制趟数
            for (int j = 0; j < arr.length - 1 - i; j++){   // 内存循环控制比较交换，次数随着趟数的增加而减少
                // 比较i位置和i+1位置的值，如果左大右小，交换它们，否则不动
                if(arr[j] > arr[j + 1]){
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        // 遍历数组
        for(int tmp: arr){
            System.out.print(tmp + " ");
        }
        System.out.println();
    }

    // 取子数组
    public static void main6(String[] args) {
        int[] arr = new int[20];
        for(int i = 0; i < arr.length; i++){    // 给数组元素赋值，必须使用经典for
            arr[i] = (int)(Math.random() * 20);
        }
        // 使用foreach遍历数组
        for (int tmp : arr){
            System.out.print(tmp + " ");
        }
        System.out.println();
        // 0 1 2 3  4  5  6  7
        // 9 8 5 16 19 16 14 9
        // 取子数组：把满足条件的一部分数据取出来放到一个新数组中

        // 练习：把所有奇数取出来
        // 1 创建新数组，容量跟老数组长度一样大，防止老数组中全是有效元素的情况
        int[] newArr = new int[arr.length];
        // 2 声明计数器，初值是0，表明没有元素插入，隐藏的作用是第一个有效元素向下标0位置插入
            // 作用有2个：a 本职工作：计数（新数组中的有效元素的个数），b 指示元素插入新数组的下标值。
        int count = 0;  // 它是算法的灵魂！
        // 3 遍历老数组，保证数据结构良好
        for(int i = 0 ; i < arr.length; i++){
            // 4 如果找到符合条件的元素
            if(arr[i] % 2 != 0){
                // 5 把符合条件的元素保存在新数组中，新数组下标由计算器控制
                newArr[count] = arr[i];
                // 6 调整计数器
                count++;
            }
        }
        // 7 创建最终数组，长度是计算器大小
        int[] finalArr = new int[count];
        // 8 依次把新数组中的所有有效元素赋值到最终数组中
        for(int i = 0; i < count; i++){
            finalArr[i] = newArr[i];
        }
        // 遍历最终数组
        for(int tmp : finalArr){
            System.out.print(tmp + " ");
        }
        System.out.println();
    }

    // 数组的扩容
    public static void main5(String[] args) {
        int[] arr = new int[10];
        for(int i = 0; i < arr.length; i++){    // 给数组元素赋值，必须使用经典for
            arr[i] = (int)(Math.random() * 20);
        }
        // 使用foreach遍历数组
        for (int tmp : arr){
            System.out.print(tmp + " ");
        }
        System.out.println();
        // 0 1 2 3  4  5  6  7
        // 9 8 5 16 19 16 14 9
        // 扩容
        // 1 创建新数组，容量比原来大
        int[] newArr = new int[(int)(arr.length * 1.5)];    // 扩容1.5倍长度
        // 2 依次包老数组中的有效元素复制到新数组中，以短数组为准
        for(int i = 0 ; i < arr.length; i++){
            newArr[i] = arr[i];
        }
        // 3 老引用指向新数组
        arr = newArr;
        // 遍历数组
        for(int tmp : arr){
            System.out.print(tmp + " ");
        }
        System.out.println();
    }

    // 数组的缩减
    public static void main4(String[] args) {
        int[] arr = new int[8];
        for(int i = 0; i < arr.length; i++){    // 给数组元素赋值，必须使用经典for
            arr[i] = (int)(Math.random() * 20);
        }
        // 使用foreach遍历数组
        for (int tmp : arr){
            System.out.print(tmp + " ");
        }
        System.out.println();
        // 0 1 2 3  4  5  6  7
        // 9 8 5 16 19 16 14 9
        // 数组的缩减
        // arr.length = arr.length / 2;
        // 1 创建一个容量小的新数组，数组中的所有元素都是缺省值
        int[] newArr = new int[arr.length / 2];
        // 2 依次包老数组中的有效元素复制到新数组中，复制次数是新数组的长度
        for(int i = 0 ; i < newArr.length; i++){    // 以短的数组下标为准
            newArr[i] = arr[i];
        }
        // 老引用指向新数组，老数组变垃圾数据
        arr = newArr;
        // 遍历数组，此时遍历的是缩减后的数组
        for(int tmp : arr){
            System.out.print(tmp + " ");
        }
        System.out.println();
    }

    // 翻转数组
    public static void main3(String[] args) {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) { // 要想给数组元素赋值, 必须经典for
            arr[i] = (int) (Math.random() * 20);
        }
        // 遍历数组
        for (int tmp : arr) {
            System.out.print(tmp + " ");
        }
        System.out.println();
        // 0 1  2  3  4  5 6 7
        // 1 15 17 1 12 17 6 4
        // 翻转数组
        for (int i = 0; i < arr.length / 2; i++){
            // 交换 i 和length - 1 - i 位置
            int tmp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = tmp;
        }
        // 遍历数组
        for (int tmp : arr){
            System.out.print(tmp + " ");
        }
        System.out.println();
    }

    // 找最大值
    public static void main2(String[] args) {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++){
            arr[i] = (int)(Math.random() * 100);
        }
        // 遍历数组
        for (int tmp : arr){
            System.out.print(tmp + " ");
        }
        System.out.println();
        // 0  1 2 3 4  5 6  7
        // 18 5 0 2 11 6 19 6
        // 找最大值
        int max = arr[0];
        for (int tmp : arr){
            if (tmp > max){
                max = tmp;
            }
        }
        System.out.println("max = " + max);

        // 通过下标找最大值
        int maxIndex = 0;   // 位置信息
        for (int i = 0; i < arr.length; i++){
            if (arr[i] < arr[maxIndex]){
                maxIndex = i;
            }
        }
        System.out.println("arr[maxIndex] = " + arr[maxIndex]);

        // 有条件找最大值，找奇数最大值
        int max2 = 0x80000000;
        for (int tmp : arr){
            if (tmp % 2 != 0){
                if (tmp > max2){
                    max2 = tmp;
                }
            }
        }
        if(max2 == 0x80000000){
            System.out.println("没有奇数");
        }else{
            System.out.println("最大奇数：" + max2);
        }

        // 有条件找最大值，找能被7整除的数的最大值，用下标的方式
        int maxIndex2 = -1; // 能被7整除的数现在还不存在
        for (int i = 0; i < arr.length; i++){
            if (arr[i] % 7 == 0){
                if(maxIndex2 == -1){
                    maxIndex2 = i;      // 找到了能被7整除的第一个数
                }else{
                    if(arr[i] > arr[maxIndex2]){
                        maxIndex2 = i;
                    }
                }
            }
        }
        if(maxIndex2 != -1){
            System.out.println("能被7整除的数：" + arr[maxIndex2]);
        }else {
            System.out.println("没有找到能被7整除的数");
        }
    }

    // 遍历数组有2中方式
    public static void main1(String[] args) {
        int[] arr = new int[8];
        for(int i = 0; i < arr.length; i++){    // 给数组元素赋值，必须使用经典for
            arr[i] = (int)(Math.random() * 20);
        }
        // 遍历数组
        for (int i = 0; i < arr.length; i++){
            int tmp = arr[i];
            System.out.print(tmp + " ");
        }
        System.out.println();

        // 遍历数组，并不影响原数组中的元素值
        for (int i = 0; i < arr.length; i++){
            int tmp = arr[i];
            tmp *= 10;  // 不影响数组元素值
            System.out.print(tmp + " ");
        }
        System.out.println();

        // 遍历数组有2中方式：
        // 1) 经典for循环
        // 2）增强型for循环或称为foreach：安全遍历，只读访问数组元素
        /*
        for (数组元素类型 临时变量 : 数组名){
            访问临时变量  // 安全遍历，只读访问数组元素
        }
        */
        // 安全遍历，只读访问数组元素
        for (int tmp : arr){
            tmp *= 20;
            System.out.print(tmp + " ");
        }
        System.out.println();
    }
}
