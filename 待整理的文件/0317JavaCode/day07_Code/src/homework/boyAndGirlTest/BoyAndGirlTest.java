package homework.boyAndGirlTest;

public class BoyAndGirlTest {

    public static void main(String[] args){

        Boy boy = new Boy("小明", 28);
        Girl girl = new Girl("小丽");

        boy.marry(girl);    // 对象传递

        boy.shout();
    }
}
