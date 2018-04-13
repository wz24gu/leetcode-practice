package edu.wz.cs.leetcode.easy;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 437. Path Sum III<br>
 * https://leetcode.com/problems/path-sum-iii<br><br>
 * 
 * You are given a binary tree in which each node contains an integer value. Find the number of paths that sum to a 
 * given value.<br>
 * 
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent 
 * nodes to child nodes).<br>
 * 
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 */
public class PathSumIII {
    
    public static int solution(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        
        int result = helper(root, sum);
        result += solution(root.left, sum) + solution(root.right, sum);
        return result;
    }
    
    private static int helper(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        
        if (node.val == sum) {
            return 1 + helper(node.left, sum - node.val) + helper(node.right, sum - node.val);
        }
        else {
            return helper(node.left, sum - node.val) + helper(node.right, sum - node.val);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        root.right.right = new TreeNode(11);
        System.out.println(PathSumIII.solution(root, 8));        
    }

}
