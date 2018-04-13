package edu.wz.cs.leetcode.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 301. Remove Invalid Parentheses<br>
 * https://leetcode.com/problems/remove-invalid-parentheses<br><br>
 * 
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.<br>
 * 
 * Note: The input string may contain letters other than the parentheses ( and ).
 */
public class RemoveInvalidParentheses {
    
    public static List<String> solution(String s) {
        List<String> result = new ArrayList<>();
        
        Set<String> set = new HashSet<>();
        set.add(s);
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        boolean found = false;
        
        while (!queue.isEmpty()) {
            String t = queue.poll();
            if (valid(t)) {
                result.add(t);
                found = true;
            }
            
            if (found) {
                continue;
            }
            
            int n = t.length();
            for (int i = 0; i < n; i++) {
                if (t.charAt(i) != '(' && t.charAt(i) != ')') {
                    continue;
                }
                String str = t.substring(0, i) + t.substring(i + 1);
                if (!set.contains(str)) {
                    queue.offer(str);
                    set.add(str);
                }
            }
        }
        
        return result;
    }
    
    private static boolean valid(String t) {
        int count = 0;
        int n = t.length();
        for (int i = 0; i < n; i++) {
            if (t.charAt(i) == '(') {
                count++;
            }
            else if (t.charAt(i) == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }
    
    public static List<String> solutionX(String s) {
        List<String> result = new ArrayList<>();
        helper(s, result, 0, 0, new char[] {'(', ')'});
        return result;
    }
    
    private static void helper(String s, List<String> result, int last_i, int last_j, char[] par) {
        for (int i = last_i, count = 0; i < s.length(); i++) {
            if (s.charAt(i) == par[0]) {
                count++;
            }
            if (s.charAt(i) == par[1]) {
                count--;
            }
            if (count >= 0) {
                continue;
            }
            
            // found invalid
            for (int j = last_j; j <= i; j++) {
                if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1])) {
                    helper(s.substring(0, j) + s.substring(j + 1), result, i, j, par);
                }
            }
            return;   
        }
        
        String reversed = new StringBuilder(s).reverse().toString();
        if (par[0] == '(') {
            helper(reversed, result, 0, 0, new char[] {')', '('});
        }
        else {
            result.add(reversed);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(RemoveInvalidParentheses.solution("()())()"));
        System.out.println(RemoveInvalidParentheses.solution("(a)())()"));
        System.out.println(RemoveInvalidParentheses.solution(")("));
        
        System.out.println(RemoveInvalidParentheses.solutionX("()())()"));
        System.out.println(RemoveInvalidParentheses.solutionX("(a)())()"));
        System.out.println(RemoveInvalidParentheses.solutionX(")("));
    }

}
