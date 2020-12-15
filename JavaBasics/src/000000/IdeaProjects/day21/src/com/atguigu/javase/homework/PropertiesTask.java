package com.atguigu.javase.homework;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 作业5：使用Properties处理一个属性文件，读取文件中的配置信息
 */
public class PropertiesTask {

    @Test
    public void test() throws IOException {

        // 创建Properties属性类对象
        Properties properties = new Properties();
        // 加载配置文件
        // 文件查找的起始位置是项目的根目录
        properties.load(new FileInputStream("src\\com\\atguigu\\javase\\homework\\myPropertiesFile"));

        // 读取配置信息
        String url = properties.getProperty("url");
        System.out.println(url);

        String username = properties.getProperty("username");
        System.out.println(username);

        String password = properties.getProperty("password");
        System.out.println(password);
    }
}
