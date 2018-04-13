package edu.wz.cs.leetcode.easy;

/**
 * 371. Sum of Two Integers<br>
 * https://leetcode.com/problems/sum-of-two-integers<br><br>
 * 
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -
 */
public class SumOfTwoIntegers {

    // this is a very genius solution
    // without carry: 0+0=0, 0+1=1, 1+0=1, 1+1=0; this is the same as ^
    // carry: 0+0=0, 0+1=0, 1+0=0, 1+1=1; this is the same as & and then left shift one position
    // recursively add sum and carry, until carry is 0
    public static int solution(int a, int b) {
        if (b == 0) {
            return a;
        }
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return solution(sum, carry);
    }
    
    public static void main(String[] args) {
        System.out.println(SumOfTwoIntegers.solution(1, 2));
    }

}
