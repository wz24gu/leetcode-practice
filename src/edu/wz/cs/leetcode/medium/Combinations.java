package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. Combinations<br>
 * https://leetcode.com/problems/combinations<br>
 * 
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.<br>
 */
public class Combinations {
    
    public static List<List<Integer>> solution(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n <= 0 || k <= 0 || k > n) {
            return result;
        }
        
        List<Integer> list = new ArrayList<>();
        backtrack(1, n, k, list, result);
        return result;
    }
    
    private static void backtrack(int start, int n, int k, List<Integer> list, List<List<Integer>> result) {
        if (list.size() > k) {
            return;
        }
        if (list.size() == k) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i = start; i <= n; i++) {
            list.add(i);
            backtrack(i + 1, n, k, list, result);
            list.remove(list.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(Combinations.solution(4, 2));
    }

}
