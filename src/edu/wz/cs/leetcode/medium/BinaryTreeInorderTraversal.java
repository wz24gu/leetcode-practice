package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 94. Binary Tree Inorder Traversal<br>
 * https://leetcode.com/problems/binary-tree-inorder-traversal<br><br>
 * 
 * Given a binary tree, return the inorder traversal of its nodes' values.<br>
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreeInorderTraversal {
    
    public static List<Integer> solution(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        inorder(root, result);
        return result;
    }
    
    private static void inorder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        
        inorder(node.left, result);
        result.add(node.val);
        inorder(node.right, result);
    }
    
    public static List<Integer> solutionAlt(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            
            if (!stack.isEmpty()) {
                curr = stack.pop();
                result.add(curr.val);
                curr = curr.right;
            }
        }
        
        return result;
    }
    
    // Morris traversal
    public static List<Integer> solutionX(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        TreeNode prev, curr;
        curr = root;
        while (curr != null) {
            if (curr.left == null) {
                result.add(curr.val);
                curr = curr.right;
            }
            else {
                prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                }
                else {
                    prev.right = null;
                    result.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(BinaryTreeInorderTraversal.solution(root));
        System.out.println(BinaryTreeInorderTraversal.solutionAlt(root));
        System.out.println(BinaryTreeInorderTraversal.solutionX(root));
    }

}
