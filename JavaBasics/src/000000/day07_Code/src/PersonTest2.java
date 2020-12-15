class PersonTest2 {

    // 对象生命周期
    public static void main(String[] args) {

        // 1、离开作用域p1失效，Person对象成为垃圾
        Person p1 = new Person();
        Person p2 = new Person();

        // 2、给对象名赋值 null，对象成为垃圾
        p2 = null;
        //System.out.println(p2.display());     // 编译报错

        // 对象的引用赋值
        // 给p1赋值null，p1失效，p3还是有效
        Person p3 = p1;
        p1 = null;
        System.out.println(p3.display());     // 编译报错


    }
}
