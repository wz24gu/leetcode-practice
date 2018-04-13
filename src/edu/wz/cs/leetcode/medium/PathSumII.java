package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 113. Path Sum II<br>
 * https://leetcode.com/problems/path-sum-ii<br><br>
 * 
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 */
public class PathSumII {
    
    public static List<List<Integer>> solution(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        List<Integer> list = new ArrayList<>();
        backtrack(root, sum, list, result);
        return result;
    }
    
    private static void backtrack(TreeNode node, int sum, List<Integer> list, List<List<Integer>> result) {
        if (node == null) {
            return;
        }
        
        list.add(node.val);
        if (node.left == null && node.right == null && sum == node.val) {
            result.add(new ArrayList<Integer>(list));
        }
        
        backtrack(node.left, sum - node.val, list, result);
        backtrack(node.right, sum- node.val, list, result);
        list.remove(list.size() - 1);
    }
    
    public static List<List<Integer>> solutionAlt(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        List<Integer> path = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        int val = 0;
        TreeNode curr = root;
        TreeNode prev = null;
        
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                path.add(curr.val);
                val += curr.val;
                curr = curr.left;
            }
            
            curr = stack.peek();
            if (curr.right != null && curr.right != prev) {
                curr = curr.right;
                continue;
            }
            
            if (curr.left == null && curr.right == null && val == sum) {
                result.add(new ArrayList<Integer>(path));
            }
            
            prev = curr;
            stack.pop();
            path.remove(path.size() - 1);
            val -= curr.val;
            curr = null;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        System.out.println(PathSumII.solution(root, 22));
        System.out.println(PathSumII.solutionAlt(root, 22));
    }

}
