package com.atguigu.bms.view;

import com.atguigu.bms.domain.Book;
import com.atguigu.bms.service.BookList;

public class BookView {

    //创建最大包含10个书籍对象的 BookList 对象，供以下各成员方法使用
    private BookList bookList = new BookList(10);

    /**
     * 项目入口
     */
    public void enterMainMenu(){
        boolean loopFlag = true;
        while (loopFlag){
            // 打印主菜单
            System.out.println("-----------------书籍信息管理软件-----------------");
            System.out.println();
            System.out.println("        1 添 加 书籍");
            System.out.println("        2 修 改 书籍");
            System.out.println("        3 删 除 书籍");
            System.out.println("        4 书籍 列 表");
            System.out.println("        5 退     出");
            System.out.println();
            System.out.print("请选择(1 - 5)：");

            // 使用工具类获取用户的选择
            char choice = CMUtility.readMenuSelection();

            // 根据用户的选择
            switch (choice) {
                case '1': addNewBook(); break;
                case '2': modifyBook(); break;
                case '3': deleteBook(); break;
                case '4': listAllBook(); break;
                case '5':
                    System.out.print("确认是否退出(Y/N) : ");
                    char c = CMUtility.readConfirmSelection();
                    if(c == 'Y'){
                        loopFlag = false;
                    }
                    break;
            }
        }
    }

    private void addNewBook(){
        System.out.println("---------------------添加书籍---------------------");
        System.out.print("书名：");
        String name = CMUtility.readString(10);
        System.out.print("作者：");
        String author = CMUtility.readString(20);
        System.out.print("价格：");
        int price = CMUtility.readInt();
        System.out.print("销量：");
        int sales = CMUtility.readInt();
        System.out.print("库存：");
        int stock = CMUtility.readInt();

        // 创建一个 Book 对象
        Book book = new Book(name, author, price, sales, stock);

        // 给管理器添加对象
        boolean flag = this.bookList.addBook(book);
        if(flag){
            System.out.println("---------------------添加完成---------------------");
        }else {
            System.out.println("---------------------添加失败，容量已满---------------------");
        }
        listAllBook();
    }


    private void modifyBook(){
        System.out.println("---------------------修改书籍---------------------");
        System.out.print("请选择待修改客户编号(-1退出)：");
        // 通过工具类获取用户输入的整数
        int no = CMUtility.readInt();
        // 如果这个整数是-1, 方法提前返回, 就不修改了
        if(no == -1){
            return;
        }
        // 根据编号获取要修改的目标对象
        Book target = bookList.getBook(no - 1);
        // 如果获取到的目标对象为空, 打印错误, 并提前返回
        if (target == null) {
            System.out.println("编号错误！！");
            return;
        }
        System.out.println("<直接回车表示不修改>");

        System.out.print("书名(" + target.getName() + "): ");
        // 通过调用工具方法获取用户输入的新书名
        String name = CMUtility.readString(10, target.getName());
        // 无条件设置目标对象的 name 属性
        target.setName(name);

        System.out.print("作者(" + target.getAuthor() + "): ");
        // 通过调用工具方法获取用户输入的新作者
        String author = CMUtility.readString(10, target.getAuthor());
        // 无条件设置目标对象的 author 属性
        target.setAuthor(author);

        System.out.print("价格(" + target.getPrice() + "): ");
        // 通过调用工具方法获取用户输入的新价格
        int price = CMUtility.readInt(target.getPrice());
        // 无条件设置目标对象的 price 属性
        target.setPrice(price);

        System.out.print("销量(" + target.getSales() + "): ");
        // 通过调用工具方法获取用户输入的新销售额
        int sales = CMUtility.readInt(target.getSales());
        // 无条件设置目标对象的 sales 属性
        target.setSales(sales);

        System.out.print("库存(" + target.getStock() + "): ");
        // 通过调用工具方法获取用户输入的新库存
        int stock = CMUtility.readInt(target.getStock());
        // 无条件设置目标对象的 stock 属性
        target.setStock(stock);

        System.out.println("---------------------修改完成---------------------");
        listAllBook();
    }


    private void deleteBook(){
        System.out.println("---------------------删除书籍---------------------");
        System.out.print("请选择待删除书籍编号(-1退出)：");
        int no = CMUtility.readInt();
        if (no == -1){
            return;
        }
        System.out.print("确认是否删除(Y/N)：");
        char confirm = CMUtility.readConfirmSelection();
        if(confirm == 'Y'){
            boolean flag = bookList.deleteBook(no - 1);
            if(flag){
                System.out.println("---------------------删除完成---------------------");
            }else{
                System.out.println("---------------------删除失败, 编号错误!---------------------");
            }
        }
        listAllBook();
    }


    private void listAllBook(){
        System.out.println("---------------------------书籍列表---------------------------");
        System.out.println("书名\t\t作者\t\t价格\t\t销量\t\t库存");
        // 真的获取到所有书籍, 向管理器要, 调用方法, 再遍历打印输出
        Book[] allBooks = bookList.getAllBooks();
        for (int i = 0; i < allBooks.length; i++) { // 有风险吗?
            System.out.println((i + 1) + "\t\t" + allBooks[i].say());
        }
        System.out.println("-------------------------书籍列表完成-------------------------");
    }
}
