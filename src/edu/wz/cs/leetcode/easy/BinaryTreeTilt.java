package edu.wz.cs.leetcode.easy;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 563. Binary Tree Tilt<br>
 * https://leetcode.com/problems/binary-tree-tilt<br>
 * 
 * Given a binary tree, return the tilt of the whole tree. The tilt of a tree node is defined as the absolute difference
 * between the sum of all left subtree node values and the sum of all right subtree node values. Null node has tilt 0.
 * The tilt of the whole tree is defined as the sum of all nodes' tilt.<br><br>
 * 
 * Note:<br>
 * 1. The sum of node values in any subtree won't exceed the range of 32-bit integer.<br>
 * 2. All the tilt values won't exceed the range of 32-bit integer.
 */
public class BinaryTreeTilt {
    
    /**
     * binary tree traversal orders:
     * inorder: left root right
     * preorder: root left right
     * postorder: left right root
     */
    
    private static int result;
    
    public static int solution(TreeNode root) {
        result = 0;
        int sum = postorder(root);
        System.out.println("sum of all values in the tree: " + sum);
        return result;
    }
    
    private static int postorder(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int left = postorder(node.left);
        int right = postorder(node.right);
        result += Math.abs(left - right);
        return left + right + node.val;
    }
    
    public static int solutionAlt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = solutionAlt(root.left);
        int right = solutionAlt(root.right);
        return left + right + Math.abs(sum(root.left) - sum(root.right));
    }
    
    private static int sum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = sum(node.left);
        int right = sum(node.right);
        return left + right + node.val;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(BinaryTreeTilt.solution(root));
        System.out.println(BinaryTreeTilt.solutionAlt(root));
    }

}
