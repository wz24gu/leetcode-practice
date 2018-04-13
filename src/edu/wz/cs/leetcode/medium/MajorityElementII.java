package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 229. Majority Element II<br>
 * https://leetcode.com/problems/majority-element-ii<br><br>
 * 
 * Given an integer array of size n, find all elements that appear more than n/3 times. The algorithm should run in 
 * linear time and in O(1) space.<br>
 * 
 * Hint:<b>
 * 1. How many majority elements could it possibly have?<br>
 * 2. Do you have a better hint? Suggest it!
 */
public class MajorityElementII {
    
    // Moore voting
    public static List<Integer> solution(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        int a = 0;
        int b = 0;
        int countA = 0;
        int countB = 0;
        for (int num : nums) {
            if (num == a) {
                countA++;
            }
            else if (num == b) {
                countB++;
            }
            else if (countA == 0) {
                a = num;
                countA = 1;
            }
            else if (countB == 0) {
                b = num;
                countB = 1;
            }
            else {
                countA--;
                countB--;
            }
        }
        
        countA = 0;
        countB = 0;
        for (int num : nums) {
            if (num == a) {
                countA++;
            }
            else if (num == b) {
                countB++;
            }
        }
        
        if (countA > nums.length / 3) {
            result.add(a);
        }
        if (countB > nums.length / 3) {
            result.add(b);
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3};
        System.out.println(MajorityElementII.solution(nums));
    }

}
