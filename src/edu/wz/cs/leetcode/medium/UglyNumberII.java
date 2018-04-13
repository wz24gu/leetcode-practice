package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 264. Ugly Number II<br>
 * https://leetcode.com/problems/ugly-number-ii<br><br>
 * 
 * Write a program to find the n-th ugly number.<br>
 * 
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 
 * 12 is the sequence of the first 10 ugly numbers.<br>
 * 
 * Note that 1 is typically treated as an ugly number, and n does not exceed 1690.
 */
public class UglyNumberII {
    
    public static int solution(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        while (result.size() < n) {
            int n2 = result.get(i2) * 2;
            int n3 = result.get(i3) * 3;
            int n5 = result.get(i5) * 5;
            
            int min = Math.min(n2, Math.min(n3, n5));
            result.add(min);
            
            if (min == n2) {
                i2++;
            }
            if (min == n3) {
                i3++;
            }
            if (min == n5) {
                i5++;
            }
        }
        
        return result.get(result.size() - 1);
    }
    
    public static void main(String[] args) {
        System.out.println(UglyNumberII.solution(1));
        System.out.println(UglyNumberII.solution(2));
        System.out.println(UglyNumberII.solution(3));
        System.out.println(UglyNumberII.solution(4));
        System.out.println(UglyNumberII.solution(5));
    }

}
