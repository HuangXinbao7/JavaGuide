package previews;

public class Car {

    String color = "red";
    int num = 4;

    void show(){
        System.out.println("color = " + color + ", num = " + num);
    }
}

class CarTest{

    public static void main(String[] args) {
        // 创建对象
        Car c1 = new Car();
        Car c2 = new Car();

        // 对对象的属性进行修改
        c1.color = "blue";

        c1.show();  // 使用对象的方法
        c2.show();  // 使用对象的方法
    }
}
