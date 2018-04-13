package edu.wz.cs.leetcode.easy;

/**
 * 191. Number of 1 Bits<br>
 * https://leetcode.com/problems/number-of-1-bits<br><br>
 * 
 * Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming 
 * weight).<br>
 * 
 * For example, the 32-bit integer '11' has binary representation 00000000000000000000000000001011, so the function 
 * should return 3.
 */
public class NumberOfOneBits {

    public static int solution(int n) {
        int count = 0;
        while (n != 0) {
            count += (n & 1);
            n >>>= 1;  // unsigned shift
        }
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println(NumberOfOneBits.solution(11));
        System.out.println(NumberOfOneBits.solution(-1));
    }

}
