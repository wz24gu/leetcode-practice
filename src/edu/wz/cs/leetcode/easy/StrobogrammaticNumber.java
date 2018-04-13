package edu.wz.cs.leetcode.easy;

/**
 * 246. Strobogrammatic Number<br>
 * https://leetcode.com/problems/strobogrammatic-number<br><br>
 * 
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down). Write a 
 * function to determine if a number is strobogrammatic. The number is represented as a string.<br>
 * 
 * For example, the numbers "69", "88", and "818" are all strobogrammatic.
 */
public class StrobogrammaticNumber {
    
    // 0, 1, 8, 6->9
    public static boolean solution(int n) {
        if (n < 0) {
            return false;
        }
        
        String s = String.valueOf(n);
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                if (s.charAt(i) != '0' && s.charAt(i) != '1' && s.charAt(i) != '8') {
                    return false;
                }
            }
            else {
                boolean valid = (s.charAt(i) == '6' && s.charAt(j) == '9')
                             || (s.charAt(i) == '9' && s.charAt(j) == '6');
                if (!valid) {
                    return false;
                }
            }
            i++;
            j--;
        }
        
        return true;        
    }
    
    public static boolean solution(String num) {
        if (num == null || num.length() == 0) {
            return true;
        }
        
        int i = 0;
        int j = num.length() - 1;
        while (i < j) {
            char a = num.charAt(i);
            char b = num.charAt(j);
            if (a == b) {
                if (a != '0' && a != '1' && a != '8') {
                    return false;
                }
            }
            else {
                boolean valid = (a == '6' && b == '9' || a == '9' && b == '6');
                if (!valid) {
                    return false;
                }
            }
            i++;
            j--;
        }
        
        if (i == j) {
            char a = num.charAt(i);
            return a == '0' || a == '1' || a == '8';
        }
        else {
            return true;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(StrobogrammaticNumber.solution(69));
        System.out.println(StrobogrammaticNumber.solution(88));
        System.out.println(StrobogrammaticNumber.solution(818));
        
        System.out.println(StrobogrammaticNumber.solution("69"));
        System.out.println(StrobogrammaticNumber.solution("88"));
        System.out.println(StrobogrammaticNumber.solution("818"));
    }

}
