/*
方法的调用顺序
* */
public class MethodTest4 {

    public static int add(int a, int b) {
        System.out.println("methodtest4 add()..." + a + ", " + b);
        int c = a + b;
        return c;
    }


    public static void main(String[] args) {
        System.out.println("main begin");

        // 跨类调用方法
        int x = Another.add(10, 20);
        System.out.println(x);

        System.out.println("main end");
    }
}
