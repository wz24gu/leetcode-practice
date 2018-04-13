package edu.wz.cs.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 166. Fraction to Recurring Decimal<br>
 * https://leetcode.com/problems/fraction-to-recurring-decimal<br><br>
 * 
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.<br>
 * 
 * If the fractional part is repeating, enclose the repeating part in parentheses.<br>
 * 
 * For example,<br>
 * 1. Given numerator = 1, denominator = 2, return "0.5".<br>
 * 2. Given numerator = 2, denominator = 1, return "2".<br>
 * 3. Given numerator = 2, denominator = 3, return "0.(6)".
 */
public class FractionToRecurringDecimal {
    
    public static String solution(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        if (numerator > 0 && denominator < 0 || numerator < 0 && denominator > 0) {
            sb.append("-");
        }
        
        long n = Math.abs((long) numerator);
        long d = Math.abs((long) denominator);
        
        sb.append(n / d);
        long r = n % d;
        if (r == 0) {
            return sb.toString();
        }
        
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        map.put(r, sb.length());
        while (r != 0) {
            r *= 10;
            sb.append(r / d);
            r %= d;
            if (map.containsKey(r)) {
                int idx = map.get(r);
                sb.insert(idx, "(");
                sb.append(")");
                break;
            }
            else {
                map.put(r, sb.length());
            }
        }
        
        return sb.toString();        
    }
    
    public static void main(String[] args) {
        System.out.println(FractionToRecurringDecimal.solution(1, 2));
        System.out.println(FractionToRecurringDecimal.solution(2, 1));
        System.out.println(FractionToRecurringDecimal.solution(2, 3));
    }

}
