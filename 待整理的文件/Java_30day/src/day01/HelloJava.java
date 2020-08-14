/*
* 1、Java规范了三种注释方式：
* 单行注释
* 多行注释
* 文档注释（java特有）
*
* 2、单行注释和多行注释的作用：
* 对所写的代码程序进行解释说明，增强代码的可读性。方便自己也方便别人理解代码。
* 帮助调试所写的代码。
*
* 3、特点：
* 注释的内容不参与编译。即编译后的 .class 格式的字节码文件不包含注释掉的内容
*
* 4、文档注释的使用：
* 注释内容可以被JDK提供的工具 javadoc 所解析，生成一套以网页文件形式体现的该程序的说明文档。
*
* 5、多行注释不可以嵌套使用。
* */

package day01;

public class HelloJava {
    /*
    * 多行注释
    * main方法是程序运行的入口
    */
    public static void main(String[] args){
        // 单行注释
        System.out.println("Hello Java !");
    }
}
