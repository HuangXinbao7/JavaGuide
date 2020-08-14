package com.atguigu.jdbc.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 封装方法
 */
public class CommonUtil {

    /**
     * 把连接做成参数 connection
     * @param connection
     * @param sql
     * @param args
     * @return 影响的行数
     */
    public static int update(Connection connection, String sql, Object... args) throws SQLException, IOException, ClassNotFoundException {

        PreparedStatement preparedStatement = null;
        try {
            //connection = JdbcUtil.getConnection();
            // 根据 sql 预编译执行体对象
            preparedStatement = connection.prepareStatement(sql);

            // 使用循环处理 sql 中的 “？”
            for (int i = 0; i < args.length; i++) {
                // 数据库中的下标永远是从1开始
                preparedStatement.setObject(i + 1, args[i]);
            }
            // 执行绑定好的 sql，并确定"?"都被替换后才可以执行，并返回影响的行数 i
            int i = preparedStatement.executeUpdate();
            // 查看 i
            System.out.println(i + " rows");
            // 返回影响的行数
            return i;
        } finally {     // 保证资源一定会被关闭
            // 不要真的关闭连接，因为连接对象是别人给的
            JdbcUtil.close(null, preparedStatement);
        }
    }


    // 使用可变参数代替数组参数
    // 把异常抛给调用者，自己不捕捉也不处理，因为这是工具类方法
    public static int update(String sql, Object... args) throws SQLException, IOException, ClassNotFoundException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int i;

        try {
            connection = JdbcUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            // 使用循环
            for (i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            // 执行，并返回影响的行数 i
            i = preparedStatement.executeUpdate();
            // 查看 i
            System.out.println(i + " rows");
            //return i;
        } finally {
            JdbcUtil.close(connection, preparedStatement);
        }
        return i;
    }
}
