package com.atguigu.javase.homework;

/**
 * 二叉树
 */
// 树结点
class TreeNode {
    int value;      // 结点的数据域
    TreeNode left;  // 左指针
    TreeNode right; // 右指针
    public TreeNode(int value) {
        this.value = value;
    }
}

// 二叉树
class Tree {

    private TreeNode root;  // 声明根结点引用 root

    // 遍历二叉树
    public void travel() {
        view(root);     // 调用view() 方法，遍历二叉树
        System.out.println();
    }

    // 查看结点的方法
    private void view(TreeNode node) {
        if (node == null) { // 若结点为空，则返回
            return;
        }
        view(node.left);    // 递归调用 view(), 查看左子结点
        System.out.print(node.value + " ");   // 打印当前结点数据域的值
        view(node.right);    // 递归调用 view(), 查看右子结点
    }

    // 插入新结点
    private void insert(TreeNode target, TreeNode newNode) {
        if (newNode.value < target.value) {     // 如果要插入的新结点的值小于目标位置上的结点的值
            if(target.left != null) {           // 判断当前结点的左子结点是否为空
                insert(target.left, newNode);   // 递归调用insert() 方法，在左子树中插入新结点
            }else {     // 如果左子结点为空
                target.left = newNode;      // 将新结点插入到目标结点的左指针域
            }
        } else {    // 插入到右子树中
            if(target.right != null) {      // 判断右指针域是否为空
                insert(target.right, newNode);  // 递归调用 insert() 方法，在右指针域中插入新结点
            } else {    // 如果右指针域为空
                target.right = newNode;     // 将新结点插入到目标结点的右指针域
            }
        }
    }

    // 添加新结点
    public void add(int val) {
        TreeNode newNode = new TreeNode(val);   // 创建一个树结点对象
        if(root == null) {  // 如果二叉树为空
            root = newNode;     // 将根结点引用指向新结点
        } else {
            insert(root, newNode);  // 递归调用 insert() 方法，插入新结点
        }
    }
}


public class TreeTest {

    public static void main(String[] args) {
        Tree tree = new Tree();  // 创建一个二叉树对象
        tree.add(20);   // 插入新结点，值为 20
        tree.add(10);
        tree.add(15);
        tree.add(30);
        tree.add(300);
        tree.add(5);
        tree.add(7);

        tree.travel();  // 遍历二叉树
    }
}
