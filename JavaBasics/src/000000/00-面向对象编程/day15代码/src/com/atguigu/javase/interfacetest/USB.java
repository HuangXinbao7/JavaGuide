package com.atguigu.javase.interfacetest;

/*练习 : 声明USB接口interface ，在接口中声明 connect方法、work方法和disconnect方法。编译并确认接口生成的class文件*/
public interface USB {

    void connect();

    void work();

    void disconnect();
}
