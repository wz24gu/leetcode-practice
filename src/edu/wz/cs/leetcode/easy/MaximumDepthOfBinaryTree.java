package edu.wz.cs.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 104. Maximum Depth of Binary Tree<br>
 * https://leetcode.com/problems/maximum-depth-of-binary-tree<br><br>
 * 
 * Given a binary tree, find its maximum depth. The maximum depth is the number of nodes along the longest path from
 * the root node down to the farthest leaf node.
 */
public class MaximumDepthOfBinaryTree {
    
    public static int solution(TreeNode root) {
        if (root == null) {
            return 0;
        }        
        return 1 + Math.max(solution(root.left), solution(root.right));
    }
    
    public static int solutionAlt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int max = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            max++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        
        return max;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        
        System.out.println(MaximumDepthOfBinaryTree.solution(root));
        System.out.println(MaximumDepthOfBinaryTree.solutionAlt(root));
    }
}
