package com.atguigu.javase.generic;

// 只有此接口的子类才是表示人的信息
interface Info{

}

// 表示练习方式
class Contact implements Info {

    private String address;
    private String telephone;
    private String zipcode;

    public Contact() {
    }

    public Contact(String address, String telephone, String zipcode) {
        this.address = address;
        this.telephone = telephone;
        this.zipcode = zipcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }
}

//
class Introduction implements Info{
    private String name;
    private String sex;
    private int age;

    public Introduction() {
    }

    public Introduction(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Introduction{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}


/**
 * 自定义泛型类，E（Element） 泛型类型皆可以在本类中任意位置使用
 * E 表示这个类的类型参数，是一个变化的类型，表示某种类型
 * 此时并不知道具体的类型，在创建类对象时就可以知道。
 * 泛型类型适合对象相关的：即在创建类对象时才能确定具体的类型
 */
public class GenericPerson<E> {

    private String name;
    //private Object info;  // info数据类型不安全，不确定
    private E info;         // info数据类型泛型化

    public GenericPerson() {
    }

    public GenericPerson(String name, E info) {
        this.name = name;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public E getInfo() {
        return info;
    }

    public void setInfo(E info) {
        this.info = info;
    }

    // 静态环境中不可以使用泛型类型
    //public static void test(E e) {}
}
