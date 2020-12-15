package com.atguigu.javase.statictest;

import java.util.Date;

// 结点
class Node{
    Object value;   // 数据域，使用Object，兼容性好
    Node next;      // 指针域，是一个引用变量，保存对象的地址，本类的对象的地址

    public Node(Object value) {
        this.value = value;
    }
}

// 单向链表
class Link {
    private Node head;  // 指向头结点的引用
    private Node tail;  // 指向尾结点的引用
    private int size = 0;

    // 添加结点
    public void add(Object val) {
        Node newNode = new Node(val);
        if(head == null) {  // 第一次插入
            tail = head = newNode;
        }else { // 链表非空插入
            // 让尾结点的next指向新结点
            tail.next = newNode;
            // 刷新尾结点，指向新结点
            tail = newNode;
        }
        size++;
    }

    // 遍历链表
    public void travle() {
        Node tmp = head;    // tmp指向头结点
        while(tmp != null) {
            System.out.print(tmp.value + " ");
            // 让tmp指向原来的下一个结点
            tmp = tmp.next;
        }
        System.out.println();
    }

    // 尝试完成删除功能
    public void delete(Object val) {
        if(head.value.equals(val)) {    // 先判断要删除的是不是头结点
            head = head.next;           // 让头引用指向旧头结点的下一个
            size--;
            return;
        }
        Node prev = head;
        while (prev.next != null) {
            if (prev.next.value.equals(val)) {
                prev.next = prev.next.next; // 把删除的目标的下一个地址写入前一个结点的next指针域
                if(prev.next == null) { // 把尾结点删除了
                    tail = prev;    // 尾引用向左移动
                }
                size--;
                break;
            }
            prev = prev.next;
        }
    }

    // 返回结点个数
    public int size() {
        //// 利用对链表的遍历操作，做累加操作
        //int count = 0;
        //Node tmp = head;
        //while(tmp != null) {
        //    count++;
        //    tmp = tmp.next;
        //}
        //return count;
        return size;
    }
}


public class LinkTest {

    public static void main(String[] args) {
        Link link = new Link();
        link.add("aaa");    // 插入数据
        link.add("bbb");    // 插入数据
        link.add("ccc");    // 插入数据
        link.add("xxx");    // 插入数据
        link.add("111");    // 插入数据
        link.add("222");    // 插入数据
        link.add("333");    // 插入数据

        link.travle();      // 遍历链表

        link.add(new Date());
        System.out.println(link.size());

        link.delete("ccc");
        link.travle();      // 遍历链表
    }
}
