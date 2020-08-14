class PersonTest {

    // 对象的使用
    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person();

        p1.age = 30;

        System.out.println(p1.display());
        System.out.println(p2.display());
    }
}
