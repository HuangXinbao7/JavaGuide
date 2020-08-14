package com.atguigu.jdbc.test;

import com.alibaba.druid.support.json.JSONUtils;
import com.atguigu.jdbc.javabean.Customer;
import com.atguigu.jdbc.javabean.Teacher;
import com.atguigu.jdbc.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

/**
 * ResultSetHandler 作用是处理结果集数据
 *      BeanListHandler 把结果集
 */
public class DBUtilsTest {



    @Test
    public void test9() {
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from student";
        //new BeanListHandler<>(Student);


        Connection connection = null;

        try {
            connection = JdbcUtil.getConnection();
            //String sql = "select max(id) from teacher where id > ?";
            // 用于集合函数

            // 取第一行第一列
            ScalarHandler scalarHandler = new ScalarHandler();
            Object object = queryRunner.query(connection, sql, scalarHandler, 0);
            System.out.println(object);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection);
        }
    }






    /**
     * max
     */
    @Test
    public void test8() {
        QueryRunner queryRunner = new QueryRunner();
        Connection connection = null;

        try {
            connection = JdbcUtil.getConnection();
            //String sql = "select max(id) from teacher where id > ?";
            // 用于集合函数
            String sql = "select count(*) from teacher where id > ?";

            // 取第一行第一列
            ScalarHandler scalarHandler = new ScalarHandler();
            Object object = queryRunner.query(connection, sql, scalarHandler, 0);
            System.out.println(object);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection);
        }
    }



    /**
     * 使用 ArrayHandler
     */
    @Test
    public void test7() {
        QueryRunner queryRunner = new QueryRunner();
        Connection connection = null;

        try {
            connection = JdbcUtil.getConnection();
            String sql = "select * from teacher where id > ?";

            // 取第一行第一列
            ScalarHandler scalarHandler = new ScalarHandler();
            Object object = queryRunner.query(connection, sql, scalarHandler, 0);
            System.out.println(object);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection);
        }
    }



    /**
     * 使用 ArrayHandler
     */
    @Test
    public void test6() {
        QueryRunner queryRunner = new QueryRunner();
        Connection connection = null;

        try {
            connection = JdbcUtil.getConnection();
            String sql = "select * from teacher where id > ?";

            ArrayListHandler arrayListHandler = new ArrayListHandler();
            List<Object[]> list = queryRunner.query(connection, sql, arrayListHandler, 0);
            Iterator<Object[]> iterator = list.iterator();
            while (iterator.hasNext()) {
                Object[] next = iterator.next();
                for (int i = 0; i < next.length; i++) {
                    System.out.print(next[i] + "\t");
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection);
        }
    }


    /**
     * 使用 ArrayHandler
     */
    @Test
    public void test5() {
        QueryRunner queryRunner = new QueryRunner();
        Connection connection = null;

        try {
            connection = JdbcUtil.getConnection();
            String sql = "select * from teacher where id > ?";


            // 把
            ArrayHandler arrayHandler = new ArrayHandler();
            Object[] objects = queryRunner.query(connection, sql, arrayHandler, 0);
            for (int i = 0; i < objects.length; i ++) {
                System.out.println(objects[i]);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection);
        }
    }


    /**
     * BeanListHandler 的使用
     * 这是频率最高的结果集处理器
     */
    @Test
    public void test4() {
        QueryRunner queryRunner = new QueryRunner();
        Connection connection = null;

        try {
            connection = JdbcUtil.getConnection();
            String sql = "select * from teacher where id > ?";

            // 把结果集中的所有对象保存为 javabean对象，并保存到一个集合中。
            BeanListHandler<Teacher> teacherBeanListHandler = new BeanListHandler<>(Teacher.class);
            List<Teacher> query = queryRunner.query(connection, sql, teacherBeanListHandler, 0);
            query.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection);
        }
    }


    /**
     * beanHandler
     * @throws SQLException
     */
    @Test
    public void test3() {
        QueryRunner queryRunner = new QueryRunner();
        Connection connection = null;

        try {
            connection = JdbcUtil.getConnection();
            String sql = "select * from teacher";

            // 处理单个对象，把结果集中的第一条记录转换成实体的javabean对象
            // 对象的类型由构造器指定
            BeanHandler<Teacher> beanHandler = new BeanHandler<>(Teacher.class);// 需要类模板对象
            // 返回一个 Customer 对象
            Teacher teacher = queryRunner.query(connection, sql, beanHandler);
            System.out.println(teacher);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection);
        }
    }


    @Test
    public void test2() throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        Connection connection = null;

        try {
            connection = JdbcUtil.getConnection();
            String sql = "select id, name, age, gender, phone from customer where id > ?";

            // 处理单个对象，把结果集中的第一条记录转换成实体的javabean对象
            // 对象的类型由构造器指定
            BeanHandler<Customer> beanHandler = new BeanHandler<>(Customer.class);// 需要类模板对象
            // 返回一个 Customer 对象
            Customer customer = queryRunner.query(connection, sql, beanHandler, 1);
            System.out.println(customer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection);
        }
    }


    @Test
    public void test1() throws SQLException {
        QueryRunner queryRunner = new QueryRunner();

        Connection connection = JdbcUtil.getConnection();
        int i = queryRunner.update(connection, "delete from customer where id < 1 ?");
        System.out.println(i + " rows");

        JdbcUtil.close(connection);

    }
}
