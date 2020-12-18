class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
    public TreeNode(int value) {
        this.value = value;
    }
}

class Tree {
    private TreeNode root;  // 引用

    /**
     * 插入结点的方法
     * @param target    目标结点
     * @param newNode   要插入的结点
     */
    private void insert(TreeNode target, TreeNode newNode) {
        if(newNode.value < target.value) {
            if(target.left != null) {
                insert(target.left, newNode);
            } else {
                target.left = newNode;
            }
        }


    }
    public void add(int val) {
        TreeNode newNode = new TreeNode(val);
        // 如果根结点为null
        if(root == null) {
            root = newNode;
        }else {
            if(val < root.value) {
                root.left = newNode;
            } else {
                root.right = newNode;
            }
        }
    }
}

public class TreeTest {


}
