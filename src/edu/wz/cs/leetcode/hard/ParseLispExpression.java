package edu.wz.cs.leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 736. Parse Lisp Expression<br>
 * https://leetcode.com/problems/parse-lisp-expression<br><br>
 * 
 * You are given a string expression representing a Lisp-like expression to return the integer value of.<br>
 * 
 * The syntax for these expressions is given as follows.<br>
 * 
 * 1. An expression is either an integer, a let-expression, an add-expression, a mult-expression, or an assigned variable. 
 * Expressions always evaluate to a single integer. (An integer could be positive or negative.)<br>
 * 2. A let-expression takes the form (let v1 e1 v2 e2 ... vn en expr), where let is always the string "let", then there 
 * are 1 or more pairs of alternating variables and expressions, meaning that the first variable v1 is assigned the value 
 * of the expression e1, the second variable v2 is assigned the value of the expression e2, and so on sequentially; and 
 * then the value of this let-expression is the value of the expression expr.<br>
 * 3. An add-expression takes the form (add e1 e2) where add is always the string "add", there are always two expressions 
 * e1, e2, and this expression evaluates to the addition of the evaluation of e1 and the evaluation of e2.<br>
 * 4. A mult-expression takes the form (mult e1 e2) where mult is always the string "mult", there are always two expressions 
 * e1, e2, and this expression evaluates to the multiplication of the evaluation of e1 and the evaluation of e2.<br>
 * 5. For the purposes of this question, we will use a smaller subset of variable names. A variable starts with a lowercase 
 * letter, then zero or more lowercase letters or digits. Additionally for your convenience, the names "add", "let", or 
 * "mult" are protected and will never be used as variable names.<br>
 * 6. Finally, there is the concept of scope. When an expression of a variable name is evaluated, within the context of 
 * that evaluation, the innermost scope (in terms of parentheses) is checked first for the value of that variable, and 
 * then outer scopes are checked sequentially. It is guaranteed that every expression is legal. Please see the examples 
 * for more details on scope.<br><br>
 * 
 * Note:<br>
 * 1. The given string expression is well formatted: There are no leading or trailing spaces, there is only a single 
 * space separating different components of the string, and no space between adjacent parentheses. The expression is 
 * guaranteed to be legal and evaluate to an integer.<br>
 * 2. The length of expression is at most 2000. (It is also non-empty, as that would not be a legal expression.)<br>
 * 3. The answer and all intermediate calculations of that answer are guaranteed to fit in a 32-bit integer.
 */
public class ParseLispExpression {
    
    public static int solution(String expression) {
        Map<String, Integer> map = new HashMap<>();
        return helper(expression, map);
    }
    
    private static int helper(String exp, Map<String, Integer> map) {
        if (exp.charAt(0) != '(') {
            if (exp.charAt(0) == '-' || exp.charAt(0) >= '0' && exp.charAt(0) <= '9') {
                return Integer.parseInt(exp);
            }
            else {
                return map.get(exp);
            }
        }
        
        Map<String, Integer> tmp = new HashMap<>();
        tmp.putAll(map);
        List<String> tokens = parse(exp.substring(exp.charAt(1) == 'm' ? 6 : 5, exp.length() - 1));
        if (exp.startsWith("(a")) {
            return helper(tokens.get(0), tmp) + helper(tokens.get(1), tmp);
        }
        else if (exp.startsWith("(m")) {
            return helper(tokens.get(0), tmp) * helper(tokens.get(1), tmp);
        }
        else {
            for (int i = 0; i < tokens.size() - 2; i += 2) {
                tmp.put(tokens.get(i), helper(tokens.get(i+1), tmp));
            }
            return helper(tokens.get(tokens.size() - 1), tmp);
        }
    }
    
    private static List<String> parse(String s) {
        List<String> res = new ArrayList<>();
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            }
            if (c == ')') {
                count--;
            }
            if (count == 0 && c == ' ') {
                res.add(new String(sb));
                sb = new StringBuilder();
            }
            else {
                sb.append(c);
            }
        }
        
        if (sb.length() > 0) {
            res.add(new String(sb));
        }
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(ParseLispExpression.solution("(add 1 2)"));
        System.out.println(ParseLispExpression.solution("(mult 3 (add 2 3))"));
        System.out.println(ParseLispExpression.solution("(let x 2 (mult x 5))"));
        System.out.println(ParseLispExpression.solution("(let x 2 (mult x (let x 3 y 4 (add x y))))"));
        System.out.println(ParseLispExpression.solution("(let x 3 x 2 x)"));
        System.out.println(ParseLispExpression.solution("(let x 1 y 2 x (add x y) (add x y))"));
        System.out.println(ParseLispExpression.solution("(let x 2 (add (let x 3 (let x 4 x)) x))"));
        System.out.println(ParseLispExpression.solution("(let a1 3 b2 (add a1 1) b2)"));
    }

}
