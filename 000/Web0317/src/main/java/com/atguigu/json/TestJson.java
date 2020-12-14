package com.atguigu.json;

import com.atguigu.bean.User;
import com.google.gson.Gson;
import org.junit.Test;

/**
 * Create by XinB on 2020/7/2 17:09
 */
public class TestJson {

    @Test
    public void testJavaToJson(){

        User user = new User();
        user.setUsername("SongSong");
        user.setPassword("123456");

        Gson gson = new Gson();
        String toJson = gson.toJson(user);
        System.out.println("Gson: " + toJson);
    }

    public void testJsonToJava(){


    }

}
