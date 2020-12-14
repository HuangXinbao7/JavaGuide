package com.atguigu.bms.domain;

/**
 * 	Book
 * 		name
 * 		author
 * 		price
 * 		sales
 * 		stock
 */
public class Book {

    private String name;    // 书名
    private String author;  // 作者
    private int price;      // 价格
    private int sales;      // 销量
    private int stock;      // 库存

    public Book(){
    }

    public Book(String name, String author, int price, int sales, int stock){
        this.name = name;
        this.author = author;
        this.price = price;
        this.sales = sales;
        this.stock = stock;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public int getSales() {
        return sales;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public String say(){
        return name + "\t\t" + author + "\t\t" + price + "\t\t" + sales + "\t\t" + stock;
    }
}
