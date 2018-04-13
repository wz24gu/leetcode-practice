package edu.wz.cs.leetcode.easy;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 110. Balanced Binary Tree<br>
 * https://leetcode.com/problems/balanced-binary-tree<br><br>
 * 
 * Given a binary tree, determine if it is height-balanced.<br>
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees 
 * of every node never differ by more than 1.
 */
public class BalancedBinaryTree {
    
    public static boolean solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(right - left) > 1) {
            return false;
        }
        return solution(root.left) && solution(root.right);
    }
    
    private static int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(BalancedBinaryTree.solution(root));
        
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(3);
        root2.left.left.left = new TreeNode(4);
        root2.left.left.right = new TreeNode(4);
        System.out.println(BalancedBinaryTree.solution(root2));
    }

}
