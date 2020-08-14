public class SwitchExer {
    public static void main(String[] args){
        /*
        * 使用switch语句改写下列if语句：
        int a = 3;
        int x = 100;
        if(a==1)
        x+=5;
        else if(a==2)
        x+=10;
        else if(a==3)
        x+=16;
        else
        x+=34;
        System.out.println(“x:” + x);
        * */
        int a = 3;
        int x = 100;

        switch (a){
            case 1 :
                x += 5;
                break;
            case 2 :
                x += 10;
                break;
            case 3 :
                x += 16;
                break;
            default:
                x += 34;
                break;
        }
        System.out.println("x: " + x);
    }
}
