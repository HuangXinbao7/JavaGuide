package com.atguigu.javase.io;

import org.junit.Test;
import org.omg.CORBA.MARSHAL;

import java.io.*;

/**
 * 字节，字符，输入，输出
 * InputStream OutputStream Reader Writer
 * 文件流
 * FileInputStream FileOutputStream FileReader FileWriter
 * 缓冲区
 * BufferedInputStream BufferedOutputStream
 * BufferedReader BufferedWriter
 * 对象流（字节流）
 * ObjectInputStream ObjectOutputStream
 *
 * 转换流
 * InputStreamReader   字节流 -> 字符流
 * OutputStreamWriter  字节流 -> 字符流
 *
 * 重点流：
 * FileInputStream, FileOutputStream, BufferedReader, BufferedWriter
 *
 */
public class IOTest {

    /**
     * 练习：
     */
    @Test
    public void exer4() {

    }

    /**
     * 转换流之输出流
     */
    @Test
    public void test21() {

        //try

    }


    /**
     * 转换流之输入流
     * 使用转换流处理文本，并使用BufferedReader包装
     */
    @Test
    public void test20() {
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader buf = null;



    }


    /**
     * 对象流：对象反序列化
     */
    @Test
    public void test11() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream("对象序列化");
            ois = new ObjectInputStream(fis);

            Object obj1 = ois.readObject();
            Object obj2 = ois.readObject();
            Object obj3 = ois.readObject();
            System.out.println(obj1);
            System.out.println(obj2);
            System.out.println(obj3);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 对象流：对象序列化
     */
    @Test
    public void test10() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try{
            fos = new FileOutputStream("对象序列化");
            oos = new ObjectOutputStream(fos);

            Student s1 = new Student(1, "小明", 3, 50);
            Student s2 = new Student(2, "小丽", 2, 100);
            Student s3 = new Student(3, "小花", 3, 80);
            oos.writeObject(s1);
            oos.writeObject(s2);
            oos.writeObject(s3);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    /**
     * 使用对象流写一个二进制文件， 保存随机个(100个以内）的随机数(100以内)。
     * 再写程序把所有的随机数都读出来
     */
    @Test
    public void test5() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;   // 对象流直接包装字节流

        try {
            fis = new FileInputStream("随机数");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }


    /**
     * 使用对象流写一个二进制文件， 保存随机个(100个以内）的随机数(100以内)。
     * 再写程序把所有的随机数都读出来
     */
    @Test
    public void test4() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream("随机数");
            oos = new ObjectOutputStream(fos);

            int rand = (int)(Math.random() * 100);
            oos.writeInt(rand);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }




    }


    @Test
    public void test3() {

    }


    /**
     * 已知在项目的模块atguigu下存在copy.txt文件，文件中具有如下数据：
     * 尚硅谷
     * 观察下列代码，求最终结果：( )
     */
    @Test
    public void exer3() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("atguigu\\copy.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("atguigu\\copy.txt"));
        String line=null;
        while((line=br.readLine())!=null){bw.write(line);}
        bw.close();
        br.close();
    }


    /**
     * 使用缓冲流
     * 结论：使用缓冲流反而慢，使用节点流快
     */
    @Test
    public void exer2() {
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("E:/TestFiles/CentOS-7-x86_64-DVD-1908.iso");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }


    /**
     *
     * 使用字节流
     */
    @Test
    public void exer1() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("E:/TestFiles/CentOS-7-x86_64-DVD-1908.iso");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 更高级的读文件方式，使用 BufferedReader
     */
    @Test
    public void test2() {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try{
            fileReader = new FileReader("HashMap.java");
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    /**
     * 最原始的方式读文件
     */
    @Test
    public void test1() {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("day24.iml");
            /*
            int ch;
            // 一次只能读取一个字符，效率低
            while ((ch = fileReader.read()) != -1) {
                System.out.print((char)ch);
            }
            */

            // 更好的读文件方式：使用缓冲区
            char[] buf = new char[1024];
            int n; // n的作用是从输入流中一次读到的数组后，实际读了多少
            while ((n = fileReader.read(buf)) != -1) {
                // 处理数据时，只处理 n 个
                for (int i = 0; i < n; i++) {
                    System.out.print(buf[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try{
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 字符输出流的简单实例
     */
    @Test
    public void test() throws IOException {
        File file = new File("汉字文件");
        boolean newFile = file.createNewFile();
        System.out.println(newFile);

        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("这是汉字");
        fileWriter.close();
    }
}
