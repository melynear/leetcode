package cn.lizhi.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层序遍历
 *
 * @author 种花家的兔子
 * @version v1.0
 * @date 2020年03月02日
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            List<Integer> levelResult = new ArrayList<>();
            
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                levelResult.add(cur.value);
                
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            
            result.add(levelResult);
        }
        
        return result;
    }
    
    /**
     * 树的结点定义
     */
    public class TreeNode {
        /**
         * 结点关键字
         */
        int value;
        
        /**
         * 左结点
         */
        TreeNode left;
        
        /**
         * 右结点
         */
        TreeNode right;
        
        TreeNode(int value) {
            this.value = value;
        }
    }
}
