package edu.wz.cs.leetcode.medium;

import java.util.Arrays;

/**
 * 681. Next Closest Time<br>
 * https://leetcode.com/problems/next-closest-time<br><br>
 * 
 * Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits. There is 
 * no limit on how many times a digit can be reused.<br>
 * 
 * You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid. "1:34", "12:9" 
 * are all invalid.
 */
public class NextClosestTime {
    
    public static String solution(String time) {
        char[] result = time.toCharArray();
        char[] digits = new char[] {result[0], result[1], result[3], result[4]};
        Arrays.sort(digits);
        
        result[4] = helper(result[4], (char) ('9' + 1), digits);
        if (result[4] > time.charAt(4)) {
            return String.valueOf(result);
        }
        
        result[3] = helper(result[3], '5', digits);
        if (result[3] > time.charAt(3)) {
            return String.valueOf(result);
        }
        
        result[1] = result[0] == '2' ? helper(result[1], '3', digits) : helper(result[1], (char) ('9' + 1), digits);
        if (result[1] > time.charAt(1)) {
            return String.valueOf(result);
        }
        
        result[0] = helper(result[0], '2', digits);
        return String.valueOf(result);
    }
    
    private static char helper(char current, char limit, char[] digits) {
        if (current == limit) {
            return digits[0];  // digits[0] is always the smallest
        }
        
        int pos = Arrays.binarySearch(digits, current) + 1;
        while (pos < 4 && (digits[pos] > limit || digits[pos] == current)) {  // traverse and remove duplicate
            pos++;
        }
        return pos == 4 ? digits[0] : digits[pos];
    }
    
    public static void main(String[] args) {
        System.out.println(NextClosestTime.solution("19:34"));
        System.out.println(NextClosestTime.solution("23:59"));
    }

}
