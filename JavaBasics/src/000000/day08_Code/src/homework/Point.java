package homework;

/*
3.定义一个“点”（Point）类用来表示平面中的点（有两个坐标）。要求如下：
    1）可以生成具有特定坐标的点对象。
    2）提供可以设置两个坐标的方法。
    3）提供可以计算该“点”距原点距离的平方的方法
*/
public class Point {

    private int x;
    private int y;

    public Point(){}

    // 可以生成具有特定坐标的点对象
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    // 提供可以设置两个坐标的方法, get 和 set
    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String say(){
        return "x: " + x + ", y: " + y;
    }

    // 计算该“点”距原点距离的平方的方法
    public int getDistance(){
        return x * x + y * y;
    }
}
