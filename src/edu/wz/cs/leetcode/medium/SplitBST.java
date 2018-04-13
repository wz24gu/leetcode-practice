package edu.wz.cs.leetcode.medium;

import java.util.Arrays;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 776. Split BST<br>
 * https://leetcode.com/problems/split-bst<br><br>
 * 
 * Given a Binary Search Tree (BST) with root node root, and a target value V, split the tree into two subtrees where 
 * one subtree has nodes that are all smaller or equal to the target value, while the other subtree has all nodes that 
 * are greater than the target value.  It's not necessarily the case that the tree contains a node with value V.<br>
 * 
 * Additionally, most of the structure of the original tree should remain.  Formally, for any child C with parent P in 
 * the original tree, if they are both in the same subtree after the split, then node C should still have the parent P.<br>
 * 
 * You should output the root TreeNode of both subtrees after splitting, in any order.<br><br>
 * 
 * Note:<br>
 * 1. The size of the BST will not exceed 50.<br>
 * 2. The BST is always valid and each node's value is different.
 */
public class SplitBST {
    
    public static TreeNode[] solution(TreeNode root, int V) {
        TreeNode dummySmall = new TreeNode(-1);
        TreeNode small = dummySmall;
        TreeNode dummyLarge = new TreeNode(-1);
        TreeNode large = dummyLarge;
        
        while (root != null) {
            if (root.val <= V) {
                small.right = root;
                small = root;
                root = root.right;
                small.right = null;
            }
            else {
                large.left = root;
                large = root;
                root = root.left;
                large.left = null;
            }
        }
        
        return new TreeNode[] {dummySmall.right, dummyLarge.left};
    }
    
    public static TreeNode[] solutionAlt(TreeNode root, int V) {
        TreeNode small = new TreeNode(-1);
        TreeNode large = new TreeNode(-1);
        helper(root, V, small, large);
        return new TreeNode[] {small.right, large.left};
    }
    
    private static void helper(TreeNode node, int V, TreeNode small, TreeNode large) {
        if (node == null) {
            return;
        }
        if (node.val <= V) {
            small.right = node;
            TreeNode right = node.right;
            node.right = null;
            helper(right, V, node, large);
        }
        else {
            large.left = node;
            TreeNode left = node.left;
            node.left = null;
            helper(left, V, small, node);
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        System.out.println(Arrays.toString(SplitBST.solution(root, 2)));
        
        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(6);
        root2.left.left = new TreeNode(1);
        root2.left.right = new TreeNode(3);
        root2.right.left = new TreeNode(5);
        root2.right.right = new TreeNode(7);
        System.out.println(Arrays.toString(SplitBST.solutionAlt(root2, 2)));
    }

}
