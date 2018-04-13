package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 386. Lexicographical Numbers<br>
 * https://leetcode.com/problems/lexicographical-numbers<br><br>
 * 
 * Given an integer n, return [1 - n] in lexicographical order.<br>
 * 
 * For example, given 13, return: [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9].<br>
 * 
 * Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.
 */
public class LexicographicalNumbers {
    
    // this implementation will be TLE
    public static List<Integer> solution(int n) {
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = String.valueOf(i + 1);
        }
        Arrays.sort(arr);
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(Integer.parseInt(arr[i]));
        }
        return result;
    }
    
    public static List<Integer> solutionX(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            dfs(i, n, result);
        }
        return result;
    }
    
    private static void dfs(int current, int n, List<Integer> result) {
        if (current > n) {
            return;
        }
        else {
            result.add(current);
            for (int i = 0; i < 10; i++) {
                if (current * 10 + i > n) {
                    return;
                }
                dfs(current * 10 + i, n, result);
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println(LexicographicalNumbers.solution(13));
        System.out.println(LexicographicalNumbers.solutionX(13));
    }

}
