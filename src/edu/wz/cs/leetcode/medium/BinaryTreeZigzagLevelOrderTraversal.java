package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 103. Binary Tree Zigzag Level Order Traversal<br>
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal<br><br>
 * 
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then 
 * right to left for the next level and alternate between).
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    
    public static List<List<Integer>> solution(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        List<Integer> list = new ArrayList<>();
        
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            while (!stack1.isEmpty()) {                
                TreeNode node = stack1.pop();
                list.add(node.val);
                
                if (node.left != null) {
                    stack2.push(node.left);
                }
                if (node.right != null) {
                    stack2.push(node.right);
                }   
            }
            if (!list.isEmpty()) {
                result.add(new ArrayList<Integer>(list));
                list.clear();
            }
            
            while (!stack2.isEmpty()) {
                TreeNode node = stack2.pop();
                list.add(node.val);
                
                if (node.right != null) {
                    stack1.push(node.right);
                }
                if (node.left != null) {
                    stack1.push(node.left);
                }
            }
            if (!list.isEmpty()) {
                result.add(new ArrayList<Integer>(list));
                list.clear();
            }
        }
        
        return result;
    }
    
    public static List<List<Integer>> solutionX(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int d = 0;
        
        while (!queue.isEmpty()) {            
            int size = queue.size();
            List<Integer> list = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (d == 0) {
                    list.add(node.val);
                }
                else {
                    list.add(0, node.val);
                }
                
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(list);
            d = 1 - d;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(BinaryTreeZigzagLevelOrderTraversal.solution(root));
        System.out.println(BinaryTreeZigzagLevelOrderTraversal.solutionX(root));
    }

}
