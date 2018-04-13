package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 247. Strobogrammatic Number II<br>
 * https://leetcode.com/problems/strobogrammatic-number-ii<br><br>
 * 
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).<br>
 * 
 * Find all strobogrammatic numbers that are of length = n.<br>
 * 
 * For example, Given n = 2, return ["11","69","88","96"].
 */
public class StrobogrammaticNumberII {
    
    public static List<String> solution(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        
        helper(n, "", result);
        helper(n, "0", result);
        helper(n, "1", result);
        helper(n, "8", result);
        return result;
    }
    
    private static void helper(int n, String out, List<String> result) {
        if (out.length() > n) {
            return;
        }
        if (out.length() == n && (n == 1 || out.charAt(0) != '0')) {
            result.add(new String(out));
        }
        
        helper(n, "0" + out + "0", result);
        helper(n, "1" + out + "1", result);
        helper(n, "6" + out + "9", result);
        helper(n, "8" + out + "8", result);
        helper(n, "9" + out + "6", result);
    }
    
    public static void main(String[] args) {
        System.out.println(StrobogrammaticNumberII.solution(1));
        System.out.println(StrobogrammaticNumberII.solution(2));
    }

}
