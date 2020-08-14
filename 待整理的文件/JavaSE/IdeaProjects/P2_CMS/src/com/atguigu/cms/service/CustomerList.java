package com.atguigu.cms.service;

import com.atguigu.cms.domain.Customer;

// 它永远是被动的调用的. 它是一个Customer对象的管理器
public class CustomerList {

    // 这两个属性具有强烈的逻辑性和逻辑关系, 所以必须完全封装...
    // 用来保存客户对象的数组
    private Customer[] customers;
    // 记录已保存客户对象的数量, 计数器
    private int realCount = 0; // 它仍然是灵魂!!!!!!!

    /*用途：构造器，用来初始化customers数组
    参数：totalCount：指定customers数组的最大空间*/
    public CustomerList(int toalCount) {
        this.customers = new Customer[toalCount]; // 数组的创建的容量的权力交给调用者.
    }

    /**
     * 用途：将参数customer添加组中最后一个客户对象记录之后
 *     参数：customer指定要添加的客户对象
 *     返回：添加成功返回true；false表示数组已满，无法添加
     */
    public boolean addCustomer(Customer customer) { // 张一
        // 这个方法会被多次调用, 每调用一次参数中的对象都要自动插入数组
        if (realCount == customers.length) {//if (数组已满) {
            return false;
        }
        this.customers[realCount] = customer; // 张一
        realCount++;
        return true; // 表示添加成功
    }

    /**
     * 用途：返回数组中记录的所有客户对象
     * 返回： Customer[] 数组中包含了当前所有客户对象，该数组长度与对象个数相同。
     * 返回完美数组, 用计数器控制
     */
    public Customer[] getAllCustomers() {
        // 1) 创建新数组, 用于保存所有有效对象
        Customer[] newArr = new Customer[realCount];
        // 2) 依次把数组中的所有有效对象复制到新数组中
        for (int i = 0; i < realCount; i++) {
            newArr[i] = this.customers[i];
        }
        // 3) 返回新数组
        return newArr;
    }

    /*用途：返回参数index指定索引位置的客户对象记录
    参数： index指定所要获取的客户对象在数组中的索引位置
    返回：封装了客户信息的Customer对象*/
    public Customer getCustomer(int index) {
        // if (参数中的下标值不在有效范围内) 提前返回null, 防止出现越界异常
        if (index < 0 || index >= realCount) {
            return null;
        }
        return customers[index];
    }

    /**
     * 用途：从数组中删除参数index指定索引位置的客户对象记录
     * 参数： index指定所删除对象在数组中的索引位置
     * 返回：删除成功返回true；false表示索引无效，无法删除
     */
    public boolean deleteCustomer(int index) {
        if (index < 0 || index >= realCount) {
            return false; // 删除失败
        }
        // 1) 把要删除的下标位置处置为空洞
        this.customers[index] = null;
        // 2) 从要删除的下标位置开始依次把右侧相邻元素复制到左边. 控制好循环
        for (int i = index; i < realCount - 1; i++) { // 到有效元素的倒数第二个就是最后一次复制.
            customers[i] = customers[i + 1];
        }
        // 3) 把之前的最后有效元素位置处置空洞
        customers[realCount - 1] = null;
        // 4) 调整计数器
        realCount--;
        return true;
    }

}
