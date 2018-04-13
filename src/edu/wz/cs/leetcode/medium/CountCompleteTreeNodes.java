package edu.wz.cs.leetcode.medium;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 222. Count Complete Tree Nodes<br>
 * https://leetcode.com/problems/count-complete-tree-nodes<br><br>
 * 
 * Given a complete binary tree, count the number of nodes.<br>
 * 
 * Definition of a complete binary tree from Wikipedia:<br>
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last 
 * level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 */
public class CountCompleteTreeNodes {

    public static int solution(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = left(root);
        int right = right(root);
        if (left == right) {
            return (int) Math.pow(2, left) - 1;
        }
        
        return solution(root.left) + solution(root.right) + 1;
    }
    
    private static int left(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + left(node.left);
    }
    
    private static int right(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + right(node.right);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        System.out.println(CountCompleteTreeNodes.solution(root));
    }
    
}
