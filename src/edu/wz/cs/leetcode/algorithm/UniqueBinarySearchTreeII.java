package edu.wz.cs.leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

import edu.wz.cs.leetcode.model.TreeNode;

public class UniqueBinarySearchTreeII {
    
    public List<TreeNode> generateBST(int n) {
        if (n <= 0) {
            return null;
        }
        return generate(1, n);
    }
    
    private List<TreeNode> generate(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        
        if (start > end) {
            list.add(null);
            return list;
        }
        if (start == end) {
            list.add(new TreeNode(start));
            return list;
        }
        
        List<TreeNode> left;
        List<TreeNode> right;
        for (int i = start; i <= end; i++) {
            left = generate(start, i - 1);
            right = generate(i + 1, end);
            
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
        UniqueBinarySearchTreeII uniqueBinarySearchTree = new UniqueBinarySearchTreeII();
        System.out.println(uniqueBinarySearchTree.generateBST(3));
    }

}
