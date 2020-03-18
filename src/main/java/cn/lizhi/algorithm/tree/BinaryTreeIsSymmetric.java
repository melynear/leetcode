package cn.lizhi.algorithm.tree;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * @author 种花家的兔子
 * @version v1.0
 * @date 2019年11月20日
 */
public class BinaryTreeIsSymmetric {
    public static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;
        
        public TreeNode(int value) {
            this.value = value;
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        System.out.println(isSymmetric(root.left, root.right));
    }
    
    private static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else {
            return left.value == right.value && isSymmetric(left.right, right.left) && isSymmetric(left.left, right.right);
        }
    }
}
