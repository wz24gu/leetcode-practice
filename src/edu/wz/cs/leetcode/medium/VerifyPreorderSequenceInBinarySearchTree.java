package edu.wz.cs.leetcode.medium;

import java.util.Stack;

/**
 * 255. Verify Preorder Sequence in Binary Search Tree<br>
 * https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree<br><br>
 * 
 * Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.<br>
 * 
 * You may assume each number in the sequence is unique.<br>
 * 
 * Follow up: Could you do it using only constant space complexity?
 */
public class VerifyPreorderSequenceInBinarySearchTree {
    
    public static boolean solution(int[] preorder) {
        if (preorder == null || preorder.length <= 1) {
            return true;
        }
        
        return helper(preorder, 0, preorder.length - 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private static boolean helper(int[] preorder, int start, int end, int min, int max) {
        if (start > end) {
            return true;
        }
        
        int val = preorder[start];
        if (val <= min || val >= max) {
            return false;
        }
        
        int i;
        for (i = start; i <= end; i++) {
            if (preorder[i] > val) {
                break;
            }
        }
        return helper(preorder, start + 1, i - 1, min, val)
            && helper(preorder, i, end, val, max);
    }
    
    public static boolean solutionAlt(int[] preorder) {
        if (preorder == null || preorder.length <= 1) {
            return true;
        }
        
        int low = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        stack.push(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {  // left node push in stack, right node, pop out low, if < low return false
            if (preorder[i] < low) {
                return false;
            }
            while (!stack.isEmpty() && preorder[i] > stack.peek()) {
                low = stack.pop();
            }
            stack.push(preorder[i]);
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        int[] preorder = {5, 2, 1, 3, 6};
        System.out.println(VerifyPreorderSequenceInBinarySearchTree.solution(preorder));
        System.out.println(VerifyPreorderSequenceInBinarySearchTree.solutionAlt(preorder));
    }

}
