public class MethodTest {

    public static void test(int a) {
        System.out.println("test..." + a);
    }

    public static int add(int a, int b) {
        test(a);
        int c = a + b;
        return c;
    }

    public static void main(String[] args) {
        int a = 10;
        int b = 30;
        //add(10, 30);
        int c = add(a, b);
        System.out.println(c);
    }
}
