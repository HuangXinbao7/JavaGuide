package previews;

// 创建元素为引用类型(对象)的数组
public class MyDate {

    private int day;
    private int month;
    private int year;

    // 构造器
    public MyDate(int d, int m, int y) {
        day = d;
        month = m;
        year = y;
    }

    public void display(){
        System.out.println(year + "-" + month + "-" + day);
    }
}
