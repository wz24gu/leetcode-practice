package edu.wz.cs.leetcode.medium;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 114. Flatten Binary Tree to Linked List<br>
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list<br><br>
 * 
 * Given a binary tree, flatten it to a linked list in-place.
 */
public class FlattenBinaryTreeToLinkedList {
    
    public static void solution(TreeNode root) {
        if (root == null) {
            return;
        }
        
        if (root.left != null) {
            solution(root.left);
        }
        if (root.right != null) {
            solution(root.right);
        }
        
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null) {
            root = root.right;
        }
        root.right = temp;
    }
    
    public static void solutionAlt(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            if (current.left != null) {
                TreeNode node = current.left;
                while (node.right != null) {
                    node = node.right;
                }
                
                node.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        FlattenBinaryTreeToLinkedList.solution(root);
        System.out.println(root);
        
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(5);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(6);
        FlattenBinaryTreeToLinkedList.solutionAlt(root2);
        System.out.println(root2);
    }
    
    

}
