package edu.wz.cs.leetcode.hard;

/**
 * 65. Valid Number<br>
 * https://leetcode.com/problems/valid-number<br><br>
 * 
 * Validate if a given string is numeric.<br>
 * Some examples:<br>
 * "0" => true<br>
 * " 0.1 " => true<br>
 * "abc" => false<br>
 * "1 a" => false<br>
 * "2e10" => true<br>
 * 
 * Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before 
 * implementing one.
 */
public class ValidNumber {
    
    public static boolean solution(String s) {
        s = s.trim();
        int n = s.length();
        
        boolean point = false;
        boolean e = false;
        boolean number = false;
        boolean numAfterE = true;
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                number = true;
                numAfterE = true;
            }
            else if (c == '.') {
                if (e || point) {
                    return false;
                }
                point = true;
            }
            else if (c == 'e') {
                if (e || !number) {
                    return false;
                }
                numAfterE = false;
                e = true;
            }
            else if (c == '+' || c == '-') {
                if (i != 0 && s.charAt(i-1) != 'e') {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        
        return number && numAfterE;
    }
    
    public static void main(String[] args) {
        System.out.println(ValidNumber.solution("0"));
        System.out.println(ValidNumber.solution("0.1"));
        System.out.println(ValidNumber.solution("abc"));
        System.out.println(ValidNumber.solution("1 a"));
        System.out.println(ValidNumber.solution("2e10"));
    }

}
