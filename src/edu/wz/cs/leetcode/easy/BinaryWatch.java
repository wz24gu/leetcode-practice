package edu.wz.cs.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 401. Binary Watch<br>
 * https://leetcode.com/problems/binary-watch<br><br>
 * 
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the
 * minutes (0-59). Each LED represents a zero or one, with the least significant bit on the right.<br>
 * 
 * For example, the above binary watch reads "3:25".<br>
 * Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times
 * the watch could represent.<br><br>
 * 
 * Note:<br>
 * 1. The order of output does not matter.<br>
 * 2. The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".<br>
 * 3. The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it
 * should be "10:02".
 */
public class BinaryWatch {
    
    public static List<String> solution(int n) {
        List<String> result = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (n == countDigit(h) + countDigit(m)) {
                    result.add(String.format("%d:%02d", h, m));
                }
            }
        }
        return result;
    }
    
    private static int countDigit(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }
    
    private static final int[] hours = {1, 2, 4, 8};
    private static final int[] minutes = {1, 2, 4, 8, 16, 32};
    
    public static List<String> solutionX(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            List<Integer> hList = generate(hours, i);
            List<Integer> mList = generate(minutes, n - i);
            for (int h : hList) {
                if (h > 11) {
                    continue;
                }
                for (int m : mList) {
                    if (m > 59) {
                        continue;
                    }
                    result.add(String.format("%d:%02d", h, m));
                }
            }                    
        }
        return result;
    }
    
    private static List<Integer> generate(int[] nums, int i) {
        List<Integer> list = new ArrayList<>();
        helper(nums, i, 0, 0, list);
        return list;
    }
    
    private static void helper(int[] nums, int count, int pos, int sum, List<Integer> list) {
        if (count == 0) {
            list.add(sum);
            return;
        }
        
        for (int i = pos; i < nums.length; i++) {  // from pos to n - 1, get i nums in each loop
            helper(nums, count - 1, i + 1, sum + nums[i], list);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(BinaryWatch.solution(1));
        System.out.println(BinaryWatch.solutionX(1));
    }

}
