package edu.wz.cs.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

import edu.wz.cs.leetcode.model.TreeLinkNode;

/**
 * 116. Populating Next Right Pointers in Each Node<br>
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node<br><br>
 * 
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should 
 * be set to NULL.<br>
 * 
 * Initially, all next pointers are set to NULL.<br><br>
 * 
 * Note:<br>
 * 1. You may only use constant extra space.<br>
 * 2. You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 */
public class PopulatingNextRightPointersInEachNode {
    
    public static void solution(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        
        if (root.left != null) {
            root.left.next = root.right;
        }
        if (root.right != null) {
            root.right.next = (root.next == null) ? null : root.next.left;
        }
        
        solution(root.left);
        solution(root.right);
    }
    
    public static void solutionAlt(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeLinkNode node = queue.poll();
                if (i != size) {
                    node.next = queue.peek();
                }
                else {
                    node.next = null;
                }
                
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        root.left.left = new TreeLinkNode(4);
        root.left.right = new TreeLinkNode(5);
        root.right.left = new TreeLinkNode(6);
        root.right.right = new TreeLinkNode(7);
        PopulatingNextRightPointersInEachNode.solution(root);
        System.out.println(root);
        
        TreeLinkNode root2 = new TreeLinkNode(1);
        root2.left = new TreeLinkNode(2);
        root2.right = new TreeLinkNode(3);
        root2.left.left = new TreeLinkNode(4);
        root2.left.right = new TreeLinkNode(5);
        root2.right.left = new TreeLinkNode(6);
        root2.right.right = new TreeLinkNode(7);
        PopulatingNextRightPointersInEachNode.solutionAlt(root2);
        System.out.println(root2);
    }

}
