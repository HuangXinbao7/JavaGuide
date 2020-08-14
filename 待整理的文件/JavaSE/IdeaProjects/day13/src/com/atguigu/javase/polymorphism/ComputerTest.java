package com.atguigu.javase.polymorphism;

import sun.plugin.com.event.COMEventHandler;

public class ComputerTest {

    /*
    在Test类中提供一个静态方法listPrice,以Computer引用变量为参数，打印输出电脑价格。
    在main方法中，分别以Computer、PC、NotePad对象为参数，调用listPrice方法。
    在方法listPrice中，判断Computer参数的真实对象，并调用不同对象上的特有方法
    */
    public static void listPrice(Computer com) {    // 多态参数
        System.out.println("价格：" + com.getPrice());
        if(com instanceof NotePad) {
            NotePad np = (NotePad)com;
            np.navigate();
        }else if (com instanceof PC) {
            ((PC)com).code();
        }else {
            System.out.println("普通电脑");
        }
    }

    public static void main(String[] args) {
        Computer np = new NotePad(2.0, 3, 32, 2899, 4);
        PC pc = new PC(4.8, 32, 256, 5999, "小米机械");
        Computer com = new Computer(3.0, 8, 512, 4999);

        listPrice(np);
        listPrice(pc);
        listPrice(com);
    }


    public static void main2(String[] args) {
        Computer[] arr = new Computer[6];
        arr[0] = new NotePad(2.0, 4, 32, 1500, 2);
        arr[1] = new PC(4.8, 8, 128, 4000, "小米键盘");
        arr[2] = new Computer(3.0, 16, 256, 5000);
        arr[3] = new NotePad(2.0, 4, 32, 3600, 4);
        arr[4] = new PC(3.2, 8, 32, 1500, "樱桃原装");
        arr[5] = new Computer(3.0, 16, 512, 6000);

        for(Computer tmp: arr) {
            System.out.println(tmp.getDetails());
        }
        System.out.println("**********************");

        // 选择排序
        for(int i = 0; i < arr.length - 1 ; i++) {
            // 以 i 为基准位置
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++) {
                if (arr[j].getPrice() < arr[minIndex].getPrice()) {
                    minIndex = j;
                }
            }

            if(i != minIndex) {     // 如果基准位置保存的已经是最小值，就不用交换，反之才交换
                //
                Computer tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
            }
        }

        for(Computer tmp: arr) {
            System.out.println(tmp.getDetails());
        }
        System.out.println("****************");
    }


    public static void main1(String[] args) {
        //Computer com1 = new PC(3.8, 8, 256, "小米键盘");
        //System.out.println(com1.getDetails());  // 虚拟方法调用
        //
        //com1 = new NotePad(2.2, 2, 128, 5);
        //System.out.println(com1.getDetails());
    }
}
