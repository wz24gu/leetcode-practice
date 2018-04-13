package edu.wz.cs.leetcode.model;

import java.util.LinkedList;
import java.util.Queue;

public class TreeLinkNode {
    
    public int val;
    public TreeLinkNode left;
    public TreeLinkNode right;
    public TreeLinkNode next;
    
    public TreeLinkNode(int val) {
        this.val = val;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(this);
        while (!queue.isEmpty()) {
            TreeLinkNode node = queue.poll();
            sb.append(node.val);
            sb.append("(->");
            if (node.next != null) {
                sb.append(node.next.val).append(") ");
            }
            else {
                sb.append("NULL) ");
            }
            
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return sb.toString();
    }

}
