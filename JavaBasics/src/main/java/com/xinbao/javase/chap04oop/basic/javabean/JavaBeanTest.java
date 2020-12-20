package com.xinbao.javase.chap04oop.basic.javabean;

/**
 * JavaBean是一种Java语言写成的可重用组件。
 * 所谓JavaBean，是指符合如下标准的Java类：
 * 		>类是公共的
 * 		>有一个无参的公共的构造器
 * 		>有属性，且有对应的get、set方法
 */
public class JavaBeanTest {		// 类是公共的

	// 有属性
	private int id;
	private String name;

	// 有一个无参的公共的构造器
	public JavaBeanTest(){}

	// 且有对应的get、set方法
	public void setId(int i){
		id = i;
	}
	public int getId(){
		return id;
	}
	public void setName(String n){
		name = n;
	}
	public String getName(){
		return name;
	}
}
