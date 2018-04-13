package edu.wz.cs.leetcode.medium;

import java.util.Stack;

/**
 * 394. Decode String<br>
 * https://leetcode.com/problems/decode-string<br><br>
 * 
 * Given an encoded string, return it's decoded string.<br>
 * 
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated 
 * exactly k times. Note that k is guaranteed to be a positive integer.<br>
 * 
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.<br>
 * 
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those 
 * repeat numbers, k. For example, there won't be input like 3a or 2[4].
 */
public class DecodeString {
    
    public static String solution(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                int num_begin = i;
                while (s.charAt(i) != '[') {
                    i++;
                }
                int num = Integer.valueOf(s.substring(num_begin, i));
                
                i++;
                int str_begin = i;
                int count = 1;
                while (count != 0) {
                    if (s.charAt(i) == '[') {
                        count++;
                    }
                    else if (s.charAt(i) == ']') {
                        count--;
                    }
                    i++;
                }
                i--;
                
                String str = solution(s.substring(str_begin, i));
                for (int j = 0; j < num; j++) {
                    sb.append(str);
                }                
            }
            else {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
    
    public static String solutionAlt(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        Stack<Integer> stackInt = new Stack<>();
        Stack<StringBuilder> stackStr = new Stack<>();
        
        StringBuilder current = new StringBuilder();
        int k = 0;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                k = k * 10 + c - '0';
            }
            else if (c == '[') {
                stackInt.push(k);
                stackStr.push(current);
                current = new StringBuilder();
                k = 0;
            }
            else if (c == ']') {
                StringBuilder tmp = current;
                current = stackStr.pop();
                int n = stackInt.pop();
                for (int i = 0; i < n; i++) {
                    current.append(tmp);
                }
            }
            else {
                current.append(c);
            }
        }
        
        return current.toString();   
    }
    
    public static void main(String[] args) {
        System.out.println(DecodeString.solution("3[a]2[bc]"));
        System.out.println(DecodeString.solution("3[a2[c]]"));
        System.out.println(DecodeString.solution("2[abc]3[cd]ef"));
        
        System.out.println(DecodeString.solutionAlt("3[a]2[bc]"));
        System.out.println(DecodeString.solutionAlt("3[a2[c]]"));
        System.out.println(DecodeString.solutionAlt("2[abc]3[cd]ef"));
    }

}
