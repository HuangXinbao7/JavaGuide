package com.atguigu.jdbc.dao;

import com.atguigu.jdbc.javabean.Customer;
import com.atguigu.jdbc.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.util.List;

/**
 * DAO：Data Access Object 数据访问对象
 *
 * 专门处理 Customer 类和 custoemr 表之间的映射
 */
public class CustomerDAO {

    /**
     * 查询器对象变成属性，更便于使用
     */
    private QueryRunner queryRunner = new QueryRunner();


    /**
     * 用于从数据库中获取对象集合
     * @param sql
     * @param args
     * @return
     */
    public List<Customer> getList(String sql, Object... args) {
        Connection connection = null;
        try {
            connection = JdbcUtil.getConnection();
            BeanListHandler<Customer> beanListHandler = new BeanListHandler<>(Customer.class);
            return queryRunner.query(connection, sql, beanListHandler, args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection);
        }
        // 表示查询失败
        return null;
    }


    /**
     * 单独获取一个对象的方法
     * @param sql
     * @param args
     * @return
     */
    public Customer getBean(String sql, Object... args) {
        Connection connection = null;
        try {
            connection = JdbcUtil.getConnection();
            BeanHandler<Customer> beanHandler = new BeanHandler<>(Customer.class);
            return queryRunner.query(connection, sql, beanHandler, args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection);
        }
        // 表示查询失败
        return null;
    }


    /**
     * @param sql
     * @param args
     * @return
     */
    public Customer getValue(String sql, Object... args) {
        Connection connection = null;
        try {
            connection = JdbcUtil.getConnection();
            ScalarHandler scalarHandler = new ScalarHandler();
            //return queryRunner.query(connection, sql, scalarHandler);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection);
        }
        // 表示查询失败
        return null;
    }



}
