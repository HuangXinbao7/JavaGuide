package com.atguigu.javase.homework;

/**
 * 把 C:/program files 目录复制为 D:/programs2
 */
public class DirectoryCopyTask {

    /**
     * 复制目录
     */
    public static void copyDirectory(File src, File dest) throws IOException {
        dest.mkdirs();      // 先创建目标目录
        File[] files = src.listFiles();     // 列出当前源目录的子目录和文件
        if(files == null) {     // 如果不允许列出目录中的内容树或当前源目录为空，会返回 null
            return;
        }
        // 递归的处理当前源目录的子目录或文件
        for(int i = 0; i < files.length; i++) {
            // 创建目标对象
            File target = new File(dest.getAbsolutePath() + "/" + files[i].getName());
            if (files[i].isFile()) {
                // 复制文件，源文件：C:/program files/aa.txt  目标文件：D:/programs2/aa.txt
                copyFile(files[i], target);     // 调用复制文件方法
            } else if (files[i].isDirectory()) {
                // 复制目录，递归时，C:/program files/xxx D:/programs2/xxx
                copyDirectory(files[i], target);    // 递归时以子目录为源，以当前目标目录的子目录为新目标
            }
        }
    }


    /**
     * 复制文件
     */
    private static void copyFile(File src, File dest) {
        // 如果不是文件也不能读, 返回
        if (!src.isFile() || !src.canRead()) {
            return;
        }
        System.out.println(src + " 复制为 " + dest);

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(src);
            fos = new FileOutputStream(dest);
            byte[] buffer = new byte[8192];     // 设置缓冲区大小
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        } catch (Exception e) {
            // 特殊异常的判断和处理
            if (e instanceof FileNotFoundException) {
                System.out.println("文件不允许被复制。。。");
            } else {
                e.printStackTrace();
            }
        } finally {
            // 关闭输入流
            if(fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            // 关闭输出流
            if(fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {

        File src = new File("C:/program files");
        File dest = new File("E:/programs2");

        copyDirectory(src, dest);
    }
}
