package com.atguigu.bms.service;

import com.atguigu.bms.domain.Book;


/**
 * 	BookList
 * 		void addBook(Book book) // 如何保证一定成功, 内部要自动扩容
 * 		Book[] getAllBooks()
 * 		Book getBook(int index)
 * 		boolean deleteBook(int index)
 */
// 它永远是被动的调用的. 它是一个 Book 对象的管理器
public class BookList {

    // 这两个属性具有强烈的逻辑性和逻辑关系, 所以必须完全封装
    // 用来保存书籍对象的数组
    private Book[] books;
    // 记录已保存书籍对象的数量, 计数器
    private int realCount = 0;  //


    // 初始化 books 数组的构造器
    public BookList(int totalCount){
        // 由调用者决定数组的容量
        this.books = new Book[totalCount];
    }


    /**
     * 添加书籍
     *
     */
    public boolean addBook(Book book){
        if (realCount == books.length){
            return false;
        }
        this.books[realCount] = book;
        realCount++;
        return true;    // 添加成功
    }


    /**
     * 返回数组中记录的所有书籍对象
     */
    public Book[] getAllBooks(){
        // 创建新数组
        Book[] newArr = new Book[realCount];
        // 依次把数组中的所有有效对象复制到新数组中
        for (int i = 0; i < realCount; i++) {
            newArr[i] = this.books[i];
        }
        // 返回数组
        return newArr;
    }


    /**
     * 返回参数index指定索引位置的书籍对象记录
     */
    public Book getBook(int index){
        if(index < 0 || index >= realCount){
            return null;
        }
        return books[index];
    }

    /**
     * 从数组中删除指定索引位置的书籍对象记录
     */
    public boolean deleteBook(int index){
        if(index < 0 || index >= realCount){
            return false;   // 删除失败
        }
        // 1) 把要删除的下标位置处置为空洞
        this.books[index] = null;
        // 2) 从要删除的下标位置开始依次把右侧相邻元素复制到左边. 控制好循环
        // 到有效元素的倒数第二个就是最后一次复制
        for (int i = index; i < realCount - 1; i++) {
            books[i] = books[i + 1];
        }
        // 3) 把之前的最后有效元素位置处置空洞
        books[realCount - 1] = null;
        // 4) 调整计数器
        realCount--;
        return true;
    }
}
