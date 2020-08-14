import java.io.*;
import java.util.Scanner;

/**
 * Java中从命令行控制台输入数据的几种常用方法
 * 1 使用标准输入串对象 System.in
 * 2 使用Scanner获取一个字符串或一组数字
 * 3 使用 BufferedReader 获取包含空格的输入
 */
public class InputTest {

    /**
     * 3 使用 BufferedReader 取得含空格的输入
     * Scanner 取得的输入一 space、tab、enter 键为结束符
     * 要想取得包含 space 在内的输入，可以用 java.io.BufferedReader 类来实现
     */
    public static void main(String[] args) throws IOException {
        // 使用 BufferedReader 的readLine() 方法，必须要处理 java.io.IOException 异常
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tx = br.readLine();
        System.out.println(tx);
    }


    /**
     * 2 使用 Scanner 获取一个字符串或一组数字
     *
     */
    public static void main2(String[] args) {

        Scanner sc = new Scanner(System.in);    // 使用 System.in 获取用户输入
        System.out.print("enter a string: ");
        System.out.println(sc.next());      // 取得用户输入的字符串
    }


    /**
     * 1 使用标准输入串对象System.in
     * 在java中，使用System.out表示标准输出设备，使用System.in表示标准输入设备。
     * 默认情况下，输出设备是显示器，输入设备是键盘。
     * 为完成控制台输出，只需要使用println方法就可以在控制台上现实基本值或字符串。
     * java并不直接支持控制台输入，可以使用 Scanner 类创建它的对象，用以读取来自 System.in 的输入。
     */
    public static void main1(String[] args) {

        Scanner xx = new Scanner(System.in);    // 创建一个 Scanner 类型的对象，并将它的引用值赋给变量 xx
        System.out.print("Enter a number: ");
        int number = xx.nextInt();  // 读取一个int类型的整数
        System.out.println("number = " + number);
    }
}
