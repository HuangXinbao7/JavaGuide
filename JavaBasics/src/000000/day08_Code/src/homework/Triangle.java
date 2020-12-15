package homework;

/*
4. 编写两个类，Triangle和TriangleTest，
其中Triangle中声明私有的底边长base和高height，同时声明公共方法访问私有变量；
另一个类中使用这些公共方法，计算三角形的面积。
*/
public class Triangle {
    private double base;
    private double height;

    public Triangle() {}

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public void setBase(double base){
        this.base = base;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getBase(){
        return base;
    }

    public double getHeight(){
        return height;
    }
}
