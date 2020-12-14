package com.atguigu.javase.reflect;

import org.junit.Test;

import java.io.InputStream;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;
import java.util.concurrent.Callable;


@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation{
    int id() default 10;
    String value() default "缺省值";
}


/**
 * 写一个 Teacher 类
 */
@MyAnnotation("我是一个值")
class Teacher extends ArrayList implements Runnable, Serializable, Callable {

    public static String school = "atguigu";

    public static void test() {
        System.out.println("这是静态方法");
    }

    public String name;
    public int age;
    public String gender;

    public Teacher() {
    }

    public Teacher(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    @Override
    public void run() {

    }

    @Override
    public Object call() throws Exception {
        return null;
    }

    private void lesson(String content, int hours) {
        System.out.println(name + " 老师在上[" + content + "]课, 共上了[" + hours + "]小时");
        //throw new Error("我是一个无端的错误");
        //return "上课OK";
    }
}



public class ReflectTest {

    @Test
    public void test12() throws Exception {
        Class clazz = Class.forName("com.atguigu.javase.reflect.Teacher");
        // 只能反射能处理注解, 并且注解必须停留到Runtime
        MyAnnotation annotation = (MyAnnotation) clazz.getAnnotation(MyAnnotation.class);
        System.out.println(annotation);
    }


    /**
     * 访问静态成员不需要this目标对象
     */
    @Test
    public void test11() throws Exception {
        Class clazz = Class.forName("com.atguigu.javase.reflect.Teacher");
        Field school = clazz.getField("school");
        // 不会抛出空指针异常。静态属性的访问完全忽略参数，可写可不写
        Object obj = school.get(null);
        System.out.println(obj);

        // 访问静态方法
        Method test = clazz.getMethod("test");
        test.invoke(null);  // 参数被忽略
        test.invoke("呵呵");  // 参数被忽略
    }


