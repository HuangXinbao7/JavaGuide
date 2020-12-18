package com.atguigu.javase.abstracttest;

public class PetTest {

    // 创建6个元素的数组，分别存放2个Cat、2个Dog和2个Bird对象。
    // 将数组元素按重量倒序排序，然后打印各对象的字符串表示（toString）
    public static void main(String[] args) {

        //Pet pet = new Cat();
        // 当看到一个引用时抽象类时，绝对是多态引用！！！
        Pet pet = new Bird("小布", 1, 100, 20);   // 多态
        pet.speak();    // 虚拟方法调用

        // 只是 new Pet 引用数组（多态数组），不是 new Pet 对象
        Pet[] arrPet = new Pet[6];
        arrPet[0] = new Cat("小白", 2, 10, "白");
        arrPet[1] = new Cat("小黑", 3, 15, "黑");
        arrPet[2] = new Dog("小牛", 1, 20, "斗牛犬");
        arrPet[3] = new Dog("二哈", 4, 22, "二哈");
        arrPet[4] = new Bird("八哥", 1, 1, 60);
        arrPet[5] = new Bird("小鹦", 2, 2, 80);

        // 遍历
        for (Pet tmp: arrPet) {
            System.out.println(tmp.toString());
        }
        System.out.println("*************************");

        // 排序：将数组元素按重量倒序排序
        for(int i = 0; i < arrPet.length; i++) {
            for(int j = i + 1; j < arrPet.length; j++) {
                if(arrPet[i].getWeight() < arrPet[j].getWeight()) {
                    Pet tmp = arrPet[i];
                    arrPet[i] = arrPet[j];
                    arrPet[j] = tmp;
                }
            }
        }

        // 然后打印各对象的字符串表示（toString）
        for(Pet tmp: arrPet) {
            System.out.println(tmp.toString());
        }
    }
}
