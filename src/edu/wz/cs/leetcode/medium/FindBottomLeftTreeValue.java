package edu.wz.cs.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 513. Find Bottom Left Tree Value<br>
 * https://leetcode.com/problems/find-bottom-left-tree-value<br><br>
 * 
 * Give a binary tree, find the leftmost value in the last row of the tree.<br>
 * 
 * Note: You may assume the tree (i.e., the given root node) is NOT null.
 */
public class FindBottomLeftTreeValue {

    public static int solution(TreeNode root) {
        int result = root.val;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) {
                    result = node.val;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(FindBottomLeftTreeValue.solution(root));
        
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.right.left = new TreeNode(5);
        root2.right.right = new TreeNode(6);
        root2.right.left.left = new TreeNode(7);
        System.out.println(FindBottomLeftTreeValue.solution(root2));
    }

}
