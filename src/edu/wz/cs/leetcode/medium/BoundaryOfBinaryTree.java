package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 545. Boundary of Binary Tree<br>
 * https://leetcode.com/problems/boundary-of-binary-tree<br><br>
 * 
 * Given a binary tree, return the values of its boundary in anti-clockwise direction starting from root. Boundary 
 * includes left boundary, leaves, and right boundary in order without duplicate nodes.<br>
 * 
 * Left boundary is defined as the path from root to the left-most node. Right boundary is defined as the path from root 
 * to the right-most node. If the root doesn't have left subtree or right subtree, then the root itself is left boundary 
 * or right boundary. Note this definition only applies to the input binary tree, and not applies to any subtrees.<br>
 * 
 * The left-most node is defined as a leaf node you could reach when you always firstly travel to the left subtree if 
 * exists. If not, travel to the right subtree. Repeat until you reach a leaf node.<br>
 * 
 * The right-most node is also defined by the same way with left and right exchanged.
 */
public class BoundaryOfBinaryTree {
    
    public static List<Integer> solution(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        if (root.left != null || root.right != null) {
            res.add(root.val);
        }
        
        left(root.left, res);
        leaves(root, res);
        right(root.right, res);
        
        return res;
    }
    
    private static void left(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            return;
        }
        
        res.add(node.val);
        if (node.left != null) {
            left(node.left, res);
        }
        else {
            left(node.right, res);
        }
    }
    
    private static void right(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            return;
        }
        
        if (node.right != null) {
            right(node.right, res);
        }
        else {
            right(node.left, res);
        }
        res.add(node.val);
    }
    
    private static void leaves(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        
        if (node.left == null && node.right == null) {
            res.add(node.val);
        }
        leaves(node.left, res);
        leaves(node.right, res);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        System.out.println(BoundaryOfBinaryTree.solution(root));
        
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);
        root2.left.right.left = new TreeNode(7);
        root2.left.right.right = new TreeNode(8);
        root2.right = new TreeNode(3);
        root2.right.left = new TreeNode(6);
        root2.right.left.left = new TreeNode(9);
        root2.right.left.right = new TreeNode(10);        
        System.out.println(BoundaryOfBinaryTree.solution(root2));
    }

}
