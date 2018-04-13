package edu.wz.cs.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 257. Binary Tree Paths<br>
 * https://leetcode.com/problems/binary-tree-paths<br><br>
 * 
 * Given a binary tree, return all root-to-leaf paths.
 */
public class BinaryTreePaths {
    
    public static List<String> solution(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }        
        
        helper(root, "", result);
        return result;
    }
    
    private static void helper(TreeNode node, String path, List<String> result) {
        path += node.val;
        if (node.left == null && node.right == null) {            
            result.add(path);
        }
        else {
            if (node.left != null) {
                helper(node.left, path + "->", result);
            }
            if (node.right != null) {
                helper(node.right, path + "->", result);
            }
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        System.out.println(BinaryTreePaths.solution(root));
    }

}
