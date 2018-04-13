package edu.wz.cs.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 202. Happy Number<br>
 * https://leetcode.com/problems/happy-number<br><br>
 * 
 * Write an algorithm to determine if a number is "happy".<br>
 * 
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number 
 * by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or 
 * it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy 
 * numbers.
 */
public class HappyNumber {
    
    public static boolean solution(int n) {
        if (n <= 0) {
            return false;
        }
        
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            int sum = 0;
            while (n != 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            
            if (set.contains(sum)) {
                return false;
            }
            set.add(sum);
            n = sum;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(HappyNumber.solution(19));
        System.out.println(HappyNumber.solution(11));
    }

}
