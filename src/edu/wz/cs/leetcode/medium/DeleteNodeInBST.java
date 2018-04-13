package edu.wz.cs.leetcode.medium;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 450. Delete Node in a BST<br>
 * https://leetcode.com/problems/delete-node-in-a-bst<br><br>
 * 
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node 
 * reference (possibly updated) of the BST.<br>
 * 
 * Basically, the deletion can be divided into two stages:<br>
 * 1. Search for a node to remove.<br>
 * 2. If the node is found, delete the node.<br>
 * 
 * Note: Time complexity should be O(height of tree).
 */
public class DeleteNodeInBST {
    
    public static TreeNode solution(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        
        if (root.val > key) {
            root.left = solution(root.left, key);
        }
        else if (root.val < key) {
            root.right = solution(root.right, key);
        }
        else {
            if (root.right == null) {
                return root.left;
            }
            TreeNode curr = root.right;
            while (curr.left != null) {
                curr = curr.left;
            }
            root.val = curr.val;
            root.right = solution(root.right, curr.val);
        }
        
        return root;
    }
    
    // This is a template for all binary trees
    public static TreeNode solutionGeneral(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        
        if (root.val == key) {
            if (root.right == null) {
                return root.left;
            }
            else {
                TreeNode current = root.right;
                while (current.left != null) {
                    current = current.left;
                }
                int swap = root.val;
                root.val = current.val;
                current.val = swap;
            }
        }
        
        root.left = solutionGeneral(root.left, key);
        root.right = solutionGeneral(root.right, key);
        return root;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        System.out.println(DeleteNodeInBST.solution(root, 3));
        
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(6);
        root2.left.left = new TreeNode(2);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(7);
        System.out.println(DeleteNodeInBST.solutionGeneral(root2, 3));
    }

}
