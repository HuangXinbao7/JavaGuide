package day03;

/*
* ˼����
* */
public class AriExer3 {
    public static void main(String[] args){

        // ˼��1
        short s1 = 3;
        //s1 = s1 + 2;  // ����ʧ��
        s1 += 2;        // ��������
        System.out.println(s1);

        // ˼��2
        int i = 1;
        i *= 0.1;
        // short���͵���0.1�Զ�����Ϊint�͵���ֵ0��i * 0 �Ľ����0
        System.out.println(i);  // 0
        i++;
        System.out.println(i);  // 1

        // ˼��3
        int m = 2;
        int n = 3;
        n *= m++;       // n = n * m++
        System.out.println("m = " + m);     // m = 3
        System.out.println("n = " + n);     // n = 6


        // ˼��4
        int n4 = 10;
        /*
        * ���Ǹ����ӵ����㣬�����׳���
        * ��һ��С���ţ�������������10����ʱn4��ֵ����11,
        * �ڶ���С���ţ�������������n4=11�Ļ�����������1������ʱn4��ֵ��12
        * ����ֵ�������ߵĲ����� n4 ��ֵ���ڳ�ʼֵ 10
        * ���������ֵ������Եȼ��ڣ�
        * n4 = n4 + (n4++) + (++n4) ����
        * n4 = 10 + 10 + 12
        * ���ԣ�n4 = 32
        * */
        n4 += (n4++) + (++n4);
        System.out.println(n4);     // 32
    }
}
