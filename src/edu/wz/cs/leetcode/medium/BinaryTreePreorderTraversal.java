package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 144. Binary Tree Preorder Traversal<br>
 * https://leetcode.com/problems/binary-tree-preorder-traversal<br><br>
 * 
 * Given a binary tree, return the preorder traversal of its nodes' values.<br>
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreePreorderTraversal {
    
    public static List<Integer> solution(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        preorder(root, result);
        return result;
    }
    
    private static void preorder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        preorder(node.left, list);
        preorder(node.right, list);
    }
    
    public static List<Integer> solutionAlt(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        
        return result;   
    }
    
    // template
    public static List<Integer> solutionAlt2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                result.add(curr.val);
                curr = curr.left;
            }
            else {
                curr = stack.pop();
                curr = curr.right;
            }
        }
        
        return result;   
    }
    
    // Morris traversal
    public static List<Integer> solutionAlt3(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                result.add(curr.val);
                curr = curr.right;
            }
            else {
                TreeNode prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                
                if (prev.right == null) {
                    prev.right = curr;
                    result.add(curr.val);
                    curr = curr.left;
                }
                else {
                    prev.right = null;
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
        System.out.println(BinaryTreePreorderTraversal.solution(root));
        System.out.println(BinaryTreePreorderTraversal.solutionAlt(root));
        System.out.println(BinaryTreePreorderTraversal.solutionAlt2(root));
        System.out.println(BinaryTreePreorderTraversal.solutionAlt3(root));
    }

}
