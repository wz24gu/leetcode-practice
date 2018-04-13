package edu.wz.cs.leetcode.medium;

/**
 * 537. Complex Number Multiplication<br>
 * https://leetcode.com/problems/complex-number-multiplication<br><br>
 * 
 * Given two strings representing two complex numbers. You need to return a string representing their multiplication.
 * Note i ^ 2 = -1 according to the definition.<br><br>
 * 
 * Note:<br>
 * 1. The input strings will not have extra blank.<br>
 * 2. The input strings will be given in the form of a + bi, where the integer a and b will both belong to the range of
 * [-100, 100]. And the output should be also in this form.
 */
public class ComplexNumberMultiplication {
    
    public static String solution(String a, String b) {
        String[] A = a.split("\\+");  // + is a meta character, should escape
        int a1 = Integer.parseInt(A[0]);
        int a2 = Integer.parseInt(A[1].substring(0, A[1].length() - 1));
        
        String[] B = b.split("\\+");
        int b1 = Integer.parseInt(B[0]);
        int b2 = Integer.parseInt(B[1].substring(0, B[1].length() - 1));
        
        int x = a1 * b1 - a2 * b2;
        int y = a1 * b2 + a2 * b1;
        return x + "+" + y + "i";
    }
    
    public static void main(String[] args) {
        System.out.println(ComplexNumberMultiplication.solution("1+1i", "1+1i"));
        System.out.println(ComplexNumberMultiplication.solution("1+-1i", "1+-1i"));
        System.out.println(ComplexNumberMultiplication.solution("1+1i", "1+-1i"));
    }

}
