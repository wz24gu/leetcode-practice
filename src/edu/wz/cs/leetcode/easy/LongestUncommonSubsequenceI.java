package edu.wz.cs.leetcode.easy;

/**
 * 521. Longest Uncommon Subsequence I<br>
 * https://leetcode.com/problems/longest-uncommon-subsequence-i<br><br>
 * 
 * Given a group of two strings, you need to find the longest uncommon subsequence of this group of two strings. The
 * longest uncommon subsequence is defined as the longest subsequence of one of these strings and this subsequence
 * should not be any subsequence of the other strings.<br>
 * 
 * A subsequence is a sequence that can be derived from one sequence by deleting some characters without changing the
 * order of the remaining elements. Trivially, any string is a subsequence of itself and an empty string is a
 * subsequence of any string.<br>
 * 
 * The input will be two strings, and the output needs to be the length of the longest uncommon subsequence. If the
 * longest uncommon subsequence doesn't exist, return -1.<br><br>
 * 
 * Note:<br>
 * 1. Both strings' lengths will not exceed 100.<br>
 * 2. Only letters from a ~ z will appear in input strings.
 */
public class LongestUncommonSubsequenceI {
    
    public static int solution(String a, String b) {
        if (a.equals(b)) {
            return -1;
        }
        else {
            return Math.max(a.length(), b.length());
        }
    }
    
    public static void main(String[] args) {
        System.out.println(LongestUncommonSubsequenceI.solution("aba", "cdc"));
    }

}
