package com.atguigu.javase.interfacetest;

//定义一个接口用来实现两个对象的比较。表达对象的比较能力
interface CompareObject {
    //若返回值是 0 , 代表相等; 若为正数，代表当前对象大；负数代表当前对象小
    public int compareTo(Object o);
}

/*定义一个Circle类。包含属性半径，再定义一个ComparableCircle类，继承Circle类并且实现CompareObject接口。
        在ComparableCircle类中给出接口中方法compareTo的实现体，用来比较两个圆的半径大小。
定义一个测试类TestInterface，创建两个ComparableCircle对象，调用compareTo方法比较两个类的半径大小。
 */
class Circle {

    private int radius;

    public Circle() {
    }

    public Circle(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}

class ComparableCircle extends Circle implements CompareObject {

    public ComparableCircle() {
    }

    public ComparableCircle(int radius) {
        super(radius);
    }

    //若返回值是 0 , 代表相等; 若为正数（实际返回1），代表当前对象大；负数（实际返回-1）代表当前对象小
    @Override public int compareTo(Object o) { // 方法在实现时必须依照接口要求
        if (!(o instanceof ComparableCircle)) { // 造型有风险， 必须先判断
            return 0x7FFFFFFF; // 返回特殊值表示对象不可比
        }
        // 比较this对象的半径 和 o对象的半径
        ComparableCircle right = (ComparableCircle)o;
        if (this.getRadius() > right.getRadius()) { // 左大右小
            return 1;
        } else if (this.getRadius() < right.getRadius()) { // 左小右大
            return -1;
        } else {
            return 0;
        }
    }
}

public class InterfaceTest {

    public static void main(String[] args) {
        ComparableCircle c1 = new ComparableCircle(200);
        ComparableCircle c2 = new ComparableCircle(1120);

        // 以接口为准. 体现更好的兼容性, 面向接口编程: 只看接口, 不看子类.
        int n = c1.compareTo(c2);
        if (n > 0) { //if (n == 1) { // 在主方法中判断应该以子类为准，还是以接口为准？？？
            System.out.println(c1 + "大于" + c2);
        } else if (n < 0) { // (n == -1) {
            System.out.println(c1 + "小于" + c2);
        } else {
            System.out.println(c1 + "等于" + c2);
        }
    }
}
