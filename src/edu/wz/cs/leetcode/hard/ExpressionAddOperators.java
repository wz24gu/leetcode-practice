package edu.wz.cs.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 282. Expression Add Operators<br>
 * https://leetcode.com/problems/expression-add-operators<br><br>
 * 
 * Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators 
 * (not unary) +, -, or * between the digits so they evaluate to the target value.
 */
public class ExpressionAddOperators {
    
    public static List<String> solution(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return result;
        }
        
        backtrack(num, 0, 0, 0, target, "", result);
        return result;
    }
    
    private static void backtrack(String num, int pos, long eval, long multi, int target, String path, List<String> result) {
        int n = num.length();
        if (pos == n) {
            if (target == eval) {
                result.add(path);
                return;
            }
        }
        
        for (int i = pos; i < n; i++) {
            if (i != pos && num.charAt(pos) == '0') {
                break;
            }
            
            long curr = Long.parseLong(num.substring(pos, i+1));
            if (pos == 0) {
                backtrack(num, i + 1, curr, curr, target, path + curr, result);
            }
            else {
                backtrack(num, i + 1, eval + curr, curr, target, path + "+" + curr, result);
                backtrack(num, i + 1, eval - curr, -curr, target, path + "-" + curr, result);
                backtrack(num, i + 1, eval - multi + multi * curr, multi * curr, target, path + "*" + curr, result);
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println(ExpressionAddOperators.solution("123", 6));
        System.out.println(ExpressionAddOperators.solution("232", 8));
        System.out.println(ExpressionAddOperators.solution("105", 5));
        System.out.println(ExpressionAddOperators.solution("00", 0));
        System.out.println(ExpressionAddOperators.solution("3456237490", 9191));
    }

}
