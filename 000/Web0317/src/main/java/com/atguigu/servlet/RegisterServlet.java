package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Create by XinB on 2020/7/2 16:06
 *
 * 基于Tomcat对Servlet规范的是实现，处理客户端的请求
 * Sun制定了Servlet规范, Tomcat实现了Servlet规范
 */
public class RegisterServlet extends HttpServlet {
    /**
     * doGet：用于处理客户端的get方式的请求
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        super.doGet(req, resp);
    }

    /**
     * doPost：用于处理客户端的post方式的请求
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        super.doPost(req, resp);
    }

    /**
     * service：重写HttpServlet中service的逻辑，在方法中处理所有的请求
     * @param req  请求对象，
     * @param resp 响应对象
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 1 处理请求和响应的乱码问题
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();

        // 2 获取客户端提交的数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // 3 数据的校验

        // 数据失败，注册请求被打回，数据校验成功，继续后续处理
        if("".equals(username) || "".equals(password)){
            writer.println("REGISTER FAIL");
            writer.close();
            return;
        }

        // 5 将检验成功的数据，写到数据库中
        // JDBC
        System.out.println("REGISTER SUCCESS: " + username + ", " + password);

        // 6 给客户端响应
        writer.println("REGISTER SUCCESS");
        writer.close();
    }
}
