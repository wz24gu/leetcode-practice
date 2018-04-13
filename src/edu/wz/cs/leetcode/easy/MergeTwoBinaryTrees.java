package edu.wz.cs.leetcode.easy;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 617. Merge Two Binary Trees<br>
 * https://leetcode.com/problems/merge-two-binary-trees<br><br>
 * 
 * Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are
 * overlapped while the others are not. You need to merge them into a new binary tree. The merge rule is that if two
 * nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used
 * as the node of new tree.<br><br>
 * 
 * Note: The merging process must start from the root nodes of both trees.
 */
public class MergeTwoBinaryTrees {
    
    public static TreeNode solution(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        
        TreeNode root = new TreeNode(t1.val + t2.val);
        root.left = solution(t1.left, t2.left);
        root.right = solution(t1.right, t2.right);
        return root;
    }
    
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(2);
        t1.left.left = new TreeNode(5);
        
        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(3);
        t2.left.right = new TreeNode(4);
        t2.right.right = new TreeNode(7);
        
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(MergeTwoBinaryTrees.solution(t1, t2));
    }

}
