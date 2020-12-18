package com.atguigu.javase.io;

import org.junit.Test;

/**
 * 处理流：在其他流的基础上进行连接，包装，在不改变被包装流的基础之上，提供更加好用的功能。
 */
public class IOTest {


    /**
     * 编码
     */
    @Test
    public void test8() throws UnsupportedEncodingException {
        int n = 0x6211;
        System.out.println((char)n);
        String s1 = "abc我爱你qqq";    // 在程序中，字符串永远是 Unicode字符序列。
        // 如果把字符串保存文件或网络传输，必须要编码。为了省空间和高效通过。

        // 读文件时是解码
        int n2 = 0xCED2;
        System.out.println((char)n2);

        // 编码：字符串 => 字节数组，为了保存字符串
        // 存文件时是编码
        //byte[] bytes1 = s1.getBytes(");    // 编码，默认使用的是utf8
        byte[] bytes2 = s1.getBytes("utf8");    // 使用指定的编码方式编码
        for (int i = 0; i < bytes2.length; i++) {
            System.out.println(Integer.toHexString(bytes2[i])  + " ");
        }
        System.out.println();

        // 解码：字符数组 => 字符串，为了读取内容转成字符串
        //String ss1 = new String(bytes1); // 使用默认的编码方式解码
        String ss1 = new String(bytes2, "utf8");    // 指定编码
        System.out.println(ss1);

        // 把2个字节的gbk码，查表对应到相应的 Unicode码
        String ss2 = new String(bytes2, "gbk");
        System.out.println(ss2);
    }


