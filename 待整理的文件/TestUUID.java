package org.example;

import java.util.UUID;

/**
 * 格式化一个UUID字符串
 * 生成一个UUID字符串
 */
public class TestUUID {
    public static void main(String[] args) {
        generateUUID();

    }

    private static void generateUUID() {
        // 格式化一个UUID字符串
        //UUID uuid = UUID.fromString("63982000-bc30-ab45-df12-8752fbac99");
        UUID uuid = UUID.fromString("AAA-bc30-ab45-df12-8752fbac99");
        System.out.println("格式化后的值：" + uuid);

        // 生成一个UUID字符串
        System.out.println("生成一个UUID：" + uuid.randomUUID());
    }
}
