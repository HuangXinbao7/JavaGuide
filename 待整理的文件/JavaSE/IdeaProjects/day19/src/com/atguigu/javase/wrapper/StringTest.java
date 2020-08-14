package com.atguigu.javase.wrapper;

import org.junit.Test;

/**
 * String 是 javaSE中最重要的类，没有之一。
 * String 字符串：内容不可改变的 Unicode 字符的序列。内部是使用 char[] 保存所有字符
 * String s = "abc";    // s 指向一个字符串对象
 * s += 200;    // 用原来的内容拼接200，拼接的结果是一个新的字符串对象，再把新对象地址刷回s变量
 * 特点：字符串的任何修改都会产生一个新对象。
 * 优缺点：好处是使用稳定安全。缺点是会产生大量垃圾的中间对象。
 *
 * String str = new String("abc");
 * "abc"本身在常量区, 内部的char[] 也在常量区
 * str引用指向的String对象在GC区, 对象的属性value指向的char[]在常量区
 *
 * 字符串常量（带双引号的字面量）保存在内存中的常量区
 *      jdk8以前，常量区是方法区的一部分
 *      jdk8之后，常量区从方法区分离。只有String放在常量区
 * 字面量相加就在常量池中，只要有变量参与拼接，拼接的新串就一定在GC区
 *
 *
 *                  0 2  5     11   16      21       27       33    38
 * String string = "  abcABCqq 1234 我喜欢你,你喜欢我吗?我不喜欢你 YYzz   ";
 *
 * public int length()
 *      获取字符串长度, string.length() => 39
 * public char charAt(int index)
 *      获取参数指定下标处的字符, string.charAt(17) => '喜', string.charAt(3) => 'b'
 * public char[] toCharArray()
 *      返回字符串内部字符数组的复制
 *      System.arraycopy(value, 0, result, 0, value.length); 数组的复制
 *      // 第1个参数是源数组对象, 第2个参数是源数组的开始下标, 第3个参数是目标数组对象, 第4个参数是目标数组的开始下标, 第5个参数是复制的元素个数
 *
 * public boolean equals(Object anObject)
 *      比较对象
 * public int compareTo(String anotherString)
 *      以字符的Unicode为比较依据
 *
 * public int indexOf(String s)
 *      获取参数中的子串s在当前字符串中首次出现的下标索引
 *          string.indexOf("喜欢") => 17
 *          string.indexOf("讨厌") => -1 表示子串不存在.
 * public int indexOf(String s ,int startpoint)
 *      从第二个参数指定的下标开始搜索子串出现的下标
 *          string.indexOf("喜欢", 18) => 22
 *          string.indexOf("喜欢", 23) => 29
 *
 * public int lastIndexOf(String s)
 *      从右向左搜索子串首次出现的下标
 *          string.lastIndexOf("喜欢") => 29
 * public int lastIndexOf(String s ,int startpoint)
 *          string.lastIndexOf("喜欢", 28) => 22
 *          string.lastIndexOf("喜欢", 21) => 17
 *
 * public boolean startsWith(String prefix)
 *      判断当前串是否以参数中的子串为开始
 *          string.startsWith("  abc") => true
 * public boolean endsWith(String suffix)
 *      判断当前串是否以参数中的子串为结束
 *          string.endsWith("YYzz") => false;
 *
 * public String substring(int start,int end)
 *      从当前字符串中截取子串, 以start为开始索引(包含), 以end为结束索引(不包含)
 *          string.substring(16, 20) => "我喜欢你"
 * public String substring(int startpoint)
 *      从startpoint到最后取子串
 *          string.substring(21) 等价于 string.substring(21, string.length());
 *
 * public String replace(char oldChar,char newChar)
 *      把当前串中的所有的oldChar全部替换为newChar, 返回新串
 *          string.replace(' ', '#');   // 替换所有字符都会替换，第二个参数不能为空
 * public String replaceAll(String old,String new)
 *          string.replaceAll(" ", "#");
 *              把当前串中的所有 old替换为new。可以消除空格。
 *              第二个参数为空，表示去除空格
 *
 * public String trim()
 *      修剪字符串首尾的空白字符.(码值小于等于32的都是空白字符)

 * public String concat(String str)
 *      连接
 *
 * public String toUpperCase()
 *      变成大写
 * public String toLowerCase()
 *      变成小写
 *
 * public String[] split(String regex)
 *      把字符串切割成多个部分, 参数中的子串为切割器, 切割的结果中不包含切割器
 */
