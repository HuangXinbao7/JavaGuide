package com.atguigu.javase.homework;

/**
 * 代理模式
 */
interface HouseRent {
    void rant();
}

// 被代理对象1
class FangDong implements HouseRent {
    @Override
    public void rant() {
        System.out.println("租房1");
    }
}
// 被代理对象2
class FangDong2 implements HouseRent {
    @Override
    public void rant() {
        System.out.println("租房2");
    }
}

// 代理对象
class LianJia implements HouseRent {

    // 使用对象关联，来实现最终代理
    private HouseRent fangDong1 = new FangDong();
    private HouseRent fangDong2 = new FangDong2();


    @Override
    public void rant() {
        System.out.println("==");
        fangDong1.rant();        // 被代理对象
        fangDong2.rant();        // 被代理对象
        System.out.println("==");
    }
}


public class ProxyTest {

    public static void main(String[] args) {
        // 客户，不能直接找到房东。目标只有一个就是接口业务
        HouseRent hr = new LianJia();
        hr.rant();
    }
}
