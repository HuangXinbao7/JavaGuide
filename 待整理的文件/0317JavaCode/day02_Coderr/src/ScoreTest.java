public class ScoreTest {

    public static void main(String[] args) {

        int score = 89;
        // int score = Integer.parseInt(args[0]);

        if (score == 100) {
            System.out.println("BMW");
        }else if(score > 80 && score < 99) {
            System.out.println("IphoneX");
        }else if(score >= 60 && score <= 80) {
            System.out.println("一本参考书");
        }else {
            System.out.println("什么也没有");
        }
    }
}
