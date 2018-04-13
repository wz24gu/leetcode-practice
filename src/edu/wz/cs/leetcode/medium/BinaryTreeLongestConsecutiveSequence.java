package edu.wz.cs.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 298. Binary Tree Longest Consecutive Sequence<br>
 * https://leetcode.com/problems/binary-tree-longest-consecutive-sequence<br><br>
 * 
 * Given a binary tree, find the length of the longest consecutive sequence path.<br>
 * 
 * The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child 
 * connections. The longest consecutive path need to be from parent to child (cannot be the reverse).
 */
public class BinaryTreeLongestConsecutiveSequence {
    
    private static int result;
    
    public static int solution(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        result = 0;
        preorder(root, root.val, 0);
        return result;
    }
    
    private static void preorder(TreeNode node, int val, int out) {
        if (node == null) {
            return;
        }
        
        out = (node.val == val + 1) ? out + 1 : 1;        
        result = Math.max(result, out);
        
        preorder(node.left, node.val, out);
        preorder(node.right, node.val, out);
    }
    
    // this solution has some problem
    public static int solutionAlt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int len = 1;
            TreeNode node = queue.poll();
            
            while (node.left != null && node.left.val == node.val + 1
                    || node.right != null && node.right.val == node.val + 1) {
                if (node.left != null && node.left.val == node.val + 1) {
                    if (node.right != null) {
                        queue.offer(node.right);
                        node = node.left;
                    }
                }
                else if (node.right != null && node.right.val == node.val + 1) {
                    if (node.left != null) {
                        queue.offer(node.left);
                        node = node.right;
                    }
                }
                len++;
            }
            
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            
            result = Math.max(result, len);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);
        System.out.println(BinaryTreeLongestConsecutiveSequence.solution(root));
        System.out.println(BinaryTreeLongestConsecutiveSequence.solutionAlt(root));
        
        TreeNode root2 = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.right.left = new TreeNode(2);
        root2.right.left.left = new TreeNode(1);
        System.out.println(BinaryTreeLongestConsecutiveSequence.solution(root2));
        System.out.println(BinaryTreeLongestConsecutiveSequence.solutionAlt(root2));
    }

}
