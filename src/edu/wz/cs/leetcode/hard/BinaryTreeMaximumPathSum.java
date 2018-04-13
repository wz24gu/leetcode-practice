package edu.wz.cs.leetcode.hard;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 124. Binary Tree Maximum Path Sum<br>
 * https://leetcode.com/problems/binary-tree-maximum-path-sum<br><br>
 * 
 * Given a binary tree, find the maximum path sum.<br>
 * 
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along 
 * the parent-child connections. The path must contain at least one node and does not need to go through the root.
 */
public class BinaryTreeMaximumPathSum {
    
    private static int result;
    
    public static int solution(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        result = Integer.MIN_VALUE;
        helper(root);
        return result;
    }
    
    private static int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int left = Math.max(helper(node.left), 0);  // don't add negative
        int right = Math.max(helper(node.right), 0);  // don't add negative
        result = Math.max(result, left + right + node.val);
        return Math.max(left, right) + node.val;        
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(11);
        root.right = new TreeNode(13);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(2);
        System.out.println(BinaryTreeMaximumPathSum.solution(root));
    }

}
