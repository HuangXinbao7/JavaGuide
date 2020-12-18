package com.atguigu.javase.homework;

import java.util.Date;

class Node {
    Object value; // 数据域
    Node next; // 指针域
    public Node(Object value) {
        this.value = value;
    }
}

class Link {

    private Node head;
    private Node tail;
    private int size = 0;

    public void add(Object val) { // 添加
        if (val == null) {
            return;
        }
        Node newNode = new Node(val);
        if (head == null) {
            tail = head = newNode;
        } else { // 尾部插入
            tail.next = newNode; // 新结点链入老尾的后面
            tail = newNode; // 刷新老尾为新尾
        }
        size++;
    }

    public void travel() { // 遍历
        Node tmp = head;
        while (tmp != null) {
            System.out.print(tmp.value + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public void remove(Object val) {
        if (head.value.equals(val)) { // 先判断要删除的是不是头结点
            head = head.next; // 让头引用指向老头的下一个.
            size--;
            return;
        }
        Node prev = head;
        while (prev.next != null) { // 定位要删除的目标结点的 "前一个" 结点
            if (prev.next.value.equals(val)) { // 判断目标是否定位, 定位成功
                prev.next = prev.next.next; // 把删除的目标的下一个地址 写入 前一个节点的next指针域
                if (prev.next == null) { // 删除后, 再判断是否把尾结点删除了.
                    tail = prev; // 尾引用向左移动一下.
                }
                size--;
                break; // 中断循环, 结束搜索
            }
            prev = prev.next; // 向右移动指针, 定位下一个结点继续搜索
        }
    }

    public int size() { // 获取元素个数
        /*
        int size = 0;
        Node tmp = head;
        while (tmp != null) {
            size++;
            tmp = tmp.next;
        } */
        return size;
    }
}

public class LinkTest {

    public static void main(String[] args) {
        Link link = new Link(); // 是一个容器, 里面可以保存任意对象, 而且容量没有限制, 不要关心下标
        link.add("ccc");
        link.add("aa");
        link.add("bbb");
        link.add("xx");
        link.add("111");
        link.add("333");
        link.add("444");
        link.add(new Date());

        link.travel();

        System.out.println(link.size());

        link.remove("bbb");

        link.travel();
    }
}
