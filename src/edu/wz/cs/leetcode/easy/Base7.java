package edu.wz.cs.leetcode.easy;

/**
 * 504. Base 7<br>
 * https://leetcode.com/problems/base-7<br><br>
 * 
 * Given an integer, return its base 7 string.<br>
 * 
 * Note: The input will be in range of [-1e7, 1e7]
 */
public class Base7 {

    public static String solution(int num) {
        if (num == 0) {
            return "0";
        }        
        
        boolean negative = num < 0 ? true : false;        
        StringBuilder sb = new StringBuilder();
        num = Math.abs(num);
        while (num != 0) {
            sb.insert(0, num % 7);
            num /= 7;
        }
        if (negative) {
            sb.insert(0, "-");
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(Base7.solution(100));
        System.out.println(Base7.solution(-7));
        System.out.println(Base7.solution(0));
    }

}
