package com.atguigu.team.service;

public enum Status {
    FREE("空闲"), BUSY("忙碌"), VOCATION("休假");

    private String desc;

    private Status(String desc) {
        this.desc = desc;
    }

    @Override public String toString() {
        return desc;
    }
}
