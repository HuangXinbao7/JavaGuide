package com.atguigu.jdbc.dao;

import com.atguigu.jdbc.javabean.Customer;
import org.junit.Test;

import java.util.List;

public class DAOTest {



    @Test
    public void test2() {
        CustomerDAO customerDAO = new CustomerDAO();
        String sql = "select * from customer";
        //customerDAO.getBean(sql)
        //
        //System.out.println(list);
    }



    @Test
    public void test1() {
        CustomerDAO customerDAO = new CustomerDAO();

        String sql = "select * from customer";
        List<Customer> list = customerDAO.getList(sql, 0);
        list.forEach(System.out::println);

        Customer customer = customerDAO.getBean("select * from customer", 3);
        System.out.println(customer);

        Customer value = customerDAO.getValue("select sum(age) from customer");
        System.out.println(value);

        String sql2 = "insert into customer(name, age, gender, phone) values(?,?,?,?)";
        //int n = customerDAO.


    }
}
