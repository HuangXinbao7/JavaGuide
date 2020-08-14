package main;

public class MyDate {

    private int year;
    private int month;
    private int day;

    public MyDate(){}

    public MyDate(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String say(){
        return year + "年" + month +"月" + day + "日";
    }
}

class MyDateTest{
    public static void main(String[] args){
        MyDate[] arr;
        arr = new MyDate[4];
        arr[0] = new MyDate(2001, 3, 4);
        arr[1] = new MyDate(2008, 8, 8);
        arr[2] = new MyDate(2020, 3, 28);
        // 空洞：引用数组中为null的元素，空洞很危险，会出空指针异常。

        for (int i = 0; i < arr.length; i++){
            //System.out.println(arr[i].say());  出现空指针异常。出现空指针通常会有一个.操作
            System.out.println(arr[i]);
        }
    }
}


