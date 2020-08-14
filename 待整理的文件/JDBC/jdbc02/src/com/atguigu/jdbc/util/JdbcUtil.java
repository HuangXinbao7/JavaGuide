package com.atguigu.jdbc.util;

//import com.mysql.jdbc.Connection;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 */
public class JdbcUtil {


    private static DataSource dataSource;

    // 静态属性
    // 在类加载的时候就把连接池对象创建出来
    static {
        try {
            Properties properties = new Properties();
            InputStream inputStream = JdbcUtil.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(inputStream);
            System.out.println(properties.toString());
            inputStream.close();
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 工具类的进一步封装
     * @return
     */
    public static Connection getConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        return connection;
    }


    /**
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Connection getConnection1() throws IOException, ClassNotFoundException, SQLException {

        InputStream inputStream = JdbcUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        inputStream.close();

        // 获取配置信息
        String driverClass = properties.getProperty("driverClass");
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        // 加载驱动类
        Class.forName(driverClass);
        //java.sql.Connection connection = DriverManager.getConnection(url, user, password);
        //return connection;
        return DriverManager.getConnection(url, user, password);
    }


    /**
     * 关闭连接
     * @param connection
     */
    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 方法的重载
     */
    public static void close(Connection connection, Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



    public static void close(Connection connection, Statement statement, ResultSet resultSet) {

        if (statement != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
