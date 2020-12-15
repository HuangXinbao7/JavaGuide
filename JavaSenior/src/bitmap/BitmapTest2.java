package org.example.bitmap;

import java.util.Random;

/**
 * BitMap 的第二个实例
 *
 * @Author Created by XinB on 2020/8/30 14:13
 */
public class BitmapTest2 {

    private static final int DEFAULT = 1024*1024*1024;
    public int size;
    private byte[] map;

    public BitmapTest2() {
        this.size = DEFAULT;
        this.map = new byte[size];
    }

    public BitmapTest2(int size) {
        this.size = size;
        this.map = new byte[size];
    }


    public void set(int val) {
        if (val < 0) {
            throw new RuntimeException("need Positive integer");
        }
        // 等价于val/8得到所在的第几个字节里，即位桶
        int seg = val >> 3;

        // 等价于val%8获取余数，即位于上面求得所在位桶的第几位
        int mod = val & (0x07);

        //
        map[seg] |= 0x01 << (val & (0x07));
    }

    public boolean isExits(int val) {
        if (val < 0)  {
            throw new RuntimeException("need Positive integer");
        }
        //
        //计算位于第几个桶位
//        int seg = val >> 3;
        //位于上面求得所在位桶的第几位
//        int mod = val & 7;

        return ((map[val >> 3] >> (val & 7)) & 0x01) == 0x01;
    }


    public static void main(String[] args) {

        BitmapTest2 bitMap = new BitmapTest2();

        int[] array = new int[100000000];
        Random random = new Random();


        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(5000000);
        }

        for (int i = 0; i < array.length; i++) {
            bitMap.set(array[i]);
        }
        long start = System.currentTimeMillis();

        for (int a : array) {
            if (!bitMap.isExits(a)) {
                System.out.println("not exist");
            }
        }
        System.out.println("bitmap时间=" + (System.currentTimeMillis() - start));
    }
}
