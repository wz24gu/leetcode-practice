package edu.wz.cs.leetcode.medium;

/**
 * 395. Longest Substring with At Least K Repeating Characters<br>
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters<br><br>
 * 
 * Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every 
 * character in T appears no less than k times.
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters {
    
    public static int solutionX(String s, int k) {
        return helper(s, 0, s.length() - 1, k);
    }
    
    private static int helper(String s, int lo, int hi, int k) {
        if (hi - lo + 1 < k) {
            return 0;
        }
        
        int[] freq = new int[26];
        for (int i = lo; i <= hi; i++) {
            freq[s.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0 && freq[i] < k) {
                for (int j = lo; j <= hi; j++) {
                    if (s.charAt(j) == i + 'a') {
                        int left = helper(s, lo, j - 1, k);
                        int right = helper(s, j + 1, hi, k);
                        return Math.max(left, right);
                    }
                }
            }
        }
        
        return hi - lo + 1;
    }
    
    public static int solution(String s, int k) {
        int result = 0;
        int n = s.length();
        int i = 0;
        
        while (i + k <= n) {
            int[] m = new int[26];
            int mask = 0;
            int max_idx = i;
            
            for (int j = i; j < n; j++) {
                int t = s.charAt(j) - 'a';
                m[t]++;
                if (m[t] < k) {
                    mask |= (1 << t);
                }
                else {
                    mask &= (~(1 << t));
                }
                
                if (mask == 0) {
                    result = Math.max(result, j - i + 1);
                    max_idx = j;
                }                
            }
            
            i = max_idx + 1;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(LongestSubstringWithAtLeastKRepeatingCharacters.solution("aaabb", 3));
        System.out.println(LongestSubstringWithAtLeastKRepeatingCharacters.solution("ababbc", 2));
        System.out.println(LongestSubstringWithAtLeastKRepeatingCharacters.solutionX("aaabb", 3));
        System.out.println(LongestSubstringWithAtLeastKRepeatingCharacters.solutionX("ababbc", 2));
    }

}
