package com.atguigu.team.service;

import com.atguigu.team.domain.*;

public class CompanyService {

    // 保存所有员工对象，包括普通员工，程序员，设计师，架构师
    private Employee[] employees;

    public CompanyService() {

        Equipment[] eqs = new Equipment[Data.EQUIPMENTS.length];
        // 遍历二维数组
        for(int i = 0; i < Data.EQUIPMENTS.length; i++) {
            // 创建一维的子数组对象，存放二维数组中的子数组元素
            String[] child = Data.EQUIPMENTS[i];
            // 如果子数组长度为 0，则跳过，继续遍历下一个元素
            if(child.length == 0) {
                continue;
            }

            // 获取识别码, 子数组下标为0的元素
            int code = Integer.parseInt(child[0]);
            // 分支识别码
            switch (code) {
                case Data.PC:       // PC：21, model, display
                    eqs[i] = new PC(child[1], child[2]);
                    break;
                case Data.NOTEBOOK: // NoteBook: 22, model, price
                    eqs[i] = new NoteBook(child[1], Integer.parseInt(child[2]));
                    break;
                case Data.PRINTER:  // Printer: 23, type, name
                    eqs[i] = new Printer(child[1], child[2]);
                    break;
            }
        }

        this.employees = new Employee[Data.EMPLOYEES.length];
        for(int i = 0; i < employees.length; i++) {

            String[] child = Data.EMPLOYEES[i];
            // 获取识别码, 子数组下标为0的元素
            int code = Integer.parseInt(child[0]);

            // 获取创建员工对象的参数:
            // {"13", "2", "令狐冲", "32", "18000", "15000", "2000"},
            int id = Integer.parseInt(child[1]);
            String name = child[2];
            int age = Integer.parseInt(child[3]);
            double salary = Integer.parseInt(child[4]);
            Status status = Status.FREE;

            // 分支识别码
            switch (code) {
                case Data.EMPLOYEE:     // Employee     : 10, id, name, age, salary
                    this.employees[i] = new Employee(id, name, age, salary);
                    break;
                case Data.PROGRAMMER:   // Programmer   : 11, id, name, age, salary
                    // 关联的设备从 eqs 数组中取
                    this.employees[i] = new Programmer(
                            id,
                            name,
                            age,
                            salary,
                            0,
                            status,
                            eqs[i]);
                    break;
                case Data.DESIGNER:     // Designer     : 12, id, name, age, salary, bonus
                    this.employees[i] = new Designer(
                            id,
                            name,
                            age,
                            salary,
                            0,
                            status,
                            eqs[i],
                            Integer.parseInt(child[5]));
                    break;
                case Data.ARCHITECT:    // Architect    : 13, id, name, age, salary, bonus, stock
                    this.employees[i] = new Architect(
                            id,
                            name,
                            age,
                            salary,
                            0,
                            status,
                            eqs[i],
                            Integer.parseInt(child[5]),
                            Integer.parseInt(child[6]));
                    break;
            }
        }
    }

    /**
     * 方法：获取当前所有员工。
     * 返回：包含所有员工对象的数组
     */
    public Employee[] getAllEmployees() {
        return employees;
    }

    /**
     * 方法：获取指定ID的员工对象。
     *     参数：指定员工的ID
     *     返回：指定员工对象
     *     异常：找不到指定的员工
     */
    public Employee getEmployee(int id) throws TeamException {
        // 遍历数组
        for (int i = 0; i < employees.length; i++) {
            // 如果某元素的员工id == 参数id
            if (employees[i].getId() == id) {
                //返回此元素
                return employees[i];
            }
        }
        // 抛出异常 自定义异常
        throw new TeamException("找不到指定ID[" + id + "]的员工");
    }
}
