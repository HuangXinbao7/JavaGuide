package com.atguigu.team.domain;

import com.atguigu.team.service.Status;

public class Designer extends Programmer {

    private double bonus;   // 奖金

    public Designer() {}

    public Designer(int id,
                    String name,
                    int age,
                    double salary,
                    int memberId,
                    Status status,
                    Equipment equipment,
                    double bonus) {
        super(id, name, age, salary, memberId, status, equipment);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return super.say() + "\t" +
                "设计师" + "\t" +
                getStatus() + "\t" +
                bonus + "\t\t\t" +
                getEquipment();
    }


    // 返回团队列表格式
    public String toStringForTeam() {
        //return getMemberString() + "/" + super.say() + "\t" + "程序员";
        return getMemberString() + "/" + super.say() + "\t" + "设计师" + "\t" + getEquipment();
    }
}
