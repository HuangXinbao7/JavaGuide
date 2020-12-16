package com.atguigu.cms.main;

import com.atguigu.cms.domain.Customer;
import com.atguigu.cms.service.CustomerList;
import com.atguigu.cms.view.CustomerView;

public class CustomerMain {

    public static void main(String[] args) {
        CustomerView customerView = new CustomerView();
        customerView.enterMainMenu(); // 一旦调用此方法,不能轻易返回
    }

    public static void main2(String[] args) {
        Customer cust1 = new Customer("张一", '男', 10, "34234234", "zhang1@qq.com");
        Customer cust2 = new Customer("张二", '女', 20, "34234234", "zhang2@qq.com");
        Customer cust3 = new Customer("张三", '男', 30, "34234234", "zhang3@qq.com");
        Customer cust4 = new Customer("张四", '女', 40, "34234234", "zhang4@qq.com");
        Customer cust5 = new Customer("张五", '女', 50, "34234234", "zhang5@qq.com");
        Customer cust6 = new Customer("张六", '男', 60, "34234234", "zhang6@qq.com");
        Customer cust7 = new Customer("张七", '女', 70, "34234234", "zhang7@qq.com");
        Customer cust8 = new Customer("张八", '男', 80, "34234234", "zhang8@qq.com");

        System.out.println(cust1.say());
        System.out.println(cust2.say());
        System.out.println(cust3.say());
        System.out.println(cust4.say());
        System.out.println(cust5.say());
        System.out.println(cust6.say());
        System.out.println(cust7.say());
        System.out.println(cust8.say());

        System.out.println("************************************");

        // 创建管理器对象, 内部数组长度由参数控制
        CustomerList customerList = new CustomerList(8);
        // addCustomer是封装在对象中的功能, 完成添加任务, 面向对象 : 关注的是具有功能的对象.
        boolean b1 = customerList.addCustomer(cust4); // 张四
        boolean b2 = customerList.addCustomer(cust5); // 张五
        boolean b3 = customerList.addCustomer(cust1); // 张一
        boolean b4 = customerList.addCustomer(cust2); // 张二
        boolean b5 = customerList.addCustomer(cust3); // 张三
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
        System.out.println(b4);
        System.out.println(b5);
        //Customer[] customers = customerList.getCustomers(); // 这个方法不好
        /* 不要这样做的原因是, 添加功能我想让customerList对象自己完成
        customers[0] = cust1;
        customers[1] = cust2;
        customers[2] = cust3;
        */
        /* 这个数组不好用
        for (int i = 0; i < customers.length; i++) { // 数组完美吗??? ,有空洞
            if (customers[i] != null) {
                System.out.println(customers[i].say());
            } else {
                System.out.println(customers[i]);
            }
        }*/

        //customerList.setRealCount(2);

        Customer[] allCustomers = customerList.getAllCustomers();
        for (int i = 0; i < allCustomers.length; i++) { // 数组完美吗?
            System.out.println(allCustomers[i].say());
        }

        System.out.println("********************************");

        Customer customer = customerList.getCustomer(2000);
        if (customer == null) {
            System.out.println("数据不合法!!!");
        } else {
            System.out.println(customer.say());
        }

        boolean flag = customerList.deleteCustomer(2); // 删除或添加完成后都需要重新获取完美数组
        System.out.println(flag);
        // 遍历
        Customer[] allCustomers2 = customerList.getAllCustomers();
        for (int i = 0; i < allCustomers2.length; i++) { // 数组完美吗?
            System.out.println(allCustomers2[i].say());
        }
    }
}
