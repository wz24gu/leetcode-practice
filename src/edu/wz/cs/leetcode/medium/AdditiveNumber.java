package edu.wz.cs.leetcode.medium;

/**
 * 306. Additive Number<br>
 * https://leetcode.com/problems/additive-number<br><br>
 * 
 * Additive number is a string whose digits can form additive sequence.<br>
 * 
 * A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent 
 * number in the sequence must be the sum of the preceding two.<br>
 * 
 * For example:<br>
 * "112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.<br>
 * 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8<br>
 * 
 * "199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.<br>
 * 1 + 99 = 100, 99 + 100 = 199<br>
 * 
 * Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.<br>
 * 
 * Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.<br>
 * 
 * Follow up: How would you handle overflow for very large input integers?
 */
public class AdditiveNumber {
    
    public static boolean solution(String num) {
        int n = num.length();        
        for (int i = 1; i <= n / 2; i++) {
            for (int j = 1; Math.max(i, j) <= n - i - j; j++) {
                if (valid(i, j, num)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private static boolean valid(int i, int j, String num) {
        if (num.charAt(0) == '0' && i > 1) {
            return false;
        }
        if (num.charAt(0) == '0' && j > 1) {
            return false;
        }
        
        String sum;
        long x1 = Long.parseLong(num.substring(0, i));
        long x2 = Long.parseLong(num.substring(i, i + j));
        
        for (int start = i + j; start < num.length(); start += sum.length()) {
            x2 = x1 + x2;
            x1 = x2 - x1;
            sum = String.valueOf(x2);
            if (!num.startsWith(sum, start)) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean solutionAlt(String num) {
        int n = num.length();
        for (int i = 1; i < n / 2; i++) {
            if (num.charAt(0) == '0' && i > 1) {
                return false;
            }
            long x1 = Long.parseLong(num.substring(0, i));
            
            for (int j = 1; Math.max(i, j) <= n - i - j; j++) {
                if (num.charAt(i) == '0' && j > 1) {
                    break;
                }
                long x2 = Long.parseLong(num.substring(i, i + j));
                
                if (valid(x1, x2, j + 1, num)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private static boolean valid(long x1, long x2, int start, String num) {
        if (start == num.length()) {
            return true;
        }
        
        x2 = x1 + x2;
        x1 = x2 - x1;
        String sum = String.valueOf(x2);
        return num.startsWith(sum, start) && valid(x1, x2, start + sum.length(), num);
    }
    
    public static void main(String[] args) {
        System.out.println(AdditiveNumber.solution("112358"));
        System.out.println(AdditiveNumber.solution("199100199"));
        
        System.out.println(AdditiveNumber.solutionAlt("112358"));
        System.out.println(AdditiveNumber.solutionAlt("199100199"));
    }

}
