package edu.wz.cs.leetcode.easy;

/**
 * 408. Valid Word Abbreviation<br>
 * https://leetcode.com/problems/valid-word-abbreviation<br>
 * 
 * Given a non-empty string s and an abbreviation abbr, return whether the string matches with the given abbreviation.<br>
 * 
 * A string such as "word" contains only the following valid abbreviations:
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]<br>
 * 
 * Notice that only the above abbreviations are valid abbreviations of the string "word". Any other string is not a 
 * valid abbreviation of "word".<br>
 * 
 * Note: Assume s contains only lowercase letters and abbr contains only lowercase letters and digits.
 */
public class ValidWordAbbreviation {
    
    public static boolean solution(String word, String abbr) {
        int i = 0, m = word.length();
        int j = 0, n = abbr.length();
        
        while (i < m && j < n) {
            if (digit(abbr.charAt(j))) {
                if (abbr.charAt(j) == '0') {
                    return false;
                }
                
                int skip = 0;
                while (j < n && digit(abbr.charAt(j))) {
                    skip = skip * 10 + (abbr.charAt(j) - '0');
                    j++;
                }
                i += skip;
            }
            else {
                if (word.charAt(i) != abbr.charAt(j)) {
                    return false;
                }
                i++;
                j++;
            }
        }
        
        return i == m && j == n;
    }
    
    private static boolean digit(char c) {
        return c >= '0' && c <= '9';
    }
    
    public static void main(String[] args) {
        System.out.println(ValidWordAbbreviation.solution("internationalization", "i12iz4n"));
        System.out.println(ValidWordAbbreviation.solution("apple", "a2e"));
    }

}
