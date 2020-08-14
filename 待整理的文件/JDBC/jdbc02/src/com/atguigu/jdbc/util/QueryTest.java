package com.atguigu.jdbc.util;

import com.atguigu.jdbc.javabean.Customer;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * 查询是重点和难点
 *
 */
public class QueryTest {


    @Test
    public void test5() {
        ArrayList<Customer> cusList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;     //结果集也是资源

        try {
            connection = JdbcUtil.getConnection();
            // 使用多行的 sql语句时，要特别注意关键字左右的空格，
            String sql = "select " +
                    "id," +
                    "name as custName," +
                    "age as custAge," +
                    "gender as custGender," +
                    "phone as custPhone " +
                    "from " +
                    "customer " +
                    "where id > ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, 0);

            //
            resultSet = preparedStatement.executeQuery();

            //
            ResultSetMetaData metaData = resultSet.getMetaData();
            //
            int cols = metaData.getColumnCount();
            System.out.println(cols);
            // 第一列的列名
            String columnName = metaData.getColumnName(1);
            System.out.println(columnName);
            while (resultSet.next()) {
                // 使用列标签代替列索引, 别标签不是列名，是虚表的列名，
                // 如果有别名，以虚表的列名为准
                // 好处：与顺序无关
                int n = resultSet.getInt("id");
                String name = resultSet.getString("custName");
                int age = resultSet.getInt("custAge");
                String gender = resultSet.getString("custGender");
                String phone = resultSet.getString("custPhone");

                // ORMapping：Object Relational Mapping，对象关系映射
                Customer customer = new Customer();
                //System.out.println(customer);
                // 把每个对象保存到集合中
                cusList.add(customer);

                // 常用的是获取列标签
                for (int i = 0; i < cols; i++){
                    String columnLabel1 = metaData.getColumnLabel(i + 1);
                    System.out.println(columnLabel1 + "\t");

                }
                System.out.println();
            }

            // 循环遍历输出
            for (Customer tmp: cusList) {
                System.out.println(tmp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            JdbcUtil.close(connection, preparedStatement, resultSet);
        }
    }


    /**
     * resultSet 中只有数据，如果想要获取表结构等元数据
     *
     */
    @Test
    public void test4() {
        ArrayList<Customer> cusList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;     //结果集也是资源

        try {
            connection = JdbcUtil.getConnection();
            // 使用多行的 sql语句时，要特别注意关键字左右的空格，
            String sql = "select " +
                    "id," +
                    "name as custName," +
                    "age as custAge," +
                    "gender as custGender," +
                    "phone as custPhone " +
                    "from " +
                    "customer " +
                    "where id > ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, 0);

            //
            resultSet = preparedStatement.executeQuery();

            //
            ResultSetMetaData metaData = resultSet.getMetaData();
            //
            int cols = metaData.getColumnCount();
            System.out.println(cols);
            // 第一列的列名
            String columnName = metaData.getColumnName(1);
            System.out.println(columnName);
            while (resultSet.next()) {
                // 使用列标签代替列索引, 别标签不是列名，是虚表的列名，
                // 如果有别名，以虚表的列名为准
                // 好处：与顺序无关
                int n = resultSet.getInt("id");
                String name = resultSet.getString("custName");
                int age = resultSet.getInt("custAge");
                String gender = resultSet.getString("custGender");
                String phone = resultSet.getString("custPhone");

                // ORMapping：Object Relational Mapping，对象关系映射
                Customer customer = new Customer();
                //System.out.println(customer);
                // 把每个对象保存到集合中
                cusList.add(customer);

                // 常用的是获取列标签
                for (int i = 0; i < cols; i++){
                    String columnLabel1 = metaData.getColumnLabel(i + 1);
                    System.out.println(columnLabel1 + "\t");

                }
                System.out.println();
            }

            // 循环遍历输出
            for (Customer tmp: cusList) {
                System.out.println(tmp);
            }

            //cusList.to





        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            JdbcUtil.close(connection, preparedStatement, resultSet);
        }
    }




    /**
     * 把每一条记录封装成对象, 并放到集合中
     *
     */
    @Test
    public void test3() {
        ArrayList<Customer> cusList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;     //结果集也是资源

        try {
            connection = JdbcUtil.getConnection();
            // 使用多行的 sql语句时，要特别注意关键字左右的空格，
            String sql = "select " +
                    "id," +
                    "name as custName," +
                    "age as custAge," +
                    "gender as custGender," +
                    "phone as custPhone " +
                    "from " +
                    "customer " +
                    "where id > ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, 0);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                // 使用列标签代替列索引, 别标签不是列名，是虚表的列名，
                // 如果有别名，以虚表的列名为准
                // 好处：与顺序无关
                int n = resultSet.getInt("id");
                String name = resultSet.getString("custName");
                int age = resultSet.getInt("custAge");
                String gender = resultSet.getString("custGender");
                String phone = resultSet.getString("custPhone");

                // ORMapping：Object Relational Mapping，对象关系映射
                Customer customer = new Customer();
                //System.out.println(customer);
                // 把每个对象保存到集合中
                cusList.add(customer);
            }

            // 循环遍历输出
            for (Customer tmp: cusList) {
                System.out.println(tmp);
            }

            //cusList.to
            //cusList.





        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            JdbcUtil.close(connection, preparedStatement, resultSet);
        }
    }




    /**
     * 使用别名系统来处理，但不推荐使用别名。
     * 使用列标签代替列索引
     */
    @Test
    public void test2() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;     //结果集也是资源

        try {
            connection = JdbcUtil.getConnection();
            // 使用多行的 sql语句时，要特别注意关键字左右的空格，
            String sql = "select " +
                        "id," +
                        "name as custName," +
                        "age as custAge," +
                        "gender as custGender," +
                        "phone as custPhone " +
                        "from " +
                        "customer " +
                        "where id > ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, 0);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                // 使用列标签代替列索引, 别标签不是列名，是虚表的列名，
                // 如果有别名，以虚表的列名为准
                // 好处：与顺序无关
                int n = resultSet.getInt("id");
                String name = resultSet.getString("custName");
                int age = resultSet.getInt("custAge");
                String gender = resultSet.getString("custGender");
                String phone = resultSet.getString("custPhone");
                System.out.println(n + "\t" + name + "\t" + age + "\t" + gender + "\t" + phone);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            JdbcUtil.close(connection, preparedStatement, resultSet);
        }
    }


