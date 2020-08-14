public class StringTest3 {

	public static void main(String[] args) {
		// 字符串 , 由一系列字符串起来
		String s1 = "abc100"; 
		String s2 = ""; // 空串, 含义是有字符串对象, 但是里面没有内容
		String s3 = null; // s3是空地址, 含义是什么也没有, 当然也不可能有内容
	
		// 字符串可以和任意数据作拼接, 拼接的结果是原内容加上新内容的新字符串
		// 字符串是内容不可以改变的对象, 所以任何的字符串连接都会产生新对象.
		s1 = s1 + 300; // 字符串连接
		System.out.println(s1);
		s1 = s1 + '男'; // 拼接字符
		System.out.println(s1);
		s1 = s1 + 3.22; // 拼接double
		System.out.println(s1); 
		s1 = s1 + true; // 拼接boolean
		System.out.println(s1);
		s1 = s1 + "我是汉字";
		System.out.println(s1);
		
		s2 = s2 + 100;
		System.out.println(s2); // "100"
		
		// 把基本数据类型的值 -> 字符串, 用一个""和基本数据值拼接即可.
		//String s4 = 300; 不可以这样做
		String s4 = "" + 300; // "300"
		String s5 = "" + .382; // "0.382"
		System.out.println(s4);
		System.out.println(s5);
		
		String s6 = "300"; // 字符串字面量
		s3 = s3 + 400;
		System.out.println(s3);
		
		//String s7 = null + 500; // null是极特殊数据, 没有类型
		// 字符串 -> 基本数据值, int n = Integer.parseInt("2938"); // 把字符串内容的整数变成真的整数
		String s7 = "982"; // 内容必须是有效整数
		//int n2 = s7; // 这样做也不可以, 因为右面是引用, 左边是int型变量
		int n2 = Integer.parseInt(s7);// 内容必须是有效整数, 否则会出错
		System.out.println(n2);
		
		s7 = s7 + "abc" + 200 + ",hello" + false + s6;
		System.out.println(s7);
		
		//String str1 = 4;        //判断对错：
		String str2 = 3.5f + "";             //判断str2对错：System.out.println(str2);        //输出：
		System.out.println(3+4+"Hello!");      //输出：
		System.out.println("Hello!"+3+4);      //输出：
		System.out.println('a'+1+"Hello!");    //输出：
		System.out.println("Hello"+'a'+1);            //输出：

	}
}