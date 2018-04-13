package edu.wz.cs.leetcode.easy;

/**
 * 693. Binary Number with Alternating Bits<br>
 * https://leetcode.com/problems/binary-number-with-alternating-bits<br><br>
 * 
 * Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have
 * different values.
 */
public class BinaryNumberWithAlternatingBits {

    public static boolean solution(int n) {
        int bit = -1;
        while (n > 0) {
            if ((n & 1) == 1) {
                if (bit == 1) {
                    return false;
                }
                bit = 1;
            }
            else {
                if (bit == 0) {
                    return false;
                }
                bit = 0;
            }
            n >>= 1;
        }
        return true;
    }
    
    public static boolean solutionX(int n) {
        int d = n & 1;
        while ((n & 1) == d) {
            d ^= 1;
            n >>= 1;
        }
        return n == 0;
    }
    
    public static boolean solutionAlt(int n) {
        int pre = (n & 1);
        n >>= 1;
        while (n != 0) {
            int cur = (n & 1);
            if (pre == cur) {
                return false;
            }
            pre = cur;
            n >>= 1;
        }
        return true;
    }
    
    public static boolean solutionXX(int n) {
        int prev = -1;
        while (n != 0) {
            int curr = n & 1;
            if (prev != -1 && curr == prev) {
                return false;
            }
            prev = curr;
            n >>= 1;
        }
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(BinaryNumberWithAlternatingBits.solution(5));
        System.out.println(BinaryNumberWithAlternatingBits.solution(7));
        System.out.println(BinaryNumberWithAlternatingBits.solution(11));
        System.out.println(BinaryNumberWithAlternatingBits.solution(10));
        
        System.out.println(BinaryNumberWithAlternatingBits.solutionX(5));
        System.out.println(BinaryNumberWithAlternatingBits.solutionX(7));
        System.out.println(BinaryNumberWithAlternatingBits.solutionX(11));
        System.out.println(BinaryNumberWithAlternatingBits.solutionX(10));
        
        System.out.println(BinaryNumberWithAlternatingBits.solutionAlt(5));
        System.out.println(BinaryNumberWithAlternatingBits.solutionAlt(7));
        System.out.println(BinaryNumberWithAlternatingBits.solutionAlt(11));
        System.out.println(BinaryNumberWithAlternatingBits.solutionAlt(10));
        
        System.out.println(BinaryNumberWithAlternatingBits.solutionXX(5));
        System.out.println(BinaryNumberWithAlternatingBits.solutionXX(7));
        System.out.println(BinaryNumberWithAlternatingBits.solutionXX(11));
        System.out.println(BinaryNumberWithAlternatingBits.solutionXX(10));
    }

}
