package edu.wz.cs.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 101. Symmetric Tree<br>
 * https://leetcode.com/problems/symmetric-tree<br><br>
 * 
 * Given a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).<br>
 * 
 * Note: Bonus points if you could solve it both recursively and iteratively.
 */
public class SymmetricTree {
    
    public static boolean solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }
    
    private static boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        
        if (left.val != right.val) {
            return false;
        }
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
    
    public static boolean solutionAlt(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(root.left);
        queue2.offer(root.right);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            if (node1 == null && node2 != null || node1 != null && node2 == null) {
                return false;
            }
            if (node1 != null && node2 != null) {
                if (node1.val != node2.val) {
                    return false;
                }
                queue1.offer(node1.left);
                queue1.offer(node1.right);
                queue2.offer(node2.right);
                queue2.offer(node2.left);
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(SymmetricTree.solution(root));
        System.out.println(SymmetricTree.solutionAlt(root));
        
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.right = new TreeNode(3);
        root2.right.right = new TreeNode(3);
        System.out.println(SymmetricTree.solution(root2));
        System.out.println(SymmetricTree.solutionAlt(root2));
    }

}
