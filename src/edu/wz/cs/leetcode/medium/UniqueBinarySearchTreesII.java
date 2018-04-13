package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 95. Unique Binary Search Trees II<br>
 * https://leetcode.com/problems/unique-binary-search-trees-ii<br><br>
 * 
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 */
public class UniqueBinarySearchTreesII {
    
    public static List<TreeNode> solution(int n) {
        if (n <= 0) {
            return new ArrayList<TreeNode>();
        }
        return helper(1, n);
    }
    
    private static List<TreeNode> helper(int lo, int hi) {
        List<TreeNode> list = new ArrayList<>();
        
        if (lo > hi) {
            list.add(null);
            return list;
        }
        
        if (lo == hi) {
            list.add(new TreeNode(lo));
            return list;
        }
        
        for (int i = lo; i <= hi; i++) {
            List<TreeNode> left = helper(lo, i - 1);
            List<TreeNode> right = helper(i + 1, hi);
            
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    list.add(root);
                }
            }
        }
        
        return list;   
    }
    
    public static void main(String[] args) {
        System.out.println(UniqueBinarySearchTreesII.solution(3));
    }
    

}
