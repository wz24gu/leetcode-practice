package edu.wz.cs.leetcode.medium;

import java.util.Stack;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 98. Validate Binary Search Tree<br>
 * https://leetcode.com/problems/validate-binary-search-tree<br><br>
 * 
 * Given a binary tree, determine if it is a valid binary search tree (BST).<br>
 * 
 * Assume a BST is defined as follows:<br>
 * 1. The left subtree of a node contains only nodes with keys less than the node's key.<br>
 * 2. The right subtree of a node contains only nodes with keys greater than the node's key.<br>
 * 3. Both the left and right subtrees must also be binary search trees.
 */
public class ValidateBinarySearchTree {
    
    public static boolean solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private static boolean helper(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return helper(node.left, min, node.val) && helper(node.right, node.val, max);
    }
    
    public static boolean solutionAlt(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode prev = null;
        
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            
            if (!stack.isEmpty()) {
                curr = stack.pop();
                if (prev != null && prev.val >= curr.val) {
                    return false;
                }
                prev = curr;
                curr = curr.right;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(ValidateBinarySearchTree.solution(root));
        System.out.println(ValidateBinarySearchTree.solutionAlt(root));
        
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        System.out.println(ValidateBinarySearchTree.solution(root2));
        System.out.println(ValidateBinarySearchTree.solutionAlt(root2));
    }

}
