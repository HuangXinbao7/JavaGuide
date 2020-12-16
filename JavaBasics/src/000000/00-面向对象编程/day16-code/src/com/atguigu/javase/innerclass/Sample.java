package com.atguigu.javase.innerclass;

interface A {
    public abstract void fun1();
}
class C implements A {
    @Override
    public void fun1() {
        System.out.println("C implements");
    }
}

public class Sample {

    public static void main(String[] args) {
        /*
        new Sample().callInner(new A() {
            //接口是不能new但此处比较特殊是子类对象实现接口，只不过没有为对象取名
            @Override public void fun1() {
                System.out.println("implement for fun1");
            }
        });// 两步写成一步了
         */
        Sample sample = new Sample();
        A aa = new A() {
            @Override
            public void fun1() {
                System.out.println("实现了fun1");
            }
        };
        sample.callInner(aa);

        C c = new C();
        sample.callInner(c);
    }

    public void callInner(A a) {
        a.fun1(); // 虚拟方法
    }
}


