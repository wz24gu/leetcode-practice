package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 199. Binary Tree Right Side View<br>
 * https://leetcode.com/problems/binary-tree-right-side-view<br><br>
 * 
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see 
 * ordered from top to bottom.
 */
public class BinaryTreeRightSideView {
    
    public static List<Integer> solution(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == size - 1) {
                    result.add(node.val);
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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        System.out.println(BinaryTreeRightSideView.solution(root));
    }

}
