package homework;

public class FamilyAccount {

    public static void main(String[] args) {
        // 基本金
        int balance = 10000;
        // 收支明细
        String details = "收支\t\t账户金额\t\t收支金额\t\t说   明\n";
        // 控制循环变量, 初始值是 true
        boolean loopFlag = true;

        // 写一个循环，由loopFlag控制
        do {
            // 打印主菜单
            System.out.println("-----------家庭收支记账软件-----------");
            System.out.println("            1 收支明细");
            System.out.println("            2 登记收入");
            System.out.println("            3 登记支出");
            System.out.println("            4 退    出");
            System.out.println("");
            System.out.print("请选择(1-4)：");

            // 从键盘获取用户输入
            char op = Utility.readMenuSelection();

            switch (op) {
                // 打印收支明细
                case '1':
                    System.out.println(details);
                    break;

                // 处理收入
                case '2':
                    System.out.print("本次收入金额：");
                    int money1 = Utility.readNumber();
                    System.out.print("本次收入说明：");
                    String info1 = Utility.readString();
                    balance += money1;
                    String str1 = "收入\t\t" + balance + "\t\t" + money1 + "\t\t" + info1 + "\n";
                    details += str1;
                    break;

                // 处理支出
                case '3':
                    System.out.print("本次支持金额：");
                    int money2 = Utility.readNumber();
                    System.out.print("本次支出说明：");
                    String info2 = Utility.readString();
                    balance -= money2;
                    String str2 = "支出\t\t" + balance + "\t\t" + money2 + "\t\t" + info2 + "\n";
                    details += str2;
                    break;

                // 控制循环
                case '4':
                    loopFlag = false;
                    break;
            }
        } while(loopFlag);
    }
}
