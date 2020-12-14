package com.atguigu.javase.homework;


public class DeviceTest {

    public static void main(String[] args) {
        Device[] arr = new Device[5];
        arr[0] = new Mouse(542, "鼠标1", "工厂1", 499, "白色");
        arr[1] = new Mouse(65, "鼠标2", "工厂2", 129, "红色");
        arr[2] = new Keyboard(75, "键盘1", "键盘工厂1",588, 87);
        arr[3] = new Keyboard(347, "键盘2", "键盘工厂2",399, 97);
        arr[4] = new Keyboard(425, "键盘3", "键盘工厂3", 999, 104);

        // 排序：根据价格排序，升序
        for(int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j].getPrice() > arr[j + 1].getPrice()) {
                    Device tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }

        for (Device tmp: arr) {
            System.out.println(tmp.say());
        }
    }
}
