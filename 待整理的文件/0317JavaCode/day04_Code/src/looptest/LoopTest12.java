package looptest;

public class LoopTest12 {

    public static void main(String[] args){
        // 判断一个数是否是质数：质数是它只能被1和本身整除
        int n = Integer.parseInt(args[0]);
        boolean flag = true;    // flag 表示假定n是质数

        // 尝试证明n不是质数，只要在 2~n-1中找到一个数能整除n，那么这个数一定不是质数
        for (int i = 2; i < n; i++){    // 尝试找反例，从2~n-1
            if(n % i == 0){             // 如果n被某个i整除，则说明原假设是错误的
                flag = false;   // 推翻假设，说明n不是质数
            }
        }

        // 最后的结论肯定保存在flag中
        if(flag){
            System.out.println(n + " 是质数");
        }
    }
}
