/*
定义三个重载方法max()，
第一个方法求两个int值中的最大值，
第二个方法求两个double值中的最大值，
第三个方法求三个double值中的最大值，
并分别调用三个方法。
* */
public class MethodExer2 {

    // 第一个方法求两个int值中的最大值
    public static int max(int a, int b){
        int c = (a > b ? a : b);
        return c;
    }

    // 第二个方法求两个double值中的最大值
    public static double max(double  a, double b){
        double c = (a > b ? a : b);
        return c;
    }

    // 第三个方法求三个double值中的最大值
    public static double max(double a, double b, double c){
        double max1 = (a > b ? a : b);
        double d = (c > max1 ? c : max1);
        return d;
    }


    public static void main(String[] args) {
        int max1 = max(10, 20);
        System.out.println(max1);

        double max2 = max(10.2, 20.2);
        System.out.println(max2);

        double max3 = max(10.2, 20.2, 30.3);
        System.out.println(max3);
    }
}
