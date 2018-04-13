package edu.wz.cs.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 337. House Robber III<br>
 * https://leetcode.com/problems/house-robber-iii<br><br>
 * 
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the 
 * "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that 
 * "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked 
 * houses were broken into on the same night.<br>
 * 
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 */
public class HouseRobberIII {
    
    public static int solution(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        return helper(root, map);
    }
    
    private static int helper(TreeNode node, Map<TreeNode, Integer> map) {
        if (node == null) {
            return 0;
        }
        if (map.containsKey(node)) {
            return map.get(node);
        }
        
        int val = 0;
        if (node.left != null) {
            val += helper(node.left.left, map) + helper(node.left.right, map);
        }
        if (node.right != null) {
            val += helper(node.right.left, map) + helper(node.right.right, map);
        }
        
        val = Math.max(val + node.val, helper(node.left, map) + helper(node.right, map));
        map.put(node, val);
        return val;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        System.out.println(HouseRobberIII.solution(root));
        
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(5);
        root2.left.left = new TreeNode(1);
        root2.left.right = new TreeNode(3);
        root2.right.right = new TreeNode(1);
        System.out.println(HouseRobberIII.solution(root2));        
    }

}
