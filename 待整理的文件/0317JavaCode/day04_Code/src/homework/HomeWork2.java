package homework;

/*
第二题：
打印高度为5的等腰三角形
*/
public class HomeWork2 {

    public static void main(String[] args){

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5-i-1; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < 2*i+1; k++){
                System.out.print("*");
            }
            if(i < 5-1){
                System.out.println();
            }
        }
    }
}


// 答案
class HomeWork22 {

    public static void main(String[] args){

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4-i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < 2*i+1; k++){
                System.out.print("*");
            }
            if(i < 5-1){
                System.out.println();
            }
        }
    }
}

