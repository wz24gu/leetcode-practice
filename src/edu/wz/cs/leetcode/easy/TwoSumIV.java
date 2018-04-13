package edu.wz.cs.leetcode.easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 653. Two Sum IV<br>
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst<br><br>
 * 
 * Given a binary search tree and a target number, return true if there exist two elements in the BST such that their
 * sum is equal to the given target.
 */
public class TwoSumIV {

    public static boolean solution(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (map.containsKey(k - node.val)) {
                if (k - node.val != node.val || k - node.val == node.val && map.get(node.val) > 1) {
                    return true;
                }
            }
            map.put(node.val, map.getOrDefault(node.val, 0) + 1);
            
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        
        return false;
    }
    
    public static boolean solutionAlt(TreeNode root, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        return helper(root, map, k);
    }
    
    private static boolean helper(TreeNode node, Map<Integer, Integer> map, int k) {
        if (node == null) {
            return false;
        }
        
        if (map.containsKey(k - node.val)) {
            if (k - node.val != node.val || k - node.val == node.val && map.get(node.val) > 1) {
                return true;
            }
        }
        map.put(node.val, map.getOrDefault(node.val, 0) + 1);
        
        return helper(node.left, map, k) || helper(node.right, map, k);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        System.out.println(TwoSumIV.solution(root, 9));
        System.out.println(TwoSumIV.solution(root, 28));
        System.out.println(TwoSumIV.solutionAlt(root, 9));
        System.out.println(TwoSumIV.solutionAlt(root, 28));        
    }

}