    /**
     * 访问私有方法 getDeclaredMethod()
     * */
    @Test
    public void test10() {
        try {
            Class clazz = Class.forName("com.atguigu.javase.reflect.Teacher");
            Object obj = clazz.newInstance();
            // getMethod 获取的是本类及从父类继承的所有公共方法
            // Method method = clazz.getMethod("lesson", String.class, int.class);
            // getDeclaredMethod可以获取本类声明的任意方法, 包括私有的.
            Method lesson = clazz.getDeclaredMethod("lesson", String.class, int.class);
            lesson.setAccessible(true); // 设置为可以访问，突破封装
            Object javaSE = lesson.invoke(obj, "JavaSE", 8);// 执行方法
            System.out.println(javaSE);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


    /**
     * 没有无参构造器，如何创建对象
     */
    @Test
    public void test9() throws Exception {
        try {
            Class clazz = Class.forName("com.atguigu.javase.reflect.Teacher");
            // 反射的方式创建对象
            // 拿到构造器，通过全参构造创建对象
            Constructor constructor = clazz.getConstructor(String.class, int.class, String.class);// 形参类型列表
            // 创建对象
            Object obj = constructor.newInstance("小明", 20, "男");
            System.out.println(obj);

            // 反射的方式调用方法
            // 第一个参数是方法名, 后面是形参类型列表
            Method clazzMethod = clazz.getMethod("lesson", String.class, int.class);
            // 等效于 obj.lesson("javaWeb", 3)
            // 前提是类中的方法是 public
            Object retValue = clazzMethod.invoke(obj, "JavaSE", 3);
            // 如果实际调用的方法没有返回值, 这里的返回值就是null
            System.out.println(retValue);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


    /**
     * 类加载器的重要作用：加载资源
     */
    @Test
    public void test8() throws Exception {
        // 加载类路径中的资源文件 classpath
        InputStream input = this.getClass().getClassLoader().getResourceAsStream("test.properties");
        Properties properties = new Properties();
        properties.load(input);

        Enumeration<?> enumeration = properties.propertyNames();
        while (enumeration.hasMoreElements()) {
            Object name = enumeration.nextElement();
            Object value = properties.get(name);
            System.out.println(name + " >>>>> " + value);
        }
    }


    /**
     * 类加载器 ClassLoader
     */
    @Test
    public void test7() {

        // 获取系统类加载器：SystemClassLoader
        ClassLoader classLoader1 = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader1);
        // 获取系统类加载器的父类加载器：扩展类加载器 ExtClassLoader
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);
        // 获取扩展类加载器：引导类加载器 BootstrapClassLoader
        ClassLoader classLoader3 = classLoader2.getParent();
        System.out.println(classLoader3);

        // 获取 Teacher 类的类加载器
        ClassLoader classLoader = Teacher.class.getClassLoader();
        System.out.println(classLoader);

        // 引导类加载器加载
        ClassLoader classLoader4 = String.class.getClassLoader();
        System.out.println(classLoader4);
    }


    /**
     * 基本类型的类模板对象：只要是数据类型，一定有相应的类模板对象
     */
    @Test
    public void test66() throws ClassNotFoundException {
        Class clazzI = Integer.class;
        Class clazzi = int.class;   // 只要是数据类型，一定有相应的类模板对象
        System.out.println(clazzI == clazzi);   // false，包装类和基本类不是同一种类型

        // 基本类型的类模板对象什么也不能做，唯一能做的就是作为一个标识，表明它是int类型
        //clazzi.newInstance();
        //clazzI.newInstance();
        System.out.println(clazzI.isPrimitive());   // 判断类模板表示的类是不是基本类型
        System.out.println(clazzi.isPrimitive());   // 判断类模板表示的类是不是基本类型
    }


    /**
     *  实例化Class类对象（获取类模板对象）的四种方法
     */
    @Test
    public void test6() throws Exception {
        // 拿到的是同一个类模板对象
        // 第一种方式：类名.class
        Class clazz1 = Teacher.class;
        // 第二种方式：类的实例对象名.getClass()
        Class clazz2 = new Teacher("小明", 40, "男").getClass();    // 第二种方式
        System.out.println(clazz1 == clazz2);
        // 第三种方式：Class.forName("全限定类名")
        Class clazz3 = Class.forName("com.atguigu.javase.reflect.Teacher");
        System.out.println(clazz1 == clazz3);
        // 第四种方式：通过类加载器
        ClassLoader classLoader = this.getClass().getClassLoader();
        Class clazz4 = classLoader.loadClass("com.atguigu.javase.reflect.Teacher");
        System.out.println(clazz3 == clazz4);
    }


    /**
     * 通过类模板，可以获取和这个类相关的所有信息
     */
    @Test
    public void test5() throws Exception {
        // 有了类模板，可以获取和这个类相关的所有信息
        Class<?> clazz = Class.forName("com.atguigu.javase.reflect.Teacher");
        Class<?> superclass = clazz.getSuperclass();    // 获取父类类型
        System.out.println(superclass);

        Class<?>[] interfaces = clazz.getInterfaces();  // 获取实现的所有接口
        System.out.println(interfaces);
    }


    /**
     * 写一个 Student 类，用反射的方式创建对象，并打印输出
     */
    @Test
    public void test44() {
        try {
            Class clazz = Class.forName("com.atguigu.javase.reflect.Student");
            Object object1 = clazz.newInstance();
            System.out.println(object1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }


    /**
     * 反射的使用
     * 访问私有属性 getDeclaredField(), 使用此方法前提是需要设置 setAccessible(true)
     */
    @Test
    public void test4() {
        try {
            Class clazz = Class.forName("com.atguigu.javase.reflect.Student");
            Object object1 = clazz.newInstance();
            System.out.println(object1);

            // getField 无法获取私有属性定义，其实它只能获取公共的属性定义，包括本类的和父类继承的
            // Field nameField = clazz.getField("name");

            // 获取本类中声明的任意属性，当然也包括私有的
            Field nameField = clazz.getDeclaredField("name");
            // 设置为可访问，就可以访问了。这是暴力反射！墙裂不建议，突破封装性
            nameField.setAccessible(true);
            nameField.set(object1, "小明");

            // 访问 age 属性
            Field ageField = clazz.getDeclaredField("age");
            ageField.setAccessible(true);
            ageField.set(object1, 20);  // 修改属性值

            // 访问
            Field genderField = clazz.getDeclaredField("gender");
            genderField.setAccessible(true);
            genderField.set(object1, "男");

            System.out.println(object1);
        } catch (ClassNotFoundException e) {    // 类名错误或类不存在
            e.getCause();
        } catch (IllegalAccessException e) {    // 访问了没有访问权限的成员。比如访问了私有成员
            e.printStackTrace();
        } catch (InstantiationException e) {    // 创建对象时构造器定位异常
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }


    /**
     * 反射的使用
     * 属性访问 getField(), 使用此方法前提是类中的属性的访问控制修饰符是public
     */
    @Test
    public void test3() {
        try {
            // 获取类模板对象
            Class clazz = Class.forName("com.atguigu.javase.reflect.Person");
            // 使用类模板对象，通过调用 newInstance()方法，创建Person类的对象
            Object obj = clazz.newInstance();
            System.out.println(obj);

            // 属性访问：类中的属性需要是public
            // 先找到属性定义对象，再配合 this对象，完成属性访问
            // Field 就是属性定义对象
            Field nameField = clazz.getField("name");   // 获取单个属性
            // 对象属性必须配合 this 对象，才能访问成功
            nameField.set(obj, "小红");   // 修改属性, obj.name = "小红"
            // 获取属性值并打印
            System.out.println(nameField.get(obj));

            // 访问 age 属性
            Field ageField = clazz.getField("age");
            ageField.set(obj, 22);  // 修改 age 属性值
            System.out.println(obj);


            // 获取类模板对象所表示的类的所有可访问属性的数组
            System.out.println("******************************");
            Field[] clazzFields = clazz.getFields();
            // 单独修改属性
            clazzFields[0].set(obj, "小芳");
            clazzFields[1].set(obj, 22);
            for (Field tmp: clazzFields) {
                System.out.println(tmp.get(obj));
            }
            System.out.println("******************************");
        } catch (ClassNotFoundException e) {    // 类名错误或类不存在
            e.getCause();
        } catch (IllegalAccessException e) {    // 访问了没有访问权限的成员。比如访问了私有成员
            e.printStackTrace();
        } catch (InstantiationException e) {    // 创建对象时构造器定位异常
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }


    /**
     * 干预类的加载
     * Class.forName("类的全限定名称");   // 结果就是类模板对象
     */
    @Test
    public void test2() {
        try {
            // 手工加载类模板，结果就是获取到了类模板对象，根据类名加载类模板，动态加载类
            // 注意：参数的类名必须全限定类名，且包名之间使用 "."
            Class clazz = Class.forName("com.atguigu.javase.reflect.Person");
            // 依据类模板，通过调用方法来创建对象，像工厂，调用了无参构造器创建对象
            // clazz 是Person类模板，所以创建出来的对象就是 Person 对象
            Object object1 = clazz.newInstance();
            System.out.println(object1);
            Object object2 = clazz.newInstance();
            System.out.println(object2);
        } catch (ClassNotFoundException e) {    // 类名错误或类不存在
            e.getCause();
        } catch (IllegalAccessException e) {    // 访问了没有访问权限的成员。比如访问了私有成员
            e.printStackTrace();
        } catch (InstantiationException e) {    // 创建对象时构造器定位异常
            e.printStackTrace();
        }
    }


    /**
     * 正常情况下，不使用反射机制创建对象
     */
    @Test
    public void test1() {
        // 无参构造方法，问题暴露在编译时，对 Person是一种强依赖，硬编码。
        Person p1 = new Person();
        p1.setName("小明");
        p1.setAge(10);

        System.out.println(p1.getName());
        System.out.println(p1.getAge());
        System.out.println(p1);

        Person p2 = new Person("宁姐", 20);
        System.out.println(p2);
    }


    /**
     * 第三种获取类模板对象的方法：Class.forName("")
     */
    @Test
    public void test0() throws Exception {
        // Person 类是 com.atguigu.javase.reflect包下的一个类
        String str = "com.atguigu.javase.reflect.Person";
        // 获取类模板对象
        Class strClass = Class.forName(str);
        System.out.println(strClass);

        // 调用缺省构造函数，返回该Class对象的一个实例并赋值给 obj
        Object obj = strClass.newInstance();
        System.out.println(obj);

        // 获取Class对象所表示的类的Field
        Field field = strClass.getField("name");
        Field field2 = strClass.getField("age");
        System.out.println(field);
        System.out.println(field2);
    }
}
