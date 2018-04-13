package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 102. Binary Tree Level Order Traversal<br>
 * https://leetcode.com/problems/binary-tree-level-order-traversal<br><br>
 * 
 * Given a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 */
public class BinaryTreeLevelOrderTraversal {
    
    public static List<List<Integer>> solution(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(list);
        }
        
        return result;
    }
    
    public static List<List<Integer>> solutionAlt(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, 0, result);
        return result;
    }
    
    private static void helper(TreeNode node, int level, List<List<Integer>> result) {
        if (node == null) {
            return;
        }
        
        if (level == result.size()) {
            result.add(new ArrayList<Integer>());
        }
        result.get(level).add(node.val);
        
        if (node.left != null) {
            helper(node.left, level + 1, result);
        }
        if (node.right != null) {
            helper(node.right, level + 1, result);
        }        
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(BinaryTreeLevelOrderTraversal.solution(root));
        System.out.println(BinaryTreeLevelOrderTraversal.solutionAlt(root));        
    }

}
