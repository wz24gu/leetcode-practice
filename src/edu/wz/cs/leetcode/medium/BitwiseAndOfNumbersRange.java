package edu.wz.cs.leetcode.medium;

/**
 * 201. Bitwise AND of Numbers Range<br>
 * https://leetcode.com/problems/bitwise-and-of-numbers-range<br><br>
 * 
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.<br>
 * 
 * For example, given the range [5, 7], you should return 4.
 */
public class BitwiseAndOfNumbersRange {
    
    public static int solution(int m, int n) {
        int count = 0;
        while (m != n) {
            m >>>= 1;
            n >>>= 1;
            count++;
        }
        return (m << count);
    }
    
    public static int solutionAlt(int m, int n) {
        int mask = 0xffffffff;
        while ((m & mask) != (n & mask)) {
            mask <<= 1;
        }
        return m & mask;
    }
    
    public static void main(String[] args) {
        System.out.println(BitwiseAndOfNumbersRange.solution(5, 7));
        System.out.println(BitwiseAndOfNumbersRange.solutionAlt(5, 7));
        
        System.out.println(BitwiseAndOfNumbersRange.solution(26, 30));
        System.out.println(BitwiseAndOfNumbersRange.solutionAlt(26, 30));
    }

}
