package com.xinbao.javase.chap04oop.Intermediate.interview;

import java.util.Date;

/**
 * 面试题： == 和 equals() 区别
 * 
 * 一、回顾 == 的使用：
 * == ：运算符
 * 1. 可以使用在基本数据类型变量和引用数据类型变量中
 * 2. 如果比较的是基本数据类型变量：比较两个变量保存的数据是否相等。（不一定类型要相同）
 *    如果比较的是引用数据类型变量：比较两个对象的地址值是否相同.即两个引用是否指向同一个对象实体
 * 补充： == 符号使用时，必须保证符号左右两边的变量类型一致。
 * 
 * 二、equals()方法的使用：
 * 1. 是一个方法，而非运算符
 * 2. 只能适用于引用数据类型
 * 3. Object类中equals()的定义：
 *    public boolean equals(Object obj) {
	        return (this == obj);
	  }
 *    说明：Object类中定义的equals()和==的作用是相同的：比较两个对象的地址值是否相同.即两个引用是否指向同一个对象实体
 * 
 * 4. 像String、Date、File、包装类等都重写了Object类中的equals()方法。重写以后，比较的不是
 *    两个引用的地址是否相同，而是比较两个对象的"实体内容"是否相同。
 *    
 * 5. 通常情况下，我们自定义的类如果使用equals()的话，也通常是比较两个对象的"实体内容"是否相同。那么，我们
 *    就需要对Object类中的equals()进行重写.
 *    重写的原则：比较两个对象的实体内容是否相同.
 */
public class EqualsTest {
	public static void main(String[] args) {
		
		//基本数据类型
		int i = 10;
		int j = 10;
		double d = 10.0;
		System.out.println(i == j);	// true
		System.out.println(i == d);	// true
		
		boolean b = true;
		//System.out.println(i == b);	// int 类型和boolean类型之间不能进行比较
		
		char c = 10;
		System.out.println(i == c);		// true
		
		char c1 = 'A';
		char c2 = 65;
		System.out.println(c1 == c2);//true


		// 引用类型：
		Customer cust1 = new Customer("Tom", 21);
		Customer cust2 = new Customer("Tom", 21);
		System.out.println(cust1 == cust2);	// false
		
		String str1 = new String("atguigu");
		String str2 = new String("atguigu");
		System.out.println(str1 == str2);	// false
		System.out.println("****************************");
		System.out.println(cust1.equals(cust2));	// false--->true
		System.out.println(str1.equals(str2));		// true
		
		Date date1 = new Date(32432525324L);
		Date date2 = new Date(32432525324L);
		System.out.println(date1.equals(date2));	// true
	}


	public static class Customer {

		private String name;
		private int age;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public Customer() {
			super();
		}
		public Customer(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}

		//自动生成的equals()
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Customer other = (Customer) obj;
			if (age != other.age)
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}

		//重写的原则：比较两个对象的实体内容(即：name和age)是否相同
		//手动实现equals()的重写
//	@Override
//	public boolean equals(Object obj) {
//
////		System.out.println("Customer equals()....");
//		if (this == obj) {
//            return true;
//        }
//
//		if(obj instanceof Customer){
//			Customer cust = (Customer)obj;
//			//比较两个对象的每个属性是否都相同
////			if(this.age == cust.age && this.name.equals(cust.name)){
////				return true;
////			}else{
////				return false;
////			}
//
//			//或
//			return this.age == cust.age && this.name.equals(cust.name);
//		}else{
//			return false;
//
//		}
//
//	}
		//手动实现
//	@Override
//	public String toString() {
//		return "Customer[name = " + name + ",age = " + age + "]";
//	}
		//自动实现
		@Override
		public String toString() {
			return "Customer [name=" + name + ", age=" + age + "]";
		}
	}

}
