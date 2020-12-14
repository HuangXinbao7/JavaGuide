package com.xinbao.javase.chap02_basesystax;

import org.junit.Test;

public class IfTest {

    /**
     * 分支结构中的if-else（条件判断结构）
     */
    @Test
    public void test01() {
        // 举例1
        int heartBeats = 79;
        if(heartBeats < 60 || heartBeats > 100){
            System.out.println("需要做进一步检查");
        }
        System.out.println("检查结束");

        // 举例2
        int age = 23;
        if(age < 18){
            System.out.println("年龄小于18");
        }else{
            System.out.println("年龄大于18");
        }

        // 举例3
        if(age < 0){
            System.out.println("您输入的数据非法");
        }else if(age < 18){
            System.out.println("青少年时期");
        }else if(age < 35){
            System.out.println("青壮年时期");
        }else if(age < 60){
            System.out.println("中年时期");
        }else if(age < 120){
            System.out.println("老年时期");
        }else{
            System.out.println("你是要成仙啊~~");
        }
    }
}
