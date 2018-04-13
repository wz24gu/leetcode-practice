package edu.wz.cs.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

import edu.wz.cs.leetcode.model.TreeLinkNode;

/**
 * 117. Populating Next Right Pointers in Each Node II<br>
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii<br><br>
 * 
 * Follow up for problem "Populating Next Right Pointers in Each Node".<br>
 * What if the given tree could be any binary tree? Would your previous solution still work?<br>
 * 
 * Note: You may only use constant extra space.
 */
public class PopulatingNextRightPointersInEachNodeII {

    public static void solution(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeLinkNode node = queue.poll();
                if (i < size - 1) {
                    node.next = queue.peek();
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
    
    public static void solutionX(TreeLinkNode root) {
        TreeLinkNode dummy = new TreeLinkNode(-1);
        TreeLinkNode prev = dummy;
        
        while (root != null) {
            if (root.left != null) {
                prev.next = root.left;
                prev = prev.next;
            }
            if (root.right != null) {
                prev.next = root.right;
                prev = prev.next;
            }
            
            root = root.next;
            if (root == null) {
                prev = dummy;
                root = dummy.next;
                dummy.next = null;
            }
        }
    }
    
    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        root.left.left = new TreeLinkNode(4);
        root.left.right = new TreeLinkNode(5);
        root.right.right = new TreeLinkNode(7);        
        PopulatingNextRightPointersInEachNodeII.solution(root);
        System.out.println(root);
        
        TreeLinkNode root2 = new TreeLinkNode(1);
        root2.left = new TreeLinkNode(2);
        root2.right = new TreeLinkNode(3);
        root2.left.left = new TreeLinkNode(4);
        root2.left.right = new TreeLinkNode(5);
        root2.right.right = new TreeLinkNode(7);        
        PopulatingNextRightPointersInEachNodeII.solutionX(root2);
        System.out.println(root2);
    }
    
}
