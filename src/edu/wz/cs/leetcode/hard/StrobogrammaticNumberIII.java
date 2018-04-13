package edu.wz.cs.leetcode.hard;

/**
 * 248. Strobogrammatic Number III<br>
 * https://leetcode.com/problems/strobogrammatic-number-iii<br><br>
 * 
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).<br>
 * 
 * Write a function to count the total strobogrammatic numbers that exist in the range of low <= num <= high.<br>
 * 
 * For example, Given low = "50", high = "100", return 3. Because 69, 88, and 96 are three strobogrammatic numbers.<br>
 * 
 * Note: Because the range might be a large number, the low and high numbers are represented as string.
 */
public class StrobogrammaticNumberIII {
    
    private static int result;
    
    public static int solution(String low, String high) {
        result = 0;
        for (int i = low.length(); i <= high.length(); i++) {
            helper(low, high, "", i);
            helper(low, high, "0", i);
            helper(low, high, "1", i);
            helper(low, high, "8", i);
        }
        return result;
    }
    
    private static void helper(String low, String high, String path, int len) {
        if (path.length() >= len) {
            if (path.length() != len) {
                return;
            }
            if (len != 1 && path.charAt(0) == '0') {
                return;
            }
            if (len == low.length() && path.compareTo(low) < 0
                    || len == high.length() && path.compareTo(high) > 0) {
                return;
            }
            result++;
        }
        
        helper(low, high, "0" + path + "0", len);
        helper(low, high, "1" + path + "1", len);
        helper(low, high, "6" + path + "9", len);
        helper(low, high, "8" + path + "8", len);
        helper(low, high, "9" + path + "6", len);
    }
    
    public static void main(String[] args) {
        System.out.println(StrobogrammaticNumberIII.solution("50", "100"));
    }

}
