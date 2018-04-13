package edu.wz.cs.leetcode.medium;

/**
 * 424. Longest Repeating Character Replacement<br>
 * https://leetcode.com/problems/longest-repeating-character-replacement<br><br>
 * 
 * Given a string that consists of only uppercase English letters, you can replace any letter in the string with another 
 * letter at most k times. Find the length of a longest substring containing all repeating letters you can get after 
 * performing the above operations.<br>
 * 
 * Note: Both the string's length and k will not exceed 10^4.
 */
public class LongestRepeatingCharacterReplacement {
    
    public static int solution(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int result = 0;
        int max = 0;
        int start = 0;
        int[] counts = new int[26];
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            counts[s.charAt(i) - 'A']++;
            max = Math.max(max, counts[s.charAt(i) - 'A']);
            while (i - start + 1 - max > k) {
                counts[s.charAt(start) - 'A']--;
                start++;
            }
            result = Math.max(result, i - start + 1);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(LongestRepeatingCharacterReplacement.solution("ABAB", 2));
        System.out.println(LongestRepeatingCharacterReplacement.solution("AABABBA", 1));
    }

}
