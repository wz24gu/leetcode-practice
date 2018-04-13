package edu.wz.cs.leetcode.easy;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 606. Construct String from Binary Tree<br>
 * https://leetcode.com/problems/construct-string-from-binary-tree<br><br>
 * 
 * You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing
 * way. The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty
 * parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary
 * tree.
 */
public class ConstructStringFromBinaryTree {
    
    public static String solution(TreeNode root) {
        if (root == null) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        helper(sb, root);
        return sb.substring(1, sb.length() - 1);  // remove the leftmost and rightmost parenthesis
    }
    
    private static void helper(StringBuilder sb, TreeNode node) {
        if (node == null) {
            return;
        }
        
        sb.append("(");
        sb.append(node.val);
        if (node.left == null && node.right != null) {
            sb.append("()");
        }
        helper(sb, node.left);
        helper(sb, node.right);
        sb.append(")");
    }
    
    public static String solutionX(TreeNode t) {
        if (t == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        helperX(t, sb);
        return sb.toString();
    }
    
    private static void helperX(TreeNode node, StringBuilder sb) {
        sb.append(node.val);
        if (node.left != null) {
            sb.append("(");
            helperX(node.left, sb);
            sb.append(")");
        }
        if (node.right != null) {
            if (node.left == null) {
                sb.append("()");
            }
            sb.append("(");
            helperX(node.right, sb);
            sb.append(")");
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        System.out.println(ConstructStringFromBinaryTree.solution(root));
        System.out.println(ConstructStringFromBinaryTree.solutionX(root));
        
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        System.out.println(ConstructStringFromBinaryTree.solution(root2));
        System.out.println(ConstructStringFromBinaryTree.solutionX(root2));
    }

}
