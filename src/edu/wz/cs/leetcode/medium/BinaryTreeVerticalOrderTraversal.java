package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 314. Binary Tree Vertical Order Traversal<br>
 * https://leetcode.com/problems/binary-tree-vertical-order-traversal<br><br>
 * 
 * Given a binary tree, return the vertical order traversal of its nodes' values. (i.e., from top to bottom, column by column).<br>
 * 
 * If two nodes are in the same row and column, the order should be from left to right.
 */
public class BinaryTreeVerticalOrderTraversal {
    
    private static class Pair {
        public int index;
        public TreeNode node;
        public Pair(int index, TreeNode node) {
            this.index = index;
            this.node = node;
        }
    }
    
    public static List<List<Integer>> solution(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, root));
        int min = 0;
        
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            if (!map.containsKey(p.index)) {
                map.put(p.index, new ArrayList<Integer>());
            }
            map.get(p.index).add(p.node.val);
            min = Math.min(min, p.index);
            
            if (p.node.left != null) {
                queue.offer(new Pair(p.index - 1, p.node.left));
            }
            if (p.node.right != null) {
                queue.offer(new Pair(p.index + 1, p.node.right));
            }
        }
        
        while (map.containsKey(min)) {
            result.add(map.get(min++));
        }
        return result;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(BinaryTreeVerticalOrderTraversal.solution(root));
        
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(8);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(0);
        root2.right.left = new TreeNode(1);
        root2.right.right = new TreeNode(7);
        System.out.println(BinaryTreeVerticalOrderTraversal.solution(root2));
        
        TreeNode root3 = new TreeNode(3);
        root3.left = new TreeNode(9);
        root3.right = new TreeNode(8);
        root3.left.left = new TreeNode(4);
        root3.left.right = new TreeNode(0);
        root3.right.left = new TreeNode(1);
        root3.right.right = new TreeNode(7);
        root3.left.right.right = new TreeNode(2);
        root3.right.left.left = new TreeNode(5);
        System.out.println(BinaryTreeVerticalOrderTraversal.solution(root3));
    }

}
