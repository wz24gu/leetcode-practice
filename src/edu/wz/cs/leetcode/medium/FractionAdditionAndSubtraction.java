package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 592. Fraction Addition and Subtraction<br>
 * https://leetcode.com/problems/fraction-addition-and-subtraction<br><br>
 * 
 * Given a string representing an expression of fraction addition and subtraction, you need to return the calculation 
 * result in string format. The final result should be irreducible fraction. If your final result is an integer, say 2, 
 * you need to change it to the format of fraction that has denominator 1. So in this case, 2 should be converted to 
 * 2/1.<br><br>
 * 
 * Note:<br>
 * 1. The input string only contains '0' to '9', '/', '+' and '-'. So does the output.<br>
 * 2. Each fraction (input and output) has format ±numerator/denominator. If the first input fraction or the output is 
 * positive, then '+' will be omitted.<br>
 * 3. The input only contains valid irreducible fractions, where the numerator and denominator of each fraction will 
 * always be in the range [1,10]. If the denominator is 1, it means this fraction is actually an integer in a fraction 
 * format defined above.
 * 4. The number of given fractions will be in the range [1,10].<br>
 * 5. The numerator and denominator of the final result are guaranteed to be valid and in the range of 32-bit int.
 */
public class FractionAdditionAndSubtraction {
    
    public static String solution(String expression) {
        List<String> nums = new ArrayList<>();
        int n = expression.length();
        
        int i = 0;
        int j = 0;
        while (j <= n) {
            if (j == n
                    || j != i && (expression.charAt(j) == '+' || expression.charAt(j) == '-')) {
                if (expression.charAt(i) == '+') {
                    nums.add(expression.substring(i + 1, j));
                }
                else {
                    nums.add(expression.substring(i, j));
                }
                i = j;
            }
            j++;
        }
        
        String result = "0/1";
        for (String num : nums) {
            result = add(result, num);
        }
        return result;
    }
    
    private static String add(String s1, String s2) {
        String[] sa1 = s1.split("/");
        String[] sa2 = s2.split("/");
        int n1 = Integer.parseInt(sa1[0]);
        int d1 = Integer.parseInt(sa1[1]);
        int n2 = Integer.parseInt(sa2[0]);
        int d2 = Integer.parseInt(sa2[1]);
        
        int n = n1 * d2 + n2 * d1;
        int d = d1 * d2;
        
        if (n == 0) {
            return "0/1";
        }
        
        boolean isNegative = n * d < 0;
        n = Math.abs(n);
        d = Math.abs(d);
        int gcd = gcd(n, d);
        
        return (isNegative ? "-" : "") + (n / gcd) + "/" + (d / gcd);
    }
    
    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    
    public static void main(String[] args) {
        System.out.println(FractionAdditionAndSubtraction.solution("-1/2+1/2"));
        System.out.println(FractionAdditionAndSubtraction.solution("-1/2+1/2+1/3"));
        System.out.println(FractionAdditionAndSubtraction.solution("1/3-1/2"));
        System.out.println(FractionAdditionAndSubtraction.solution("5/3+1/3"));
    }

}
