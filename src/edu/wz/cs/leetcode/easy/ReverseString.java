package edu.wz.cs.leetcode.easy;

/**
 * 344. Reverse String<br/>
 * 
 * Write a function that takes a string as input and returns the string reversed.
 */
public class ReverseString {
    
    public static String solution(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        
        char[] arr = s.toCharArray();
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            char swap = arr[i];
            arr[i] = arr[j];
            arr[j] = swap;
        }        
        return new String(arr);
    }
    
    public static void main(String[] args) {
        System.out.println(ReverseString.solution("hello"));
    }

}
