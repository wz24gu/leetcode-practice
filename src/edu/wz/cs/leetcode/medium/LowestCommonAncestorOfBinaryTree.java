package edu.wz.cs.leetcode.medium;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 236. Lowest Common Ancestor of a Binary Tree<br>
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree<br><br>
 * 
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.<br>
 * 
 * According to the definition of LCA on Wikipedia: "The lowest common ancestor is defined between two nodes v and w as 
 * the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself)."
 */
public class LowestCommonAncestorOfBinaryTree {
    
    public static TreeNode solution(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        
        TreeNode left = solution(root.left, p, q);
        TreeNode right = solution(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        System.out.println(LowestCommonAncestorOfBinaryTree.solution(root, root.left, root.right).val);
        System.out.println(LowestCommonAncestorOfBinaryTree.solution(root, root.left, root.left.right.right).val);
    }

}
