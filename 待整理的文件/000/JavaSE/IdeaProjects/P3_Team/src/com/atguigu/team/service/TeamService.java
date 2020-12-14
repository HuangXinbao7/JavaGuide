package com.atguigu.team.service;

import com.atguigu.team.domain.Architect;
import com.atguigu.team.domain.Designer;
import com.atguigu.team.domain.Employee;
import com.atguigu.team.domain.Programmer;

/**
 * 团队管理器, 内部用数组来管理团队, 是一组开发人员. 和客户信息管理一样
 */
public class TeamService {

    // 为新加入的团队成员赋予唯一的 TID（memberId）
    private static int count = 1;
    // 常量 : 表示数组的最大容量, 最多1个架构师,最多2个设计师, 最多3个程序员
    public final int MAX_MEMBER = 6;
    // 内部数组, 用于保存一组开发人员, 最多6个
    private Programmer[] team = new Programmer[MAX_MEMBER];
    // 计数器, 仍然还是算法的灵魂
    private int realCount = 0;

    /**
     * 方法：向团队中添加成员
     * 参数：待添加成员的对象
     * 异常：添加失败， TeamException中包含了失败原因
     */
    public void addMember(Employee emp) throws TeamException {
        Programmer programmer = null;
        // 已知异常转换为自定义异常
        try {
            programmer = (Programmer)emp;
        } catch (ClassCastException e) {
            //throw new TeamException(e);
            throw new TeamException("添加的成员不是开发人员");
        }
        if(realCount == team.length) {
            throw new TeamException("成员已满，无法添加");
        }
        if(programmer.getStatus() == Status.BUSY) {
            throw new TeamException("该员已是团队成员");
        }
        if (programmer.getStatus() == Status.VOCATION) {
            throw new TeamException("该成员在休假，无法添加");
        }

        // 对已有成员的统计
        int architer = 0;
        int desinger = 0;
        int programmers = 0;
        for (int i = 0; i < realCount; i++) {
            if( team[i] instanceof Architect) {
                architer++;
            } else if(team[i] instanceof Designer) {
                desinger++;
            } else {
                programmers++;
            }
        }

        // 新成员的身份判断
        if(programmer instanceof Architect) {
            if(architer == 1) {
                throw new TeamException("团队中只能有一个名架构师");
            }
        } else if (programmer instanceof Designer) {
            if (desinger == 2) {
                throw new TeamException("团队中只能有两名设计师");
            }
        } else {
            if (programmers == 3) {
                throw new TeamException("团队中只能有三名程序员");
            }
        }

        // 真正添加之前要先给它赋予一个tid, 改其状态
        programmer.setMemberId(count++);
        programmer.setStatus(Status.BUSY);
        this.team[realCount++] = programmer;
    }

    /**
     * 方法：返回当前团队的所有有效对象
     * 返回：包含所有成员对象的数组，数组大小与成员人数一致
     * 返回的是完美数组
     */
    public Programmer[] getTeam() {
        // 1 创建新数组，用于保存所有有效对象
        Programmer[] newArr = new Programmer[realCount];
        // 2 依次把数组中的所有有效对象复制到新数组中
        for (int i = 0; i < realCount; i++) {
            newArr[i] = this.team[i];
        }
        // 3 返回新数组
        return newArr;
    }

    /**
     * 方法：从团队中删除成员
     * 参数：待删除成员的memberId
     * 异常：删除失败， TeamException中包含了失败原因
     */
    public void removeMember(int memberId) throws TeamException {
        //int index = 0;
        int index = -1;
        // 定位下标：搜索遍历数组, 找到要删除的元素的memberId == 参数memberId的下标
        for(int i = 0; i < realCount; i++) {
            if(team[i].getMemberId() == memberId) {
                index = i;
                break;
            }
        }
        if(index == -1) {
            throw new TeamException("要删除的指定TID[" + memberId + "]的成员不存在");
        }
        // 依据下标删除
        // 在真正删除前改其状态，夺其id
        this.team[index].setStatus(Status.FREE);
        // 重置 id
        this.team[index].setMemberId(0);

        // 1 把要删除的下标位置处置为空
        this.team[index] = null;
        // 2 从要删除的下标位置开始依次把右侧相邻元素往左移动一位，控制好循环
        // 到有效元素的倒数第二个就是最后一次复制
        for(int i = index; i < realCount - 1; i++) {
            team[i] = team[i + 1];
        }
        // 3 把之前的最后有效元素位置处置为空
        // 4 计数器调整
        team[--realCount] = null;
    }
}
