package edu.wz.cs.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 404. Sum of Left Leaves<br>
 * https://leetcode.com/problems/sum-of-left-leaves<br><br>
 * 
 * Find the sum of all left leaves in a given binary tree.<br>
 */
public class SumOfLeftLeaves {
    
    private static int result;
    
    public static int solution(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        result = 0;
        helper(root.left, true);
        helper(root.right, false);
        return result;
    }
    
    private static void helper(TreeNode node, boolean isLeft) {
        if (node == null) {
            return;
        }
        
        if (node.left == null && node.right == null && isLeft) {
            result += node.val;
        }
        helper(node.left, true);
        helper(node.right, false);
    }
    
    public static int solutionAlt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null && node.left.left == null && node.left.right == null) {
                sum += node.left.val;
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        
        return sum;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        
        System.out.println(SumOfLeftLeaves.solution(root));
        System.out.println(SumOfLeftLeaves.solutionAlt(root));
    }
    

}
