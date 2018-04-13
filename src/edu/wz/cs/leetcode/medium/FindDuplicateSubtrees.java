package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 652. Find Duplicate Subtrees<br>
 * https://leetcode.com/problems/find-duplicate-subtrees<br><br>
 * 
 * Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, you only need to return the 
 * root node of any one of them.<br>
 * 
 * Two trees are duplicate if they have the same structure with same node values.
 */
public class FindDuplicateSubtrees {
    
    public static List<TreeNode> solution(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        preorder(root, map, result);
        System.out.println(map);
        return result;
    }
    
    private static String preorder(TreeNode node, Map<String, Integer> map, List<TreeNode> result) {
        if (node == null) {
            return "#";
        }
        
        String s = node.val + "," + preorder(node.left, map, result) + "," + preorder(node.right, map, result);
        if (map.containsKey(s) && map.get(s) == 1) {
            result.add(node);
        }
        map.put(s, map.getOrDefault(s, 0) + 1);
        return s;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(4);
        System.out.println(FindDuplicateSubtrees.solution(root));
    }

}
