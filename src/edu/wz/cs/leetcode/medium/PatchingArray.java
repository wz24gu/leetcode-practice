package edu.wz.cs.leetcode.medium;

/**
 * 330. Patching Array<br>
 * https://leetcode.com/problems/patching-array<br><br>
 * 
 * Given a sorted positive integer array nums and an integer n, add/patch elements to the array such that any number in 
 * range [1, n] inclusive can be formed by the sum of some elements in the array. Return the minimum number of patches required.<br>
 */
public class PatchingArray {
    
    public static int solution(int[] nums, int n) {
        long miss = 1;
        int result = 0;
        int i = 0;
        
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i++];
            }
            else {
                miss += miss;
                result++;
            }
        }
        
        return (int) result;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 3};
        System.out.println(PatchingArray.solution(nums, 6));
        
        int[] nums2 = {1, 5, 10};
        System.out.println(PatchingArray.solution(nums2, 20));
        
        int[] nums3 = {1, 2, 2};
        System.out.println(PatchingArray.solution(nums3, 5));
    }

}
