package com.atguigu.jdbc.test;

import com.atguigu.jdbc.util.CommonUtil;
import com.atguigu.jdbc.util.JdbcUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 事务：一组 DML 操作，让数据从一种状态到另一种状态
 *  ACID 特性：A：原子性，C：一致性，I：隔离性，D：持久性
 *      1）设置自动提交为 false
 *      2）多个 DML 形成一个整体的事务
 *      3）结束事务
 *          提交事务（全成功），在try的最后
 *          回滚事务（全失败），在catch中回滚
 *      4）还原设置
 *          在finally中
 *
 *
 *
 *
 */
public class TransactionTest {

    // 事务
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        try {
            connection = JdbcUtil.getConnection();
            connection.setAutoCommit(false);
            CommonUtil.update("select * from customer");
        } catch (IOException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } finally {

            try {
                connection.setAutoCommit(true);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            JdbcUtil.close(connection);
        }
    }
}
