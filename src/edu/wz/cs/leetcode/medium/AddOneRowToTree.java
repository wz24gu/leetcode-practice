package edu.wz.cs.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 623. Add One Row to Tree<br>
 * https://leetcode.com/problems/add-one-row-to-tree<br><br>
 * 
 * Given the root of a binary tree, then value v and depth d, you need to add a row of nodes with value v at the given 
 * depth d. The root node is at depth 1.<br>
 * 
 * The adding rule is: given a positive integer depth d, for each NOT null tree nodes N in depth d-1, create two tree 
 * nodes with value v as N's left subtree root and right subtree root. And N's original left subtree should be the left 
 * subtree of the new left subtree root, its original right subtree should be the right subtree of the new right 
 * subtree root. If depth d is 1 that means there is no depth d-1 at all, then create a tree node with value v as the 
 * new root of the whole original tree, and the original tree is the new root's left subtree.<br><br>
 * 
 * Note:<br>
 * 1. The given d is in range [1, maximum depth of the given tree + 1].<br>
 * 2. The given binary tree has at least one tree node.
 */
public class AddOneRowToTree {
    
    public static TreeNode solution(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        
        int level = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            level++;            
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (d == level) {                    
                    TreeNode newLeft = new TreeNode(v);
                    newLeft.left = node.left;
                    node.left = newLeft;
                    TreeNode newRight = new TreeNode(v);
                    newRight.right = node.right;
                    node.right = newRight;
                }
                else {
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }            
        }
        
        return root;
    }
    
    public static TreeNode solutionX(TreeNode root, int v, int d) {
        if (d == 0 || d == 1) {
            TreeNode newRoot = new TreeNode(v);
            if (d == 0) {
                newRoot.left = root;
            }
            else {
                newRoot.right = root;
            }
            return newRoot;
        }
        
        if (root != null && d > 1) {
            root.left = solutionX(root.left, v, d > 2 ? d - 1 : 1);
            root.right = solutionX(root.right, v, d > 2 ? d - 1 : 0);
        }
        
        return root;
    }
    
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(5);
        System.out.println(AddOneRowToTree.solution(root, 1, 2));
        
        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(1);
        System.out.println(AddOneRowToTree.solution(root2, 1, 3));
        
        TreeNode root3 = new TreeNode(4);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(6);
        root3.left.left = new TreeNode(3);
        root3.left.right = new TreeNode(1);
        root3.right.left = new TreeNode(5);
        System.out.println(AddOneRowToTree.solutionX(root3, 1, 2));
        
        TreeNode root4 = new TreeNode(4);
        root4.left = new TreeNode(2);
        root4.left.left = new TreeNode(3);
        root4.left.right = new TreeNode(1);
        System.out.println(AddOneRowToTree.solutionX(root4, 1, 3));
    }

}
