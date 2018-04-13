package edu.wz.cs.leetcode.medium;

import java.util.Arrays;

/**
 * 338. Counting Bits<br>
 * https://leetcode.com/problems/counting-bits<br><br>
 * 
 * Given a non negative integer number num. For every numbers i in the range 0 <= i <= num calculate the number of 1's
 * in their binary representation and return them as an array.<br>
 * 
 * Example:<br>
 * For num = 5 you should return [0,1,1,2,1,2].<br>
 * 
 * Follow up:<br>
 * 1. It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time
 * O(n) /possibly in a single pass?
 * 2. Space complexity should be O(n).
 * 3. Can you do it like a boss? Do it without using any builtin function like _builtin_popcount in c++ or in any other
 * language.
 */
public class CountingBits {

    public static int[] solution(int n) {
        int[] result = new int[n+1];
        for (int i = 0; i <= n; i++) {
            result[i] = helper(i);
        }
        return result;
    }
    
    private static int helper(int i) {
        int count = 0;
        while (i > 0) {
            count += (i & 1);
            i >>>= 1;
        }
        return count;
    }
    
    /**
     * 0: 0
     * 1: 1
     * 2: 1
     * 3: 2
     * 4: 1
     * 5: 2
     * 6: 2
     * 7: 3
     */
    public static int[] solutionX(int n) {
        int[] result = new int[n+1];
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                result[i] = result[i/2];
            }
            else {
                result[i] = result[i/2] + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(CountingBits.solution(5)));
        System.out.println(Arrays.toString(CountingBits.solutionX(5)));
        System.out.println(Arrays.toString(CountingBits.solution(20)));
        System.out.println(Arrays.toString(CountingBits.solutionX(20)));
    }
}
