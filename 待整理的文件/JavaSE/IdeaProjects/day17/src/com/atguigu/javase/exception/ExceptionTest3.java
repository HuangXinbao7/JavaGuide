package com.atguigu.javase.exception;

/**
 * 异常处理
 */
public class ExceptionTest3 {

    public static void main(String[] args) {
        System.out.println("main begin");

        try {
            int n1 = Integer.parseInt(args[0]);
            int n2 = Integer.parseInt(args[1]);
            int n3 = n1 / n2;
            System.out.println(n1 + " / " + n2 + " = " + n3);
            return; // 这里的return也不影响finally的执行
        } catch(ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println(e.getMessage());
        } catch (ArithmeticException e) {
            e.printStackTrace();    // 打印栈踪迹
        } catch (Exception e) {
            System.out.println("其他异常：" + e);
            System.out.println(e.getMessage());
        } finally { // finally表示最终的，
            // 即使是try中的return也不影响finally的执行
            System.out.println("无论前面执行了什么，这个代码块都要执行");
        }
        System.out.println("main end");
    }


    public static void main1(String[] args) {
        System.out.println("main begin");

        try{
            int n = Integer.parseInt(args[0]);
            System.out.println("n: " + n);      // 如果真的出现异常，此语句将受影响。
        } catch (NumberFormatException e){      // 捕获数字格式化异常，其他异常不能捕获
            System.out.println(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {     // 终极的异常捕获，相当于 else 语句
            System.out.println("其他异常：" + e);
        }

        System.out.println("main end"); // 异常捕获外的代码收到保护
    }
}
