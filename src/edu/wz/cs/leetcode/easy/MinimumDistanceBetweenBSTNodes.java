package edu.wz.cs.leetcode.easy;

import java.util.Stack;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 783. Minimum Distance Between BST Nodes<br>
 * https://leetcode.com/problems/minimum-distance-between-bst-nodes<br><br>
 * 
 * Given a Binary Search Tree (BST) with the root node root, return the minimum difference between the values of any two 
 * different nodes in the tree.<br><br>
 * 
 * Note:<br>
 * 1. The size of the BST will be between 2 and 100.<br>
 * 2. The BST is always valid, each node's value is an integer, and each node's value is different.
 */
public class MinimumDistanceBetweenBSTNodes {
    
    private static TreeNode prev;
    private static int min;
    
    public static int solution(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        prev = null;
        min = Integer.MAX_VALUE;
        inorder(root);
        return min;
    }
    
    private static void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        
        inorder(node.left);
        if (prev != null) {
            min = Math.min(min, node.val - prev.val);
        }
        prev = node;
        inorder(node.right);
    }
    
    public static int solutionAlt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        TreeNode prev = null;
        int min = Integer.MAX_VALUE;
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            
            if (!stack.isEmpty()) {
                curr = stack.pop();
                if (prev != null) {
                    min = Math.min(min, curr.val - prev.val);
                }
                prev = curr;
                curr = curr.right;
            }
        }
        
        return min;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        System.out.println(MinimumDistanceBetweenBSTNodes.solution(root));
        System.out.println(MinimumDistanceBetweenBSTNodes.solutionAlt(root));
    }

}
