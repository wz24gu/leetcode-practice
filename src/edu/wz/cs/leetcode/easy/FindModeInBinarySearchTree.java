package edu.wz.cs.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 501. Find Mode in Binary Search Tree<br>
 * https://leetcode.com/problems/find-mode-in-binary-search-tree<br><br>
 * 
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the 
 * given BST.<br>
 * 
 * Assume a BST is defined as follows:<br>
 * 1. The left subtree of a node contains only nodes with keys less than or equal to the node's key.<br>
 * 2. The right subtree of a node contains only nodes with keys greater than or equal to the node's key.<br>
 * 3. Both the left and right subtrees must also be binary search trees.<br>
 * 
 * Note: If a tree has more than one mode, you can return them in any order.<br>
 * 
 * Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to 
 * recursion does not count).
 */
public class FindModeInBinarySearchTree {

    private static int max;
    
    public static int[] solution(TreeNode root) {
        max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        helper(root, map);
        
        List<Integer> list = new ArrayList<>();
        for (int i : map.keySet()) {
            if (map.get(i) == max) {
                list.add(i);
            }
        }
        
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
    
    private static void helper(TreeNode node, Map<Integer, Integer> map) {
        if (node == null) {
            return;
        }
        
        helper(node.left, map);
        map.put(node.val, map.getOrDefault(node.val, 0) + 1);
        max = Math.max(max, map.get(node.val));
        helper(node.right, map);
    }
    
    public static int[] solutionAlt(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            map.put(node.val, map.getOrDefault(node.val, 0) + 1);
            max = Math.max(max, map.get(node.val));
            
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }            
        }
        
        List<Integer> list = new ArrayList<>();
        for (int val : map.keySet()) {
            if (map.get(val) == max) {
                list.add(val);
            }
        }
        
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;        
    }
    
    private static TreeNode prev;
    private static int count;
    
    public static int[] solutionX(TreeNode root) {
        max = 0;
        count = 1;
        prev = null;
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
    
    private static void inorder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        
        inorder(node.left, list);
        
        if (prev != null) {
            count = (prev.val == node.val) ? count + 1 : 1;
        }
        if (count >= max) {
            if (count > max) {
                list.clear();
            }
            list.add(node.val);
            max = count;
        }
        prev = node;
        
        inorder(node.right, list);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        System.out.println(Arrays.toString(FindModeInBinarySearchTree.solution(root)));
        System.out.println(Arrays.toString(FindModeInBinarySearchTree.solutionAlt(root)));
        System.out.println(Arrays.toString(FindModeInBinarySearchTree.solutionX(root)));
    }

}
