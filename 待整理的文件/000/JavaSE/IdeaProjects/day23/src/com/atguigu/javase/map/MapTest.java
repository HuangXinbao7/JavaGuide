package com.atguigu.javase.map;


import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;


class Person {
    int id;
    String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}


public class MapTest {

    @Test
    public void test2() {
        HashSet set = new HashSet();
        Person p1 = new Person(1001, "AA");
        Person p2 = new Person(1001, "BB");

        set.add(p1);
        set.add(p2);

        p1.name = "CC";
        p1 = null;

        // 能否删除 p1？
        // 不能，因为
        set.remove(p1);
        System.out.println(set);

        // 能否添加？
        // 可以成功添加。、
        // 虽然集合中已经存在属性值id=1001，name="CC"的对象，
        // 但是它的下标是通过id=1001，name="AA"计算的。
        // 当前要添加的对象的属性id=1001，name="CC"，不冲突，所以可以添加
        set.add(new Person(1001, "CC"));
        System.out.println(set);

        // 能否添加成功？
        // 能。虽然集合中已存在了通过id=1001，name="AA"计算出的下标，
        // 但是现在这个下标位置的对象属性是 id=1001，name="CC",
        // 与当前要添加的新对象的 equals不为true。
        set.add(new Person(1001, "AA"));
        System.out.println(set);
    }



    @Test
    public void test1() {
        // 类型推断，编译器会根据左面推断右面的泛型类型
        // 右面的泛型一定和左面的泛型一致，因此可以省略
        Map<Integer, String> map = new HashMap<>();
        map.put(9, "nine");
        map.put(3, "three");
        map.put(2, "two");
        map.put(8, "eight");
        map.put(7, "seven");
        map.put(10, "ten");
        map.put(20, "20"); // 下标4
        map.put(30, "30"); // 下标是14

        map.put(25, "25"); // 会和下标9冲突
        map.put(41, "41");
        map.put(57, "57");

        map.put(100, "100"); // 12

        map.put(200, "200"); // 扩容并重新散列

        System.out.println(map);
    }
}
