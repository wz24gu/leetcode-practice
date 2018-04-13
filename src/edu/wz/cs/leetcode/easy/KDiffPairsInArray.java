package edu.wz.cs.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 532. K-diff Pairs in an Array<br>
 * https://leetcode.com/problems/k-diff-pairs-in-an-array<br><br>
 * 
 * Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. Here a 
 * k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute 
 * difference is k.<br><br>
 * 
 * Note:<br>
 * 1. The pairs (i, j) and (j, i) count as the same pair.<br>
 * 2. The length of the array won't exceed 10,000.<br>
 * 3. All the integers in the given input belong to the range: [-1e7, 1e7].
 */
public class KDiffPairsInArray {
    
    public static int solution(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return 0;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int count = 0;
        for (int num : map.keySet()) {
            if (map.containsKey(num - k)) {
                if (k != 0 || map.get(num - k) > 1) {
                    count++;
                }
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 1, 5};
        System.out.println(KDiffPairsInArray.solution(nums, 2));
        
        int[] nums2 = {1, 2, 3, 4, 5};
        System.out.println(KDiffPairsInArray.solution(nums2, 1));
        
        int[] nums3 = {1, 3, 1, 5, 4};
        System.out.println(KDiffPairsInArray.solution(nums3, 0));
    }

}
