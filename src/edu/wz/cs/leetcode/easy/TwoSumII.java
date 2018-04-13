package edu.wz.cs.leetcode.easy;

import java.util.Arrays;

/**
 * 167. Two Sum II - Input array is sorted<br>
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted<br><br>
 * 
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a 
 * specific target number.<br>
 * 
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must 
 * be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.<br>
 * 
 * You may assume that each input would have exactly one solution.<br>
 * Input: numbers={2, 7, 11, 15}, target=9<br>
 * Output: index1=1, index2=2
 */
public class TwoSumII {
    
    public static int[] solution(int[] numbers, int target) {
        int[] result = {-1, -1};
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum > target) {
                j--;
            }
            else if (sum < target) {
                i++;
            }
            else {
                result[0] = i + 1;
                result[1] = j + 1;
                break;
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] sorted = {2, 7, 11, 15};
        System.out.println(Arrays.toString(TwoSumII.solution(sorted, 9)));
    }

}
