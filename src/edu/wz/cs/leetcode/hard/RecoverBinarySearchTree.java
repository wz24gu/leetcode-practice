package edu.wz.cs.leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 99. Recover Binary Search Tree<br>
 * https://leetcode.com/problems/recover-binary-search-tree<br><br>
 * 
 * Two elements of a binary search tree (BST) are swapped by mistake.<br>
 * 
 * Recover the tree without changing its structure.<br>
 * 
 * Note: A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 */
public class RecoverBinarySearchTree {
    
    public static void solution(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        List<Integer> vals = new ArrayList<>();
        inorder(root, nodes, vals);
        
        Collections.sort(vals);
        
        int n = nodes.size();
        for (int i = 0; i < n; i++) {
            nodes.get(i).val = vals.get(i);  // reset the value
        }
    }
    
    private static void inorder(TreeNode node, List<TreeNode> nodes, List<Integer> vals) {
        if (node == null) {
            return;
        }
        
        inorder(node.left, nodes, vals);
        nodes.add(node);
        vals.add(node.val);
        inorder(node.right, nodes, vals);
    }
    
    // Morris traversal
    public static void solutionX(TreeNode root) {
        TreeNode first = null;
        TreeNode second = null;
        TreeNode parent = null;
        TreeNode prev = null;
        TreeNode curr = root;
        
        while (curr != null) {
            if (curr.left == null) {
                if (parent != null && parent.val > curr.val) {
                    if (first == null) {
                        first = parent;
                    }
                    second = curr;
                }
                parent = curr;
                curr = curr.right;
            }
            else {
                prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                }
                else {
                    prev.right = null;
                    if (parent.val > curr.val) {
                        if (first == null) {
                            first = parent;
                        }
                        second = curr;
                    }
                    parent = curr;
                    curr = curr.right;
                }
            }
        }
        
        if (first != null && second != null) {
            int swap = first.val;
            first.val = second.val;
            second.val = swap;
        }
    }

}
