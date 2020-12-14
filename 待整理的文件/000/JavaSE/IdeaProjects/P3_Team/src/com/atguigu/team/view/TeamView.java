package com.atguigu.team.view;

import com.atguigu.team.domain.Employee;
import com.atguigu.team.domain.Programmer;
import com.atguigu.team.service.CompanyService;
import com.atguigu.team.service.TeamException;
import com.atguigu.team.service.TeamService;

/**
 * 主控模块，负责UI
 */
public class TeamView {

    // 关联的 公司员工管理器
    private CompanyService companyService = new CompanyService();
    // 关联的 团队管理器
    private TeamService teamService = new TeamService();

    // 真正入口
    public void enterMainMenu() {
        // 不随意返回, 用循环控制
        boolean loopFlag = true;
        while (loopFlag) {
            // 列出公司所有员工
            listAllEmployees();
            // 打印主菜单
            System.out.print("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4)  : ");
            // 获取用户选择, 使用工具类
            char c = TSUtility.readMenuSelection();
            switch (c) {
                case '1' : listTeam(); break;
                case '2' : addMember(); break;
                case '3' : deleteMember(); break;
                case '4' : loopFlag = false; // 控制循环的布尔置为false
            }
        }
    }

    // 列出公司所有员工
    private void listAllEmployees() {
        System.out.println("---------------------------开发团队调度软件---------------------------");
        System.out.println();
        System.out.println("ID\t姓名\t\t年龄\t\t工资\t\t职位\t\t状态\t\t奖金\t\t股票\t\t领用设备");
        // 获取所有员工, 再遍历
        Employee[] allEmployees = companyService.getAllEmployees();
        for (Employee emp : allEmployees) {
            System.out.println(emp);
        }
        System.out.println("-------------------------------------------------------------------");
    }


    // 添加团队成员
    private void addMember() {
        //System.out.println("TeamView.addMember");
        System.out.println("---------------------添加成员---------------------");
        System.out.print("请输入要添加的员工ID: ");
        // 使用工具类获取员工id
        int id = TSUtility.readInt();
        try {
            // 先获取员工对象, companyService
            Employee employee = companyService.getEmployee(id);
            // 把员工对象添加到团队中 teamService
            teamService.addMember(employee);
            System.out.println("添加成功");
        } catch (TeamException e) {
            //e.printStackTrace();
            System.out.println("添加失败，原因是：" + e.getMessage());
        }
        //按回车键继续...
        TSUtility.readReturn();
    }


    // 删除团队成员
    private void deleteMember() {
        //System.out.println("TeamView.deleteMember");
        System.out.println("---------------------删除成员---------------------");
        System.out.print("请输入要删除员工的TID：");
        int tid = TSUtility.readInt();
        System.out.print("确认是否删除(Y/N)：");
        char c = TSUtility.readConfirmSelection();
        if (c == 'Y') {
            try {
                teamService.removeMember(tid);
                System.out.println("删除成功");
            } catch (TeamException e) {
                System.out.println("删除失败, 原因：" + e.getMessage());
            }
            TSUtility.readReturn();
        }
    }


    // 团队列表
    private void listTeam() {
        System.out.println("--------------------团队成员列表--------------------");
        System.out.println("TID/ID\t姓名\t\t年龄\t\t工资\t\t职位\t\t奖金\t\t股票");
        // 从团队管理器中获取所有成员
        Programmer[] team = teamService.getTeam();
        // 遍历所有成员
        for (int i = 0; i < team.length; i++) {
            // 显式调用 toString2()
            System.out.println(team[i].toStringForTeam());
        }
        System.out.println("--------------------------------------------------");
    }
}
