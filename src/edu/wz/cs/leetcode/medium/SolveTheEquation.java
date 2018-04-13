package edu.wz.cs.leetcode.medium;

/**
 * 640. Solve the Equation<br>
 * https://leetcode.com/problems/solve-the-equation<br><br>
 * 
 * Solve a given equation and return the value of x in the form of string "x=#value". The equation contains only '+', '-' 
 * operation, the variable x and its coefficient.<br>
 * 
 * If there is no solution for the equation, return "No solution".<br>
 * 
 * If there are infinite solutions for the equation, return "Infinite solutions".<br>
 * 
 * If there is exactly one solution for the equation, we ensure that the value of x is an integer.
 */
public class SolveTheEquation {
    
    public static String solution(String equation) {
        int a = 0;
        int b = 0;
        int sign = 1;
        
        int n = equation.length();
        int i = 0;
        for (int j = 0; j < n; j++) {
            char c = equation.charAt(j);
            
            if (c == '+' || c == '-') {
                if (j > i) {
                    b += Integer.parseInt(equation.substring(i, j)) * sign;
                }
                i = j;
            }
            else if (c == 'x') {
                if (i == j || equation.charAt(j-1) == '+') {
                    a += sign;
                }
                else if (equation.charAt(j-1) == '-') {
                    a -= sign;
                }
                else {
                    a += Integer.parseInt(equation.substring(i, j)) * sign;
                }
                i = j + 1;
            }
            else if (c == '=') {
                if (j > i) {
                    b += Integer.parseInt(equation.substring(i, j)) * sign;
                }
                sign = -1;
                i = j + 1;
            }
        }
        
        if (i < n) {
            b += Integer.parseInt(equation.substring(i)) * sign;
        }
        
        if (a == 0 && b == 0) {
            return "Infinite solutions";
        }
        else if (a == 0 && b != 0) {
            return "No solution";
        }
        else {
            return "x=" + (-b / a);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(SolveTheEquation.solution("x+5-3+x=6+x-2"));
        System.out.println(SolveTheEquation.solution("x=x"));
        System.out.println(SolveTheEquation.solution("2x=x"));
        System.out.println(SolveTheEquation.solution("2x+3x-6x=x+2"));
        System.out.println(SolveTheEquation.solution("x=x+2"));
    }

}
