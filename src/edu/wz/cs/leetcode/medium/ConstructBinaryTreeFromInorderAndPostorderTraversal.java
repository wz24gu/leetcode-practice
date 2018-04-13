package edu.wz.cs.leetcode.medium;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal<br>
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal<br><br>
 * 
 * Given inorder and postorder traversal of a tree, construct the binary tree.<br>
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    
    public static TreeNode solution(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    private static TreeNode build(int[] inorder, int iLeft, int iRight, int[] postorder, int pLeft, int pRight) {
        if (iLeft > iRight || pLeft > pRight) {
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[pRight]);
        int i;
        for (i = iLeft; i <= iRight; i++) {
            if (inorder[i] == root.val) {
                break;
            }
        }
        
        root.left = build(inorder, iLeft, i - 1, postorder, pLeft, pLeft + i - iLeft - 1);
        root.right = build(inorder, i + 1, iRight, postorder, pLeft + i - iLeft, pRight - 1);        
        return root;
    }
    
    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        System.out.println(ConstructBinaryTreeFromInorderAndPostorderTraversal.solution(inorder, postorder));
    }

}