public class StringTest {

    /**
     * 将一个字符串进行反转。将字符串中指定部分进行反转。比如将“abcdefg” 反转成 "abfedcg"
     */
    @Test
    public void exer3() {
        String string = "abcdefghijklmn";
        int begin = 2;
        int end = 8;    // 不包含
        // 使用 substring 把字符串切割成3个字子串，把中间的子串翻转，在拼接回去
        //String tmp = "";
        //String str = string.substring(begin, end);
        //for(int i = str.length() - 1; i >=0; i--){
        //    tmp += str.charAt(i);
        //}
        //string = string.substring(0, begin) + tmp + string.substring(end);
        //System.out.println(string);

        // 思路二：
        String s1 = string.substring(0, begin);
        String s2 = string.substring(begin, end);
        String s3 = string.substring(end);

        String strTmp = "";     // 保存反转后的子字符串
        // 反向遍历子字符串
        for(int i = s2.length() -1; i >= 0; i-- ) {
            strTmp += s2.charAt(i);
        }
        string = s1 + strTmp + s3;      // 拼接反转后的新字符串
        System.out.println(string);
    }


    /*获取一个字符串在另一个字符串中出现的次数*/
    // 封装成方法
    public int getCountOfSubString(String s1, String s2) {
        int count = 0;
        int index = 0;

        while (true) {
            index = s1.indexOf(s2, index);
            // 如果搜索失败, 则循环结束
            if(index == -1) {
                break;
            }
            // 如果搜索成功, count++, 准备下一次搜索
            count++;
            index++;
        }
        return count;
    }

    /**
     * 练习：一个字符串在另一个字符串中出现的次数
     * 比如：获取"ab"在 "abkkcadkabkebfkabkskab" 中出现的次数
     */
    @Test
    public void exer2() {
        String s1 = "abkkcadkabkebfkabkskab";
        String s2 = "ab";
        System.out.println(getCountOfSubString(s1, s2));
    }


    /**
     * 练习：反转字符串
     */
    @Test
    public void exer1() {
        // 练习：反转字符串
        String str = " ancABC11 1234 我在 深圳？ SZsz ";
        // 创建一个新字符串，初始值是 ""
        String strR = "";
        String strR2 = "";
        String strR3 = "";
        String strR4 = "";
        // 反向遍历字符串，把每个字符拼接到新字符串中
        // 思路一：反向遍历
        for (int i = str.length() - 1; i >= 0; i--) {
            strR += str.charAt(i);
        }

        // 思路二：正向遍历，反向根据索引取值
        for(int i = 0; i < str.length(); i++) {
            strR2 += str.charAt(str.length() - 1 - i);
        }

        // 思路三：正向遍历，左边拼接
        for(int i = 0; i < str.length(); i++) {
            strR3 = str.charAt(i) + strR3;
        }

        // 思路四：利用数组，此方法最好，效率最高
        char[] chars = str.toCharArray();
        for(int i = 0; i < chars.length / 2; i++) {
            char tmp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = tmp;
        }
        strR4 = new String(chars);

        // 打印新字符串
        System.out.println(strR);
        System.out.println(strR2);
        System.out.println(strR3);
        System.out.println(strR4);
    }


    @Test
    public void test11() {
        String s1 = "abcd";
        System.out.println(s1.substring(0, 3));
    }


