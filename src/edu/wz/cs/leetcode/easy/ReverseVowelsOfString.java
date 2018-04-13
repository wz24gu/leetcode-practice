package edu.wz.cs.leetcode.easy;

/**
 * 345. Reverse Vowels of a String<br>
 * https://leetcode.com/problems/reverse-vowels-of-a-string<br><br>
 * 
 * Write a function that takes a string as input and reverse only the vowels of a string.<br>
 * 
 * Example 1: Given s = "hello", return "holle".<br>
 * 
 * Example 2: Given s = "leetcode", return "leotcede".
 */
public class ReverseVowelsOfString {
    
    public static String solution(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        
        char[] array = s.toCharArray();
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            while (i < j && !isVowel(array[i])) {
                i++;
            }
            while (j > i && !isVowel(array[j])) {
                j--;
            }
            if (i >= j) {
                break;
            }
            
            char swap = array[i];
            array[i] = array[j];
            array[j] = swap;            
            i++;
            j--;
        }
        
        return new String(array);
    }
    
    private static boolean isVowel(char c) {
        return c == 'a' || c == 'A'
            || c == 'e' || c == 'E'
            || c == 'i' || c == 'I'
            || c == 'o' || c == 'O'
            || c == 'u' || c == 'U';
    }
    
    public static void main(String[] args) {
        System.out.println(ReverseVowelsOfString.solution("hello"));
        System.out.println(ReverseVowelsOfString.solution("leetcode"));
    }

}
