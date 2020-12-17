package com.xinbao.javase.chap04oop.basic.exer;

/**
 * 练习2
 * 利用面向对象的编程方法，设计类Circle计算圆的面积。
 */
public class CircleTest {

    public static void main(String[] args) {

        Circle c1 = new Circle();

        c1.radius = 2.1;

        //对应方式一：
		//double area = c1.findArea();
		//System.out.println(area);

        //对应方式二：
        c1.findArea();

        //错误的调用
		//double area = c1.findArea(3.4);
		//System.out.println(area);
    }
}


/**
 * 圆类
 */
class Circle{

    // 属性
    double radius;

    // 求圆的面积
    // 方式一：
	//public double findArea(){
	//	double area = Math.PI * radius * radius;
	//	return area;
	//}

    //方式二：
    public void findArea(){
        double area = Math.PI * radius * radius;
        System.out.println("面积为：" + area);
    }

    //错误情况：因为这种方式使用不到类中的属性radius，导致计算错误
	//public double findArea(double r){
	//	double area = 3.14 * r * r;
	//	return area;
	//}
}