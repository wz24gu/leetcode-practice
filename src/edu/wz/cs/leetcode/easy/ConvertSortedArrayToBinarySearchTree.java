package edu.wz.cs.leetcode.easy;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 108. Convert Sorted Array to Binary Search Tree<br>
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree<br><br>
 * 
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.<br>
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees 
 * of every node never differ by more than 1.
 */
public class ConvertSortedArrayToBinarySearchTree {
    
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
        int mid = lo + (hi - lo) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, lo, mid - 1);
        node.right = helper(nums, mid + 1, hi);
        return node;
    }
    
    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        System.out.println(ConvertSortedArrayToBinarySearchTree.solution(nums));
    }

}
