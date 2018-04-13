package edu.wz.cs.leetcode.medium;

/**
 * 467. Unique Substrings in Wraparound String<br>
 * https://leetcode.com/problems/unique-substrings-in-wraparound-string<br><br>
 * 
 * Consider the string s to be the infinite wraparound string of "abcdefghijklmnopqrstuvwxyz", so s will look like this: 
 * "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".<br>
 * 
 * Now we have another string p. Your job is to find out how many unique non-empty substrings of p are present in s. In 
 * particular, your input is the string p and you need to output the number of different non-empty substrings of p in 
 * the string s.<br>
 * 
 * Note: p consists of only lowercase English letters and the size of p might be over 10000.
 */
public class UniqueSubstringsInWraparoundString {
    
    public static int solution(String p) {
        int[] count = new int[26];
        int n = p.length();
        int len = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0 && (p.charAt(i) == p.charAt(i-1) + 1 || p.charAt(i-1) - p.charAt(i) == 25)) {
                len++;
            }
            else {
                len = 1;
            }
            count[p.charAt(i) - 'a'] = Math.max(count[p.charAt(i) - 'a'], len);
        }
        
        int sum = 0;
        for (int c : count) {
            sum += c;
        }
        return sum;
    }
    
    public static void main(String[] args) {
        System.out.println(UniqueSubstringsInWraparoundString.solution("a"));
        System.out.println(UniqueSubstringsInWraparoundString.solution("cac"));
        System.out.println(UniqueSubstringsInWraparoundString.solution("zab"));
    }

}
