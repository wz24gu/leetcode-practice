package edu.wz.cs.leetcode.algorithm;

import edu.wz.cs.leetcode.model.TreeNode;

public class MorrisTraversal {
    
    public static void inorder(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                System.out.println(curr.val + " ");
                curr = curr.right;
            }
            else {
                TreeNode prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                
                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                }
                else {  // prev.right = curr
                    prev.right = null;  // reset added link
                    System.out.println(curr.val + " ");
                    curr = curr.right;
                }
            }
        }
    }
    
    public static void preorder(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                System.out.println(curr.val + " ");
                curr = curr.right;
            }
            else {
                TreeNode prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                
                if (prev.right == null) {
                    prev.right = curr;
                    System.out.println(curr.val + " ");
                    curr = curr.left;
                }
                else {
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }
    }

}
