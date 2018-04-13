package edu.wz.cs.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 742. Closest Leaf in a Binary Tree<br>
 * https://leetcode.com/problems/closest-leaf-in-a-binary-tree<br><br>
 * 
 * Given a binary tree where every node has a unique value, and a target key k, find the value of the nearest leaf node 
 * to target k in the tree.<br>
 * 
 * Here, nearest to a leaf means the least number of edges travelled on the binary tree to reach any leaf of the tree. 
 * Also, a node is called a leaf if it has no children.<br><br>
 * 
 * Note:<br>
 * 1. root represents a binary tree with at least 1 node and at most 1000 nodes.<br>
 * 2. Every node has a unique node.val in range [1, 1000].<br>
 * 3. There exists some node in the given binary tree for which node.val == k.
 */
public class ClosestLeafInBinaryTree {
    
    public static int solution(TreeNode root, int k) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        TreeNode K = find(root, k, map);
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(K);
        Set<TreeNode> set = new HashSet<>();
        set.add(K);
        
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            if (tmp.left == null && tmp.right == null) {
                return tmp.val;
            }
            
            if (tmp.left != null && !set.contains(tmp.left)) {
                queue.offer(tmp.left);
                set.add(tmp.left);
            }
            if (tmp.right != null && !set.contains(tmp.right)) {
                queue.offer(tmp.right);
                set.add(tmp.right);
            }
            if (map.containsKey(tmp) && !set.contains(map.get(tmp))) {
                queue.offer(map.get(tmp));
                set.add(map.get(tmp));
            }
        }
        
        return -1;
    }
    
    private static TreeNode find(TreeNode node, int k, Map<TreeNode, TreeNode> map) {
        if (node.val == k) {
            return node;
        }
        
        if (node.left != null) {
            map.put(node.left, node);
            TreeNode left = find(node.left, k, map);
            if (left != null) {
                return left;
            }
        }
        if (node.right != null) {
            map.put(node.right, node);
            TreeNode right = find(node.right, k, map);
            if (right != null) {
                return right;
            }
        }
        
        return null;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        System.out.println(ClosestLeafInBinaryTree.solution(root, 1));
        
        TreeNode root2 = new TreeNode(1);        
        System.out.println(ClosestLeafInBinaryTree.solution(root2, 1));
        
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(3);
        root3.left.left = new TreeNode(4);
        root3.left.left.left = new TreeNode(5);
        root3.left.left.left.left = new TreeNode(6);
        System.out.println(ClosestLeafInBinaryTree.solution(root3, 2));
    }

}
