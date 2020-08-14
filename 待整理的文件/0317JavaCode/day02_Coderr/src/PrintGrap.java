public class PrintGrap {
/*
打印如下图形
----*
---* *
--* * *
-* * * *
* * * * *
i	j	k
0	4	1     j = 4-i;  k = i+1;
1	3	2
2	2	3
3	1	4
4	0	5
 * * * *
  * * *
   * *
    *
*/
    public static void main(String[] ags){
        // 打印上半部分
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5-i-1; j++) {
                System.out.print("-");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // 打印中间部分
        // 规律：j = 4-i;  k = i+1;
        System.out.println("i   " + "j   " + "k");
        for (int i = 0; i < 5; i++) {
            int j = 4 - i;
            int k = i + 1;
            System.out.println(i + "   " + j +"   " + k);
        }

        // 打印下部分的倒三角
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 4-i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
