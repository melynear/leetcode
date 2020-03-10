package cn.lizhi.algorithm;

/**
 * 给定一个二叉树，其中所有的右节点要么是具有兄弟节点（拥有相同父节点的左节点）的叶节点，要么为空，
 * 将此二叉树上下翻转并将它变成一棵树， 原来的右节点将转换成左叶节点。返回新的根。
 *
 * @author 种花家的兔子
 * @version v1.0
 * @date 2019年11月12日
 */
public class UpDownBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        public TreeNode(int val) {
            this.val = val;
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode rootLeft = new TreeNode(2);
        TreeNode rootRight = new TreeNode(3);
        TreeNode rootLeftLeft = new TreeNode(4);
        TreeNode rootLeftRight = new TreeNode(5);
        rootLeft.left = rootLeftLeft;
        rootLeft.right = rootLeftRight;
        root.left = rootLeft;
        root.right = rootRight;
        
        TreeNode treeNode = upsideDownBinaryTree(root);
        System.out.println(treeNode);
    }
    
    private static TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        if (null != left) {
            TreeNode newRoot = upsideDownBinaryTree(left);
            left.left = right;
            left.right = root;
            root.left = null;
            root.right = null;
            return newRoot;
        } else {
            return root;
        }
    }
}
