package edu.wz.cs.leetcode.medium;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 814. Binary Tree Pruning<br>
 * https://leetcode.com/problems/binary-tree-pruning<br><br>
 * 
 * We are given the head node root of a binary tree, where additionally every node's value is either a 0 or a 1.<br>
 * 
 * Return the same tree where every subtree (of the given tree) not containing a 1 has been removed.<br>
 * 
 * (Recall that the subtree of a node X is X, plus every node that is a descendant of X.)<br><br>
 * 
 *  Note:<br>
 *  1. The binary tree will have at most 100 nodes.<br>
 *  2. The value of each node will only be 0 or 1.
 */
public class BinaryTreePruning {
    
    public static TreeNode solution(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        root.left = solution(root.left);
        root.right = solution(root.right);
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        System.out.println(BinaryTreePruning.solution(root));
        
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(0);
        root2.right = new TreeNode(1);
        root2.left.left = new TreeNode(0);
        root2.left.right = new TreeNode(0);
        root2.right.left = new TreeNode(0);
        root2.right.right = new TreeNode(1);
        System.out.println(BinaryTreePruning.solution(root2));
        
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(1);
        root3.right = new TreeNode(0);
        root3.left.left = new TreeNode(1);
        root3.left.right = new TreeNode(1);
        root3.left.left.left = new TreeNode(0);        
        root3.right.left = new TreeNode(0);
        root3.right.right = new TreeNode(1);
        System.out.println(BinaryTreePruning.solution(root3));
    }

}
