package edu.wz.cs.leetcode.medium;

import java.util.Stack;

/**
 * 316. Remove Duplicate Letters<br>
 * https://leetcode.com/problems/remove-duplicate-letters<br><br>
 * 
 * Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and 
 * only once. You must make sure your result is the smallest in lexicographical order among all possible results.
 */
public class RemoveDuplicateLetters {
    
    public static String solution(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        
        char[] arr = s.toCharArray();
        int[] freq = new int[26];
        for (char c : arr) {
            freq[c - 'a']++;
        }
        
        boolean[] marked = new boolean[26];
        Stack<Character> stack = new Stack<>();
        int idx = -1;
        
        for (char c : arr) {
            idx = c - 'a';
            freq[idx]--;
            if (marked[idx]) {
                continue;
            }
            
            while (!stack.isEmpty() && c < stack.peek() && freq[stack.peek() - 'a'] != 0) {
                marked[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            marked[idx] = true;            
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(RemoveDuplicateLetters.solution("bcabc"));
        System.out.println(RemoveDuplicateLetters.solution("cbacdcbc"));
    }

}
