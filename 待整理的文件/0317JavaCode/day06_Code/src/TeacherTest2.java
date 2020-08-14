public class TeacherTest2 {

    public static void main(String[] args){

        // t1 是什么？是一个Teacher类型的引用变量，内部保存一个地址
        Teacher t1 = new Teacher();
        // 根据t1引用变量中的地址定位到堆内存中的对象实体，再进一步根据属性名定位空间
        t1.name = "佟刚";
        t1.age = 40;
        t1.gender = "男";

        t1.lesson();
        System.out.println(t1.say());


        Teacher t2 = new Teacher();
        t2.name = "小宁姐";
        t2.age = 20;
        t2.gender = "女";

        t2.lesson();
        System.out.println(t2.say());
    }
}
