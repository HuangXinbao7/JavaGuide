//package com.atguigu.java;

/**
 *
 */
public class ArrayTest {
	
	public static void main(String[] args) {
		
		// 1 一维数组的声明和初始化
		int[] arr = new int[3];		// 声明
		// 1.1 静态初始化: 数组的初始化和数组元素的赋值操作同时进行
		arr = new int[]{1001,1002,1003,1004};
		// 1.2 动态初始化: 数组的初始化和数组元素的赋值操作分开进行
		// 总结：数组一旦初始化完成，其长度就确定了。
		String[] names = new String[5];
		names[0] = "王铭";
		names[1] = "王赫";
		names[2] = "张学良";
		names[3] = "孙居龙";
		names[4] = "王宏志";//charAt(0)

		// 声明数组的错误写法：
		//int[] arr1 = new int[];
		//int[5] arr2 = new int[5];
		//int[] arr3 = new int[3]{1,2,3};
		// 正确的写法：
		int[] arr4 = {1,2,3,4,5};	//类型推断

		
		// 2. 如何调用数组的指定位置的元素:通过角标的方式调用。
		//数组的角标（或索引）从0开始的，到数组的长度-1结束。
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
		}
		
		// 3. 获取数组的长度。
		// 属性:length
		System.out.println(arr.length);		// 4
		System.out.println(names.length);	// 5

		
		// 4 如何遍历数组
		for(int i = 0;i < names.length;i++){
			System.out.println(names[i]);
		}
	}
}
