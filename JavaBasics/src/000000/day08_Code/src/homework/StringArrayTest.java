package homework;

// 使用静态方式1,和2各创建一个字符串数组, 保存几位同学的姓名. 遍历打印输出
public class StringArrayTest {

    public static void main(String[] args){
        // 静态初始化1
        String[] nameArr1 = new String[]{"小明", "小红", "小丽", "小东"};
        for (int i = 0; i < nameArr1.length; i++){
            System.out.print(nameArr1[i] + " ");
        }
        System.out.println();

        //// 静态初始化2
        String[] nameArr2 = {"小明", "小红", "小丽", "小东"};
        for(int i = 0; i < nameArr2.length; i++) {
            System.out.print(nameArr2[i] + " ");
        }
        System.out.println();
    }
}