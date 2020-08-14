public class LoopTest4 {
    public static void main(String[] args) {

        // 打印200以内所有质数
        for (int i = 2; i < 200; i++) {
            // 判断i是否是质数，假设i是质数
            boolean flag = true;

            // 尝试推翻假设，从 2~n-1中只要找到一个数可以整除i
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {   // 如果i被某个j整除，说明i不是质数
                    flag = false;   // 推翻假设
                    break;          // 反例不需要多，一个足以
                }
            }
            if (flag) {
                System.out.println(i + "是质数");
            }
        }
    }
}
