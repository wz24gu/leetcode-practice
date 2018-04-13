package edu.wz.cs.leetcode.easy;

/**
 * 414. Third Maximum Number<br>
 * https://leetcode.com/problems/third-maximum-number<br><br>
 * 
 * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the 
 * maximum number. The time complexity must be in O(n).
 */
public class ThirdMaximumNumber {
    
    public static int solution(int[] nums) {
        long m1 = Long.MIN_VALUE;  // use long in case integer min exists in the array
        long m2 = Long.MIN_VALUE;
        long m3 = Long.MIN_VALUE;
        
        for (int num : nums) {
            if (num > m1) {
                m3 = m2;
                m2 = m1;
                m1 = num;
            }
            else if (num < m1 && num > m2) {
                m3 = m2;
                m2 = num;
            }
            else if (num < m2 && num > m3) {  // have to be this way because we don't use =
                m3 = num;
            }
        }
        
        if (m3 == Long.MIN_VALUE || m3 == m2) {  // the second condition may not be necessary
            return (int) m1;
        }
        else {
            return (int) m3;
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {3, 2, 1};
        System.out.println(ThirdMaximumNumber.solution(nums));
        
        int[] nums2 = {1, 2};
        System.out.println(ThirdMaximumNumber.solution(nums2));
        
        int[] nums3 = {2, 2, 3, 1};
        System.out.println(ThirdMaximumNumber.solution(nums3));
    }

}
