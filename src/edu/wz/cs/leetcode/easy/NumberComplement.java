package edu.wz.cs.leetcode.easy;

/**
 * 476. Number Complement<br/>
 * 
 * Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary
 * representation.<br/>
 * 
 * Note:<br/>
 * 1. The given integer is guaranteed to fit within the range of a 32-bit signed integer.<br/>
 * 2. You could assume no leading zero bit in the integer's binary representation.
 */
public class NumberComplement {
    
    public static int solution(int num) {
        boolean start = false;
        for (int i = 31; i >= 0; i--) {
            if (((num >> i) & 1) == 1) {  // find the first 1 bit and set start as true
                start = true;
            }
            if (start) {
                num ^= (1 << i);
            }
        }
        return num;
    }
    
    public static int solutionAlt(int num) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if (num == 0) {
                break;
            }
            int n = (num & 1) ^ 1;
            result += (n << i);
            num >>= 1;
        }
        return result;
    }
    
    public static int solutionAlt2(int num) {
        int result = 0;
        for (int i = 0; i < 32 && num != 0; i++) {
            int bit = (num & 1) == 1 ? 0 : 1;
            result |= (bit << i);
            num >>>= 1;            
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(NumberComplement.solution(5));
        System.out.println(NumberComplement.solutionAlt(5));
        System.out.println(NumberComplement.solutionAlt2(5));
        
        System.out.println(NumberComplement.solution(1));
        System.out.println(NumberComplement.solutionAlt(1));
        System.out.println(NumberComplement.solutionAlt2(1));
    }

}
