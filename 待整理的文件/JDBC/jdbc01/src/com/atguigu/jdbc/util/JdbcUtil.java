package com.atguigu.jdbc.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {

    /**
     * 获取连接
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
        InputStream inputStream = JdbcUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        inputStream.close();

        String driverClass = properties.getProperty("driverClass");
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        Class.forName(driverClass);
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
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
}
