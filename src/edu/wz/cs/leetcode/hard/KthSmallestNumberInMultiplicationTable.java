package edu.wz.cs.leetcode.hard;

/**
 * 668. Kth Smallest Number in Multiplication Table<br/>
 * 
 * Nearly every one have used the Multiplication Table. But could you find out the k-th smallest number quickly from 
 * the multiplication table?<br/>
 * 
 * Given the height m and the length n of a m * n Multiplication Table, and a positive integer k, you need to return 
 * the k-th smallest number in this table.<br/><br/>
 * 
 * Note:<br/>
 * 1. The m and n will be in the range [1, 30000].<br/>
 * 2. The k will be in the range [1, m * n]
 */
public class KthSmallestNumberInMultiplicationTable {

    public static int solution(int m, int n, int k) {
        if (m == 0 || n == 0) {
            throw new IllegalArgumentException();
        }
        
        int lo = 1;
        int hi = m * n;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int count = helper(m, n, mid);
            if (count >= k) {
                hi = mid - 1;
            }
            else {
                lo = mid + 1;
            }
        }
        return lo;
    }
    
    private static int helper(int m, int n, int mid) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(n, mid / i);
        }
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println(KthSmallestNumberInMultiplicationTable.solution(3, 3, 5));
        System.out.println(KthSmallestNumberInMultiplicationTable.solution(2, 3, 6));
    }
    
}
