package edu.wz.cs.leetcode.medium;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 156. Binary Tree Upside Down<br>
 * https://leetcode.com/problems/binary-tree-upside-down<br><br>
 * 
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same 
 * parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left 
 * leaf nodes. Return the new root.
 */
public class BinaryTreeUpsideDown {
    
    public static TreeNode solution(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        TreeNode result = solution(left);
        
        left.left = right;
        left.right = root;
        root.left = null;
        root.right = null;
        return result;
    }
    
    public static TreeNode solutionAlt(TreeNode root) {
        TreeNode current = root;
        TreeNode prev = null;
        TreeNode next = null;
        TreeNode temp = null;
        
        while (current != null) {
            next = current.left;
            current.left = temp;
            temp = current.right;
            current.right = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(BinaryTreeUpsideDown.solution(root));
        
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);
        System.out.println(BinaryTreeUpsideDown.solutionAlt(root2));
    }

}
