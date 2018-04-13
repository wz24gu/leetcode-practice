package edu.wz.cs.leetcode.easy;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree<br>
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree<br><br>
 * 
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.<br>
 * 
 * According to the definition of LCA on Wikipedia: "The lowest common ancestor is defined between two nodes v and w as 
 * the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself)."
 */
public class LowestCommonAncestorOfBinarySearchTree {
    
    public static TreeNode solution(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        
        int max = Math.max(p.val, q.val);
        int min = Math.min(p.val, q.val);
        if (root.val > max) {
            return solution(root.left, p, q);
        }
        else if (root.val < min) {
            return solution(root.right, p, q);
        }
        else {
            return root;
        }
    }
    
    public static TreeNode solutionAlt(TreeNode root, TreeNode p, TreeNode q) {
        int max = Math.max(p.val, q.val);
        int min = Math.min(p.val, q.val);
        while (root != null) {
            if (root.val > max) {
                root = root.left;
            }
            else if (root.val < min) {
                root = root.right;
            }
            else {
                break;
            }
        }
        return root;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        
        System.out.println(LowestCommonAncestorOfBinarySearchTree.solution(root, root.left, root.right));
        System.out.println(LowestCommonAncestorOfBinarySearchTree.solutionAlt(root, root.left, root.right));
        
        System.out.println(LowestCommonAncestorOfBinarySearchTree.solution(root, root.left, root.left.right));
        System.out.println(LowestCommonAncestorOfBinarySearchTree.solutionAlt(root, root.left, root.left.right));
        
    }

}
