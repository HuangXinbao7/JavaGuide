package org.example.bitmap;

import java.util.Random;

/**
 * BitMap的用法：排序
 *
 * @Author Created by XinB on 2020/8/30 14:13
 */
public class BitmapTest {

    /**
     * 1千万数据集合
     */
    private static final int N = 10000000;

    /**
     * bitmap数组
     */
    private static int[] bitMap = new int[N/32 + 1];

    /**
     * 为集合数据加标记
     * @param n
     */
    public void addValue(int n) {
        // 定位数组编号，相当于 n/32
        int row = n >> 5;
        // 定位数组内slot位置，相当于 n%32
        int offset = n & 0x1f;
        // 数组slot置1
        bitMap[row] = 1 << offset;
    }

    /**
     * 判断给定数字是否存在
     * @param n
     * @return
     */
    public boolean isExits(int n) {
        // 定位数组编号
        int row = n >> 5;
        // 定位数组内slot位置
        int offset = n & 0x1F;
        // 1 << position 将a[i]中左移position求与,slot位置有值返回true
        return (bitMap[row] & (1 << offset)) != 0;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // 初始化一个长度为N的数组
        int[] num = new int[N];
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            // 随机数范围是(0-100000)
            int item = random.nextInt(100000);
            num[i] = item;
        }

        BitmapTest bitmapTest = new BitmapTest();
        // 置1
        for (int i = 0; i < N; i++) {
            bitmapTest.addValue(num[i]);
        }

        // 手动添加
        num[0] = 200;
        bitmapTest.addValue(num[0]);

        int tmp = 200;
        if(bitmapTest.isExits(tmp)) {
            System.out.println("tmp: " + tmp + " 已经存在");
        }else {
            System.out.println("tmp: " + tmp + " 不存在");
        }
    }
}
