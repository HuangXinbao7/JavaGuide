package com.atguigu.team.main;

import com.atguigu.team.domain.*;
import com.atguigu.team.service.CompanyService;
import com.atguigu.team.service.Status;
import com.atguigu.team.service.TeamException;
import com.atguigu.team.view.TeamView;

public class TeamMain {

    public static void main(String[] args) {
        TeamView teamView = new TeamView();
        teamView.enterMainMenu();   // 真正的入口
    }

    public static void main2(String[] args) {

        CompanyService companyService = new CompanyService();

        // 获取当前所有员工
        Employee[] allEmployees = companyService.getAllEmployees();
        // 遍历员工
        for(int i = 0; i < allEmployees.length; i++) {
            System.out.println(allEmployees[i]);
        }
        System.out.println("*****************");

        try {
            Employee employee = companyService.getEmployee(50);
            System.out.println(employee);
        } catch (TeamException e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }


    public static void main1(String[] args) {
        Employee emp1 = new Employee(1, "张三", 30, 10000);
        System.out.println(emp1);

        Equipment eq1 = new NoteBook("MBP", 12000);
        Employee emp2 = new Programmer(2, "李四", 40, 4000, 0, Status.FREE, eq1);
        System.out.println(emp2);

        Equipment eq2 = new PC("DELL7000", "DELL27");
        Employee emp3 = new Designer(3, "王五", 50, 5000, 0, Status.VOCATION, eq2, 50000);
        System.out.println(emp3);

        Equipment eq3 = new Printer("激光", "HP2000");
        Employee emp4 = new Architect(4, "赵六", 60, 6000, 0, Status.FREE, eq3, 60000, 60000);
        System.out.println(emp4);
    }
}
