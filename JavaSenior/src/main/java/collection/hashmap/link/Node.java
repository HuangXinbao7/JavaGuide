package org.example.collection.hashmap.link;

/**
 * 链表
 * @author: Ming
 * Date: Created on 2020/9/24 0:57
 */
public class Node {

    public Node next;
    private Object data;

    public Node(Object data) {this.data = data;}

    /**
     * 链表：链表是一种物理存储单元上非连续、非顺序的存储结构
     * 特点：插入、删除的时间复杂度为 O(1)  查找遍历的时间复杂度为 O(N) 插入快，查找慢
     */
    public static void main(String[] args) {
        Node node = new Node("张三");
        node.next = new Node("李四");

        System.out.println(node.data);
        System.out.println(node.next.data);

    }
}
