package edu.wz.cs.leetcode.easy;

/**
 * 35. Search Insert Position<br>
 * https://leetcode.com/problems/search-insert-position<br><br>
 * 
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it 
 * would be if it were inserted in order.<br>
 * 
 * You may assume no duplicates in the array.
 */
public class SearchInsertPosition {
    
    public static int solution(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) {
                lo = mid + 1;
            }
            else if (nums[mid] > target) {
                hi = mid - 1;
            }
            else {
                return mid;
            }
        }
        return lo;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(SearchInsertPosition.solution(nums, 5));
        System.out.println(SearchInsertPosition.solution(nums, 2));
        System.out.println(SearchInsertPosition.solution(nums, 7));
        System.out.println(SearchInsertPosition.solution(nums, 0));
    }

}
