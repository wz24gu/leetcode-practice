package edu.wz.cs.leetcode.medium;

/**
 * 96. Unique Binary Search Trees<br>
 * https://leetcode.com/problems/unique-binary-search-trees<br><br>
 * 
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 */
public class UniqueBinarySearchTrees {
    
    public static int solution(int n) {
        if (n <= 1) {
            return n;
        }
        
        // Catalan number
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i-j-1];
            }
        }
        return dp[n];
    }
    
    public static void main(String[] args) {
        System.out.println(UniqueBinarySearchTrees.solution(1));
        System.out.println(UniqueBinarySearchTrees.solution(2));
        System.out.println(UniqueBinarySearchTrees.solution(3));
    }

}
