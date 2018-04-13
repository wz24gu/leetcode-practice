package edu.wz.cs.leetcode.medium;

/**
 * 287. Find the Duplicate Number<br>
 * https://leetcode.com/problems/find-the-duplicate-number<br><br>
 * 
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least 
 * one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.<br><br>
 * 
 * Note:<br>
 * 1. You must not modify the array (assume the array is read only).<br>
 * 2. You must use only constant, O(1) extra space.<br>
 * 3. Your runtime complexity should be less than O(n ^ 2).<br>
 * 4. There is only one duplicate number in the array, but it could be repeated more than once.<br>
 */
public class FindTheDuplicateNumber {

    public static int solution(int[] nums) {        
        int lo = 1;  // lo and hi are not index but element
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0;
            for (int n : nums) {
                if (n <= mid) {
                    count++;
                }
            }
            if (count <= mid) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }
        return lo;
    }
    
    public static int solutionX(int[] nums) {
        int slow = 0;
        int fast = 0;
        int temp = 0;
        
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                break;
            }
        }
        
        while (true) {
            temp = nums[temp];
            slow = nums[slow];
            if (temp == slow) {
                break;
            }
        }
        
        return slow;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 4};
        System.out.println(FindTheDuplicateNumber.solution(nums));
        System.out.println(FindTheDuplicateNumber.solutionX(nums));
    }

}
