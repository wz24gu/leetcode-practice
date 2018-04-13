package edu.wz.cs.leetcode.medium;

import java.util.Stack;

/**
 * 678. Valid Parenthesis String<br>
 * https://leetcode.com/problems/valid-parenthesis-string<br><br>
 * 
 * Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this 
 * string is valid. We define the validity of a string by these rules:<br>
 * 1. Any left parenthesis '(' must have a corresponding right parenthesis ')'.<br>
 * 2. Any right parenthesis ')' must have a corresponding left parenthesis '('.<br>
 * 3. Left parenthesis '(' must go before the corresponding right parenthesis ')'.<br>
 * 4. '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.<br>
 * 5. An empty string is also valid.<br>
 * 
 * Note: The string size will be in the range [1, 100].
 */
public class ValidParenthesisString {
    
    public static boolean solution(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        Stack<Integer> left = new Stack<>();
        Stack<Integer> star = new Stack<>();
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left.push(i);
            }
            else if (c == '*') {
                star.push(i);
            }
            else {
                if (left.isEmpty() && star.isEmpty()) {
                    return false;
                }
                if (!left.isEmpty()) {
                    left.pop();
                }
                else {
                    star.pop();
                }
            }
        }
        
        while (!left.isEmpty() && !star.isEmpty()) {
            if (left.peek() > star.peek()) {
                return false;
            }
            left.pop();
            star.pop();
        }
        
        return left.isEmpty();
    }
    
    public static boolean solutionX(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        int low = 0;
        int high = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                low++;
                high++;
            }
            else if (c == ')') {
                if (low > 0) {
                    low--;
                }
                high--;
            }
            else {
                if (low > 0) {
                    low--;
                }
                high++;
            }
            
            if (high < 0) {
                return false;
            }
        }
        
        return low == 0;
    }
    
    public static void main(String[] args) {
        System.out.println(ValidParenthesisString.solution("()"));
        System.out.println(ValidParenthesisString.solution("(*)"));
        System.out.println(ValidParenthesisString.solution("(*))"));
        
        System.out.println(ValidParenthesisString.solutionX("()"));
        System.out.println(ValidParenthesisString.solutionX("(*)"));
        System.out.println(ValidParenthesisString.solutionX("(*))"));
    }

}
