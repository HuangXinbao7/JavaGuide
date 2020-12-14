public class RecursionTest {

    public static void binomial() {
        recursion(10);
    }

    private static int count = 0;
    public static int recursion(int k) {
        count ++;
        System.out.println("count1: " + count + " k: " + k);
        if (k <= 0) {
            return 0;
        }
        return recursion(k-1) + recursion(k-2);

    }

    public static int test(int k) {
        if (k <= 0) {
            return 0;
        }
        return test(k-1) * test(k-2);
    }


    public static void main(String[] args) {
        //binomial();
        int t = test(5);
        System.out.println(t);

    }
}
