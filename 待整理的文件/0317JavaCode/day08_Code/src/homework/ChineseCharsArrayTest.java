package homework;

public class ChineseCharsArrayTest {

    // 参考答案
    public static void main(String[] args) {
        // 创建一个字符串数组，保存所有汉字。
        char first = '一';
        char last = '龥';
        char[] chinese = new char[last - first + 1];
        for (int i = 0; i < chinese.length; i++){
            chinese[i] = (char)(first + i);
        }

        // 遍历
        for (int i = 0; i < chinese.length; i++){
            System.out.println(chinese[i] + " ");
            if(i % 20 == 19){
                System.out.println();
            }
        }

        // 打印汉字的总个数
        System.out.println(chinese.length);
    }


    // 作业提交
    public static void main1(String[] args){

        // Windows系统中所有中文的 Unicode编码范围是：4E00-9FA5
        // 4E00-9FA5 对应的十进制是：19968-40869，一共 20902个字
        char[] chineseArr = new char[20902];
        for(int i = 0; i < 20902; i++){
            //chineseArr[i] = (char)(0x4E00+i);
            chineseArr[i] = (char)(19968+i);
        }

        for (int i = 0; i < chineseArr.length; i++){
            System.out.print(chineseArr[i]);
        }
    }
}
