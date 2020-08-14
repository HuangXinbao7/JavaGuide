package com.atguigu.javase.homework;

/**
 * 作业2：在cmd中输入 path, 把path环境变量复制成字符串, 切割, 分析你的path中有哪些目录
 */
public class SplitPath {

    public static void main(String[] args) {

        // Windows 系统中的环境变量值
        String path = "D:\\Tools\\cmder\\bin;" +
                "D:\\Tools\\cmder\\vendor\\bin;" +
                "D:\\Tools\\cmder\\vendor\\conemu-maximus5\\ConEmu\\Scripts;" +
                "D:\\Tools\\cmder\\vendor\\conemu-maximus5;" +
                "D:\\Tools\\cmder\\vendor\\conemu-maximus5\\ConEmu;" +
                "D:\\Develop_Tools\\java\\jdk1.8.0_241\\bin;" +
                "C:\\Program Files (x86)\\Common Files\\Oracle\\Java\\javapath;" +
                "C:\\Windows\\system32;" +
                "C:\\Windows;" +
                "C:\\Windows\\System32\\Wbem;" +
                "C:\\Windows\\System32\\WindowsPowerShell\\v1.0\\;" +
                "C:\\Windows\\System32\\OpenSSH\\;" +
                "D:\\Develop_Tools\\nodejs\\;" +
                "D:\\Tools\\cmder;" +
                "D:\\Develop_Tools\\Git\\cmd;" +
                "D:\\Develop_Tools\\XJad\\;" +
                "C:\\Users\\HQM\\AppData\\Local\\Microsoft\\WindowsApps;" +
                "D:\\Program Files\\Bandizip\\;" +
                "D:\\Develop_Tools\\IntelliJ IDEA 2020.1\\bin;" +
                "D:\\Develop_Tools\\PyCharm 2019.3.3\\bin;" +
                "D:\\Develop_Tools\\WebStorm 2019.3.3\\bin;" +
                "C:\\Users\\HQM\\AppData\\Roaming\\npm;" +
                "D:\\Develop_Tools\\Git\\mingw64\\bin;" +
                "D:\\Develop_Tools\\Git\\usr\\bin;" +
                "D:\\Tools\\cmder\\vendor\\git-for-windows\\cmd;" +
                "D:\\Tools\\cmder\\vendor\\git-for-windows\\mingw64\\bin;" +
                "D:\\Tools\\cmder\\vendor\\git-for-windows\\usr\\bin";

        // 切割, 切割器为 “;”
        String[] splitPath = path.split(";");

        // 遍历切割后的数组
        for(String tmp: splitPath) {
            System.out.println(tmp);
        }
    }
}
