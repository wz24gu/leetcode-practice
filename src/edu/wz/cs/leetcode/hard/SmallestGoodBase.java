package edu.wz.cs.leetcode.hard;

/**
 * 483. Smallest Good Base<br/>
 * https://leetcode.com/problems/smallest-good-base<br/><br/>
 * 
 * For an integer n, we call k>=2 a good base of n, if all digits of n base k are 1.<br/>
 * 
 * Now given a string representing n, you should return the smallest good base of n in string format.<br/>
 * 
 * Example 1: Input: "13"; Output: "3"<br/>
 * Explanation: 13 base 3 is 111.<br/><br/>
 * 
 * Example 2: Input: "4681"; Output: "8"<br/>
 * Explanation: 4681 base 8 is 11111.<br/><br/>
 * 
 * Example 3: Input: "1000000000000000000"; Output: "999999999999999999"<br/>
 * Explanation: 1000000000000000000 base 999999999999999999 is 11.<br/><br/>
 * 
 * Note:<br/>
 * 1. The range of n is [3, 10^18].<br/>
 * 2. The string representing n is always valid and will not have leading zeros.
 */
public class SmallestGoodBase {

    /** n = 1 + k + k ^ 2 + ... + k ^ (m-1)
     * n = (k ^ m - 1) / (k - 1)
     * if k smallest, then m greatest
     * 2 <= m < log2(n + 1) (when k = 2)
     * 2 <= k < n ^ (1 / (m -1))
     */
    public static String solution(String n) {
        long num = Long.parseLong(n);
        
        for (int m = (int) (Math.log(num + 1) / Math.log(2)); m >= 2; m--) {
            long left = 2;
            long right = (long) (Math.pow(num, 1.0 / (m - 1)) + 1);
            while (left < right) {
                long mid = left + (right - left) / 2;
                long sum = 0;
                for (int i = 0; i < m; i++) {
                    sum = sum * mid + 1;
                }
                
                if (sum == num) {
                    return String.valueOf(mid);
                }
                else if (sum < num) {
                    left = mid + 1;
                }
                else {
                    right = mid;
                }
            }
        }
        
        return String.valueOf(num - 1);  // n with (n - 1) base will always be 11
    }
    
    public static void main(String[] args) {
        System.out.println(SmallestGoodBase.solution("13"));
        System.out.println(SmallestGoodBase.solution("4681"));
        System.out.println(SmallestGoodBase.solution("1000000000000000000"));
    }
    
}
