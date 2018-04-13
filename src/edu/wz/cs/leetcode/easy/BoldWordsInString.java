package edu.wz.cs.leetcode.easy;

/**
 * 758. Bold Words in String<br>
 * https://leetcode.com/problems/bold-words-in-string<br><br>
 * 
 * Given a set of keywords words and a string S, make all appearances of all keywords in S bold. Any letters between <b> 
 * and </b> tags become bold.<br>
 * 
 * The returned string should use the least number of tags possible, and of course the tags should form a valid combination.<br>
 * 
 * For example, given that words = ["ab", "bc"] and S = "aabcd", we should return "a<b>abc</b>d". Note that returning 
 * "a<b>a<b>b</b>c</b>d" would use more tags, so it is incorrect.<br><br>
 * 
 * Note:<br>
 * 1. words has length in range [0, 50].<br>
 * 2. words[i] has length in range [1, 10].<br>
 * 3. S has length in range [0, 500].<br>
 * 4. All characters in words[i] and S are lowercase letters.
 */
public class BoldWordsInString {
    
    public static String solution(String[] words, String S) {
        if (S == null || S.length() == 0 || words == null || words.length == 0) {
            return S;
        }
        
        int n = S.length();
        boolean[] bold = new boolean[n];        
        for (String word : words) {
            mark(S, word, bold);
        }        
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (!bold[i]) {
                sb.append(S.charAt(i));
                continue;
            }
            int j = i;
            while (j < n && bold[j]) {
                j++;
            }
            sb.append("<b>" + S.substring(i, j) + "</b>");
            i = j - 1;
        }
        
        return sb.toString();
    }
    
    private static void mark(String S, String word, boolean[] bold) {
        int n = S.length();
        int m = word.length();
        for (int i = 0; i <= n - m; i++) {
            String sub = S.substring(i, i + m);
            if (sub.equals(word)) {
                for (int j = i; j < i + m; j++) {
                    bold[j] = true;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        String S = "aabcd";
        String[] words = {"ab", "bc"};
        System.out.println(BoldWordsInString.solution(words, S));
    }

}
