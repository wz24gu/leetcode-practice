package edu.wz.cs.leetcode.medium;

import java.util.Arrays;

/**
 * 616. Add Bold Tag in String<br>
 * https://leetcode.com/problems/add-bold-tag-in-string<br><br>
 * 
 * Given a string s and a list of strings dict, you need to add a closed pair of bold tag <b> and </b> to wrap the 
 * substrings in s that exist in dict. If two such substrings overlap, you need to wrap them together by only one pair 
 * of closed bold tag. Also, if two substrings wrapped by bold tags are consecutive, you need to combine them.<br><br>
 * 
 * Note:<br>
 * 1. The given dict won't contain duplicates, and its length won't exceed 100.<br>
 * 2. All the strings in input have length in range [1, 1000].
 */
public class AddBoldTagInString {
    
    public static String solution(String s, String[] dict) {
        int n = s.length();
        boolean[] bold = new boolean[n];
        for (int i = 0, end = 0; i < n; i++) {
            for (String word : dict) {
                if (s.startsWith(word, i)) {
                    end = Math.max(end, i + word.length());
                }
            }
            bold[i] = end > i;
        }
        System.out.println(Arrays.toString(bold));
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (!bold[i]) {
                sb.append(s.charAt(i));
                continue;
            }
            int j = i;
            while (j < n && bold[j]) {
                j++;
            }
            sb.append("<b>" + s.substring(i, j) + "</b>");
            i = j - 1;
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        String[] dict = {"abc", "123"};
        System.out.println(AddBoldTagInString.solution("abcxyz123", dict));
        
        String[] dict2 = {"aaa", "aab", "bc"};
        System.out.println(AddBoldTagInString.solution("aaabbcc", dict2));
    }

}
