package previews;

// 创建元素为引用类型(对象)的数组演示
public class MyDateTest {

    public static void main(String[] args){

        // 创建元素为引用类型的数组 m
        // 内存状态：main 方法压栈到栈内存，并创建一个局部变量 m
        MyDate[] m;

        // 内存状态：在堆内存中创建一个元素个数为10的 MyDate[] 对象，并默认初值为 null
        // 将这对象地址赋值给引用对象变量 m
        m = new MyDate[10];     // java中使用关键字new创建数组对象

        /*
        for 循环三次后内存状态：在堆内存中，创建 MyDate[] 对象
        执行三次后，m[0]、m[1]、m[2] 三个元素中都保存了新创建的MyDate[]对象的地址
        */
        for (int i = 0; i < 10; i++){
            m[i] = new MyDate(i+1, i+1, 1990+i);
            m[i].display();
        }
    }
}
