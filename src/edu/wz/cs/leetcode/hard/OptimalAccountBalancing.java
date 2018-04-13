package edu.wz.cs.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * 465. Optimal Account Balancing<br/>
 * https://leetcode.com/problems/optimal-account-balancing<br/><br/>
 * 
 * A group of friends went on holiday and sometimes lent each other money. For example, Alice paid for Bill's lunch for 
 * 10. Then later Chris gave Alice 5 for a taxi ride. We can model each transaction as a tuple (x, y, z) which means 
 * person x gave person y $z. Assuming Alice, Bill, and Chris are person 0, 1, and 2 respectively (0, 1, 2 are the 
 * person's ID), the transactions can be represented as [[0, 1, 10], [2, 0, 5]].<br/>
 * 
 * Given a list of transactions between a group of people, return the minimum number of transactions required to settle 
 * the debt.<br/><br/>
 * 
 * Note:<br/>
 * 1. A transaction will be given as a tuple (x, y, z). Note that x ≠ y and z > 0.<br/>
 * 2. Person's IDs may not be linear, e.g. we could have the persons 0, 1, 2 or we could also have the persons 0, 2, 6.
 */
public class OptimalAccountBalancing {
    
    public static int solution(int[][] transactions) {
        if (transactions == null || transactions.length == 0 || transactions[0].length == 0) {
            return 0;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] t : transactions) {
            map.put(t[0], map.getOrDefault(t[0], 0) - t[2]);
            map.put(t[1], map.getOrDefault(t[1], 0) + t[2]);
        }
        
        int[] accounts = new int[map.size()];
        int count = 0;
        for (int i : map.keySet()) {
            if (map.get(i) != 0) {
                accounts[count++] = map.get(i);
            }
        }
        return helper(accounts, 0, count, 0);
    }
    
    private static int helper(int[] accounts, int left, int right, int num) {        
        while (left < right && accounts[left] == 0) {
            left++;
        }
        
        int result = Integer.MAX_VALUE;
        for (int i = left + 1; i < right; i++) {
            if (accounts[i] < 0 && accounts[left] > 0
                    || accounts[i] > 0 && accounts[left] < 0) {
                accounts[i] += accounts[left];
                result = Math.min(result, helper(accounts, left + 1, right, num + 1));
                accounts[i] -= accounts[left];
            }
        }
        
        return result == Integer.MAX_VALUE ? num : result;
    }
    
    public static void main(String[] args) {
        int[][] transactions = { {0, 1, 10}, {2, 0, 5} };
        System.out.println(OptimalAccountBalancing.solution(transactions));
        
        int[][] transactions2 = { {0, 1, 10}, {1, 0, 1}, {1, 2, 5}, {2, 0, 5} };
        System.out.println(OptimalAccountBalancing.solution(transactions2));
    }

}
