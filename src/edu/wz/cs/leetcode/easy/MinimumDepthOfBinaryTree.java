package edu.wz.cs.leetcode.easy;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 111. Minimum Depth of Binary Tree<br>
 * https://leetcode.com/problems/minimum-depth-of-binary-tree<br><br>
 * 
 * Given a binary tree, find its minimum depth.<br>
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
public class MinimumDepthOfBinaryTree {
    
    public static int solution(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        if (root.left == null && root.right == null) {
            return 1;
        }
        
        if (root.left == null) {
            return solution(root.right) + 1;
        }
        else if (root.right == null) {
            return solution(root.left) + 1;
        }
        else {
            return Math.min(solution(root.left), solution(root.right)) + 1;
        }
    }
    
    private static int min;
    
    public static int solutionAlt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        min = Integer.MAX_VALUE;
        helper(root, 1);
        return min;
    }
    
    private static void helper(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            min = Math.min(min, level);
            return;
        }
        helper(node.left, level + 1);
        helper(node.right, level + 1);
    }    
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        System.out.println(MinimumDepthOfBinaryTree.solution(root));
        System.out.println(MinimumDepthOfBinaryTree.solutionAlt(root));
    }

}
