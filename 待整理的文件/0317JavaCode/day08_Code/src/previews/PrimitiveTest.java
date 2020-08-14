package previews;

public class PrimitiveTest {

    public static void main(String[] args){

        // 创建Primitive对象p，输出其成员变量t的三个元素
        // 练习目的：检验基本数据类型数组创建时的自动赋值
        Primitive p = new Primitive();
        for (int i = 0; i < p.t.length; i++){
            System.out.println(p.t[i]);
        }

        // 给对象d的成员变量t赋值为{true,true,true}，并输出t的三个元素值。
        for (int i = 0; i < p.t.length; i++){
            p.t[i] = true;
            System.out.println(p.t[i]);
        }
    }
}
