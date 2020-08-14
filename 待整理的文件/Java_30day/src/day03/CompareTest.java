package day03;

/**
 * ��������Ƚ������
 * ע�⣺
 * �Ƚ�������Ľ������boolean����
 * ע������ == �� =
 */
public class CompareTest {
    public static void main(String[] args){

        int i = 10;
        int j = 20;

        // ������ֵ
        int i2, j2;
        i2 = j2 = 30;

        System.out.println(i == j);    // false
        System.out.println(i != j);    // true

        // ע������ == �� =
        System.out.println(i == j);    // false
        System.out.println(i = j);    // 20

        boolean b1 = false;
        boolean b2 = true;
        System.out.println(b1 == b2);       // false
        System.out.println(b1 = b2);        // true


        // #########################
        //��ϰ1
        int x = 1;
        int y = 1;
        if(x++ == 2 & ++y == 2){
            x = 7;
        }
        System.out.println("x="+x+", y="+y);    // x=2, y=2

        //��ϰ2
        int x2 = 1, y2 = 1;
        if(x2++ == 2 && ++y2 == 2){
            x = 7;
        }
        System.out.println("x2="+x2+", y2="+y2);     // x2=2, y2=1

        //��ϰ3
        int x3 = 1, y3 = 1;
        if(x3++ == 1 | ++y3 == 1){
            x3 = 7;
        }
        System.out.println("x3="+x3+", y3="+y3);     // x3=7, y3=2

        //��ϰ4
        int x4 = 1, y4 = 1;
        if(x4++ == 1 || ++y4 == 1){
            x4 = 7;
        }
        System.out.println("x4=" + x4 + ", y4=" + y4);  // x4=7, y4=1


        //������
        boolean xx = true;
        boolean yy = false;
        short z = 42;

        if((z++ == 42)&&(yy=true)) z++;
        if((xx=false)||(++z == 45)) z++;
        System.out.println("z=" + z);       // z=46
    }
}
