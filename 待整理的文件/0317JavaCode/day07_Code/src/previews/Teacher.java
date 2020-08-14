package previews;

public class Teacher {

    // 属性
    String name;
    String profession;
    String curriculum;
    int teachAge;

    // 方法
    public void showInfo(){
        String info = "姓名："+name+", 专业："+profession+", 教授的课程："+curriculum+", 教龄：" + teachAge;
        System.out.println(info);
    }
}
