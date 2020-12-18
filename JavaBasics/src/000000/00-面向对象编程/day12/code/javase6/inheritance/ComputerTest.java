package com.atguigu.javase.inheritance;

public class ComputerTest {

    public static void main(String[] args) {
        PC pc = new PC(4.2, 8, 1000, "小米");
        System.out.println(pc.getDetails());
    }

    public static void main1(String[] args) {
        PC pc = new PC();
        pc.setCpu(3.5);
        pc.setMemory(8);
        pc.setDisk(500);
        pc.keyboard = "DELL键盘";

        System.out.println(pc.getCpu());
        System.out.println(pc.getMemory());
        System.out.println(pc.getDisk());
        System.out.println(pc.keyboard);

        System.out.println(pc.getDetails());
        pc.code();

        NotePad notePad = new NotePad();
        notePad.setCpu(2.8);
        notePad.setMemory(4);
        notePad.setDisk(64);
        notePad.satelite = 5;

        System.out.println(notePad.getCpu());
        System.out.println(notePad.getMemory());
        System.out.println(notePad.getDisk());
        System.out.println(notePad.satelite);

        notePad.navigate();
        System.out.println(notePad.getDetails());
    }
}
