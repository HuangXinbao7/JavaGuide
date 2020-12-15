package homework;

/*
* 使用递归的方式求1~100的和
* */
public class HomeWork2 {

    public static int sum(int k) {
        if (k <= 1) {
            return 1;
        }
        return k + sum(k - 1);
    }

    public static void main(String[] args) {
        int s = sum(100);
        System.out.println(s);
    }
}
