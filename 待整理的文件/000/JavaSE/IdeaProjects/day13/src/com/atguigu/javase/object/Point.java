package com.atguigu.javase.object;

/**
 * equals方法的作用是判断对象的内容是否相等, 默认的方法非常烂, 子类必须重写才行.
 * 哈希码 :
 *      也称为散列码. 对象在内存中不要重叠, 尽量散开.
 *      又称为特征码. 和对象的内容的相关体现的码值. 根据属性值计算的码值.
 *          和MD5码值的机制一样,  MD5码值根据文件中的每个字节计数出来
 *
 * 如果两个对象的equals为true, 说明两个对象的内容相等, 内容相等就要保证两个对象的特征码必须相等. 体现特征码的特性
 * 如果两个对象的equals为false, 说明两个对象的内容不等. 内容不等, 两个对象必须散列. 体现散列性.
 *
 * 如果两个对象的哈希码相等, 说明两个对象的内容相等, equals必须为true
 * 如果两个对象的哈希码不等, 说明两个对象的内容不等, equals必须为false
 *
 * equals方法和hashCode方法必须同时出现.
 *
 */
public class Point extends Object {

    private int x;
    private int y;

    public Point() {}

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public String say(){
        return "x: " + x + ", y: " + y;
    }

    /*
    从Object父类中继承的方法。默认的方法是比较地址。
    这个方法写的过于简单，必须在子类中重写！
    public boolean equals(Object obj) {
        return (this == obj);
    }
    */
    @Override
    public boolean equals(Object obj){  // 多态参数方法
        // 重写以后的方法应该满足对象内容的比较.两个对象是this和obj
        // 所谓的内容是对象的所有属性值
        if(obj instanceof Point) {
            Point p = (Point)obj;
            if(this.x == p.x && this.y == p.y) {
                return true;
            }
        }
        return false;
    }

    // 这是Object类中的hashCode方法, 只体现了散列性. 底层是根据对象的物理地址, 进行散列算法得到的
    // public native int hashCode(); 实际执行时 定位的是动态库中的C++代码
    @Override
    public int hashCode() {
        // 方法中要兼顾特征性和散列性, 所有属性必须参与.
        return Integer.parseInt(x + "000" + y);
    }

}
