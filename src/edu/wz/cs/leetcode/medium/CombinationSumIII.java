package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. Combination Sum III<br>
 * https://leetcode.com/problems/combination-sum-iii<br><br>
 * 
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used 
 * and each combination should be a unique set of numbers.<br>
 * 
 * Ensure that numbers within the set are sorted in ascending order.
 */
public class CombinationSumIII {

    public static List<List<Integer>> solution(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (n <= 0 || k <= 0) {
            return result;
        }
        
        List<Integer> list = new ArrayList<>();
        backtrack(1, k, n, list, result);
        return result;
    }
    
    private static void backtrack(int start, int k, int n, List<Integer> list, List<List<Integer>> result) {
        if (n < 0 || list.size() > k) {
            return;
        }
        if (n == 0 && list.size() == k) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i = start; i <= 9; i++) {
            list.add(i);
            backtrack(i + 1, k, n - i, list, result);
            list.remove(list.size() - 1);
        }        
    }
    
    public static void main(String[] args) {
        System.out.println(CombinationSumIII.solution(3, 7));
    }
    
}
