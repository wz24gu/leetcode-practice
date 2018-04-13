package edu.wz.cs.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 666. Path Sum IV<br>
 * https://leetcode.com/problems/path-sum-iv<br><br>
 * 
 * If the depth of a tree is smaller than 5, then this tree can be represented by a list of three-digits integers.<br>
 * 
 * For each integer in this list:<br>
 * The hundreds digit represents the depth D of this node, 1 <= D <= 4.<br>
 * The tens digit represents the position P of this node in the level it belongs to, 1 <= P <= 8. The position is the 
 * same as that in a full binary tree.<br>
 * The units digit represents the value V of this node, 0 <= V <= 9.<br>
 * 
 * Given a list of ascending three-digits integers representing a binary with the depth smaller than 5. You need to 
 * return the sum of all paths from the root towards the leaves.
 */
public class PathSumIV {

    private static int result;
    
    public static int solution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n / 10, n % 10);
        }
        
        result = 0;
        helper(nums[0] / 10, map, 0);
        return result;
    }
    
    private static void helper(int num, Map<Integer, Integer> map, int current) {
        int level = num / 10;
        int pos = num % 10;
        int left = (level + 1) * 10 + (pos * 2) - 1;
        int right = left + 1;
        current += map.get(num);
        if (!map.containsKey(left) && !map.containsKey(right)) {
            result += current;
            return;
        }
        
        if (map.containsKey(left)) {
            helper(left, map, current);
        }
        if (map.containsKey(right)) {
            helper(right, map, current);
        }        
    }
    
    public static void main(String[] args) {
        int[] nums = {113, 215, 221};
        System.out.println(PathSumIV.solution(nums));
        
        int[] nums2 = {113, 221};
        System.out.println(PathSumIV.solution(nums2));
    }

}
