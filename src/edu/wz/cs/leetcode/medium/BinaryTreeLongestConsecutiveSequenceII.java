package edu.wz.cs.leetcode.medium;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 549. Binary Tree Longest Consecutive Sequence II<br>
 * https://leetcode.com/problems/binary-tree-longest-consecutive-sequence-ii<br><br>
 * 
 * Given a binary tree, you need to find the length of Longest Consecutive Path in Binary Tree.<br>
 * 
 * Especially, this path can be either increasing or decreasing. For example, [1,2,3,4] and [4,3,2,1] are both 
 * considered valid, but the path [1,2,4,3] is not valid. On the other hand, the path can be in the child-Parent-child 
 * order, where not necessarily be parent-child order.<br>
 * 
 * Note: All the values of tree nodes are in the range of [-1e7, 1e7].
 */
public class BinaryTreeLongestConsecutiveSequenceII {
    
    public static int solution(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = helper(root, 1) + helper(root, -1) + 1;
        return Math.max(result, Math.max(solution(root.left), solution(root.right)));
    }
    
    private static int helper(TreeNode node, int diff) {
        if (node == null) {
            return 0;
        }
        
        int left = 0;
        int right = 0;
        if (node.left != null && node.val - node.left.val == diff) {
            left = 1 + helper(node.left, diff);
        }
        if (node.right != null && node.val - node.right.val == diff) {
            right = 1 + helper(node.right, diff);
        }
        return Math.max(left, right);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(BinaryTreeLongestConsecutiveSequenceII.solution(root));
        
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        System.out.println(BinaryTreeLongestConsecutiveSequenceII.solution(root2));
    }

}
