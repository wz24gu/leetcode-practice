package edu.wz.cs.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 100. Same Tree<br>
 * https://leetcode.com/problems/same-tree<br><br>
 * 
 * Given two binary trees, write a function to check if they are equal or not. Two binary trees are considered equal if 
 * they are structurally identical and the nodes have the same value.
 */
public class SameTree {
    
    public static boolean solution(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        
        if (p.val != q.val) {
            return false;
        }        
        return solution(p.left, q.left) && solution(p.right, q.right);
    }
    
    public static boolean solutionAlt(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        if (p != null) {
            queue1.offer(p);
        }
        if (q != null) {
            queue2.offer(q);
        }
        
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            if (queue1.size() != queue2.size()) {
                return false;
            }            
            
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            if (node1.val != node2.val) {
                return false;
            }
            
            if (node1.left != null) {
                queue1.offer(node1.left);
            }
            if (node2.left != null) {
                queue2.offer(node2.left);
            }
            if (queue1.size() != queue2.size()) {
                return false;
            }            
            
            if (node1.right != null) {
                queue1.offer(node1.right);
            }            
            if (node2.right != null) {
                queue2.offer(node2.right);
            }
            if (queue1.size() != queue2.size()) {
                return false;
            }            
        }
        
        return queue1.size() == queue2.size();
    }
    
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);
        
        System.out.println(SameTree.solution(p, q));
        System.out.println(SameTree.solutionAlt(p, q));
    }

}
