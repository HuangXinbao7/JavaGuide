package com.atguigu.javase.interfacetest;

/**
 * 代理 : 把代理对象当成被代理对象来使用
 * 场景 :
 *      1) 使用者无法直接获取到被代理对象
 *      2) 有对被代理对象的业务方法升级的需要, 但是不能修改被代理类.
 */
interface HouseRent {
    void rent();
}

// 被代理对象
class FangDong implements HouseRent {
    @Override
    public void rent() {
        System.out.println("我有房子出租, 是婚房, 装修好, 请爱护, 房租账号:34234234234");
    }
}

class FangDong2 implements HouseRent {
    @Override
    public void rent() {
        System.out.println("我也有房子租, 刚死了2个人, 晚上要小心");
    }
}

// 代理对象
class LianJia implements HouseRent {

    // 使用对象关联, 来实现最终的代理
    private HouseRent fangDong = new FangDong();

    @Override
    public void rent() {
        // 真正出租的房子是 房东的
        System.out.println("先交中介费20000");
        fangDong.rent(); // 被代理对象
        System.out.println("要准时交房租, 不然赶走.. 支持微信,支付宝");
    }

}


public class ProxyTest {

    public static void main(String[] args) {
        // 客户. 不能直接找到房东, 目标只有一个就是接口业务
        HouseRent hr = new LianJia();
        hr.rent();
    }
}
