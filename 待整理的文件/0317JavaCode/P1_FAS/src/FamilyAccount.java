public class FamilyAccount {

    public static void main(String[] args){

        // 准备变量，保存数据
        // 保存基本金的变量，初值是10000
        int balance = 10000;
        // 保存收支明细的字符串，初始值是表头
        String details = "收支\t账户金额\t收支金额\t说   明\n";

        // 声明控制循环的布尔变量，初值是 true
        boolean loopFlag = true;

        // 写一个循环 do while();
        do {
            // 打印主菜单
            System.out.println("--------家庭收支记账软件--------");
            System.out.println("        1 收支明细 ");
            System.out.println("        2 登记收入 ");
            System.out.println("        3 登记支出 ");
            System.out.println("        4 退   出 ");
            System.out.println("");
            System.out.print("请选择(1-4): ");

            // 通过调用工具方法完成从键盘获取用户输入
            char op = Utility.readMenuSelection();   // 返回一个char型的值
            // 虽然不知道用户的具体输入，但是知道肯定是'1'~'4'中的某个
            // 对其进行分支
            switch (op){
                // 如果op是 '1'，打印收支明细字符串
                case '1':
                    System.out.println(details);
                    break;

                // 如果op是'2'，打印"处理收入"
                case '2':
                    // 输出"本次收入金额："
                    System.out.print("本次收入金额：");
                    // 从键盘获取用户输入的收入金额，通过调用工具方法完成
                    int money1 = Utility.readNumber();  // 把这个方法返回值保存在int型变量中

                    // 输出 "本次收入说明："
                    System.out.print("本次收入说明：");
                    // 从键盘获取用户输入收入说明，通过调用工具方法完成
                    String info1 = Utility.readString();   // 把它返回的字符串保存在变量中

                    // 调整余额, 把本次收入的金额累加在基本金上
                    balance += money1;

                    // 声明明细串，拼接内容 "收入   当前金额    本次收入金额  本次收入说明"
                    String string1 = "收入\t" + balance + "\t\t" + money1 + "\t\t" + info1  + "\n";

                    // 将明细串串接在details后面
                    details += string1;
                    break;

                // 如果op是'3'，打印"处理支出"
                case '3':
                    // 输出"本次支出金额："
                    System.out.print("本次支出金额：");
                    // 从键盘获取用户输入的支出金额，通过调用工具方法完成
                    int money2 = Utility.readNumber();  // 把这个方法返回值保存在int型变量中

                    // 输出 "本次支出说明："
                    System.out.print("本次支出说明：");
                    // 从键盘获取用户输入支出说明，通过调用工具方法完成
                    String info2 = Utility.readString();   // 把它返回的字符串保存在变量中

                    // 调整余额, 把本次支出的金额累加在基本金上
                    balance -= money2;

                    // 声明明细串，拼接内容 "支出   当前金额    本次支出金额  本次支出说明"
                    String string2 = "收入\t" + balance + "\t\t" + money2 + "\t\t" + info2 + "\n";

                    // 将明细串串接在details后面
                    details += string2;
                    break;

                // 如果op是'4'，把控制循环的布尔置为false
                case '4':
                    loopFlag = false;
                    break;
            }
        }while (loopFlag);
    }
}
