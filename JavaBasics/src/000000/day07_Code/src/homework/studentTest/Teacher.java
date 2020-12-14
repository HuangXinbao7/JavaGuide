package homework.studentTest;

public class Teacher {

    private String name;
    private int age;
    private String gender;
    private Computer myComputer;    // 对象关联

    public Teacher() {}

    public Teacher(String name, int age, String gender, Computer myComputer) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.myComputer = myComputer;
    }

    public void setMyComputer(Computer myComputer){
        this.myComputer = myComputer;
    }

    public Computer getMyComputer(){
        return myComputer;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public String getGender(){
        return gender;
    }

    public String say(){
        return "姓名 : " + name + ", 年龄 : " + age + ", 性别 : " + gender + ", 我的电脑 : " + myComputer.say();
    }

    //public void lesson(Computer computer) {
    public void lesson() {
        System.out.println(name + "老师在使用电脑[" + myComputer.say() + "]上课");
    }

    public void film() {
        System.out.println("使用电脑[" + myComputer.say() + "]看电影");
    }
}
