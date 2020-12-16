package com.atguigu.javase.homework;

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
    public TreeNode(int value) {
        this.value = value;
    }
}

class Tree {

    private TreeNode root;

    public void travel() {
        view(root);
    }

    private void view(TreeNode node) {
        if (node == null) {
            return;
        }
        view(node.left);
        System.out.println(node.value);
        view(node.right);
    }

    private void insert(TreeNode target, TreeNode newNode) {
        if (newNode.value < target.value) {
            if (target.left != null) {
                insert(target.left, newNode);
            } else {
                target.left = newNode;
            }
        } else {
            if (target.right != null) {
                insert(target.right, newNode);
            } else {
                target.right = newNode;
            }
        }
    }

    public void add(int val) {
        TreeNode newNode = new TreeNode(val);
        if (root == null) {
            root = newNode;
        } else {
            insert(root, newNode);
        }
    }
}

public class TreeTest {

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.add(20);
        tree.add(10);
        tree.add(15);
        tree.add(30);
        tree.add(5);
        tree.add(8);

        tree.travel();
    }
}
