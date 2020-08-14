public class IfTest2 {
    public static void main(String[] args){
        /*
        * 编写程序：接收三个命令行字符串并转换为整数分别存入变量num1、num2、num3，
        * 对它们进行排序(使用 if-else if-else),并且从小到大输出。
        */
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        int num3 = Integer.parseInt(args[2]);

        // 输出最小的数
        //if(num1 < num2 && num1 < num3){
        //    System.out.println(num1);
        //}else if(num2 < num1 && num2 < num3){
        //    System.out.println(num2);
        //}else{
        //    System.out.println(num3);
        //}

        //
        //if(num1 > num2 && num1 < num3){
        //    System.out.println(num1);
        //}else if(num2 > num1 && num2 < num3){
        //    System.out.println(num2);
        //}else{
        //    System.out.println(num3);
        //}

        //
        //if(num1 > num2 && num1 > num3){
        //    System.out.println(num1);
        //}else if(num2 > num1 && num2 > num3){
        //    System.out.println(num2);
        //}else{
        //    System.out.println(num3);
        //}

        if(num1 < num2){
            if (num3 < num1) {
                System.out.println(num3 + ", " + num1 + ", " + num2);
            }else if(num2 < num3) {
                System.out.println(num1 + ", " + num2 + ", " + num3);
            }else {
                System.out.println(num1 + ", " + num3 + ", " + num2);
            }
        }else{
            if(num3 < num2){
                System.out.println(num3 + ", " + num2 + ", " + num1);
            }else if(num1 < num3) {
                System.out.println(num2 + ", " + num1 + ", " + num3);
            }else {
                System.out.println(num2 + ", " + num3 + ", " + num1);
            }
        }

    }
}
