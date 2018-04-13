package edu.wz.cs.leetcode.easy;

/**
 * 482. License Key Formatting<br>
 * https://leetcode.com/problems/license-key-formatting<br><br>
 * 
 * You are given a license key represented as a string S which consists only alphanumeric character and dashes. The 
 * string is separated into N+1 groups by N dashes.<br>
 * 
 * Given a number K, we would want to reformat the strings such that each group contains exactly K characters, except 
 * for the first group which could be shorter than K, but still must contain at least one character. Furthermore, there 
 * must be a dash inserted between two groups and all lowercase letters should be converted to uppercase.<br>
 * 
 * Given a non-empty string S and a number K, format the string according to the rules described above.<br><br>
 * 
 * Note:<br>
 * 1. The length of string S will not exceed 12,000, and K is a positive integer.<br>
 * 2. String S consists only of alphanumerical characters (a-z and/or A-Z and/or 0-9) and dashes(-).<br>
 * 3. String S is non-empty.
 */
public class LicenseKeyFormatting {
    
    public static String solution(String S, int K) {
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (c == '-') {
                continue;
            }
            if (c >= 'a' && c <= 'z') {
                c = (char) (c - 'a' + 'A');
            }
            sb.append(c);
        }
        
        for (int i = sb.length() - K; i > 0; i -= K) {
            sb.insert(i, "-");
        }
        return sb.toString();
    }
    
    // this implementation is incorrect
    public static String solutionX(String S, int K) {
        StringBuilder sb = new StringBuilder();
        int n = S.length();
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            char c = S.charAt(i);
            if (c == '-') {
                continue;
            }
            if (c >= 'a' && c <= 'z') {
                c = (char) (c + 'A' - 'a');
            }
            sb.append(c);
            if (++count % K == 0 && i != 0) {  // this is a bug, if the S starts with --
                sb.append("-");
            }
        }
        
        return sb.reverse().toString();
    }
    
    public static void main(String[] args) {
        System.out.println(LicenseKeyFormatting.solution("5F3Z-2e-9-w", 4));
        System.out.println(LicenseKeyFormatting.solution("2-5g-3-J", 2));
        
        System.out.println(LicenseKeyFormatting.solutionX("5F3Z-2e-9-w", 4));
        System.out.println(LicenseKeyFormatting.solutionX("2-5g-3-J", 2));
    }

}
