package looptest;

public class LoopTest7 {

    public static void main(String[] args){
        int result = 0;
        for (int i = 0; i < 100; i++){  // for循环天生的适用于循环次数精准的循环
            result += i;
        }
        System.out.println("result: " + result);
    }
}
