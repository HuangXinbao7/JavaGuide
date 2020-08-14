package com.atguigu.jdbc.test;

import com.atguigu.jdbc.util.CommonUtil;
import com.atguigu.jdbc.util.JdbcUtil;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
//import com.atguigu.jdbc.util.JdbcUtil *;
import java.util.Properties;

/**
 * java.sql.Driver 是一个接口，表示驱动程序，要想使用数据库，必须安装驱动程序。
 * 真正的 Driver 子类是由具体的数据库厂家提供
 *
 * 1）创建新项目，并在项目中创建目录 lib，lib目录主要用于保存各种 jar 包文件
 * 2）把
 *      mysql-connector-java-5.1.7-bin.jar
 *      mysql-connector-java-5.1.7-src.zip
 *  这两个文件复制到lib目录
 * 3）把 x.jar文件设置到 classpath中
 *      右击项目根目录，选择 “Open Module Settings”，
 *      左边选中的 “Libraries” 中间上面的 “+” -> 找到 .jar 包文件，点击确定。
 *      在右面的窗口中再点 “+” -> 找到 .zip 文件，点击确定。
 *      选择左边的“+”，“Add”，找到 x.src.zip 源码包
 * 4）创建Driver接口的子类对象，com.mysql.jdbc.Driver
 * 5）提供 URL 统一资源定位器： https://hao.360.com/2020.html?dfad
 *      真正连接前先创建数据库：
 *          create database if not exists jdbc charset utf8;
 * 6）Mysql URL: 主协议:子协议://服务器主机地址:端口号/数据库名
 *      jdbc:mysql://127.0.0.1:3306/jdbc
 * 7）再提供包含了用户名（user=root）和密码（password=123456）的map集合
 *
 * 实际使用中不用 Statement，因为有注入问题，且效率不好
 * 应该使用它的子类，PreparedStatement 预编译执行体，没有注入问题，且效率非常好。
 */
public class JdbcTest {


    @Test
    public void test6() throws SQLException, IOException, ClassNotFoundException {
        int update = CommonUtil.update("select * from customer", 3);
        System.out.println(update);
    }


