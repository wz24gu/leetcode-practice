package edu.wz.cs.leetcode.easy;

/**
 * 557. Reverse Words in a String III<br/>
 * 
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving
 * whitespace and initial word order.<br/><br/>
 * 
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */
public class ReverseWordsInStringIII {
    
    public static String solution(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        
        char[] arr = str.toCharArray();
        int start = 0;
        int end = 0;
        while (start < arr.length && end < arr.length) {
            // this while loop will take care of the last word in the string
            while (end < arr.length && arr[end] != ' ') {
                end++;
            }
            
            for (int i = start, j = end - 1; i < j; i++, j--) {
                char swap = arr[i];
                arr[i] = arr[j];
                arr[j] = swap;
            }
            end++;
            start = end;            
        }
        
        return new String(arr);
    }
    
    public static String solutionAlt(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        
        char[] arr = s.toCharArray();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == ' ') {
                continue;
            }
            
            int j = i + 1;
            while (j < n && arr[j] != ' ') {
                j++;
            }
            if (j > i + 1) {
                reverse(arr, i, j - 1);
            }
            i = j;
        }
        
        return new String(arr);
    }
    
    private static void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char swap = arr[i];
            arr[i] = arr[j];
            arr[j] = swap;
            i++;
            j--;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(ReverseWordsInStringIII.solution("Let's take LeetCode contest"));
        System.out.println(ReverseWordsInStringIII.solutionAlt("Let's take LeetCode contest"));
    }

}
