public class StringExer {
    // 练习 : 声明字符串name保存你的姓名 , int age保存年龄, char gender保存性别, String address保存地址
    // 再声明一个字符串 string 把以上所有内容拼接成一个长串, "姓名 : xx, 年龄 : xx, 性别 : x, 地址 : xxxxx";
    // 打印字符串
    // 在程序中能用变量的地方绝不用常量
    public static void main(String[] args){

        String name = "黄新宝";
        int age = 28;
        char gender = '男';
        String address = "深圳";

        String me = "姓名 : " + name + ", 年龄 : " + age + ", 性别 : " + gender + ", address : " + address;

        System.out.println(me);
    }
}
