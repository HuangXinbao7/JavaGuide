package homework.boyAndGirlTest;

/*
添加必要的构造器，综合应用构造器的重载，this关键字。
-name:String
+setName(i: String)
+getName(): String
+marry(boy:Boy)
*/
public class Girl {

    private String name;

    public Girl(){
        this("小红");
    }

    public Girl(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String say() {
        return "女孩，姓名：" + name;
    }

    public void marry(Boy boy){
        System.out.println(this.say() + "要嫁给[" + boy.say() + "], 嫁鸡随鸡, 生的好不如嫁的好");
    }
}
