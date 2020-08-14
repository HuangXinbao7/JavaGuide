package day03;


public class ReviewTest {
    public static void main(String[] args){
        char c1 = 'A';
        // 定义字符类型可直接使用ASCII码, 开发中非常少见
        char c2 = 65;
        System.out.println(c2);     // A

        char c3 = 33;
        char c4 = '5';      // 字符5对应的ASCII码是53
        int i1 = (int)c4;
        System.out.println(c3);     // !
        System.out.println(i1);     // 53

    }
}
