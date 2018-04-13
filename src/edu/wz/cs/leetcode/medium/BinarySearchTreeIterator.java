package edu.wz.cs.leetcode.medium;

import java.util.Stack;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 173. Binary Search Tree Iterator<br>
 * https://leetcode.com/problems/binary-search-tree-iterator<br><br>
 * 
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.<br>
 * 
 * Calling next() will return the next smallest number in the BST.<br>
 * 
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 */
public class BinarySearchTreeIterator {
    
    private static Stack<TreeNode> stack;
    
    public BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        int result = node.val;        
        
        node = node.right;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        
        BinarySearchTreeIterator binarySearchTreeIterator = new BinarySearchTreeIterator(root);
        System.out.println(binarySearchTreeIterator.hasNext());
        System.out.println(binarySearchTreeIterator.next());
        System.out.println(binarySearchTreeIterator.next());
    }

}
