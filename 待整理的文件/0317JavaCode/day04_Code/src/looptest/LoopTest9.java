package looptest;

public class LoopTest9 {

    public static void main(String[] args){
        // 求50以内所有能被7整除的数的平均值
        int sum = 0;
        int count = 0;

        for (int i = 0; i < 50; i++){
            if(i % 7 == 0){
                System.out.println(i);
                sum += i;
                count++;
            }
        }

        System.out.println("sum: " + sum);
        int avg = sum / count;
        System.out.println("avg: " + avg);
    }
}
