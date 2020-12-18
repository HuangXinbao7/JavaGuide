package com.atguigu.javase.interfacetest;

/**
 * 综合练习：
 * 1、定义一个接口用来实现两个对象的比较。
 * interface CompareObject{
 *  //若返回值是 0 , 代表相等; 若为正数，代表当前对象大；负数代表当前对象小
 * 	public int compareTo(Object o);
 * }
 * 2、定义一个Circle类。包含半径。
 * 3、定义一个 ComparableCircle类，继承Circle类并且实现CompareObject接口。在ComparableCircle类中给出接口中方法compareTo的实现体，用来比较两个圆的半径大小。
 * 4、定义一个测试类TestInterface，创建两个ComparableCircle对象，调用compareTo方法比较两个类的半径大小。
 */
// 1、定义一个接口用来实现两个对象的比较。表达对象的比较能力
interface CompareObject {
    // 若返回值是 0，代表相等；正数代表当前对象大；负数表示当前对象小。
    public int compareTo(Object obj);   // 抽象方法，this对象和参数中的obj对象进行比较
}


// 2、定义一个Circle类。包含半径，
class Circle {

    private double radius; // 半径

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}


// 3、定义一个 ComparableCircle类，继承Circle类并且实现CompareObject接口。在ComparableCircle类中给出接口中方法compareTo的实现体，用来比较两个圆的半径大小。
class ComparableCircle extends Circle implements CompareObject {

    public ComparableCircle() {
    }

    public ComparableCircle(double radius) {
        super(radius);
    }

    // 若返回值是0，表示相等；正数（实际返回1）表示当前对象大；负数（实际返回-1）表示当前对象小。
    @Override
    public int compareTo(Object obj) {      // 方法在实现时必须依照接口要求，以接口为准
        // 比较this对象的半径和obj对象的半径
        if(!(obj instanceof ComparableCircle)) {   // 造型有风险，必须先判断
            return 0x7FFFFFFF;  // 返回一个特殊值，表示对象不可比较
        }
        ComparableCircle right = (ComparableCircle)obj;     // 造型
        if(this.getRadius() > right.getRadius()) {  // 左大右小
            return 1;
        } else if (this.getRadius() < right.getRadius()) {  // 左小右大
            return -1;
        } else {
            return 0;
        }
    }
}

// * 4、定义一个测试类TestInterface，创建两个ComparableCircle对象，调用compareTo方法比较两个类的半径大小。
public class InterfaceTest {

    public static void main(String[] args) {
        ComparableCircle c1 = new ComparableCircle(100);
        ComparableCircle c2 = new ComparableCircle(50);

        // 以接口为准。体现更好的兼容性。面向接口编程，只看接口，不看子类
        // 因为子类是特殊的，接口是通用的。
        //int n = c1.compareTo("abc");
        //System.out.println(n);      // 2147483647

        int n = c1.compareTo(c2);
        //System.out.println(n);
        if(n > 0) {    // 在主方法中判断的依据应该以子类为准还是以接口为准？？？ 接口 ！！！
            System.out.println(c1 + " 大于 " + c2);
        }else if(n < 0) {
            System.out.println(c1 + " 小于 " + c2);
        }else{
            System.out.println(c1 + " 等于 " + c2);
        }
    }
}
