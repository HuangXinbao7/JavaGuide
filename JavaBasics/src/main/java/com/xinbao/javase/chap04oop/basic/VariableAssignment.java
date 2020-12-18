package com.xinbao.javase.chap04oop.basic;

import org.junit.Test;


public class VariableAssignment {

    /**
     * 变量的赋值：
     * 如果变量是基本数据类型，此时赋值的是变量所保存的数据值。
     * 如果变量是引用数据类型，此时赋值的是变量所保存的数据的地址值。
     */
    @Test
    public void test1() {
        System.out.println("***********基本数据类型：****************");
        int m = 10;
        int n = m;
        System.out.println("m = " + m + ", n = " + n);
        //
        n = 20;
        System.out.println("m = " + m + ", n = " + n);

        System.out.println("***********引用数据类型：****************");
        Order o1 = new Order();
        o1.orderId = 1001;
        Order o2 = o1;  // 赋值以后，o1和o2的地址值相同，都指向了堆空间中同一个对象实体。
        System.out.println("o1.orderId = " + o1.orderId + ",o2.orderId = " + o2.orderId);
        o2.orderId = 1002;
        System.out.println("o1.orderId = " + o1.orderId + ",o2.orderId = " + o2.orderId);
    }


    /**
     * 方法的形参的传递机制：值传递
     * <p>
     * 1.形参：方法定义时，声明的小括号内的参数
     * 实参：方法调用时，实际传递给形参的数据
     * <p>
     * 2.值传递机制：
     * 如果参数是基本数据类型，此时实参赋给形参的是实参真实存储的数据值。
     * 如果参数是引用数据类型，此时实参赋给形参的是实参存储数据的地址值。
     */
    @Test
    public void test2() {
        int m = 10;
        int n = 20;

        System.out.println("m = " + m + ", n = " + n);

        VariableAssignment assignment = new VariableAssignment();
        assignment.swap(m, n);
        System.out.println("m = " + m + ", n = " + n);


    }

    public void swap(int m, int n) {
        int temp = m;
        m = n;
        n = temp;
    }


    @Test
    public void test3() {

        Data data = new Data();

        data.m = 10;
        data.n = 20;
        System.out.println("m = " + data.m + ", n = " + data.n);

        VariableAssignment assignment = new VariableAssignment();
        assignment.swap(data);

        System.out.println("m = " + data.m + ", n = " + data.n);
    }

    public void swap(Data data){
        int temp = data.m;
        data.m = data.n;
        data.n = temp;
    }
}


class Order{
    int orderId;
}

class Data{
    int m;
    int n;
}
