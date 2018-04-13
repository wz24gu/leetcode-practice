package edu.wz.cs.leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 770. Basic Calculator IV<br>
 * https://leetcode.com/problems/basic-calculator-iv<br><br>
 * 
 * Given an expression such as expression = "e + 8 - a + 5" and an evaluation map such as {"e": 1} (given in terms of 
 * evalvars = ["e"] and evalints = [1]), return a list of tokens representing the simplified expression, such as ["-1*a","14"]<br>
 * 
 * An expression alternates chunks and symbols, with a space separating each chunk and symbol.<br>
 * A chunk is either an expression in parentheses, a variable, or a non-negative integer.<br>
 * A variable is a string of lowercase letters (not including digits.) Note that variables can be multiple letters, and 
 * note that variables never have a leading coefficient or unary operator like "2x" or "-x".<br>
 * Expressions are evaluated in the usual order: brackets first, then multiplication, then addition and subtraction. 
 * For example, expression = "1 + 2 * 3" has an answer of ["7"].<br>
 * 
 * The format of the output is as follows:<br>
 * For each term of free variables with non-zero coefficient, we write the free variables within a term in sorted order 
 * lexicographically. For example, we would never write a term like "b*a*c", only "a*b*c".<br>
 * Terms have degree equal to the number of free variables being multiplied, counting multiplicity. (For example, 
 * "a*a*b*c" has degree 4.) We write the largest degree terms of our answer first, breaking ties by lexicographic order 
 * ignoring the leading coefficient of the term.<br>
 * The leading coefficient of the term is placed directly to the left with an asterisk separating it from the variables 
 * (if they exist.) A leading coefficient of 1 is still printed.<br>
 * An example of a well formatted answer is ["-2*a*a*a", "3*a*a*b", "3*b*b", "4*a", "5*c", "-6"]<br>
 * Terms (including constant terms) with coefficient 0 are not included. For example, an expression of "0" has an output 
 * of [].<br><br>
 * 
 * Note:<br>
 * 1. expression will have length in range [1, 250].<br>
 * 2. evalvars, evalints will have equal lengths in range [0, 100].
 */
public class BasicCalculatorIV {
    
    private static class Token {
        int coefficient;        
        String operator;
        List<String> terms;
        
        public Token(int coefficient, String operator, String variable) {
            this.coefficient = coefficient;
            this.operator = operator;
            terms = new ArrayList<String>();
            if (!variable.isEmpty()) {
                terms.add(variable);
            }
        }
        
        public boolean isOperator() {
            return operator.equals("+") || operator.equals("-") || operator.equals("*");
        }
        
        public String getKey() {
            String res = "";
            Collections.sort(terms);
            for (int i = 0; i < terms.size(); i++) {
                if (!res.isEmpty()) {
                    res += "*";
                }
                res += terms.get(i);
            }
            return res;
        }
    }
    
    public static List<String> solution(String expression, String[] evalvars, int[] evalints) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < evalvars.length; i++) {
            map.put(evalvars[i], evalints[i]);
        }
        
        Stack<Token> stack = new Stack<>();
        Stack<List<Token>> calc = new Stack<>();
        Queue<Token> queue = new LinkedList<>();
        
        int i = 0;
        int n = expression.length();
        while (i < n) {
            char c = expression.charAt(i);
            if (c == '(') {
                Token token = new Token(0, "(", "");
                stack.push(token);
                i++;
            }
            else if (c == ')') {
                while (!stack.isEmpty() && !stack.peek().operator.equals("(")) {
                    queue.add(stack.pop());
                }
                stack.pop();
                i++;
            }
            else if (c == '+' || c == '-' || c == '*') {
                Token token = new Token(0, c + "", "");
                while (!stack.isEmpty() && !stack.peek().operator.equals("(")
                        && !((stack.peek().operator.equals("+") || stack.peek().operator.equals("-")) && c == '*')) {
                    queue.add(stack.pop());
                }
                stack.push(token);
                i++;
            }
            else if (c == ' ') {
                i++;
            }
            else {
                int coefficient = 1;
                int j = i + 1;
                Token token = null;
                
                if (Character.isDigit(c)) {
                    while (j < n && Character.isDigit(expression.charAt(j))) {
                        j++;
                    }
                    coefficient = Integer.parseInt(expression.substring(i, j));
                    token = new Token(coefficient, "", "");
                }
                else {
                    while (j < n && Character.isAlphabetic(c)) {
                        j++;
                    }
                    String var = expression.substring(i, j);
                    if (!map.containsKey(var)) {
                        token = new Token(coefficient, "", var);
                    }
                    else {
                        token = new Token(map.get(var), "", "");
                    }
                }
                i = j;
                queue.add(token);
            }
        }
        
        while (!stack.empty()) {
            queue.add(stack.pop());
        }
        
        while (!queue.isEmpty()) {
            Token token = queue.poll();
            if (token.isOperator()) {
                List<Token> op2 = calc.pop();
                List<Token> op1 = calc.pop();
                if (token.operator.equals("+")) {
                    op1.addAll(op2);
                    calc.push(op1);
                }
                else if (token.operator.equals("-")) {
                    for (Token t : op2) {
                        t.coefficient -= t.coefficient;
                        op1.add(token);
                    }
                    calc.push(op1);
                }
                else {
                    List<Token> list = new ArrayList<>();
                    for (Token t1 : op1) {
                        for (Token t2 : op2) {
                            Token mt = new Token(t1.coefficient * t2.coefficient, "", "");
                            mt.terms.addAll(t1.terms);
                            mt.terms.addAll(t2.terms);
                            list.add(mt);
                        }
                    }
                    calc.push(list);
                }                
            }
            else {
                List<Token> list = new ArrayList<>();
                list.add(token);
                calc.push(list);
            }
        }
        
        List<Token> list = calc.pop();
        Map<String, Integer> map_co = new HashMap<>();
        Map<Integer, Set<String>> degree = new TreeMap<>();
        for (Token token : list) {
            String key = token.getKey();
            int c = map_co.getOrDefault(key, 0) + token.coefficient;
            map_co.put(key, c);
            
            int d = token.terms.size();
            Set<String> s = degree.getOrDefault(d, new TreeSet<String>());
            s.add(key);
            degree.put(d, s);
        }
        
        List<String> res = new ArrayList<>();
        for (Integer d : degree.keySet()) {
            for (String term : degree.get(d)) {
                int coef = map_co.get(term);
                if (coef != 0) {
                    res.add(coef + (term.isEmpty() ? "" : "*") + term);
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        String[] evalvars = {"e"};
        int[] evalints = {1};
        System.out.println(BasicCalculatorIV.solution("e + 8 - a + 5", evalvars, evalints));
    }

}
