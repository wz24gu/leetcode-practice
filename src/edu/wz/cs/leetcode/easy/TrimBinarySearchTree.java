package edu.wz.cs.leetcode.easy;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 669. Trim a Binary Search Tree<br>
 * https://leetcode.com/problems/trim-a-binary-search-tree<br><br>
 * 
 * Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its elements
 * lies in [L, R] (R >= L). You might need to change the root of the tree, so the result should return the new root of
 * the trimmed binary search tree.
 */
public class TrimBinarySearchTree {
    
    public static TreeNode solution(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }
        
        if (root.val < L) {
            root = solution(root.right, L, R);
        }
        else if (root.val > R) {
            root = solution(root.left, L, R);
        }
        else {
            root.left = solution(root.left, L, R);
            root.right = solution(root.right, L, R);
        }
        return root;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(2);
        System.out.println(TrimBinarySearchTree.solution(root, 1, 2));
        
        root = new TreeNode(3);
        root.left = new TreeNode(0);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(1);
        System.out.println(TrimBinarySearchTree.solution(root, 1, 3));
    }

}
