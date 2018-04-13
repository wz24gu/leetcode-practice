package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 366. Find Leaves of Binary Tree<br>
 * https://leetcode.com/problems/find-leaves-of-binary-tree<br><br>
 * 
 * Given a binary tree, find all leaves and then remove those leaves. Then repeat the previous steps until the tree is
 * empty.
 */
public class FindLeavesOfBinaryTree {
    
    public static List<List<Integer>> solution(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        while (root != null) {
            List<Integer> list = new ArrayList<>();
            root = helper(root, list);
            result.add(list);
        }
        return result;
    }
    
    private static TreeNode helper(TreeNode node, List<Integer> list) {
        if (node == null) {
            return null;
        }
        if (node.left == null && node.right == null) {
            list.add(node.val);
            return null;
        }
        
        node.left = helper(node.left, list);
        node.right = helper(node.right, list);
        return node;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(FindLeavesOfBinaryTree.solution(root));
    }

}
