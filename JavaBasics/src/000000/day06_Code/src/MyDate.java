// 写一个类 MyDate, 属性 year，month，day，方法 String say（）
public class MyDate {

    int year = 1999;
    int month = 9;
    int day = 9;

    public String say() {
        String str = year + "年" + month + "月" + day + "日";
        return str;
    }
}
