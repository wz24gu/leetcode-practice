package edu.wz.cs.leetcode.medium;

import java.util.Arrays;

/**
 * 80. Remove Duplicates from Sorted Array II<br>
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii<br><br>
 * 
 * What if duplicates are allowed at most twice?<br>
 * For example, Given sorted array nums = [1,1,1,2,2,3],<br>
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't 
 * matter what you leave beyond the new length.
 */
public class RemoveDuplicatesFromSortedArrayII {
    
    public static int solutionX(int[] nums) {
        int i = 0;
        for (int num : nums) {
            if (i < 2 || num > nums[i-2]) {  // compare with the element two step ahead
                nums[i++] = num;
            }
        }
        return i;
    }
    
    public static int solution(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        
        int count = 1;
        int i = 0;
        int j = 1;
        while (j < n) {
            if (nums[j] == nums[j-1]) {
                if (count == 2) {
                    j++;
                }
                else {
                    count++;
                    nums[++i] = nums[j++];
                }
            }
            else {
                count = 1;
                nums[++i] = nums[j++];
            }
        }
        
        return i + 1;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println(RemoveDuplicatesFromSortedArrayII.solution(nums));
        System.out.println(Arrays.toString(nums));
        
        int[] nums2 = {1, 1, 1, 2, 2, 3};
        System.out.println(RemoveDuplicatesFromSortedArrayII.solutionX(nums2));
        System.out.println(Arrays.toString(nums2));
    }

}
