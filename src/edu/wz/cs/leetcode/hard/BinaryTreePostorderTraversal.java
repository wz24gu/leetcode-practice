package edu.wz.cs.leetcode.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 145. Binary Tree Postorder Traversal<br/>
 * https://leetcode.com/problems/binary-tree-postorder-traversal<br/><br/>
 * 
 * Given a binary tree, return the postorder traversal of its nodes' values.<br/>
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreePostorderTraversal {

    public static List<Integer> solution(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }
    
    // postorder: left right root
    private static void postorder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        
        postorder(node.left, list);
        postorder(node.right, list);
        list.add(node.val);
    }
    
    public static List<Integer> solutionAlt(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode visited = root;
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node.left == null && node.right == null
                    || node.left == visited
                    || node.right == visited) {
                result.add(node.val);
                stack.pop();
                visited = node;
            }
            else {
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
        }
        
        return result;
    }
    
    public static List<Integer> solutionX(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        // here the sequence is left -> right, stack will process as right - left, insert at the beginning of the list
        // the final sequence is left -> right -> root
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(0, node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(BinaryTreePostorderTraversal.solution(root));
        System.out.println(BinaryTreePostorderTraversal.solutionAlt(root));
        System.out.println(BinaryTreePostorderTraversal.solutionX(root));
    }

}
