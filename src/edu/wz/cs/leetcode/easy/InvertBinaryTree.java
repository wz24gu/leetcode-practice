package edu.wz.cs.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 226. Invert Binary Tree<br>
 * https://leetcode.com/problems/invert-binary-tree<br><br>
 * 
 * Invert a binary tree.
 */
public class InvertBinaryTree {

    public static TreeNode solution(TreeNode root) {
        if (root == null) {
            return root;
        }
        
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        solution(root.left);
        solution(root.right);
        return root;
    }
    
    public static TreeNode solutionAlt(TreeNode root) {
        if (root == null) {
            return root;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        System.out.println(root);
        System.out.println(InvertBinaryTree.solution(root));
        
        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(7);
        root2.left.left = new TreeNode(1);
        root2.left.right = new TreeNode(3);
        root2.right.left = new TreeNode(6);
        root2.right.right = new TreeNode(9);
        System.out.println(root2);
        System.out.println(InvertBinaryTree.solutionAlt(root2));
    }
    
}
