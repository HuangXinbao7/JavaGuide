package homework.boyAndGirlTest;

/*
添加必要的构造器，综合应用构造器的重载，this关键字。
-name:String
-age:int

+setName(i: String)
+getName(): String
+setAge(i: int)
+getAge(): int
+marry(girl:Girl)
+shout():void
*/
public class Boy {

    private String name;
    private int age;

    public Boy(){
        //this("小明", 18);
    }

    public Boy(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int i) {
        this.age = i;
    }

    public int getAge(){
        return age;
    }

    public String say() {
        return "男孩，姓名：" + name + ", 年龄：" + age;
    }

    public void marry(Girl girl){
        System.out.println(this.say() + "要娶女孩[" + girl.say() + "], 婚姻是坟墓");
        girl.marry(this);       // this表示当前对象, 正在调用此方法的对象.
    }

    public void shout() {
        System.out.println("喊一喊，有助于减压，男人压力大");
    }
}
