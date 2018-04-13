package edu.wz.cs.leetcode.medium;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal<br>
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal<br><br>
 * 
 * Given preorder and inorder traversal of a tree, construct the binary tree.<br>
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    
    public static TreeNode solution(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    private static TreeNode build(int[] preorder, int pLeft, int pRight, int[] inorder, int iLeft, int iRight) {
        if (pLeft > pRight || iLeft > iRight) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[pLeft]);
        int i = 0;
        for (i = iLeft; i <= iRight; i++) {
            if (inorder[i] == preorder[pLeft]) {
                break;
            }
        }
        
        root.left = build(preorder, pLeft + 1, pLeft + i - iLeft, inorder, iLeft, i - 1);
        root.right = build(preorder, pLeft + 1 + i - iLeft, pRight, inorder, i + 1, iRight);
        return root;
    }
    
    public static void main(String[] args) {
        int[] preorder = {5, 4, 11, 8, 13, 9};
        int[] inorder = {11, 4, 5, 13, 8, 9};
        System.out.println(ConstructBinaryTreeFromPreorderAndInorderTraversal.solution(preorder, inorder));
    }

}
