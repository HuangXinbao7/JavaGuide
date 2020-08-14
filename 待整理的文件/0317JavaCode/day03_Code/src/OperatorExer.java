public class OperatorExer {
    public static void main(String[] args){
        /*
        练习：
        获取两个数中的较大数
        获取三个数中的较大数
        */
        int n1 = 10;
        int n2 = 20;
        int n3 = 30;

        // 获取三个数中的较大数
        int max = (n1 > n2) ? n1 : n2;
        max = (max > n3) ? (max) : n3;

        System.out.println(max);
    }
}
