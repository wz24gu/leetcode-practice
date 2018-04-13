package edu.wz.cs.leetcode.medium;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 250. Count Univalue Subtrees<br>
 * https://leetcode.com/problems/count-univalue-subtrees<br><br>
 * 
 * Given a binary tree, count the number of uni-value subtrees.<br>
 * 
 * A Uni-value subtree means all nodes of the subtree have the same value.
 */
public class CountUnivalueSubtrees {
    
    private static int result = 0;
    
    public static int solution(TreeNode root) {        
        if (root == null) {
            return 0;
        }
        
        if (univalue(root, root.val)) {
            result++;
        }
        solution(root.left);
        solution(root.right);
        
        return result;
    }
    
    private static boolean univalue(TreeNode node, int val) {
        if (node == null) {
            return true;
        }
        return node.val == val && univalue(node.left, val) && univalue(node.right, val);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(5);
        System.out.println(CountUnivalueSubtrees.solution(root));
    }

}
