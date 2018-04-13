package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.wz.cs.leetcode.model.TreeNode;

/**
 * 508. Most Frequent Subtree Sum<br>
 * https://leetcode.com/problems/most-frequent-subtree-sum<br><br>
 * 
 * Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined
 * as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is
 * the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.<br>
 * 
 * Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.<br>
 */
public class MostFrequentSubtreeSum {    
   
    private static int max;
    
    public static int[] solution(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        
        max = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> list = new ArrayList<>();
        postorder(root, map, list);
        
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
    
    private static int postorder(TreeNode node, Map<Integer, Integer> map, List<Integer> list) {
        if (node == null) {
            return 0;
        }
        
        int left = postorder(node.left, map, list);
        int right = postorder(node.right, map, list);
        
        int sum = left + right + node.val;        
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        if (map.get(sum) >= max) {
            if (map.get(sum) > max) {
                max = map.get(sum);
                list.clear();
            }
            list.add(sum);
        }
        return sum;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-3);
        System.out.println(Arrays.toString(MostFrequentSubtreeSum.solution(root)));
        
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(-5);
        System.out.println(Arrays.toString(MostFrequentSubtreeSum.solution(root1)));
    }

}
