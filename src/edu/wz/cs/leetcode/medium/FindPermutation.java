package edu.wz.cs.leetcode.medium;

import java.util.Arrays;

/**
 * 484. Find Permutation<br>
 * https://leetcode.com/problems/find-permutation<br><br>
 * 
 * By now, you are given a secret signature consisting of character 'D' and 'I'. 'D' represents a decreasing 
 * relationship between two numbers, 'I' represents an increasing relationship between two numbers. And our secret 
 * signature was constructed by a special integer array, which contains uniquely all the different number from 1 to n 
 * (n is the length of the secret signature plus 1). For example, the secret signature "DI" can be constructed by array 
 * [2,1,3] or [3,1,2], but won't be constructed by array [3,2,4] or [2,1,3,4], which are both illegal constructing 
 * special string that can't represent the "DI" secret signature.<br>
 * 
 * On the other hand, now your job is to find the lexicographically smallest permutation of [1, 2, ... n] could refer 
 * to the given secret signature in the input.<br><br>
 * 
 * Note:<br>
 * 1. The input string will only contain the character 'D' and 'I'.<br>
 * 2. The length of input string is a positive integer and will not exceed 10,000
 */
public class FindPermutation {

    public static int[] solution(String s) {        
        int n = s.length();
        int[] result = new int[n+1];  // the array will have string.length() + 1 elements
        for (int i = 0; i <= n; i++) {
            result[i] = i + 1;
        }
        
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == 'I') {
                i++;
            }
            else {
                int j = i;
                while (j < n && s.charAt(j) == 'D') {
                    j++;
                }
                reverse(result, i, j);
                i = j;
            }
        }
        return result;
    }
    
    private static void reverse(int[] array, int i, int j) {
        while (i < j) {
            int swap = array[i];
            array[i] = array[j];
            array[j] = swap;
            i++;
            j--;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(FindPermutation.solution("I")));
        System.out.println(Arrays.toString(FindPermutation.solution("DI")));
    }

}
