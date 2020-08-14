package previews;

public class Person2 {

    String name;
    int age;
    int sex;    // 1: man, 0: women

    public void study() {
        System.out.println("studying");
    }

    public void showAge() {
        System.out.println("age = " + age);
    }

    public int addAge(int i) {
        return age += i;
    }

    public static void main(String[] args) {

        Person2 p1 = new Person2();
        p1.name = "小明";
        p1.age = 8;
        p1.sex = 1;

        p1.study();
        p1.showAge();
        p1.age += p1.addAge(1);
        p1.showAge();


    }

}
