package com.atguigu.cms.view;

import com.atguigu.cms.domain.Customer;
import com.atguigu.cms.service.CustomerList;

public class CustomerView {

    //创建最大包含10客户对象的CustomerList 对象，供以下各成员方法使用。
    private CustomerList custList = new CustomerList(10);

    /**
     * 项目入口
     */
    public void enterMainMenu() { // 死循环
        // 声明布尔变量, 控制循环
        boolean loopFlag = true;
        // 写一个循环
        while (loopFlag) {
            // 打印主菜单
            System.out.println("-----------------客户信息管理软件-----------------");
            System.out.println("");
            System.out.println("        1 添 加 客 户");
            System.out.println("        2 修 改 客 户");
            System.out.println("        3 删 除 客 户");
            System.out.println("        4 客 户 列 表");
            System.out.println("        5 退       出");
            System.out.println("");
            System.out.print("请选择(1 - 5)：");
            // 使用工具类获取用户的选择
            char choice = CMUtility.readMenuSelection();
            // 对用户的选择
            switch (choice) {
                // 如果是'1' 调用 addNewCustomer();
                case '1' : addNewCustomer(); break;
                // 如果是'2' 调用 modifyCustomer();
                case '2' : modifyCustomer(); break;
                // 如果是'3' 调用 deleteCustomer();
                case '3' : deleteCustomer(); break;
                // 如果是'4' 调用 listAllCustomers();
                case '4' : listAllCustomers(); break;
                // 如果是'5' 设置循环布尔为false;
                case '5' :
                    System.out.print("确认是否退出(Y/N) : ");
                    char c = CMUtility.readConfirmSelection();
                    if (c == 'Y') {
                        loopFlag = false;
                    }
                    break;
            }
        }
    }

    private void addNewCustomer() {
        System.out.println("---------------------添加客户---------------------");
        System.out.print("姓名：");
        //通过工具类真的获取用户从键盘输入的字符串
        String name = CMUtility.readString(10);
        System.out.print("性别：");
        //通过工具类真的获取用户从键盘输入的字符
        char gender = CMUtility.readChar();
        System.out.print("年龄：");
        //通过工具类真的获取用户从键盘输入的整数
        int age = CMUtility.readInt();
        System.out.print("电话 : ");
        //通过工具类真的获取用户从键盘输入的字符串
        String phone = CMUtility.readString(15);
        System.out.print("邮箱：");
        //通过工具类真的获取用户从键盘输入的字符串
        String email = CMUtility.readString(50);

        // 创建一个Customer对象.
        Customer customer = new Customer(name, gender, age, phone, email);
        // 给管理器对象添加, 通过调用它的方法添加
        boolean flag = this.custList.addCustomer(customer);
        if (flag) {
            System.out.println("---------------------添加完成---------------------");
        } else {
            System.out.println("---------------------添加失败, 容量已满.---------------------");
        }
        listAllCustomers();
    }

    private void modifyCustomer() {
        System.out.println("---------------------修改客户---------------------");
        System.out.print("请选择待修改客户编号(-1退出)：");
        // 通过工具类获取用户输入的整数
        int no = CMUtility.readInt();
        // 如果这个整数是-1, 方法提前返回, 就不修改了
        if (no == -1) {
            return;
        }
        // 根据编号获取要修改的目标对象
        Customer target = custList.getCustomer(no - 1);
        // 如果获取到的目标对象为空, 打印错误, 并提前返回
        if (target == null) {
            System.out.println("编号错误!!");
            return;
        }
        System.out.println("<直接回车表示不修改>");

        System.out.print("姓名(" + target.getName() + ")：");
        // 通过调用工具方法获取用户输入的新姓名
        String name = CMUtility.readString(10, target.getName());
        // 无条件设置目标对象的name属性
        target.setName(name);

        System.out.print("性别(" + target.getGender() + ")：");
        char gender = CMUtility.readChar(target.getGender());
        // 无条件设置目标对象的gender属性.
        target.setGender(gender);

        System.out.print("年龄(" + target.getAge() + ")：");
        int age = CMUtility.readInt(target.getAge());
        target.setAge(age);

        System.out.print("电话(" + target.getPhone() + ")：");
        String phone = CMUtility.readString(15, target.getPhone());
        target.setPhone(phone);

        System.out.print("邮箱(" + target.getEmail() + ")：");
        String email = CMUtility.readString(50, target.getEmail());
        target.setEmail(email);
        System.out.println("---------------------修改完成---------------------");
        listAllCustomers();
    }

    private void deleteCustomer() {
        System.out.println("---------------------删除客户---------------------");
        System.out.print("请选择待删除客户编号(-1退出)：");
        // 通过工具类获取用户输入的整数
        int no = CMUtility.readInt();
        // 如果这个整数是-1, 方法提前返回, 就不删除了
        if (no == -1) {
            return;
        }
        System.out.print("确认是否删除(Y/N)：");
        char confirm = CMUtility.readConfirmSelection(); // 返回的一定是大Y或大N
        if (confirm == 'Y') {
            // ? 根据用户编号 从管理器中删除指定元素
            boolean flag = custList.deleteCustomer(no - 1);
            if (flag) {
                System.out.println("---------------------删除完成-------------------- -");
            } else {
                System.out.println("---------------------删除失败, 编号错误!-------------------- -");
            }
        }
        listAllCustomers();
    }

    private void listAllCustomers() {
        System.out.println("---------------------------客户列表---------------------------");
        System.out.println("编号\t姓名\t性别\t年龄\t电话\t邮箱");
        // 真的获取到所有客户, 向管理器要, 调用方法, 再遍历打印输出
        Customer[] allCustomers = custList.getAllCustomers();
        for (int i = 0; i < allCustomers.length; i++) { // 有风险吗?
            System.out.println((i + 1) + "\t\t" + allCustomers[i].say());
        }
        System.out.println("-------------------------客户列表完成-------------------------");
    }
}
