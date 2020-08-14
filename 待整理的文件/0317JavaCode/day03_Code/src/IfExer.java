public class IfExer {
    /*
    从命令行参数接收小明的期末成绩。
    当成绩为100分时，奖励一辆BMW；
    当成绩为(80，99]时，奖励一个台iphone11；
    当成绩为[60,80]时，奖励一本参考书；
    其它时，什么奖励也没有。
    提示: 从命令行参数获取整数的代码:
    int score = Integer.parseInt(args[0]);
    */
    public static void main(String[] args) {
        int score = Integer.parseInt(args[0]);

        if (score < 0 || score > 100) {
            System.out.println("分数不合法！");
        }else {
            if (score == 100) {
                System.out.println("奖励一辆BMW！");
            }else if(80 < score && score < 99) {
                System.out.println("奖励一台iphoneX!");
            }else if(60 <= score && score <= 80) {
                System.out.println("奖励一本参考书");
            }else {
                System.out.println("什么奖励也没有！");
            }
        }
    }
}
