public class FunnyTest {

    // 计算n的阶乘
    // 什么情况下使用递归？一个问题可以分解为一个已知处理和子问题
    // 不是告诉计算该怎么做，而是告诉计算做什么
    public static int test(int n) {
        //return n;
        //return test(n);     // 在方法中调用自身称为递归，无线递归（死归）

        // 有限递归
        if (n == 1) {
            return 1;
        }
        //int result = n * test(n - 1);
        return n * test(n - 1);
    }

    // 求阶乘的和的方法
    // 求 n!+(n-1)!+...
    public static int sum(int n) {
        if (n == 1) {
            return 1;
        }
        //
        return test(n) + sum(n-1);
    }


    public static void main(String[] args) {
        System.out.println(test(5));
        System.out.println(sum(5));
    }
}
