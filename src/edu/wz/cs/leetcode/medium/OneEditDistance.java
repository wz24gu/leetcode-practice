package edu.wz.cs.leetcode.medium;

/**
 * 161. One Edit Distance<br>
 * https://leetcode.com/problems/one-edit-distance<br><br>
 * 
 * Given two strings S and T, determine if they are both one edit distance apart.
 */
public class OneEditDistance {
    
    public static boolean solution(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (Math.abs(m - n) > 1) {
            return false;
        }
        
        int min = Math.min(m, n);
        for (int i = 0; i < min; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (m == n) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                }
                else if (m > n) {
                    return s.substring(i + 1).equals(t.substring(i));
                }
                else {
                    return s.substring(i).equals(t.substring(i + 1));
                }
            }
        }
        
        return m != n;
    }
    
    public static void main(String[] args) {
        System.out.println(OneEditDistance.solution("ab", "abc"));
        System.out.println(OneEditDistance.solution("ab", "ba"));
    }

}
