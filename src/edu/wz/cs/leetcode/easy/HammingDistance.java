package edu.wz.cs.leetcode.easy;

/**
 * 461. Hamming Distance<br/>
 * 
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Given two integers x and y, calculate the Hamming distance.<br/><br/>
 * 
 * Note:<br/>
 * 0 <= x, y <= 2 ^ 31
 */
public class HammingDistance {
    
    public static int solution(int x, int y) {
        int result = 0;        
        for (int i = 0; i < 32; i++) {
            if ((x & 1) != (y & 1)) {
                result++;
            }
            x >>= 1;
            y >>= 1;
        }        
        return result;
    }
    
    public static int solutionAlt(int x, int y) {
        int result = 0;
        int z = x ^ y;
        for (int i = 0; i < 32; i++) {
            if ((z & 1) == 1) {
                result++;
            }
            z >>= 1;  // if using while loop (not end after 32), should use unsigned shift here
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(HammingDistance.solution(1, 4));
        System.out.println(HammingDistance.solutionAlt(1, 4));
        System.out.println(HammingDistance.solution(100, 19));
        System.out.println(HammingDistance.solutionAlt(100, 19));
    }

}
