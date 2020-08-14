package previews;

public class ZooTest {

    /*
    如果创建了一个类的多个对象，对于类中定义的属性，每个对象都拥有各自的一套副本，且互不干扰。
    */
    public static void main(String[] args) {

        Animal xb = new Animal();
        Animal xh = new Animal();

        xb.legs = 4;
        xh.legs = 2;

        System.out.println(xb.legs);
        System.out.println(xh.legs);

        // 修改xb对象的属性
        xb.legs = 8;

        System.out.println(xb.legs);
        System.out.println(xh.legs);
    }
}
