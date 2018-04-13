package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 347. Top K Frequent Elements<br>
 * https://leetcode.com/problems/top-k-frequent-elements<br><br>
 * 
 * Given a non-empty array of integers, return the k most frequent elements.<br>
 * For example, Given [1,1,1,2,2,3] and k = 2, return [1,2].<br><br>
 * 
 * Note:<br>
 * 1. You may assume k is always valid, 1 ≤ k ≤ number of unique elements.<br>
 * 2. Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class TopKFrequentElements {
    
    public static List<Integer> solution(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        @SuppressWarnings("unchecked")
        List<Integer>[] bucket = (List<Integer>[]) new List[n + 1];
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<Integer>();
            }
            bucket[freq].add(key);
        }        
        
        for (int i = n; i > 0; i--) {
            if (bucket[i] != null) {
                result.addAll(bucket[i]);
                k -= bucket[i].size();
            }
            if (k <= 0) {
                break;
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println(TopKFrequentElements.solution(nums, 2));
    }

}