    /**
     *
     */
    @Test
    public void test1() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;     //结果集也是资源

        try {
            connection = JdbcUtil.getConnection();
            // 不要使用 select *，因为非常被动
            String sql = "select id, name, age, gender, phone from customer where id > ?";

            /*
            mysql> select * from customer;
            +----+------+------+--------+-----------+
            | id | name | age  | gender | phone     |
            +----+------+------+--------+-----------+
            |  1 | 张三 |   30 | 男     | 123456789 |
            |  2 | 杨哥 |   35 | 男     | 12121212  |
            |  3 | 杨哥 |   35 | 男     | 12121212  |
            +----+------+------+--------+-----------+
            */

            preparedStatement = connection.prepareStatement(sql);
            // 替换sql中 "?" 符号
            // 第二个参数是 where 判断条件
            preparedStatement.setObject(1, 0);

            // 内部指针指向的的是第一行之前
            resultSet = preparedStatement.executeQuery();
            // 先判断游标后面是否有行，如果有返回 true，并且真的下移游标
            while (resultSet.next()) {
                // 获取当前行的第1列
                int n = resultSet.getInt(1);
                // 获取当前行的第2列
                String name = resultSet.getString(2);
                // 获取当前行的第3列
                int age = resultSet.getInt(3);
                // 获取当前行的第4列
                String gender = resultSet.getString(4);
                // 获取当前行的第5列
                String phone = resultSet.getString(5);
                System.out.println(n + "\t" + name + "\t" + age + "\t" + gender + "\t" + phone);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            JdbcUtil.close(connection, preparedStatement, resultSet);
        }
    }
}
