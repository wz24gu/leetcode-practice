package edu.wz.cs.leetcode.medium;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 333. Largest BST Subtree<br>
 * https://leetcode.com/problems/largest-bst-subtree<br><br>
 * 
 * Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with 
 * largest number of nodes in it.<br>
 * 
 * Note: A subtree must include all of its descendants.<br>
 * 
 * Follow up: Can you figure out ways to solve it with O(n) time complexity?
 */
public class LargestBSTSubtree {
    
    private static int result;
    
    public static int solution(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        result = 0;
        dfs(root);
        return result;
    }
    
    private static void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        
        int d = count(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (d != -1) {
            result = Math.max(result, d);
            return;
        }
        dfs(node.left);
        dfs(node.right);
    }
    
    private static int count(TreeNode node, int min, int max) {
        if (node == null) {
            return 0;
        }
        
        if (node.val <= min || node.val >= max) {
            return -1;
        }
        
        int left = count(node.left, min, node.val);
        if (left == -1) {
            return -1;
        }
        int right = count(node.right, node.val, max);
        if (right == -1) {
            return -1;
        }
        
        return left + right + 1;
    }
    
    public static int solutionAlt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        if (valid(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            return count(root);
        }
        return Math.max(solutionAlt(root.left), solutionAlt(root.right));
    }
    
    private static boolean valid(TreeNode node, int min, int max) {
        if (node == null) {
            return true;
        }
        
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return valid(node.left, min, node.val) && valid(node.right, node.val, max);
    }
    
    private static int count(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + count(node.left) + count(node.right);
    }
    
    private static class Result {
        int size;
        int lower;
        int upper;
        public Result(int size, int lower, int upper) {
            this.size = size;
            this.lower = lower;
            this.upper = upper;
        }
    }
    
    private static int mx;
    
    public static int solutionX(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        mx = 0;
        traverse(root);
        return mx;
    }
    
    private static Result traverse(TreeNode node) {
        if (node == null) {
            return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        
        Result left = traverse(node.left);
        Result right = traverse(node.right);
        if (left.size == -1 || right.size == -1 || node.val <= left.upper || node.val >= right.lower) {
            return new Result(-1, 0, 0);
        }
        
        int size = 1 + left.size + right.size;
        mx = Math.max(mx, size);
        return new Result(size, Math.min(left.lower, node.val), Math.max(right.upper, node.val));
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(8);
        root.right.right = new TreeNode(7);
        System.out.println(LargestBSTSubtree.solution(root));
        System.out.println(LargestBSTSubtree.solutionAlt(root));
        System.out.println(LargestBSTSubtree.solutionX(root));
    }

}
