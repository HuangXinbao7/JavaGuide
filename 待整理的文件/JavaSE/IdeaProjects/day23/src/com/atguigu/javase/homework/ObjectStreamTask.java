package com.atguigu.javase.homework;

import org.junit.Test;

/**
 * 使用对象流写一个二进制文件， 保存随机个(100个以内）的随机数(100以内)。
 * 再写程序把所有的随机数都读出来
 */
public class ObjectStreamTask {

    /**
     * 再写程序把所有的随机数都读出来
     */
    @Test
    public void test2() {

        FileInputStream fis = null;
        BufferedInputStream bis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream("二进制文件");
            bis = new BufferedInputStream(fis);
            ois = new ObjectInputStream(bis);
            int ch = 0;
            // 不停地循环读取数据，直到读到文件末尾抛出 EOFException 异常
            while (true) {
                try {
                    ch = ois.readInt();
                    if (ch != -1) {
                        System.out.println(ch);
                    }
                } catch (IOException e) {
                    // 处理 EOFException 异常
                    // 当读到文件末尾时，检测到 EOFException 异常就退出循环。不抛出。
                    //e.printStackTrace();
                    break;
                }
            }
        } catch (IOException e) {
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


    /**
     * 使用对象流写一个二进制文件， 保存随机个(100个以内）的随机数(100以内)。
     */
    @Test
    public void test1() {

        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream("二进制文件");
            bos = new BufferedOutputStream(fos);
            oos = new ObjectOutputStream(bos);

            int n = (int)(Math.random() * 100);
            for (int i = 0; i < n; i++) {
                int val = (int)(Math.random() * 100);
                oos.writeInt(val);
            }
        } catch (IOException e) {
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
}
