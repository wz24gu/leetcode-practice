package edu.wz.cs.leetcode.medium;

/**
 * 186. Reverse Words in a String II<br>
 * https://leetcode.com/problems/reverse-words-in-a-string-ii<br><br>
 * 
 * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.<br>
 * 
 * The input string does not contain leading or trailing spaces and the words are always separated by a single space.<br>
 * 
 * For example, Given s = "the sky is blue", return "blue is sky the".<br>
 * 
 * Could you do it in-place without allocating extra space?
 */
public class ReverseWordsInStringII {
    
    public static void solution(char[] str) {
        // reverse the whole string
        reverse(str, 0, str.length - 1);
        
        // reverse each word
        int n = str.length;
        int i = 0;        
        while (i < n) {
            int j = i;
            while (j < n && str[j] != ' ') {
                j++;
            }
            reverse(str, i, j - 1);
            i = j + 1;
        }
    }
    
    private static void reverse(char[] str, int i, int j) {
        while (i < j) {
            char swap = str[i];
            str[i] = str[j];
            str[j] = swap;
            i++;
            j--;
        }
    }
    
    public static void main(String[] args) {
        char[] str = "the sky is blue".toCharArray();
        ReverseWordsInStringII.solution(str);
        System.out.println(new String(str));        
    }

}
