package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 241. Different Ways to Add Parentheses<br>
 * https://leetcode.com/problems/different-ways-to-add-parentheses<br><br>
 * 
 * Given a string of numbers and operators, return all possible results from computing all the different possible ways 
 * to group numbers and operators. The valid operators are +, - and *.
 */
public class DifferentWaysToAddParentheses {
    
    public static List<Integer> solution(String input) {
        List<Integer> result = new ArrayList<>();
        
        int n = input.length();
        for (int i = 0; i < n; i++) {
            char c = input.charAt(i);
            
            if (c == '-' || c == '+' || c == '*') {
                String strL = input.substring(0, i);
                String strR = input.substring(i + 1);
                
                List<Integer> left = solution(strL);
                List<Integer> right = solution(strR);
                for (int l : left) {
                    for (int r : right) {
                        int sum = 0;
                        if (c == '+') {
                            sum = l + r;
                        }
                        else if (c == '-') {
                            sum = l - r;
                        }
                        else if (c == '*') {
                            sum = l * r;
                        }
                        result.add(sum);
                    }
                }                
            }            
        }
        
        if (result.isEmpty()) {
            result.add(Integer.valueOf(input));
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(DifferentWaysToAddParentheses.solution("2-1-1"));
        System.out.println(DifferentWaysToAddParentheses.solution("2*3-4*5"));
    }

}
