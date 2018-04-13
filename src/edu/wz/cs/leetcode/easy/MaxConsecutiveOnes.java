package edu.wz.cs.leetcode.easy;

/**
 * 485. Max Consecutive Ones<br>
 * https://leetcode.com/problems/max-consecutive-ones<br><br>
 * 
 * Given a binary array, find the maximum number of consecutive 1s in this array.<br><br>
 * 
 * Note:<br>
 * 1. The input array will only contain 0 and 1.<br>
 * 2. The length of input array is a positive integer and will not exceed 10,000.
 */
public class MaxConsecutiveOnes {
    
    public static int solution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int max = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                max = Math.max(max, sum);
                sum = 0;
            }
            else {
                sum++;
            }
        }
        return Math.max(max, sum);  // take care if the last element in the array is 1
    }
    
    public static int solutionAlt(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int result = 0;
        int n = nums.length;
        int i = 0;
        
        while (i < n) {
            if (nums[i] != 1) {
                i++;
            }
            else {
                int j = i + 1;
                while (j < n && nums[j] == 1) {
                    j++;
                }
                result = Math.max(result, j - i);
                i = j;
            }
        }
            
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1};
        System.out.println(MaxConsecutiveOnes.solution(nums));
        System.out.println(MaxConsecutiveOnes.solutionAlt(nums));
    }

}
