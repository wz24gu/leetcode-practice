package edu.wz.cs.leetcode.medium;

/**
 * 12. Integer to Roman<br>
 * https://leetcode.com/problems/integer-to-roman<br><br>
 * 
 * Given an integer, convert it to a roman numeral.<br>
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class IntegerToRoman {
    
    public static String solution(int num) {
        char[] roman = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        int[] value = {1000, 500, 100, 50, 10, 5, 1};
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 7; i += 2) {
            int x = num / value[i];
            
            if (x < 4) {
                for (int j = 1; j <= x; j++) {
                    sb.append(roman[i]);
                }
            }
            else if (x == 4) {
                sb.append(roman[i]).append(roman[i-1]);
            }
            else if (x > 4 && x < 9) {
                sb.append(roman[i-1]);
                for (int j = 6; j <= x; j++) {
                    sb.append(roman[i]);
                }
            }
            else if (x == 9) {
                sb.append(roman[i]).append(roman[i-2]);
            }
            
            num %= value[i];
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(IntegerToRoman.solution(3999));
        System.out.println(IntegerToRoman.solution(94));
    }

}
