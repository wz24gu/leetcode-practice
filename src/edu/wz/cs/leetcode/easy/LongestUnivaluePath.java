package edu.wz.cs.leetcode.easy;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 687. Longest Univalue Path<br>
 * https://leetcode.com/problems/longest-univalue-path<br><br>
 * 
 * Given a binary tree, find the length of the longest path where each node in the path has the same value. This path 
 * may or may not pass through the root.<br><br>
 * 
 * Note:<br>
 * 1. The length of path between two nodes is represented by the number of edges between them.<br>
 * 2. The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.
 */
public class LongestUnivaluePath {
    
    private static int result;
    
    public static int solution(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        result = 0;
        helper(root, root.val);
        return result;
    }
    
    private static int helper(TreeNode node, int val) {
        if (node == null) {
            return 0;
        }
        
        int left = helper(node.left, node.val);  // pass node.val, not val
        int right = helper(node.right, node.val);
        
        result = Math.max(result, left + right);
        
        if (node.val == val) {
            return Math.max(left, right) + 1;
        }
        else {
            return 0;
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(5);
        System.out.println(LongestUnivaluePath.solution(root));
        
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(5);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(LongestUnivaluePath.solution(root2));
    }

}
