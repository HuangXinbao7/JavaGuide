package com.atguigu.javase.collection;

import org.junit.Test;

/**
 * 集合：解决批量对象的存储问题。
 *  Collection: 保存一个一个的对象，无序可重复。
 *      Set：无序不可重复。Set中可以存放任意对象
 *          HashSet：使用哈希算法实现的 Set集合
 *              优点：全是优点
 * 			    缺点：内存连续
 *              去重规则：两个对象的 equals 为true，并且 hashCode相等
 *          TreeSet：基于二叉搜索树实现的 Set 集合。内部要进行数据的自然排序。
 *              优点：对内存要求低，检索速度极快
 * 			    缺点：插入或删除速度慢
 *              要想让它整除运作，要求添加的所有对象具有比较大小的能力。
 *              去重规则：两个对象的compare 为 0
 *
 *      List：有序可重复。Set中可以存放任意对象
 *          ArrayList：基于数组实现的 List 集合。使用场景：存储大数据。
 *              优点：检索性能好。末端插入数据是最快的。
 *              缺点：对内存要求高，要求连续，非末端插入或删除数据都是最慢的
 *          LinkedList：基于链表实现的 List 集合
 *              优点：对内存要求低，插入删除操作速度非常快。只需要修改2个指针。
 *              缺点：检索速度慢。
 *
 * 泛型：generic 解决集合中类型安全问题。
 *      在声明和创建集合时，在类名后面添加 <指定类型>
 *          好处：
 *              集合在添加元素时，不能乱添加，只能添加泛型类型，
 *              从集合中获取元素时也不需要造型。因为集合中的元素数据类型是固定的
 *
 * 集合遍历：
 *      增强for循环。为了统一数组和集合的遍历
 *
 *      经典for循环：对于List集合，还支持经典for循环。
 *
 *      Iterator 迭代器。集合遍历的真相
 *          1）先获取迭代器，必须向集合对象要。迭代器初始指针指向集合第一个元素之前。
 *          2）循环不断循环迭代器是否有下一个元素。即判断当前指针的后面是否有元素
 *          3）如果有下一个元素，取下一个元素，并往后移动指针
 *
 *          注意事项：
 *              1）对集合的任何修改都会导致迭代器被污染。解决方法是重新获取迭代器。
 *              2）next()方法在循环中必须只能调用一次。避免没有后续元素时调用next()报错。
 *
 */

// 第三方比较器
// 这里比较的是Student类的grade属性
class MyComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        if(o1 instanceof Student && o2 instanceof Student) {
            return ((Student)o1).getGrade() - ((Student)o2).getGrade();
        }
        throw new RuntimeException("对象不可比较");
    }
}


public class CollectionTest {

    /**
     * Iterator 迭代器
     */
    @Test
    public void test6(){

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add((int)(Math.random() * 50));
        }

