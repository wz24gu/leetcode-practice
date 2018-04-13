package edu.wz.cs.leetcode.medium;

/**
 * 540. Single Element in a Sorted Array<br>
 * https://leetcode.com/problems/single-element-in-a-sorted-array<br><br>
 * 
 * Given a sorted array consisting of only integers where every element appears twice except for one element which
 * appears once. Find this single element that appears only once.<br><br>
 * 
 * Note: Your solution should run in O(log n) time and O(1) space.
 */
public class SingleElementInSortedArray {
    
    public static int solution(int[] nums) {
        int i;
        for (i = 1; i < nums.length; i += 2) {
            if (nums[i] != nums[i-1]) {
                return nums[i-1];
            }
        }
        return nums[i-1];
    }
    
    public static int solutionX(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            
            if (nums[mid] == nums[mid+1]) {
                if (mid % 2 == 0) {  // left and right have even number of elements
                    lo = mid + 1;
                }
                else {  // left and right have odd number of elements
                    hi = mid;
                }
            }
            else {
                if (mid == 0 || nums[mid] != nums[mid-1]) {
                    return nums[mid];
                }
                if (mid % 2 == 0) {
                    hi = mid;
                }
                else {
                    lo = mid + 1;
                }
            }
        }
        
        return nums[lo];
    }
    
    public static int solutionXX(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        int[] nums2 = {3, 3, 7, 7, 10, 11, 11};
        int[] nums3 = {1, 2, 2, 3, 3};
        System.out.println(SingleElementInSortedArray.solution(nums));
        System.out.println(SingleElementInSortedArray.solution(nums2));
        System.out.println(SingleElementInSortedArray.solutionX(nums));
        System.out.println(SingleElementInSortedArray.solutionX(nums2));
        System.out.println(SingleElementInSortedArray.solutionXX(nums));
        System.out.println(SingleElementInSortedArray.solutionXX(nums2));
        
        System.out.println(SingleElementInSortedArray.solutionX(nums3));
    }

}
