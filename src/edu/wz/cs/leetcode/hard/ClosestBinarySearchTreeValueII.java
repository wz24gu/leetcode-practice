package edu.wz.cs.leetcode.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 272. Closest Binary Search Tree Value II<br>
 * https://leetcode.com/problems/closest-binary-search-tree-value-ii<br><br>
 * 
 * Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.<br><br>
 * 
 * Note:<br>
 * 1. Given target value is a floating point.<br>
 * 2. You may assume k is always valid, that is: k <= total nodes.<br>
 * 3. You are guaranteed to have only one unique set of k values in the BST that are closest to the target.<br>
 * 
 * Follow up: Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?
 */
public class ClosestBinarySearchTreeValueII {
    
    public static List<Integer> solution(TreeNode root, double target, int k) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> pre = new Stack<>();
        Stack<TreeNode> suc = new Stack<>();
        
        while (root != null) {
            if (root.val <= target) {
                pre.push(root);
                root = root.right;
            }
            else {
                suc.push(root);
                root = root.left;
            }
        }
        
        while (k > 0) {
            if (suc.isEmpty() || !pre.isEmpty() && target - pre.peek().val < suc.peek().val - target) {
                result.add(pre.peek().val);
                getPredecessor(pre);
            }
            else {
                result.add(suc.peek().val);
                getSuccessor(suc);
            }
            k--;
        }
        
        return result;
    }
    
    private static void getPredecessor(Stack<TreeNode> pre) {
        TreeNode node = pre.pop();
        if (node.left != null) {
            pre.push(node.left);
            while (pre.peek().right != null) {
                pre.push(pre.peek().right);
            }
        }
    }
    
    private static void getSuccessor(Stack<TreeNode> suc) {
        TreeNode node = suc.pop();
        if (node.right != null) {
            suc.push(node.right);
            while (suc.peek().left != null) {
                suc.push(suc.peek().left);
            }
        }
    }
    
    public static List<Integer> solutionAlt(TreeNode root, double target, int k) {
        List<Integer> result = new ArrayList<>();
        inorder(root, target, k, result);
        return result;
    }
    
    private static void inorder(TreeNode node, double target, int k, List<Integer> result) {
        if (node == null) {
            return;
        }
        
        inorder(node.left, target, k, result);
        
        if (result.size() < k) {
            result.add(node.val);
        }
        else if (Math.abs(node.val - target) < Math.abs(result.get(0) - target)) {
            result.remove(0);
            result.add(node.val);
        }
        else {
            return;
        }        
        
        inorder(node.right, target, k, result);
    }

}
