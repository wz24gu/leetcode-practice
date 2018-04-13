package edu.wz.cs.leetcode.medium;

/**
 * 477. Total Hamming Distance<br>
 * https://leetcode.com/problems/total-hamming-distance<br><br>
 * 
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.<br>
 * Now your job is to find the total Hamming distance between all pairs of the given numbers.<br><br>
 * 
 * Note:<br>
 * 1. Elements of the given array are in the range of 0 to 10^9<br>
 * 2. Length of the array will not exceed 10^4.
 */
public class TotalHammingDistance {
    
    public static int solution(int[] nums) {
        int result = 0;
        int n = nums.length;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : nums) {
                if (((num >> i) & 1) == 1) {
                    count++;
                }
            }
            result += count * (n - count);  // number of 1 * number of 0
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {4, 14, 2};
        System.out.println(TotalHammingDistance.solution(nums));
    }

}
