package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 163. Missing Ranges<br>
 * https://leetcode.com/problems/missing-ranges<br><br>
 * 
 * Given a sorted integer array where the range of elements are in the inclusive range [lower, upper], return its 
 * missing ranges.<br>
 * 
 * For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
 */
public class MissingRanges {
    
    public static List<String> solution(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            if (lower == upper) {
                result.add(lower + "");
            }
            else if (lower < upper) {
                result.add(lower + "->" + upper);
            }
            return result;
        }
        
        int n = nums.length;
        
        int l = lower;
        for (int i = 0; i < n; i++) {
            int r;
            if (i < n && nums[i] <= upper) {
                r = nums[i];
            }
            else {
                r = upper + 1;
            }
            
            if (l == r) {
                l++;
            }
            else if (r > l) {
                if (r - l == 1) {
                    result.add(l + "");
                }
                else {
                    result.add(l + "->" + (r - 1));
                }
            }
        }
        
        return result;
    }

}
