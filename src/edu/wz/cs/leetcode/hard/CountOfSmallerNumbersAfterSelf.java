package edu.wz.cs.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 315. Count of Smaller Numbers After Self<br>
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self<br><br>
 * 
 * You are given an integer array nums and you have to return a new counts array. The counts array has the property 
 * where counts[i] is the number of smaller elements to the right of nums[i].
 */
public class CountOfSmallerNumbersAfterSelf {
    
    public static List<Integer> solution(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        int n = nums.length;
        int[] temp = new int[n];
        List<Integer> list = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            temp[i] = insert(list, nums[i]);
        }
        
        for (int i = 0; i < n; i++) {
            result.add(temp[i]);
        }
        return result;
    }
    
    private static int insert(List<Integer> list, int num) {
        int lo = 0;
        int hi = list.size() - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int m = list.get(mid);
            if (m >= num) {
                hi = mid - 1;
            }
            else {
                lo = mid + 1;  // lo will always be the first element that is > num
            }
        }
        list.add(lo, num);
        return lo;   
    }
    
    public static void main(String[] args) {
        int[] nums = {5, 2, 6, 1};
        System.out.println(CountOfSmallerNumbersAfterSelf.solution(nums));
    }

}
