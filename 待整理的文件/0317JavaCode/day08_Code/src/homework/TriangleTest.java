package homework;

public class TriangleTest {

    public static void main(String[] args){

        Triangle t = new Triangle();

        // 设置 base 和 height
        t.setBase(30);
        t.setHeight(20);

        // 获取 base 和 height
        double base = t.getBase();
        double height = t.getHeight();

        double s = 0.0;
        s = base * height / 2;
        System.out.println("三角形面积：" + s);
    }
}
