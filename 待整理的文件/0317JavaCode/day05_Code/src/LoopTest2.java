public class LoopTest2 {
    public static void main(String[] args) {

        // 从命令参数接收一个n, 使得一个本类应该循环100次的循环, 实际循环n次
        int n = Integer.parseInt(args[0]);

        // break 可以中断循环的执行，break中断的力度大，把整个循环终止了
        for (int i = 0; i < 100; i++){
            System.out.println(i);
            if (i == n - 1) {
                break;
            }
        }
    }
}
