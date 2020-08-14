/*
* 对第一个java程序的总结
* 1、java程序编写-编译-运行的过程
* 编写：将编写的java代码保存为 ".java" 结尾的源文件中
* 编译：使用javac.exe命令编译java源文件，生成以类名命名的字节码文件。格式：javac 源文件名.java
* 运行：使用 java.exe 命令解释运行字节码文件。格式：java 类名
*
* 2、
* 一个java源文件中可以声明多个class。但是最多只能有一个类被声明为 public 类。
* 且要求声明为public的类的类名与java源文件名相同。
*
* 3、程序的入口是main()方法, 格式固定的：public static void main(String[] args){...}
*
* 4、输出语句：
* System.out.println();
* System.out.print();
*
* 5、每一行执行语句都以 ";" 结束。
*
* 6、编译的过程：
* 编译后，生成一个或多个字节码文件。字节码文件的文件名与java源文件中的类名相同。
*
* */

package day01;

/**
 * 这是个文档注释，用于注释类
 */
public class HelloWorld {
    public static void main(String[] args){
        // 这是个单行注释，
        System.out.println("Hello World !");
        /*
        * 这是个多行注释
        * */
        System.out.println("Hello Java !");
    }
}
