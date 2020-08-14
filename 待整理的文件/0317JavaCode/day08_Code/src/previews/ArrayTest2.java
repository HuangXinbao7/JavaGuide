package previews;

/*
数组元素的默认初始化
数组是引用类型，它的元素相当于类的成员变量，
因此数组一经分配空间，其中的每个元素也被按照成员变量同样的方式被隐式初始化。
*/
public class ArrayTest2 {

    public static void main(String args[]) {

        // 声明并初始化数组
        int a[] = new int[5];
        System.out.println(a[3]);   // a[3] 的默认值为0
    }
}
