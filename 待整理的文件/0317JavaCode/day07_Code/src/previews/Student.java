package previews;

public class Student {

    // 属性
    String name;
    int age;
    String courses;
    String hobby;

    // 方法
    public void showInfo(){
        String info = "姓名："+name+", 年龄："+age+", 参加的课程："+courses+", 兴趣：" + hobby;
        System.out.println(info);
    }
}
