package day03;


public class AriExer2 {
    public static void main(String[] args) {
        int i1 = 10;
        int i2 = 20;

        int i3 = i1++;
        System.out.println("i3 = " + i3);   // i3 = 10
        System.out.println("i1 = " + i1);   // i1 = 11

        int i4 = ++i1;
        System.out.println("i4 = " + i4);   // i4 = 12
        System.out.println("i1 = " + i1);   // i1 = 12

        int i5 = i2--;
        System.out.println("i5 = " + i5);   // i5 = 20
        System.out.println("i2 = " + i2);   // i2 = 19

        int i6 = --i2;
        System.out.println("i6 = " + i6);   // i6 = 18
        System.out.println("i2 = " + i2);   // i2 = 18
    }
}
