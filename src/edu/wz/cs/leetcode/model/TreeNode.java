package edu.wz.cs.leetcode.model;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    
    public int val;
    public TreeNode left;
    public TreeNode right;
    
    public TreeNode(int val) {
        this.val = val;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(this);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            sb.append(node.val + " ");
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }        
        return sb.substring(0, sb.length() - 1);
    }

}
