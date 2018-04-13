package edu.wz.cs.leetcode.algorithm;

public class UniqueBinarySearchTreeI {
    
    public int count(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];  // catalan number
            }
        }
        
        return dp[n];
    }
    
    public static void main(String[] args) {
        UniqueBinarySearchTreeI uniqueBinarySearchTreeI = new UniqueBinarySearchTreeI();
        System.out.println(uniqueBinarySearchTreeI.count(0));
        System.out.println(uniqueBinarySearchTreeI.count(1));
        System.out.println(uniqueBinarySearchTreeI.count(2));
        System.out.println(uniqueBinarySearchTreeI.count(3));
        System.out.println(uniqueBinarySearchTreeI.count(4));
    }

}
