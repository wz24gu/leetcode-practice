package edu.wz.cs.leetcode.medium;

import java.util.Stack;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 230. Kth Smallest Element in a BST<br>
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst<br><br>
 * 
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.<br>
 * 
 * Note: You may assume k is always valid, 1 <= k <= BST's total elements.<br>
 * 
 * Follow up: What if the BST is modified (insert/delete operations) often and you need to find the kth smallest 
 * frequently? How would you optimize the kthSmallest routine?
 */
public class KthSmallestElementInBST {
    
    private static int count;
    private static int number;
    
    public static int solution(TreeNode root, int k) {
        count = k;
        number = 0;
        inorder(root);
        return number;
    }
    
    private static void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        
        inorder(node.left);        
        count--;
        if (count == 0) {
            number = node.val;
            return;
        }
        inorder(node.right);
    }
    
    public static int solutionAlt(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            
            TreeNode node = stack.pop();
            k--;
            if (k == 0) {
                return node.val;
            }
            current = node.right;
        }
        
        return -1;
    }
    
    public static int solutionX(TreeNode root, int k) {
        int count = count(root.left);
        if (k <= count) {
            return solution(root.left, k);
        }
        else if (k > count + 1) {
            return solution(root.right, k - count - 1);
        }
        else {
            return root.val;
        }
    }
    
    private static int count(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + count(node.left) + count(node.right);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(KthSmallestElementInBST.solution(root, 2));
        System.out.println(KthSmallestElementInBST.solutionAlt(root, 2));
        System.out.println(KthSmallestElementInBST.solutionX(root, 2));
    }

}
