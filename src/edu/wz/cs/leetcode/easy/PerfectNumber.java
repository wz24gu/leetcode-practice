package edu.wz.cs.leetcode.easy;

/**
 * 507. Perfect Number<br>
 * https://leetcode.com/problems/perfect-number<br><br>
 * 
 * We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except 
 * itself.<br>
 * 
 * Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.<br>
 * 
 * Example: Input: 28 Output: True<br>
 * Explanation: 28 = 1 + 2 + 4 + 7 + 14<br>
 * 
 * Note: The input number n will not exceed 100,000,000. (1e8)
 */
public class PerfectNumber {

    public static boolean solution(int num) {
        if (num <= 1) {
            return false;
        }
        
        int sqrt = (int) Math.sqrt(num);        
        int result = 1;
        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) {
                result += i;
                result += num / i;
            }
        }        
        if (sqrt * sqrt == num) {
            result -= sqrt;
        }
        
        return result == num;
    }
    
    public static void main(String[] args) {
        System.out.println(PerfectNumber.solution(28));
    }

}
