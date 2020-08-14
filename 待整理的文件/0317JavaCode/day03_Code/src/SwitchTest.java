public class SwitchTest {

    public static void main(String[] args){

        int n = 10;

        // 如果分支是对于变量的值得一个等值判断时，就可以用switch代替它

        // 本质的逻辑：对括号中的变量的可能值进行穷举，列举
        // switch(必须是变量)，数据类型是非long整数，字符串，枚举
        // case 后面必须是常量，常量包括字面量和final修饰的变量
        switch(n){
            case 10:
                System.out.println("10");
                break;
            case 20:
                System.out.println("20");
                break;
            default:
                System.out.println(n);
                break;
        }
    }
}
