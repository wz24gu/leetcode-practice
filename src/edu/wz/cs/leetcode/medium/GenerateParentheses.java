package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses<br>
 * https://leetcode.com/problems/generate-parentheses<br><br>
 * 
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */
public class GenerateParentheses {
    
    public static List<String> solution(int n) {
        List<String> result = new ArrayList<>();
        helper(n, n, "", result);
        return result;
    }
    
    private static void helper(int left, int right, String out, List<String> result) {
        if (left < 0 || right < 0 || left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            result.add(out);
            return;
        }
        
        helper(left - 1, right, out + "(", result);
        helper(left, right - 1, out + ")", result);
    }
    
    public static void main(String[] args) {
        System.out.println(GenerateParentheses.solution(1));
        System.out.println(GenerateParentheses.solution(2));
        System.out.println(GenerateParentheses.solution(3));
    }

}
