package previews;

public class Zoo {

    public static void main(String[] args) {

        Animal xb = new Animal();

        xb.legs = 4;
        System.out.println(xb.legs);
        xb.eat();
        xb.move();
    }
}
