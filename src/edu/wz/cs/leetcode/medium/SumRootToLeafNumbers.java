package edu.wz.cs.leetcode.medium;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 129. Sum Root to Leaf Numbers<br>
 * https://leetcode.com/problems/sum-root-to-leaf-numbers<br><br>
 * 
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.<br>
 * 
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.<br>
 * 
 * Find the total sum of all root-to-leaf numbers.
 */
public class SumRootToLeafNumbers {
    
    public static int solution(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return helper(root, 0);
    }
    
    private static int helper(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        
        sum = sum * 10 + node.val;
        if (node.left == null && node.right == null) {
            return sum;
        }
        return helper(node.left, sum) + helper(node.right, sum);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(SumRootToLeafNumbers.solution(root));
    }

}