    /**
     * 再写一个程序，把这50个随机数读出来。
     */
    @Test
    public void exer66() {

        FileInputStream fis = null;
        BufferedInputStream bis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream("50个随机数");
            bis = new BufferedInputStream(fis);
            ois = new ObjectInputStream(bis);

            for(int i = 0; i < 50; i++){
                int n = ois.readInt();
                System.out.println(n);
            }
            // 读字符串
            System.out.println(ois.readUTF());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(ois != null) {
                try {
                    ois.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 练习：写一个程序，在文件中写入50个随机的100以内的整数，写成二进制文件。
     * 再写一个程序，把这50个随机数读出来。
     * 写一个字符串，UTF-8编码，中文
     */
    @Test
    public void exer6() {
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream("50个随机数");
            bos = new BufferedOutputStream(fos);
            oos = new ObjectOutputStream(bos);

            for (int i = 0; i < 50; i++) {
                int n = (int)(Math.random() * 100);
                oos.writeInt(n);    // 写入整数
            }
            // 写入字符串
            String str = new String("这里是UTF8编码的文本");
            oos.writeUTF(str);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(oos != null) {
                try {
                    oos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @Test
    public void test7() {
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream("二进制文件");
            bis = new BufferedInputStream(fis);
            ois = new ObjectInputStream(bis);

            // 处理数据
            int i = ois.readInt();
            System.out.println(i);

            boolean b1 = ois.readBoolean();
            boolean b2 = ois.readBoolean();
            System.out.println(b1);
            System.out.println(b2);

            long l =ois.readLong();
            System.out.println(l);

            double d = ois.readDouble();
            System.out.println(d);

            String s = ois.readUTF();
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }


    /**
     * 对象流
     * 字节流一定是二进制文件
     */
    @Test
    public void test6() {
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        // 二进制文件中保存的数据通常是内存数据的副本。
        ObjectOutputStream oos = null;

        try{
            fos = new FileOutputStream("二进制文件");
            bos = new BufferedOutputStream(fos);
            oos = new ObjectOutputStream(bos);
            // 处理数据
            oos.writeInt(10);           // 写4个字节数据
            oos.writeBoolean(true);     // 写一个字节数据
            oos.writeBoolean(false);
            oos.writeLong(20);          // 写8字节数据
            oos.writeDouble(3.14);
            oos.writeUTF("这是UTF8字符串");      // UTF8格式的字符串
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 使用缓冲流写文本
     */
    @Test
    public void exer5() {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;

        try {
            fileWriter = new FileWriter("使用缓冲流写文本");
            bufferedWriter = new BufferedWriter(fileWriter);

            String[] content = {
                    "我是一些内容的字符串1",
                    "我是一些内容的字符串2",
                    "我是一些内容的字符串3",
                    "我是一些内容的字符串4",
                    "我是一些内容的字符串5",
                    "我是一些内容的字符串6",
                    "我是一些内容的字符串7",
                    "我是一些内容的字符串8",
                    "213424982374982374892734234",
                    "falksdflakslskajflkajsdfkljasdf",
            };
            for (int i = 0; i < content.length; i++) {
                bufferedWriter.write(content[i]);
                bufferedWriter.newLine();   // 写跨平台的换行，这是最有价值方法 ***
                /* 使用上面的方法代替
                bufferedWriter.write(13);
                bufferedWriter.write(10);
                */
            }
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @Test
    public void exer4() {}


    /**
     * 使用缓冲流读文件
     */
    @Test
    public void test4() {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try{
            // 包装就是对象关联
            fileReader = new FileReader("HashMap.java.bak");
            bufferedReader = new BufferedReader(fileReader);

            String line;
            // readline() 方法是最有价值方法 ！！
            // 直接从输入流中读一行字符串
            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);   // line中没有了换行
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 只需要关闭高级流， 因为在关闭高级流时，会自动地顺带把低级流关闭了
            if(bufferedReader != null) {
                try{
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 使用字节输入输出流复制文件。能处理任意文件的复制
     */
    @Test
    public void exer3() {
        // 创建字节输入流和字符输出流
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream("大风起兮 - LuckyMaxx.flac");
            fos = new FileOutputStream("大风起兮 - LuckyMaxx_复制.flac");

            // 处理数据
            byte[] buf = new byte[8192];    // 8k效率最高
            int n;
            while ((n = fis.read(buf)) != -1) {
                fos.write(buf, 0, n);
            };
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭输入流
            if(fis != null) {
                try{
                    fis.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            // 关闭输出流
            if(fos != null) {
                try {
                    fos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 使用缓冲区的方式复制文件
     * 使用字符输入输出流，只能处理文本
     */
    @Test
    public void exer2() {
        // 创建字符输入流和字符输出流
        FileReader fileReader = null;
        FileWriter fileWriter = null;

        // 源文件和目标文件的路径
        String inputFilePath = "./src/com/atguigu/javase/io/FileCopy.java";
        String outputFilePath = "./src/com/atguigu/javase/io/FileCopy.java.bak";

        try {
            // 创建输入流和输出流对象
            fileReader = new FileReader(inputFilePath);
            fileWriter = new FileWriter(outputFilePath);

            // 循环读取源文件中的内容，并将读到的内容写入目标文件中
            // 这是落后的方式
            /*int ch = 0;
            while ((ch = fileReader.read()) != -1) {
                fileWriter.write(ch);
            }*/

            // 使用缓冲区的方式复制文件
            char[] buf = new char[1024];
            int n;

            while ((n = fileReader.read(buf)) != -1) {
                for (int i = 0; i < n; i++) {
                    fileWriter.write(buf, 0, n);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭输入流
            if(fileReader != null) {
                try{
                    fileReader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            // 关闭输出流
            if(fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 练习: 创建一个字符串数组，保存一些同学的姓名，写文件，只写名的部分。
     */
    @Test
    public void exer1() {

        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter("写文件-只写名字");

            String[] stu = {"黄渤", "黄磊", "孙红雷", "陈奕迅", "张学友"};

            for (int i = 0; i < stu.length; i++) {
                char[] array = stu[i].toCharArray();
                // 重点语句
                fileWriter.write(array, 1, array.length - 1);
                fileWriter.write(13);
                fileWriter.write(10);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileWriter != null) {
                try{
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 使用缓冲区写文件
     */
    @Test
    public void test3() {
        // 通过输出流写数组
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("使用数组写文件");

            // 处理数据
            String[] content = {
                    "这是一些内容的字符串1",
                    "这是一些内容的字符串1",
                    "这是一些内容的字符串1",
                    "这是一些内容的字符串1",
                    "232141234510327015",
                    "sfdgsdhsthasdhs",
            };

            for(int i = 0; i < content.length; i++) {
                char[] array = content[i].toCharArray();
                //fileWriter.write(array);    // 一次性写一个数组

                // 第2个参数是数组的开始索引，第3个参数是要写的长度（字符数）
                // 把数组的一部分数据写入到输出流中。重点方法 ****
                //fileWriter.write(array, 4, array.length - 4);
                fileWriter.write(array, 4, 5);

                fileWriter.write(13);   // 回车
                fileWriter.write(10);   // 换行
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 使用缓冲的字符输入流
     */
    @Test
    public void test2() {
        FileReader fileReader = null;

        try {
            fileReader = new FileReader("./src/com/atguigu/javase/io/BufferData");

            // 处理数据
            char[] buf = new char[100]; // 缓冲区
            int n;  // 保存每次读到缓冲区中的实际字符数
            // 前几次肯定是满的，最后一次不满，n <= 数组的长度
            // 只要没有读到末尾，就一直读取，-1表示读完最后一次再读的情况。
            while ((n = fileReader.read(buf)) != -1) {
                for(int i = 0; i < n; i++) {    // 循环次数以实际读到的字符个数为准
                    System.out.print(buf[i]);
                }
                //System.out.println(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭输入流
            if(fileReader != null) {
                try{
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 普通字符输入流
     */
    @Test
    public void test1() {
        FileReader fileReader = null;

        try {
            fileReader = new FileReader("./src/com/atguigu/javase/io/InputData");

            // 处理数据
            int ch;
            while ((ch = fileReader.read()) != -1) {
                System.out.print((char)ch);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭输入流
            if(fileReader != null) {
                try{
                    fileReader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
