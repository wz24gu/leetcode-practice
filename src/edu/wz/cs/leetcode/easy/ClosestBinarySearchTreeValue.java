package edu.wz.cs.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 270. Closest Binary Search Tree Value<br>
 * https://leetcode.com/problems/closest-binary-search-tree-value<br><br>
 * 
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.<br><br>
 * 
 * Note:<br>
 * 1. Given target value is a floating point.<br>
 * 2. You are guaranteed to have only one unique value in the BST that is closest to the target.
 */
public class ClosestBinarySearchTreeValue {
    
    public static int solution(TreeNode root, double target) {
        int result = 0;
        double min = Double.POSITIVE_INFINITY;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (Math.abs(node.val - target) < min) {
                min = Math.abs(node.val - target);
                result = node.val;
            }
            
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        
        return result;
    }
    
    public static int solutionX(TreeNode root, double target) {
        int result = root.val;
        
        TreeNode current = root;
        while (current != null) {
            if (Math.abs(result - target) > Math.abs(current.val - target)) {
                result = current.val;
            }
            
            if (target < current.val) {
                current = current.left;
            }
            else if (target > current.val) {
                current = current.right;
            }
            else {
                return result;
            }            
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        
        System.out.println(ClosestBinarySearchTreeValue.solution(root, 4));
        System.out.println(ClosestBinarySearchTreeValue.solutionX(root, 4));
    }

}
