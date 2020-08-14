package com.atguigu.jdbc.test;

//import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.atguigu.jdbc.util.JdbcUtil;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 */
public class DataSourceTest {


    /**
     * 使用封装好的连接池
     * @throws Exception
     */
    @Test
    public void test3() throws Exception {
        Connection connection = JdbcUtil.getConnection();
        System.out.println(connection);

    }



    /**
     * 使用连接池
     * @throws Exception
     */
    @Test
    public void test2() throws Exception {
        Properties properties = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("druid.properties");
        properties.load(inputStream);
        System.out.println(properties.toString());
        inputStream.close();

        /*
        initialSize = 3 初始的时候，连接池中的连接个数
        maxActive = 50  最大激活数，上限 （不能超过数据库最大连接数）
        minIdle = 10    最小发呆数，如果没有请求了，池中的保持最少的连接池发呆（闲置，等待）
        */
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        //connection.close();
    }


    @Test
    public void test1() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();

        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/jdbc");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        DruidPooledConnection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
