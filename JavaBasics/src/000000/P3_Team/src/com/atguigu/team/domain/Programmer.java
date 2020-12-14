package com.atguigu.team.domain;

import com.atguigu.team.service.Status;

public class Programmer extends Employee {

    private int memberId;           // TID，团队ID
    private Status status;          // 表示状态
    private Equipment equipment;    // 领用的设备

    public Programmer() {
    }

    public Programmer(int id,
                      String name,
                      int age,
                      double salary,
                      int memberId,
                      Status status,
                      Equipment equipment) {
        super(id, name, age, salary);
        this.memberId = memberId;
        this.status = status;
        this.equipment = equipment;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return super.say() + "\t" + "程序员" + "\t" +status + "\t\t\t\t" + equipment;
    }

    public String getMemberString() {
        //String member = memberId < 10 ? "0" + memberId: "" + memberId;
        //return member;
        return memberId < 10 ? "0" + memberId: "" + memberId;
    }

    // 返回团队列表格式
    public String toStringForTeam() {
        //return getMemberString() + "/" + super.say() + "\t" + "程序员";
        return "0" + memberId + "/" + super.say() + "\t" + "程序员";
    }
}
