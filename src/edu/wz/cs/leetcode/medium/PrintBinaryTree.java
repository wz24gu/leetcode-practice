package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 655. Print Binary Tree<br>
 * https://leetcode.com/problems/print-binary-tree<br><br>
 * 
 * Print a binary tree in an m*n 2D string array following these rules:<br>
 * 1. The row number m should be equal to the height of the given binary tree.<br>
 * 2. The column number n should always be an odd number.<br>
 * 3. The root node's value (in string format) should be put in the exactly middle of the first row it can be put. The 
 * column and the row where the root node belongs will separate the rest space into two parts (left-bottom part and 
 * right-bottom part). You should print the left subtree in the left-bottom part and print the right subtree in the 
 * right-bottom part. The left-bottom part and the right-bottom part should have the same size. Even if one subtree is 
 * none while the other is not, you don't need to print anything for the none subtree but still need to leave the space 
 * as large as that for the other subtree. However, if two subtrees are none, then you don't need to leave space for 
 * both of them.<br>
 * 4. Each unused space should contain an empty string "".<br>
 * 5. Print the subtrees following the same rules.<br><br>
 * 
 * Note: The height of binary tree is in the range of [1, 10].
 */
public class PrintBinaryTree {
    
    public static List<List<String>> solution(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<String>>();
        }
        
        int row = height(root);
        int col = (int) (Math.pow(2, row) - 1);  // w is 2 ^ h - 1;
        
        String[][] matrix = new String[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(matrix[i], "");
        }
        
        helper(root, 0, col - 1, 0, matrix);
        
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                list.add(matrix[i][j]);
            }
            result.add(list);
        }
        return result;
    }
    
    private static void helper(TreeNode node, int left, int right, int level, String[][] matrix) {
        if (left > right) {
            return;
        }
        
        int mid = left + (right - left) / 2;
        matrix[level][mid] = node.val + "";
        
        if (node.left != null) {
            helper(node.left, left, mid, level + 1, matrix);
        }
        if (node.right != null) {
            helper(node.right, mid + 1, right, level + 1, matrix);
        }
    }
    
    private static int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        System.out.println(PrintBinaryTree.solution(root));
        
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        System.out.println(PrintBinaryTree.solution(root1));
        
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(5);
        root2.left.left = new TreeNode(3);
        root2.left.left.left = new TreeNode(4);
        System.out.println(PrintBinaryTree.solution(root2));        
    }

}
