package com.atguigu.javase.homework;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

// 创建两个参数一样的鼠标, 判断两个鼠标是否相等, 如果不等该怎么办? 两个鼠标特征码如何?
public class MouseTest {

    public static void main(String[] args) {
        // 创建两个参数一样的鼠标
        Mouse m1 = new Mouse(1001, "鼠标1", "工厂1", 99, "白色");
        Mouse m2 = new Mouse(1001, "鼠标1", "工厂1", 99, "白色");

        // 判断两个鼠标是否相等
        System.out.println(m1 == m2);       // false
        System.out.println(m1.equals(m2));  // false

        // 两个鼠标特征码
        System.out.println(m1.hashCode());
        System.out.println(m2.hashCode());
    }



}
