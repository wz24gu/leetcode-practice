package edu.wz.cs.leetcode.medium;

import java.util.Arrays;
import java.util.Stack;

/**
 * 646. Maximum Length of Pair Chain<br>
 * https://leetcode.com/problems/maximum-length-of-pair-chain<br><br>
 * 
 * You are given n pairs of numbers. In every pair, the first number is always smaller than the second number. Now, we 
 * define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of pairs can be formed in this 
 * fashion.<br>
 * 
 * Given a set of pairs, find the length longest chain which can be formed. You needn't use up all the given pairs. You 
 * can select pairs in any order.<br>
 * 
 * Note: The number of given pairs will be in the range [1, 1000].
 */
public class MaximumLengthOfPairChain {
    
    public static int solution(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        
        Stack<int[]> stack = new Stack<>();
        stack.push(pairs[0]);
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > stack.peek()[1]) {
                stack.push(pairs[i]);
            }
        }
        return stack.size();
    }
    
    public static void main(String[] args) {
        int[][] pairs = { {1, 2}, {2, 3}, {3, 4} };
        System.out.println(MaximumLengthOfPairChain.solution(pairs));
    }

}