    @Test
    public void test10() {
        String s1 = "adf,fad,fad,发电房,fadf";
        String[] split = s1.split(",");
        for(String tmp: split) {
            System.out.print(tmp + " ");
        }
        System.out.println();
    }


    @Test
    public void test9() {
        String string = "abcDEF";
        String s = string.toUpperCase();
        System.out.println(s);
        String s2 = string.toLowerCase();
        System.out.println(s2);
    }


    @Test
    public void test8() {
        String str = " \tancABC11 1234\t     ";
        String trim = str.trim();
        System.out.println(trim);

        String ss = "           ";
        String sss = ss.trim();
        System.out.println(sss);
        System.out.println(sss.charAt(0));
    }


    @Test
    public void test7() {
        String str = " ancABC11 1234 我在 我又在 我还在 深圳? SZsz ";
        String replace = str.replace(' ', '#');
        System.out.println(replace);
        // 消除所有空格
        String str2 = str.replaceAll(" ", "");
        System.out.println(str2);
    }

    @Test
    public void teat6() {
        String string = "  abcABCqq 1234 我喜欢你,你喜欢我吗?我不喜欢你 YYzz  ";
        String subString = string.substring(0,10);
        System.out.println(subString);

        String subString2 = string.substring(20, string.length());
        System.out.println(subString2);

        String subString3 = string.substring(10, 20);
        System.out.println(subString3);
    }

    @Test
    public void test5() {
        String string = "  abcABCqq 1234 我喜欢你,你喜欢我吗?我不喜欢你 YYzz  ";
        boolean b = string.startsWith("  abc");
        System.out.println(b);

        boolean yYxx = string.endsWith("YYzz ");
        System.out.println(yYxx);

    }

    @Test
    public void test4() {
        String str = " ancABC11 1234 我在 我又在 我还在 深圳? SZsz ";
        int index1 = str.lastIndexOf("我");
        System.out.println(index1);

        int index2 = str.lastIndexOf("我", index1 - 1);
        System.out.println(index2);

        int index3 = str.lastIndexOf("我", index2 - 1);
        System.out.println(index3);
    }

    @Test
    public void test3() {
        // indexOF()
        String str = " ancABC11 1234 我在 我又在 我还在 深圳？ SZsz ";
        int index1 = str.indexOf("我");
        System.out.println(index1);     // 15

        int index2 = str.indexOf("我", index1 + 1);
        System.out.println(index2);     // 18

        int index3 = str.indexOf("我", index2 + 1);
        System.out.println(index3);     // 22

        int index4 = str.indexOf("我", index3 + 1);
        System.out.println();   // 为空，表示已经没有要找的字符了


        // lastIndexOf()
        // lastIndexOf(str)
        int index5 = str.lastIndexOf("我");
        System.out.println(index5);     // 22
        // lastIndexOf(str, fromIndex)
        int index6 = str.lastIndexOf("我", index5 - 1);
        System.out.println(index6);     // 18
    }

    @Test
    public void test2() {

        // " ancABCqq 1234 我在 深圳？ SZsz "
        //  0 2     8 10   15  18    22  16
        String str = " ancABC11 1234 我在 深圳？ SZsz ";
        System.out.println(str.length());       // 27
        System.out.println(str.charAt(8));     // 获取参数指定下标处的字符
        // 通过下标遍历字符串
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i) + " ");
        }
        System.out.println("**********************");
    }

    @Test
    public void test1() {
        String s1 = new String();   // 相当于 s1 = "";
        System.out.println(s1);

        String s2 = new String("abc");
        System.out.println(s2);

        char[] arrChar = {'a', 'b', 'c', '1', '2', '好', '坏', 'Y'};
        String s3 = new String(arrChar);
        System.out.println(s3);

        // 下面的构造器是取字符串数组一部分作为字符串，这是使用频率最高的构造器
        String s4 = new String(arrChar, 3, 5);  // 注意下标控制
        System.out.println(s4);
        String s5 = "0.0000001";
    }
}
