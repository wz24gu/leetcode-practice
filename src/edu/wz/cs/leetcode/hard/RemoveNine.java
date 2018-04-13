package edu.wz.cs.leetcode.hard;

/**
 * 660. Remove 9<br/>
 * 
 * Start from integer 1, remove any integer that contains 9 such as 9, 19, 29... So now, you will have a new integer
 * sequence: 1, 2, 3, 4, 5, 6, 7, 8, 10, 11, ... Given a positive integer n, you need to return the n-th integer after
 * removing. Note that 1 will be the first integer.<br/><br/>
 * 
 * Hint: n will not exceed 9 x 10 ^ 8
 */
public class RemoveNine {
    
    public static int solution(int n) {
        int result = 0;
        int base = 1;  // 9 ^ 0
        while (n > 0) {
            result += (n % 9) * base;
            base *= 10;
            n /= 9;
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(RemoveNine.solution(9));
        System.out.println(RemoveNine.solution(88));
    }

}
