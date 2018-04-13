package edu.wz.cs.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 671. Second Minimum Node In a Binary Tree<br>
 * https://leetcode.com/problems/second-minimum-node-in-a-binary-tree<br><br>
 * 
 * Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree 
 * has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among 
 * its two sub-nodes.<br>
 * 
 * Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the 
 * whole tree. If no such second minimum value exists, output -1 instead.<br>
 */
public class SecondMinimumNodeInBinaryTree {

    private static int first;
    private static int second;
    
    public static int solution(TreeNode root) {
        first = root.val;  // this is a non-empty tree, root.val is the smallest
        second = Integer.MAX_VALUE;
        
        helper(root);        
        if (second != first && second != Integer.MAX_VALUE) {
            return second;
        }
        else {
            return -1;
        }        
    }
    
    private static void helper(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.val != first && node.val < second) {
            second = node.val;
        }
        helper(node.left);
        helper(node.right);
    }
    
    public static int solutionAlt(TreeNode root) {
        int min = root.val;
        int min2 = Integer.MAX_VALUE;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val > min && node.val < min2) {
                min2 = node.val;
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        
        return min2 == Integer.MAX_VALUE ? -1 : min2;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        System.out.println(SecondMinimumNodeInBinaryTree.solution(root));
        System.out.println(SecondMinimumNodeInBinaryTree.solutionAlt(root));
        
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        System.out.println(SecondMinimumNodeInBinaryTree.solution(root1));
        System.out.println(SecondMinimumNodeInBinaryTree.solutionAlt(root1));
    }
    
}