    /**

     * 共用同一个 connection 连接对象，提升效率
     * 便于事务控制
     */
    @Test
    public void test5() {
        Connection connection = null;

        try {
            connection = JdbcUtil.getConnection();
            String sql = "create table if not exists student(" +
                    "id int auto_increment," +
                    "name varchar(20)," +
                    "age int," +
                    "mobile varchar(20)," +
                    "address varchar(50)," +
                    "score double," +
                    "primary key(id)" +
                    ")";
            // 没有 ？，省略最后的实参列表
            int n = CommonUtil.update(connection, sql);
            System.out.println(n + " rows");

            sql = "insert into student(name, age, mobile, address, score) values(?,?,?,?,?)";
            n = CommonUtil.update(connection, sql, "小明", 12, "111222", "北京", 90);
            System.out.println(n + " rows");
            n = CommonUtil.update(connection, sql, "小丽", 17, "111333", "上海", 60);
            System.out.println(n + " rows");
            n = CommonUtil.update(connection, sql, "小花", 15, "222444", "深圳", 100);
            System.out.println(n + " rows");
            n = CommonUtil.update(connection, sql, "小刚", 13, "225555", "乘车", 88);
            System.out.println(n + " rows");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection);
        }
    }


    /**
     * 使用封装的方法 update()
     * 缺点：连接
     */
    @Test
    public void test4() throws SQLException, IOException, ClassNotFoundException {

        String sql = "create table if not exists teacher(" +
                        "id int auto_increment," +
                        "name varchar(20)," +
                        "age int," +
                        "salary double," +
                        "phone varchar(20)," +
                        "primary key(id)" +
                    ")";
        int n = CommonUtil.update(sql);
        System.out.println(n + " rows");

        sql = "insert into teacher(name, age, salary, phone) values(?,?,?,?)";
        n = CommonUtil.update(sql, "佟刚", 40, 5000, "123123");
        System.out.println(n + " rows");
        n = CommonUtil.update(sql, "宁姐", 30, 8000, "111222");
        System.out.println(n + " rows");
        n = CommonUtil.update(sql, "大海", 20, 2000, "222333");
        System.out.println(n + " rows");
    }


    /**
     * 使用Object和循环
     */
    @Test
    public void test3() {
        // 创建预编译语句
        String sql = "insert into customer(name, age, gender, phone) values(?,?,?,?)";
        Object[] args = {"杨哥", 35, "男", "12121212"};


        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            /*
            // 统一用 setObject
            //preparedStatement.setObject(1, "佟刚");
            //preparedStatement.setObject(2, 30);
            //preparedStatement.setObject(3, "佟刚");
            //preparedStatement.setObject(4, "1212121");
            */

            // 使用循环
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            // 执行，并返回影响的行数 i
            int i = preparedStatement.executeUpdate();
            // 查看 i
            System.out.println(i + " rows");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection, preparedStatement);
        }
    }


    /**
     * 手动写代码
     */
    @Test
    public void test2() {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = JdbcUtil.getConnection();
            String sql = "create table if not exists customer (" +
                    "id int auto_increment," +
                    "name varchar(20) not null," +
                    "age int," +
                    "gender enum('男', '女') default '男'," +
                    "phone varchar(20)," +
                    "primary key(id)" +
                    ")";
            statement = connection.prepareStatement(sql);
            int rows = statement.executeUpdate();
            System.out.println(rows + "rows affected");

            sql = "insert into customer(name, age, gender, phone) values(?,?,?,?)";
            statement = connection.prepareStatement(sql);

            statement.setString(1,"张三");
            statement.setInt(2,30);
            statement.setString(3,"男");
            statement.setString(4,"123456789");
            rows = statement.executeUpdate();
            System.out.println(rows + " rows affected");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.close(connection, statement);
        }
    }





    @Test
    public void test05() {
        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtil.getConnection();
            System.out.println(connection);
            // 通过connection对象进一步获取执行体 对象, 执行体就可以执行SQL
            statement = connection.createStatement();
            String sql = "create table if not exists user(name varchar(20), password varchar(30))";
            statement.executeUpdate(sql); // 支持insert, update, delete, 及所有DDL
            int rows = statement.executeUpdate("insert into user(name, password) values('admin', 'admin')");
            System.out.println(rows + " affected");
            rows = statement.executeUpdate("insert into user(name, password) values('user', 'user')");
            System.out.println(rows + " affected");
            rows = statement.executeUpdate("insert into user(name, password) values('hello', '123456')");
            System.out.println(rows + " affected");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection, statement);
        }
    }



    @Test
    public void test04() throws Exception {
        // 反射方式处理，反射灵活
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        inputStream.close();

        String driverClass = properties.getProperty("driverClass");
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        Class.forName(driverClass);
        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println(connection);
        connection.close();     // 数据库连接是重要资源，要关闭


    }



    @Test
    public void test03() throws Exception {
        // 反射方式处理, 反射灵活
        Class.forName("com.mysql.jdbc.Driver"); // 加载类时它会自动完成自我注册.
        /* 这是com.mysql.jdbc.Driver类中的静态语句块, 我们只需要加载类, 即可完成注册
        代替我们之前的代码 :
        Driver driver = (Driver)clazz.newInstance(); // 创建对象
        DriverManager.registerDriver(driver); // 注册驱动
        * static {
                try {
                    java.sql.DriverManager.registerDriver(new Driver());
                } catch (SQLException E) {
                    throw new RuntimeException("Can't register driver!");
                }
            }
        * */
        String url = "jdbc:mysql://127.0.0.1:3306/jdbc";
        String user = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
        connection.close(); // 数据库连接是重要资源, 要关闭..
    }







    /**
     * 注册
     */
    @Test
    public void test02() throws Exception {
        // 反射方式处理, 反射灵活
        Class clazz = Class.forName("com.mysql.jdbc.Driver"); // 加载类
        Driver driver = (Driver)clazz.newInstance(); // 创建对象
        DriverManager.registerDriver(driver); // 注册驱动

        String url = "jdbc:mysql://127.0.0.1:3306/jdbc";
        Connection connection = DriverManager.getConnection(url, "root", "123456");
        System.out.println(connection);
    }




    @Test
    public void test01() throws SQLException {
        // 多态引用
        Driver driver = new com.mysql.jdbc.Driver(); // Mysql Driver子类写法固定.
        System.out.println(driver); // ???
        String url = "jdbc:mysql://127.0.0.1:3306/jdbc";
        // map集合, 保存所有连接数据库必须的信息, 如user, password
        Properties properties = new Properties();
        properties.put("user", "root");
        properties.put("password", "123456");
        Connection connect = driver.connect(url, properties);
        System.out.println(connect); // com.mysql.jdbc.JDBC4Connection@4141d797
    }

}
