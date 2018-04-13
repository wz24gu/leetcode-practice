package edu.wz.cs.leetcode.medium;

/**
 * 555. Split Concatenated Strings<br>
 * https://leetcode.com/problems/split-concatenated-strings<br><br>
 * 
 * Given a list of strings, you could concatenate these strings together into a loop, where for each string you could 
 * choose to reverse it or not. Among all the possible loops, you need to find the lexicographically biggest string after 
 * cutting the loop, which will make the looped string into a regular one.<br>
 * 
 * Specifically, to find the lexicographically biggest string, you need to experience two phases:<br>
 * 1. Concatenate all the strings into a loop, where you can reverse some strings or not and connect them in the same 
 * order as given.<br>
 * 2. Cut and make one breakpoint in any place of the loop, which will make the looped string into a regular one starting 
 * from the character at the cutpoint.<br>
 * And your job is to find the lexicographically biggest one among all the possible regular strings.<br><br>
 * 
 * Note:<br>
 * 1. The input strings will only contain lowercase letters.<br>
 * 2. The total length of all the strings will not over 1,000.
 */
public class SplitConcatenatedStrings {
    
    public static String solution(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            String rev = new StringBuilder(str).reverse().toString();
            if (str.compareTo(rev) < 0) {
                sb.append(rev);
            }
            else {
                sb.append(str);
            }
        }
        String s = sb.toString();
        
        int n = strs.length;
        String result = "a";
        int current = 0;
        
        for (int i = 0; i < n; i++) {
            String s1 = strs[i];
            String s2 = new StringBuilder(s1).reverse().toString();
            String mid = s.substring(current + s1.length()) + s.substring(0, current);
            
            for (int j = 0; j < s1.length(); j++) {
                if (s1.charAt(j) >= result.charAt(0)) {
                    String t = s1.substring(j) + mid + s1.substring(0, j);
                    result = (result.compareTo(t) >= 0) ? result : t;
                }
                if (s2.charAt(j) >= result.charAt(0)) {
                    String t = s2.substring(j) + mid + s2.substring(0, j);
                    result = (result.compareTo(t) >= 0) ? result : t;
                }
            }
            
            current += s1.length();
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        String[] strs = {"abc", "xyz"};
        System.out.println(SplitConcatenatedStrings.solution(strs));
    }

}
