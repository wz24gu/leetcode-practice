package edu.wz.cs.leetcode.easy;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 530. Minimum Absolute Difference In BST<br>
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst<br><br>
 * 
 * Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two
 * nodes.<br/><br/>
 * 
 * Node: There are at least two nodes in this BST.
 */
public class MinimumAbsoluteDifferenceInBST {
    
    private static Integer prev;
    private static int min;

    public static int solution(TreeNode root) {
        min = Integer.MAX_VALUE;
        prev = null;
        inorder(root);
        return min;
    }
    
    public static void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        
        inorder(node.left);
        if (prev != null) {
            min = Math.min(min, Math.abs(node.val - prev));
        }
        prev = node.val;
        inorder(node.right);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        System.out.println(MinimumAbsoluteDifferenceInBST.solution(root));
    }

}
