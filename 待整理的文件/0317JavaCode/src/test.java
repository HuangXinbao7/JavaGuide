//import java.util.Random;

public class test {

    // 3000米长的绳子，每天减一半。问多少天这个绳子会小于5米？不考虑小数。
    public static void main(String[] args) {

        int count = 0;
        for (int i = 3000; i >= 5; i = i / 2) {
            count++;
        }
        System.out.println("count: " + count);
    }
}