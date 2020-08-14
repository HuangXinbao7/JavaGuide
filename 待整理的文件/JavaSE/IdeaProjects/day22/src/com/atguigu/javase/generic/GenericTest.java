package com.atguigu.javase.generic;

import com.atguigu.javase.Student;
import org.junit.Test;

/**
 * 泛型：generic 解决集合中类型安全问题。如果使用Object类型会带来类型的损失
 * 典型的应用就是在集合中，集合中理论上可以保存任意对象，实际上应该让它泛型化。
 * 集合类 <元素类型>，添加元素只能添加指定类型，获取元素时一定能获取到指定类型的对象，不需要造型
 *      在声明和创建集合时，在类名后面添加 <指定类型>
 *          好处：
 *              集合在添加元素时，不能乱添加，只能添加泛型类型，
 *              从集合中获取元素时也不需要造型。因为集合中的元素数据类型是固定的
 */
// 泛型方法
class GenericMethod<A> {    // A 是成员泛型

    public void test() {}

    // 泛型方法，在返回值之前加<泛型类型参数>，必须给一个泛型类型的参数
    // 方法在调用时由实参给定的类型来决定泛型类型，是某次调用相关
    public static <B>B testB(B b2){    // B是局部泛型参数，类型不确定
        B b = b2;
        return b;
    }

    //public void test3(B b) {}   // 不可以跨方法使用局部泛型
}


// 泛型和继承的关系
class Base<T> {
    private T field;
    public void setField(T field) {
        this.field = field;
    }
    public T getField() {
        return field;
    }
}


/**
 * 子类在继承有泛型的父类时的写法
 */
// 不推荐这种写法，泛型未知
class Sub1 extends Base {}  // 子类没有理会父类的泛型，父类的泛型被子类继承后固定是 Object

// 推荐这种写法，泛型是固定的，不会变，缺点是子类需要多写几个
// 子类在继承父类时，把泛型写死，子类继承的泛型类型就是固定的
class Sub21 extends Base<String>{}
// 这种写法常见，子类中泛型写死，泛型类型就固定，使用子类方便
class Sub22 extends Base<Integer>{}

// 这种写法最灵活，因为子类的泛型也不是固定
class Sub3<T> extends Base<T> {}    // 子类中继承泛型，子类也灵活


public class GenericTest {

    // 自定义求最大值的方法
    public Comparable max(Collection<? extends Comparable> collection) {
        Iterator<? extends Comparable> iterator = collection.iterator();
        if(!iterator.hasNext()) {
            return null;
        }
        Comparable max = iterator.next();   // 假设第一个元素最大
        while (iterator.hasNext()) {
            Comparable next = iterator.next();
            if(next.compareTo(max) > 0) {
                max = next;
            }
        }
        return max;
    }

    @Test
    public void test10() {
        List<Integer> list1 = new ArrayList<Integer>();
        for(int i = 0; i < 10; i++){
            list1.add((int)(Math.random() * 100));
        }
        System.out.println(list1);
        System.out.println(max(list1));     // 求List集合中的最大值

        List<Double> list2 = new ArrayList<Double>();
        for(int i = 0; i < 10; i++) {
            list2.add((Math.random() * 100));
        }
        System.out.println(list2);
        System.out.println(max(list2));     // 求List集合中的最大值

        Set<Integer> set1 = new HashSet<Integer>();
        for(int i = 0; i < 10; i++) {
            set1.add((int)(Math.random() * 100));
        }
        System.out.println(set1);
        System.out.println(max(set1));      // 求Set集合中的最大值

        Set<String> set2 = new HashSet<String>();
        set2.add("aaa");
        set2.add("bbb");
        set2.add("ccc");
        set2.add("ddd");
        set2.add("汉字");
        set2.add("123456");
        System.out.println(max(set2));
    }


    // 自定义方法：求平均值
    // 参数中的集合可以接收Number子类类型为泛型的集合，并且是只读访问
    public Number avg(List<? extends Number> list) {
        double sum = 0;
        for(int i = 0; i < list.size(); i++) {
            sum += list.get(i).doubleValue();   // Number类型对象
        }
        return sum / list.size();
    }

    /**
     *
     */
    @Test
    public void test9() {
        // Integer 类型的集合
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < 10; i++) {
            list.add((int)(Math.random() * 100));
        }
        System.out.println(list);
        System.out.println(avg(list));      // 求集合的平均值

