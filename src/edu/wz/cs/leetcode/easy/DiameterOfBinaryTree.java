package edu.wz.cs.leetcode.easy;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 543. Diameter of Binary Tree<br>
 * https://leetcode.com/problems/diameter-of-binary-tree<br><br>
 * 
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is 
 * the length of the longestpath between any two nodes in a tree. This path may or may not pass through the root.<br>
 * 
 * Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class DiameterOfBinaryTree {
    
    private static int result;
    
    public static int solution(TreeNode root) {
        result = Integer.MIN_VALUE;
        helper(root);
        return result;
    }
    
    private static int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int left = helper(node.left);
        int right = helper(node.right);
        result = Math.max(result, left + right);
        return Math.max(left, right) + 1;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(DiameterOfBinaryTree.solution(root));
    }

}
