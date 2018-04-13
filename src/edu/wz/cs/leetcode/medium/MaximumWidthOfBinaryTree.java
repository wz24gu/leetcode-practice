package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 662. Maximum Width of Binary Tree<br>
 * https://leetcode.com/problems/maximum-width-of-binary-tree<br><br>
 * 
 * Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum 
 * width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.<br>
 * 
 * The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in 
 * the level, where the null nodes between the end-nodes are also counted into the length calculation.<br>
 * 
 * Note: Answer will in the range of 32-bit signed integer.
 */
public class MaximumWidthOfBinaryTree {
    
    public static int solution(TreeNode root) {
        List<Integer> start = new ArrayList<>();
        List<Integer> end = new ArrayList<>();
        
        return dfs(root, 0, 1, start, end);
    }
    
    private static int dfs(TreeNode node, int level, int pos, List<Integer> start, List<Integer> end) {
        if (node == null) {
            return 0;
        }
        
        if (start.size() == level) {  // start a new level
            start.add(pos);
            end.add(pos);
        }
        else {
            end.set(level, pos);
        }
        
        int cur = end.get(level) - start.get(level) + 1;
        int left = dfs(node.left, level + 1, pos * 2, start, end);
        int right = dfs(node.right, level + 1, pos * 2 + 1, start, end);
        return Math.max(cur, Math.max(left, right));
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        System.out.println(MaximumWidthOfBinaryTree.solution(root));
        
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(3);        
        root2.left.left = new TreeNode(5);
        root2.left.right = new TreeNode(3);
        System.out.println(MaximumWidthOfBinaryTree.solution(root2));
        
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(3);
        root3.right = new TreeNode(2);
        root3.left.left = new TreeNode(5);
        System.out.println(MaximumWidthOfBinaryTree.solution(root3));
        
        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(3);
        root4.right = new TreeNode(2);
        root4.left.left = new TreeNode(5);
        root4.right.right = new TreeNode(9);
        root4.left.left.left = new TreeNode(6);
        root4.right.right.right = new TreeNode(7);
        System.out.println(MaximumWidthOfBinaryTree.solution(root4));
    }

}
