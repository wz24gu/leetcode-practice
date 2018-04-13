package edu.wz.cs.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 762. Prime Number of Set Bits in Binary Representation<br>
 * https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation<br><br>
 * 
 * Given two integers L and R, find the count of numbers in the range [L, R] (inclusive) having a prime number of set 
 * bits in their binary representation.<br>
 * 
 * (Recall that the number of set bits an integer has is the number of 1s present when written in binary. For example, 
 * 21 written in binary is 10101 which has 3 set bits. Also, 1 is not a prime.)<br><br>
 * 
 * Note:<br>
 * 1. L, R will be integers L <= R in the range [1, 10^6].<br>
 * 2. R - L will be at most 10000.
 */
public class PrimeNumberOfSetBitsInBinaryRepresentation {

    public static int solution(int L, int R) {
        Set<Integer> set = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31));
        
        int count = 0;
        for (int i = L; i <= R; i++) {            
            if (set.contains(countBits(i))) {
                count++;
            }
        }
        return count;
    }
    
    private static int countBits(int n) {
        int count = 0;
        while (n != 0) {
            count += (n & 1);
            n >>>= 1;
        }
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println(PrimeNumberOfSetBitsInBinaryRepresentation.solution(6, 10));
        System.out.println(PrimeNumberOfSetBitsInBinaryRepresentation.solution(10, 15));
    }
    
}
