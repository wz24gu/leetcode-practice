package edu.wz.cs.leetcode.easy;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 538. Convert BST to Greater Tree<br>
 * https://leetcode.com/problems/convert-bst-to-greater-tree<br><br>
 * 
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to
 * the original key plus sum of all keys greater than the original key in BST.
 */
public class ConvertBSTToGreaterTree {

    private static int sum;
    
    public static TreeNode solution(TreeNode root) {
        sum = 0;
        postorder(root);
        return root;
    }
    
    private static void postorder(TreeNode node) {
        if (node == null) {
            return;
        }
        
        postorder(node.right);
        node.val += sum;
        sum = node.val;
        postorder(node.left);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);
        System.out.println(ConvertBSTToGreaterTree.solution(root));
    }

}