        // Double 类型的集合
        List<Double> list2 = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            list2.add((Math.random() * 100));
        }
        System.out.println(list2);
        System.out.println(avg(list2));     // 求集合的平均值
    }


    /**
     * 泛型的继承和通配符
     */
    @Test
    public void test8() {

        // <? super Number>：有限的通配符，？：表示未知；super：表示父类。
        // 表示 Number 及其未知父类类型，下限是Number，上线未知。此类型一定可以兼容 Number。
        // 适用于添加元素，但是不适用于取元素。
        List<? super Number> list = new ArrayList<>();
        // 可以添加元素, 但是只能添加Number及其子类.
        list.add(200);     // 200 可以被 Number及其父类兼容
        list.add(3.22);
        //list1.add(new Object());    // Object 对象不能添加，因为它是已知的父类
        Object obj = list.get(0);
        //System.out.println(obj);

        // Number 及其未知子类类型
        // 上限是 Number，下限未知
        // <? extends Number> 不适用于添加元素，适用于获取元素
        List<? extends Number> list2 = new ArrayList<>(10);
        //Number number = list2.get(0);
    }


    // 自定义打印List集合的方法
    public void printList(List<?> list) {
        for (int i = 0; i < list.size(); i++) {
            Object obj = list.get(i);
            System.out.print(obj + " ");
        }
        System.out.println();
    }

    @Test
    public void test7() {
        List<Integer> list1 = new ArrayList<Integer>();
        for(int i = 0; i < 10; i++) {
            list1.add((int)(Math.random() * 100));
        }
        printList(list1);

        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        printList(list);
    }


    /**
     * 泛型的多态和通配符
     */
    @Test
    public void test6() {
        //List<Number> list = new ArrayList<Integer>();
        // 左面的list可以保存Number及其子类对象，如果添加Double是可以的
        // 右面的list只能保存Integer，但是右面实际不允许
        // 所以泛型不能直接多态
        List<Integer> list1 = new ArrayList<Integer>();
        for(int i = 0; i < 10; i++){
            list1.add((int)(Math.random() * 20));
        }
        System.out.println(list1);

        // ? 是泛型通配符，表示类型未知
        List<?> list2 = list1;

        // list2中保存未知类型的对象
        // list2.add(200);  // 不能添加，因为200是一直类型
        // list2.add("abc");  // 添加时类型确定的不能添加
        list2.add(null);    // 因为null类型不确定，因此可以添加。但是添加null是无意义的操作
        Object obj = list2.get(0);  // 可以获取元素，但是都是Object类型

        List<?> list3 = new ArrayList<Object>();
    }


    @Test
    public void test5() {
        GenericPerson<Student> gp3 = new GenericPerson<>("张三", new Student());

        Sub3<Student> studentSub3 = new Sub3<>();
        studentSub3.setField(new Student());
        Student field = studentSub3.getField();
        System.out.println(field);
    }


    /**
     * 泛型的继承多样性
     */
    @Test
    public void test4() {
        // 泛型未知
        Sub1 sub1 = new Sub1();
        Object field1 = sub1.getField();

        // 泛型固定
        Sub21 sub21 = new Sub21();  // Sub21的泛型是 String
        String field21 = sub21.getField();

        Sub22 sub22 = new Sub22();  // Sub22的泛型是 Integer
        Integer field22 = sub22.getField();

        // 泛型灵活
        Sub3<Double> doubleSub3 = new Sub3<Double>();
        Double field4 = doubleSub3.getField();

        Sub3<Boolean> booleanSub3 = new Sub3<Boolean>();
        Boolean field5 = booleanSub3.getField();
    }


    /**
     * 写一个类， 包含一个泛型方法，在测试类中调用此方法，察看返回值类型
     */
    @Test
    public void test3() {

        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < 10; i++){
            list.add((int)(Math.random() * 20));
        }
        System.out.println(list);

        // 集合变成数组
        // Object[] objects = list.toArray(); // 为了兼容保留的老方法
        // 如果参数中传入的数组对象可以用，那它就要用， 如果不能用，再创建新的
        Integer[] arr = new Integer[22];
        Integer[] integers = list.toArray(arr);     // 典型的泛型方法
        System.out.println(arr);
        System.out.println(integers);
        System.out.println(integers.length);

        // 数组是空的也没问题，因为它的唯一作用就是让方法感知泛型类型是什么即可
        for(int i = 0; i < integers.length; i++) {
            System.out.print(integers[i] + " ");
        }
    }


    /**
     * 泛型方法的使用
     */
    @Test
    public void test2() {
        GenericMethod genericMethod = new GenericMethod();
        // 泛型方法一定有参数，用于确定泛型类型
        String rt = genericMethod.testB("aaa");
        Integer rt2 = genericMethod.testB(1000);
        // 如果是泛型非，不要传 bull，因为null无法让方法感知类型
        Object rt3 = genericMethod.testB(null);
    }


    /**
     * 泛型类和泛型参数的使用
     */
    @Test
    public void test1() {
        GenericPerson<Integer> p1 = new GenericPerson<Integer>("张三", 30);
        Integer info1 = p1.getInfo();

        GenericPerson<Double> p2 = new GenericPerson<Double>("李四", 5000.0);

        // 不带自定义泛型类的参数
        GenericPerson p3 = new GenericPerson("王五", "男");
    }
}
