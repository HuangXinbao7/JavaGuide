package com.atguigu.javase.homework;

import java.util.Date;

/**
 * 链表
 */
class Node {
    Object value;   // 数据域
    Node next;      // 指针域
    public Node(Object val) {
        this.value = val;
    }
}

class Link {

    private Node head;
    private Node tail;
    private int size = 0;

    public void add(Object val) {
        if(val == null) {
            return;
        }
        Node newNode = new Node(val);
        if(head == null) {

        } else {    // 尾部插入
            tail.next = newNode;    // 新结点链入尾结点的后面
            tail = newNode;         // 刷新尾结点为新尾
        }
        size++;     // 统计结点数
    }

    public void travel() {
        Node tmp = head;
        while (tmp != null) {
            System.out.println(tmp.value + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public void remove(Object val) {
        if(head.value.equals(val)) {    // 先判断要删除的是不是头结点
            head = head.next;           // 让头引用指向头结点的下一个结点
            size--;
            return;
        }
        Node prev = head;
        while(prev.next != null){   // 定位要删除的目标结点的前一个结点
            // prev.next.value：前一个结点的下一个结点，即目标结点的数据域
            if(prev.next.value.equals(val)) {   // 判断目标是否定位，定位成功
                prev.next = prev.next.next;     // 将前一结点指向目标结点的下一个结点
                if(prev.next == null) {     // 删除后，再判断是否是把尾结点删除了
                    tail = prev;    // 尾引用指向当前的尾结点
                }
                size--; // 删除成功后，将结点数减一
                break;  // 删除成功后，中断循环
            }
            prev = prev.next;   // 如果前面的判断删除失败，则指向向后移动，继续搜索目标结点
        }
    }

    // 获取结点个数
    public int size() {
        //// 使用遍历
        //int size = 0;
        //Node tmp = head;
        //while (tmp != null){
        //    size++;
        //    tmp = tmp.next;
        //}

        // 利用类属性 size
        return size;
    }
}


public class LinkTest {

    public static void main(String[] args) {
        Link link = new Link();     // 是个容器，可以保存任意对象，且容量没有限制
        link.add("aaa");
        link.add("bbb");
        link.add("ccc");
        link.add("xxx");
        link.add("111");
        link.add("222");
        link.add("333");

        link.add(new Date());   // 插入一个日期对象

        System.out.println(link.size());

        link.remove("bbb");

        link.travel();
    }
}
