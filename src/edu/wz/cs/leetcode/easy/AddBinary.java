package edu.wz.cs.leetcode.easy;

/**
 * 67. Add Binary<br>
 * https://leetcode.com/problems/add-binary<br><br>
 * 
 * Given two binary strings, return their sum (also a binary string).<br>
 * 
 * For example, a = "11", b = "1", Return "100".
 */
public class AddBinary {
    
    public static String solution(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        
        while (i >= 0 || j >= 0) {
            int x = (i < 0) ? 0 : a.charAt(i) - '0';
            int y = (j < 0) ? 0 : b.charAt(j) - '0';
            int sum = x + y + carry;
            sb.insert(0, sum % 2);
            carry = sum / 2;
            i--;
            j--;
        }
        
        if (carry > 0) {  // don't forget
            sb.insert(0, carry);
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(AddBinary.solution("11", "111"));
    }

}
