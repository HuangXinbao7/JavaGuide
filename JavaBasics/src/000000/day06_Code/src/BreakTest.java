public class BreakTest {

    public static void main(String[] args) {
        boolean flag = true;
        l1: {
            System.out.println("hello");
            if(flag) {
                break l1;   // 退出l1标识的语句
            }
            System.out.println("world");    // 本条语句不执行
        }
        System.out.println("three");
    }
}
