package edu.wz.cs.leetcode.medium;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 285. Inorder Successor in BST<br>
 * https://leetcode.com/problems/inorder-successor-in-bst<br><br>
 * 
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.<br>
 * 
 * Note: If the given node has no in-order successor in the tree, return null.
 */
public class InorderSuccessorInBST {
    
    public static TreeNode solution(TreeNode root, TreeNode p) {
        TreeNode result = null;
        while (root != null) {
            if (root.val > p.val) {
                result = root;  // candidate
                root = root.left;
            }
            else {
                root = root.right;
            }
        }
        return result;
    }
    
    public static TreeNode solutionAlt(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        
        if (root.val <= p.val) {
            return solutionAlt(root.right, p);
        }
        else {
            TreeNode t = solutionAlt(root.left, p);
            return t == null ? root : t;
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(InorderSuccessorInBST.solution(root, root.right));
        System.out.println(InorderSuccessorInBST.solutionAlt(root, root.right));
    }

}
