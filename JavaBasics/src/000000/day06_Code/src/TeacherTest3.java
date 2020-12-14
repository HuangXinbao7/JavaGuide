public class TeacherTest3 {

    public static void main(String[] args){

        // t1 是什么？是一个Teacher类型的引用变量，内部保存一个地址
        Teacher t1 = new Teacher();
        // 根据t1引用变量中的地址定位到堆内存中的对象实体，再进一步根据属性名定位空间
        t1.name = "佟刚";
        t1.age = 40;
        t1.gender = "男";

        System.out.println(t1.say());


        Teacher t2 = new Teacher();
        t2.name = "小宁姐";
        t2.age = 20;
        t2.gender = "女";

        System.out.println(t2.say());


        System.out.println("==================");
        // 把t2引用变量中的地址值写入t1引用变量，此时会导致t1中原来的地址被覆盖了，
        // 原来指向的对象就变成了垃圾
        // 垃圾对象：在程序中不再有引用指向的对象。垃圾对象会被清理，清理机制有特定算法
        t1 = t2;
        t1.age = 10;
        System.out.println(t2.say());   // 10
    }
}
