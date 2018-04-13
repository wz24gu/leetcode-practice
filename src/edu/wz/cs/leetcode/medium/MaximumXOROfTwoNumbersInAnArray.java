package edu.wz.cs.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 421. Maximum XOR of Two Numbers in an Array<br>
 * https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array<br><br>
 * 
 * Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 <= ai <= 2 ^ 31.<br>
 * 
 * Find the maximum result of ai XOR aj, where 0 <= i, j < n.<br>
 * 
 * Could you do this in O(n) runtime?
 */
public class MaximumXOROfTwoNumbersInAnArray {
    
    public static int solution(int[] nums) {
        int result = 0;
        int mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask |= (1 << i);
            
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num & mask);
            }            
            
            int t = result | (1 << i);
            for (int prefix : set) {
                if (set.contains(t ^ prefix)) {
                    result = t;
                    break;
                }
            }
            System.out.print(set);
            System.out.print(": " + result + ": " + t);
            System.out.println();
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {3, 10, 5, 25, 2, 8};
        System.out.println(MaximumXOROfTwoNumbersInAnArray.solution(nums));
    }

}
