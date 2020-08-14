class Test{
    public static void main(String[] args){
        System.out.println("Test...");
        // 接收命令行参数
        int n1 = Integer.parseInt(args[0]);
        System.out.println(n1);
    }
}


class OperatorTest4{
    /*
    练习：
	获取两个数中的较大数
	获取三个数中的较大数
	*/
    public static void main(String[] args){
        int n1 = 10;
        int n2 = 20;
        int n3 = 30;

        int max1 = (n1 > n2) ? n1 : n2;
        int max2 = (((n1 > n2) ? n1 : n2) > n3) ? ((n1 > n2) ? n1 : n2) : n3;

        System.out.println(max1);
        System.out.println(max2);
    }
}

class OperatorTest3{
    public static void main(String[] args){
        // 变量 = (布尔表达式) ? 表达式1 : 表达式2;
        // 表达式1 和 表达式2 的值类型要一致
        int n1 = 100;
        int n2 = 30;

        // 找出两个数中的较大者
        int max = (n1 > n2) ? n1 : n2;
        System.out.println(max);
    }
}


class OperatorTest2{
    public static void main(String[] args){
        boolean b1 = true;
        boolean b2 = false;

        //boolean b3 = b1 > b2;
        String s1 = "aa";
        String s2 = "bb";
        //boolean b3 = s1 > s2;


    }
}


public class OperatorTest {
    public static void main(String[] args){

    }

}
