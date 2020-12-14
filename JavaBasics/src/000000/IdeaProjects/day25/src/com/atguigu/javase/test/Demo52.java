package com.atguigu.javase.test;


public class Demo52 {

    /**
     * 有一个字符串，其中包含中文字符、英文字符和数字字符，
     * 请统计和打印出各个字符的字数。
     * 举例说明： String content = “中中国55kkfff”; 统计出：中：2, 国：1,  5：2,
     */
/*    static void countChar(String content){
        int[] arr = new int[65536];
        for(int i = 0; i < content.length(); i++) {
            arr[content.charAt(i)]++;
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != 0){
                System.out.println((char)i + ": " + arr[i]);
            }
        }
    }*/

    

/*    public static void main(String[] args) {

        String content = "中中国55kkfff";

        int[] arr = new int[65536];
        for(int i = 0; i < content.length(); i++) {
            arr[content.charAt(i)]++;
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != 0){
                System.out.println((char)i + ": " + arr[i]);
            }
        }
    }*/
}
