package edu.wz.cs.leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 107. Binary Tree Level Order Traversal II<br>
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii<br><br>
 * 
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, 
 * level by level from leaf to root).
 */
public class BinaryTreeLevelOrderTraversalII {
    
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
            result.add(0, list);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(BinaryTreeLevelOrderTraversalII.solution(root));
    }

}
