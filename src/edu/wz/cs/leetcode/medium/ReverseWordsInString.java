package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 151. Reverse Words in a String<br>
 * https://leetcode.com/problems/reverse-words-in-a-string<br><br>
 * 
 * Given an input string, reverse the string word by word.<br>
 * 
 * For example, Given s = "the sky is blue", return "blue is sky the".<br>
 * 
 * Clarification<br>
 * 1. What constitutes a word?<br>
 * A sequence of non-space characters constitutes a word.<br>
 * 2. Could the input string contain leading or trailing spaces?<br>
 * Yes. However, your reversed string should not contain leading or trailing spaces.<br>
 * How about multiple spaces between two words?<br>
 * Reduce them to a single space in the reversed string.
 */
public class ReverseWordsInString {
    
    public static String solution(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        
        char[] arr = trim(s);
        int n = arr.length;
        reverse(arr, 0, n - 1);
        
        int i = 0;
        int j = 0;
        while (j < n) {
            while (j < n && arr[j] != ' ') {
                j++;
            }
            reverse(arr, i, j - 1);
            j++;
            i = j;
        }
        return new String(arr);
    }
    
    private static char[] trim(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int i = 0;
        int j = 0;
        
        while (j < n) {
            while (j < n && arr[j] == ' ') {
                j++;
            }
            while (j < n && arr[j] != ' ') {
                arr[i++] = arr[j++];
            }
            if (j < n) {
                arr[i++] = ' ';
            }
        }
        return Arrays.copyOfRange(arr, 0, i);
    }
    
    private static void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char c = arr[i];
            arr[i] = arr[j];
            arr[j] = c;
            i++;
            j--;
        }
    }

    public static String solutionX(String s) {
        String[] arr = s.trim().split("\\s+");
        List<String> list = new ArrayList<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            list.add(arr[i]);
        }
        return String.join(" ", list);
    }
    
    public static void main(String[] args) {
        System.out.println(ReverseWordsInString.solution("the sky is blue"));
        System.out.println(ReverseWordsInString.solutionX("the sky is blue"));
    }

}
