package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 60. Permutation Sequence<br>
 * https://leetcode.com/problems/permutation-sequence<br><br>
 * 
 * The set [1,2,3,…,n] contains a total of n! unique permutations.<br>
 * 
 * By listing and labeling all of the permutations in order, We get the following sequence (for n = 3):<br>
 * "123", "132", "213", "231", "312", "321"<br>
 * 
 * Given n and k, return the kth permutation sequence.<br>
 * 
 * Note: Given n will be between 1 and 9 inclusive.
 */
public class PermutationSequence {
    
    public static String solution(int n, int k) {
        List<Character> number = new ArrayList<>(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9'));
        
        int[] f = new int[n];
        f[0] = 1;
        for (int i = 1; i < n; i++) {
            f[i] = f[i-1] * i;
        }
        
        StringBuilder sb = new StringBuilder();
        k--;
        for (int i = n; i >= 1; i--) {
            int j = k / f[i-1];
            sb.append(number.get(j));
            k %= f[i-1];
            number.remove(number.get(j));
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(PermutationSequence.solution(4, 17));  // 3412
    }

}
