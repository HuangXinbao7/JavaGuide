package singlelinkedlist;

public class Node<T> {

    // 节点的数据域
    public T data;
    // 节点的指针域
    public Node next;

    /**
     * 构造方法
     *
     * @param data 数据域的值
     */
    public Node(T data) {
        this.data = data;
    }

    /**
     * 创建单链表（尾插法）
     *
     * @return 返回头结点
     */
    public static Node createLinkedList() {
        //
        Node<String> head;

        Node<String> n1 = new Node<>("111");
        Node<String> n2 = new Node<>("222");
        Node<String> n3 = new Node<>("333");

        //
        head = n1;
        n1.next = n2;
        n2.next = n3;

        return head;
    }


    /**
     * 遍历链表
     *
     * @param node
     */
    public static void traverse(Node node) {
        while (node != null) {
            System.out.print(node.data + " --> ");
            node = node.next;
        }

        System.out.print("null");
        System.out.println();
    }
}
