package edu.wz.cs.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 663. Equal Tree Partition<br>
 * https://leetcode.com/problems/equal-tree-partition<br><br>
 * 
 * Given a binary tree with n nodes, your task is to check if it's possible to partition the tree to two trees which 
 * have the equal sum of values after removing exactly one edge on the original tree.<br><br>
 * 
 * Note:<br>
 * 1. The range of tree node value is in the range of [-100000, 100000].<br>
 * 2. 1 <= n <= 10000
 */
public class EqualTreePartition {
    
    public static boolean solution(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = helper(root, map);
        if (sum == 0) {
            return map.get(sum) > 1;  // if sum = 0, we need multiple 0 because 0 / 2 = 0
        }
        return sum % 2 == 0 && map.containsKey(sum / 2);
    }
    
    private static int helper(TreeNode node, Map<Integer, Integer> map) {
        if (node == null) {
            return 0;
        }
        
        int val = node.val + helper(node.left, map) + helper(node.right, map);
        map.put(val, map.getOrDefault(val, 0) + 1);
        return val;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(10);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(3);
        System.out.println(EqualTreePartition.solution(root));
        
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(10);
        root2.right.left = new TreeNode(2);
        root2.right.right = new TreeNode(20);
        System.out.println(EqualTreePartition.solution(root2));
    }
    
    

}
