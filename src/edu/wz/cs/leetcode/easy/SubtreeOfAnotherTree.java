package edu.wz.cs.leetcode.easy;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 571. Subtree of Another Tree<br>
 * https://leetcode.com/problems/subtree-of-another-tree<br><br>
 * 
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a 
 * subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree should 
 * also be considered as a subtree of itself.
 */
public class SubtreeOfAnotherTree {
    
    public static boolean solution(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        
        if (sameTree(s, t)) {
            return true;
        }
        return solution(s.left, t) || solution(s.right, t);
    }
    
    private static boolean sameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return sameTree(s.left, t.left) && sameTree(s.right, t.right);
    }
    
    public static void main(String[] args) {
        TreeNode s = new TreeNode(3);
        s.left = new TreeNode(4);
        s.right = new TreeNode(5);
        s.left.left = new TreeNode(1);
        s.left.right = new TreeNode(2);
        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);
        System.out.println(SubtreeOfAnotherTree.solution(s, t));
        
        TreeNode s1 = new TreeNode(3);
        s1.left = new TreeNode(4);
        s1.right = new TreeNode(5);
        s1.left.left = new TreeNode(1);
        s1.left.right = new TreeNode(2);
        s1.left.right.left = new TreeNode(0);
        TreeNode t1 = new TreeNode(4);
        t1.left = new TreeNode(1);
        t1.right = new TreeNode(2);
        System.out.println(SubtreeOfAnotherTree.solution(s1, t1));
    }

}
