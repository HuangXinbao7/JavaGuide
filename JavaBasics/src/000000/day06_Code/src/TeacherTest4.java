public class TeacherTest4 {

    public static void main(String[] args){

        Teacher t1 = new Teacher();
        t1.name = "佟刚";
        t1.age = 40;
        t1.gender = "男";

        System.out.println(t1.say());


        Teacher t2 = new Teacher();
        t2.name = "小宁姐";
        t2.age = 20;
        t2.gender = "女";

        System.out.println(t2.say());


        System.out.println("*******************");
        // 交换两个引用
        Teacher tmp = t1;   // 一个临时引用，保存t1的地址
        t1 = t2;
        t2 = tmp;
        System.out.println(t1.say());
        System.out.println(t2.say());
    }
}
