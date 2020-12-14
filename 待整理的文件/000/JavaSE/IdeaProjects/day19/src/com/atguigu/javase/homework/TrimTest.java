package com.atguigu.javase.homework;

/**
 * 作业3：
 * String s = "   abc yyy zz我是汉字 我也是汉字     ";
 * 模拟一个trim方法，去除字符串两端的空格。
 * 需要定位开始的非空白字符的下标和最后一个非空白字符的下标.
 */
public class TrimTest {

    // 模拟一个trim方法，去除字符串两端的空格。
    // 方法二
    public static String trim2(String s) {

        // 存放开始的非空白字符的下标，默认值是0
        int beginIndex = 0;
        // 存放最后一个非空白字符的下标，默认值是字符串最后一个字符的下标
        int endIndex = -1;

        // 定位开始的非空白字符的下标: begin
        // 正向遍历
        // 查找思路：找到第一个字符对应的 ASCII码值大于32的下标时，终止循环
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) > 32) {
                beginIndex = i;
                break;
            }
        }

        // 如果正向遍历到最后，都找不到非空字符，则提前结束查找方法。返回 ""
        //if(beginIndex == s.length()) {
        //    return "";
        //}

        // 定位最后一个非空白字符的下标: end
        // 反向遍历
        // 查找思路：从字符串最右边开始遍历，找到第一个字符对应的 ASCII码值大于32的下标时，终止循环
        for(int i = s.length() - 1; i >= 0; i++) {
            if(s.charAt(i) > 32) {
                endIndex = i;
                break;
            }
        }


        // 如果字符串中只有一个非空字符时，正向和反向遍历后 begin 会等于 end
        //if(beginIndex == endIndex) {
        //    return s.substring(beginIndex, beginIndex+1);
        //}

        // 使用 substring 获取子字符串
        return s.substring(beginIndex, endIndex + 1);
    }


    // 模拟一个trim方法，去除字符串两端的空格。
    public static String trim(String s) {

        // 存放开始的非空白字符的下标，默认值是0
        int begin = 0;
        // 存放最后一个非空白字符的下标，默认值是字符串最后一个字符的下标
        int end = s.length() - 1;

        // 定位开始的非空白字符的下标: begin
        // 正向遍历
        // 查找思路：找到第一个字符对应的 ASCII码值大于32的下标时，终止循环
        while(begin < s.length()) {
            char c = (char)(s.charAt(begin));
            if(c > 32) {
                break;
            }
            begin++;
        }
        //System.out.println(begin);

        // 如果正向遍历到最后，都找不到非空字符，则提前结束查找方法。返回 ""
        if(begin == s.length()) {
            return "";
        }

        // 定位最后一个非空白字符的下标: end
        // 反向遍历
        // 查找思路：从字符串最右边开始遍历，找到第一个字符对应的 ASCII码值大于32的下标时，终止循环
        while(end > 0){
            char c = (char)s.charAt(end);
            if(c > 32) {
                break;
            }
            end--;
        }
        System.out.println(end);


        // 如果字符串中只有一个非空字符时，正向和反向遍历后 begin 会等于 end
        if(begin == end) {
            return s.substring(begin, begin+1);
        }

        // 使用 substring 获取子字符串
        return s.substring(begin, end);
    }


    public static void main(String[] args) {
        String s = "   abc yyy zz我是汉字 我也是汉字     ";
        //String s = "    ";
        //String s = "  A  ";

        // 调用自定义方法 trim()
        String newString = trim(s);

        System.out.println(newString);
    }
}
