package com.atguigu.javase.homework;

/**
 * 作业4：
 * 获取两个字符串中最大相同子串。比如：
 *    str1 = "abcwerthelloyuiodef ";str2 = "cvhellobnm"
 *    提示：将短的那个串进行长度依次递减的子串与较长的串比较。
 */
public class MaxSubStringTest {

    // 方法二：取子串
    public static void main(String[] args) {

        String str1 = "abcwerthelloyuiodef ";
        String str2 = "cvhellobnm";
        // 最大相同子串的长度控制起来，初始长度是极端情况，是短字符串的长度
        int ruler = str2.length();
        l1: while (ruler > 0) {
            // 用当前长度从短串的中取出所有子串，在长串中进行比较，看长串是否包含它。
            int beginIndex = 0;     // 取子串中的开始索引
            int endIndex;
            // 从短串中取所有可能的子串
            while ((endIndex = beginIndex + ruler) <= str2.length()) {
                String substring = str2.substring(beginIndex, endIndex);
                // 如果长串包含子串，任务达成
                //if (str1.indexOf(substring) != -1) {
                if (str1.contains(substring)) {
                    System.out.println(substring);
                    break l1;   // 跳出外部循环
                }
                beginIndex++;
            }
            // 否则减短这个长度
            ruler--;
        }
    }


    // 方法一：使用for循环
    public static void main1(String[] args) {

        String str1 = "abcwerthelloyuiodef ";
        String str2 = "cvhellobnm-zzzzzzzzzzzzzzz";
        String subStr1 = "";
        String subStr2 = "";
        String maxStr = "";
        int len = 0;

        // 遍历短的那个字符串，i 控制获取子串的开始下标
        for(int i = 0; i < str2.length(); i++) {
            // 从i下标开始往后遍历字符串，j 控制获取子串的结束下标
            for(int j = i + 1; j < str2.length(); j++) {
                // 通过 i 和 j 截取短的那个字符串的一段子串 subStr2
                subStr2 = str2.substring(i, j);
                // 遍历长的那个字符串，k 控制要获取的子串 subStr1 的起始下标
                for (int k = 0; k < str1.length(); k++){
                    // 防止 subStr1 的尾下标越界
                    if(k+j-i <= str1.length()) {
                        // 要截取的子串长度与在较短的那个字符串中获取的子串长度相同
                        // 即 subStr1 的长度等于 subStr2 的长度，才可以比较
                        // 取 subStr1 长度为 j - i，所以尾下标为 k + j - i
                        subStr1 = str1.substring(k, k + j - i);
                    }
                    // 注意比较字符串的值是否相等要使用 equals() 方法
                    if(subStr2.equals(subStr1)) {
                        // 判断新的同子串的长度是不是最长的
                        if(subStr2.length() > len) {
                            maxStr = subStr2;   // 是，则刷新
                            len = subStr2.length(); // 是，则刷新
                        }
                    }
                }
            }
        }

        System.out.println(maxStr);
    }
}