        // 迭代器也支持泛型
        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()) {
            // 调用next()时必须先使用hasNext()判断是否好存在后续元素
            // 否则如果不先检查
            System.out.print(iterator.next());
        }
        System.out.println();
    }


    /**
     * 创建一个 List 集合，使用泛型，添加10个随机整数，求平均值
     */
    @Test
    public void exer3() {
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < 10; i++) {
            list.add((int)(Math.random() * 100));
        }
        System.out.println(list);

        int sum = 0;
        // 遍历集合，使用迭代器
        // 1）获取到迭代器
        Iterator<Integer> iterator = list.iterator();
        // 注意1：获取到迭代器后马上使用。
        // 2）循环依次访问
        while(iterator.hasNext()){
            // 3）如果有元素，真的获取
            Integer next = iterator.next();
            // 注意2：next()只能调用一次
            sum += next;    // 自动拆箱
        }
        // 注意3：一次性使用
        int avg = sum / list.size();
        System.out.println("avg = " + avg);


        // 增强型for，编译器会把它的代码变成对迭代器的使用。
        for (Integer tmp: list) {
            System.out.println(tmp);
        }

        avg = sum / list.size();

        System.out.println("avg: " + avg);
    }


    /**
     * 泛型
     */
    @Test
    public void test5() {
        // 约束此集合中只能保存 Integer 对象
        Set<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < 10; i++) {
            set.add((int)(Math.random() * 50));
        }

        System.out.println(set);

        set.add(100);
        //set.add("abc");   // 添加非 Integer 类型报错
    }


    /**
     * 练习1进阶：使用第三方比较器，并使用匿名接口对象
     * 写一个自定义比较器，把Employee对象的比较以age为准
     */
    @Test
    public void exer2() {

        Employee e1 = new Employee("小明", 18, 10000);
        Employee e2 = new Employee("小丽", 18, 8000);
        Employee e3 = new Employee("小刚", 28, 15000);
        Employee e4 = new Employee("小花", 22, 15000);

        // 关联第三方比较器对象，并使用匿名接口对象
        // 好处：不用额外写比较器类，也不用额外写创建比较器对象的语句
        Set<Employee> treeSet = new TreeSet<Employee>(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                // 这个自定义比较器，指定Employee对象的比较以age为准
                if(!(o1 instanceof Employee) || !(o2 instanceof Employee)) {
                    throw new RuntimeException("对象不可比较");
                }
                return ((Employee)o1).getAge() - ((Employee)o2).getAge();
            }
        });

        treeSet.add(e1);
        treeSet.add(e2);
        treeSet.add(e3);
        treeSet.add(e4);
        //System.out.println(treeSet);

        for(Employee tmp: treeSet) {
            System.out.println(tmp);
        }
    }


    /**
     * 使用第三方比较方法：比较器 Comparator
     */
    @Test
    public void test4() {

        Student s1 = new Student(1, "小明", 3, 90);
        Student s2 = new Student(2, "小丽", 1, 100);
        Student s3 = new Student(3, "小刚", 5, 80);
        Student s4 = new Student(4, "小花", 4, 80);

        // 创建自定义比较器对象
        Comparator comparator = new MyComparator();

        // TreeSet 关联了比较器 comparator。称为定制排序
        // 一旦关联了比较器对象，TreeSet也可以添加普通对象
        // 同时定义了自定义内部比较能力（实现了Comparable）和比较器（关联了comparator对象）。则以比较器为准。
        Set<Student> treeSet = new TreeSet<Student>(comparator);

        treeSet.add(s1);
        treeSet.add(s2);
        treeSet.add(s3);
        treeSet.add(s4);
        treeSet.add(new Student());
        //System.out.println(treeSet);

        try {
            //treeSet.add("abc");
        } catch(RuntimeException e) {
            System.out.println(e.getMessage());
        }

        for(Student tmp: treeSet) {
            System.out.println(tmp);
        }
        System.out.println("******************");

        // 使用迭代器：
        // 1）先获取迭代器，必须向集合对象要，迭代器初始指针指向第一个元素之前
        Iterator<Student> iterator = treeSet.iterator();

        // 使用注意事:1：
        // 从集合对象拿到迭代器之后，集合对象如果发生了改变（增删改查等）。会导致迭代器被污染。
        // 2）循环不断循环迭代器是否还有下一个元素，判断当前指针的后面是否有元素
        while(iterator.hasNext()) {
            // 3）如果有下一个元素，判断为真时取下元素，并移动指针
            Student stu = iterator.next();
            // 使用注意事项2：
            // next()方法在循环中必须只能调用一次
            System.out.println(stu);
        }
        // 使用注意事项3：迭代器是一次使用，用过即废。
    }


    /**
     * 练习1：写一个类 Employee，有姓名、年龄、工资 属性
     * 创建 TreeSet集合，添加几个对象，是否能添加成功？？？如果不能添加成功，该怎么办？
     */
    @Test
    public void exer1() {

        Employee e1 = new Employee("小明", 18, 10000);
        Employee e2 = new Employee("小丽", 17, 8000);
        Employee e3 = new Employee("小刚", 28, 15000);
        Employee e4 = new Employee("小花", 22, 30000);

        TreeSet<Employee> treeSet = new TreeSet<Employee>();
        treeSet.add(e1);
        treeSet.add(e2);
        treeSet.add(e3);
        treeSet.add(e4);

        //System.out.println(treeSet);

        for(Employee tmp: treeSet) {
            System.out.println(tmp);
        }
    }


    @Test
    public void test3() {
        Student s1 = new Student(1, "小明", 3, 90);
        Student s2 = new Student(2, "小丽", 1, 100);
        Student s3 = new Student(3, "小刚", 5, 70);
        Student s4 = new Student(4, "小花", 4, 50);

        Set<Student> treeSet = new TreeSet<Student>();
        treeSet.add(s1);
        treeSet.add(s2);
        treeSet.add(s3);
        treeSet.add(s4);

        System.out.println(treeSet);
    }


    /**
     * TreeSet：存放字符串
     */
    @Test
    public void test2() {

        Set<String> treeSet = new TreeSet<String>();
        treeSet.add("abc");
        treeSet.add("999");
        treeSet.add("汉字");
        treeSet.add("BBB");
        //treeSet.add(100);   // 不存存放不同类型的数据对象

        System.out.println(treeSet);
    }


    /**
     * TreeSet
     */
    @Test
    public void test1() {

        // 使用泛型限制集合中元素的数据类型
        Set<Integer> treeSet = new TreeSet<Integer>();    // 无序（添加顺序），不可重复，内部要实现自然排序
        treeSet.add(50);
        treeSet.add(20);
        treeSet.add(30);
        treeSet.add(10);
        treeSet.add(40);
        treeSet.add(25);
        //treeSet.add("abc"); // TreeSet内部要自然排序，字符串和整数之间不能比较大小

        System.out.println(treeSet);

        for(Integer tmp: treeSet) {
            System.out.println(tmp);
        }
    }
}
