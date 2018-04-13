package edu.wz.cs.leetcode.medium;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 654. Maximum Binary Tree<br>
 * https://leetcode.com/problems/maximum-binary-tree<br><br>
 * 
 * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:<br>
 * 1. The root is the maximum number in the array.<br>
 * 2. The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.<br>
 * 3. The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.<br>
 * 
 * Construct the maximum tree by the given array and output the root node of this tree.<br><br>
 * 
 * Note: The size of the given array will be in the range [1,1000].
 */
public class MaximumBinaryTree {
    
    public static TreeNode solution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return helper(nums, 0, nums.length - 1);
    }
    
    private static TreeNode helper(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        else if (lo == hi) {
            return new TreeNode(nums[lo]);
        }
        
        int max = lo;
        for (int i = lo + 1; i <= hi; i++) {
            if (nums[max] < nums[i]) {
                max = i;
            }
        }
        
        TreeNode root = new TreeNode(nums[max]);
        root.left = helper(nums, lo, max - 1);
        root.right = helper(nums, max + 1, hi);
        return root;
    }
    
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 6, 0, 5};
        System.out.println(MaximumBinaryTree.solution(nums));
    }

}
