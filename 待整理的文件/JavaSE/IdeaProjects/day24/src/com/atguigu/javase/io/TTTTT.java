package com.atguigu.javase.io;

import org.junit.Test;

import java.io.*;

/**
 * 字节, 字符, 输入, 输出
 * InputStream OutputStream Reader Writer
 * 文件流
 * FileInputStream FileOutputStream FileReader FileWriter
 * 缓冲区
 * BufferedInputStream BufferedOutputStream BufferedReader BufferedWriter
 * 对象流(字节流)
 * ObjectInputStream ObjectOutputStream
 * 对象流的本职工作是处理对象。
 *
 * 复制文件时使用缓冲流反而慢, 用节点流快
 */
public class TTTTT {

    @Test
    public void test5() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("随机数");
            ois = new ObjectInputStream(fis);
            // 不知道有多少个随机数
            int count = ois.readInt();
            for (int i = 0; i < count; i++) {
                int i1 = ois.readInt();
                System.out.println(i1);
            }
            System.out.println("*****************************");
            int count2 = ois.readInt();
            for (int i = 0; i < count2; i++) {
                long l = ois.readLong();
                System.out.println(l);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test4() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("随机数");
            oos = new ObjectOutputStream(fos);
            int rand = (int)(Math.random() * 100);
            oos.writeInt(rand); // 先写整数个数
            for (int i = 0; i < rand; i++) {
                oos.writeInt((int)(Math.random() * 100));
            }
            int rand2 = (int)(Math.random() * 100);
            oos.writeInt(rand2); // 写long个数
            for (int i = 0; i < rand2; i++) {
                oos.writeLong((int)(Math.random() * 10000));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test3() {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("test2.txt");
            fileWriter.write("qalksdfalksdjflaskjdf");
            fileWriter.write(10);
            fileWriter.write("名师回蓝 国右中中");
            //fileWriter.flush(); // 把OS缓冲区中的数据刷入硬盘
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close(); // close前会自动调用flush
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void exer3() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("HashMap.java"));
        // 如果不加第2个参数, 文件 的打开方式是清空, 第2个参数如果是true, 以追加的方式打开.
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("HashMap.java", true));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            //bufferedWriter.flush();
        }
        bufferedReader.close();
        bufferedWriter.close();
    }

    @Test
    public void exer2() { // 使用缓冲流反而慢, 用节点流快
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        long l1 = System.currentTimeMillis();
        try {

            fis = new FileInputStream("day24.zip");
            bis = new BufferedInputStream(fis);
            fos = new FileOutputStream("test2.zip");
            bos = new BufferedOutputStream(fos);
            byte[] buffer = new byte[8192];
            int n;
            while ((n = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, n);// 实际读了n个, 写n个字节
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        long l2 = System.currentTimeMillis();
        System.out.println("使用BufferedInputStream : " + (l2 - l1));
    }

    @Test
    public void exer1() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        long l1 = System.currentTimeMillis();
        try {
            fis = new FileInputStream("day24.zip");
            fos = new FileOutputStream("test3.zip");
            byte[] buffer = new byte[8192];
            int n;
            while ((n = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, n);// 实际读了n个, 写n个字节
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        long l2 = System.currentTimeMillis();
        System.out.println("使用inputStream : " + (l2 - l1));
    }

    @Test
    public void test2() {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
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

    @Test
    public void test1() {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("HashMap.java");
            /*
            int ch;
            while ((ch = fileReader.read()) != -1) { // 只能一次读一个字符
                System.out.print((char)ch);
            }*/
            char[] buf = new char[1024];
            int n; // n的作用是从输入流中一次性读到数组中后,实际读了多少
            while ((n = fileReader.read(buf)) !=-1) {
                // 处理数据时, 只处理n个
                for (int i = 0; i < n; i++) {
                    System.out.print(buf[i]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
