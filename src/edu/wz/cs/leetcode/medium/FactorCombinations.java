package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 254. Factor Combinations<br>
 * https://leetcode.com/problems/factor-combinations<br><br>
 * 
 * Numbers can be regarded as product of its factors. For example,<br>
 * 8 = 2 x 2 x 2; = 2 x 4.<br>
 * Write a function that takes an integer n and return all possible combinations of its factors.<br><br>
 * 
 * Note:<br>
 * 1. You may assume that n is always positive.<br>
 * 2. Factors should be greater than 1 and less than n.
 */
public class FactorCombinations {
    
    public static List<List<Integer>> solution(int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (n <= 1) {
            return result;
        }
        
        List<Integer> list = new ArrayList<>();
        backtrack(n, 2, list, result);
        return result;        
    }
    
    private static void backtrack(int n, int start, List<Integer> list, List<List<Integer>> result) {
        if (n == 1) {
            if (list.size() > 1) {
                result.add(new ArrayList<Integer>(list));
            }
        }
        else {
            for (int i = start; i <= n; i++) {
                if (n % i == 0) {
                    list.add(i);
                    backtrack(n / i, i, list, result);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println(FactorCombinations.solution(1));
        System.out.println(FactorCombinations.solution(37));
        System.out.println(FactorCombinations.solution(12));
        System.out.println(FactorCombinations.solution(32));
    }

}
