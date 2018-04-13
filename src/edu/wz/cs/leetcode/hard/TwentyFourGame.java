package edu.wz.cs.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 679. 24 Game<br/>
 * 
 * You have 4 cards each containing a number from 1 to 9. You need to judge whether they could operated through
 * *, /, +, -, (, ) to get the value of 24.<br/><br/>
 * 
 * Note:<br/>
 * 1. The division operator / represents real division, not integer division. For example, 4 / (1 - 2/3) = 12.<br/>
 * 2. Every operation done is between two numbers. In particular, we cannot use - as a unary operator. For example,
 * with [1, 1, 1, 1] as input, the expression -1 - 1 - 1 - 1 is not allowed.<br/>
 * 3. You cannot concatenate numbers together. For example, if the input is [1, 2, 1, 2], we cannot write this as 12 + 12.
 */
public class TwentyFourGame {
    
    private static final double EPS = 1E-12;
    private static boolean result;
    
    public static boolean solution(int[] nums) {
        if (nums == null || nums.length != 4) {
            throw new IllegalArgumentException();
        }
        
        result = false;
        List<Double> list = new ArrayList<>();
        for (int num : nums) {
            list.add((double) num);
        }
        helper(list);
        return result;
    }
    
    private static void helper(List<Double> list) {
        if (list.size() == 1 && Math.abs(list.get(0) - 24.0) < EPS) {
            result = true;
            return;
        }
        
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < i; j++) {
                List<Double> next = new ArrayList<>();
                double p1 = list.get(i);
                double p2 = list.get(j);
                next.add(p1 + p2);
                next.add(p1 - p2);
                next.add(p2 - p1);
                next.add(p1 * p2);
                if (Math.abs(p1) > EPS) {  // guard against divide by zero
                    next.add(p2 / p1);
                }
                if (Math.abs(p2) > EPS) {
                    next.add(p1 / p2);
                }
                
                list.remove(i);
                list.remove(j);
                for (double n : next) {
                    list.add(n);
                    helper(list);
                    list.remove(list.size() - 1);
                }
                list.add(j, p2);  // j is smaller than i, so always add j back first
                list.add(i, p1);
                
            }
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {4, 1, 8, 7};
        System.out.println(TwentyFourGame.solution(nums));
        
        int[] nums2 = {1, 2, 1, 2};
        System.out.println(TwentyFourGame.solution(nums2));
    }

}
