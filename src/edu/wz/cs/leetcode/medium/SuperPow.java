package edu.wz.cs.leetcode.medium;

/**
 * 372. Super Pow<br>
 * https://leetcode.com/problems/super-pow<br><br>
 * 
 * Your task is to calculate a^b mod 1337 where a is a positive integer and b is an extremely large positive integer given 
 * in the form of an array.
 */
public class SuperPow {
    
    public static int solution(int a, int[] b) {
        int result = 1;
        int n = b.length;
        for (int i = 0; i < n; i++) {
            result = pow(result, 10) * pow(a, b[i]) % 1337;
        }
        return result;
    }
    
    private static int pow(int x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x % 1337;
        }
        return pow(x % 1337, n / 2) * pow(x % 1337, n - n / 2) % 1337;
    }
    
    public static void main(String[] args) {
        int[] b = {3};
        System.out.println(SuperPow.solution(2, b));
        
        int[] b2 = {1, 0};
        System.out.println(SuperPow.solution(2, b2));
    }

}
