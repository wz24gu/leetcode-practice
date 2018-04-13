package edu.wz.cs.leetcode.hard;

/**
 * 440. K-th Smallest in Lexicographical Order<br>
 * https://leetcode.com/problems/k-th-smallest-in-lexicographical-order<br><br>
 * 
 * Given integers n and k, find the lexicographically k-th smallest integer in the range from 1 to n.<br>
 * 
 * Note: 1 <= k <= n <= 10^9.
 */
public class KthSmallestInLexicographicalOrder {
    
    public static int solution(int n, int k) {
        int current = 1;
        k--;
        while (k > 0) {
            long step = 0;
            int first = current;
            int last = current + 1;
            
            while (first <= n) {
                step += Math.min(n + 1, last) - first;
                first *= 10;
                last *= 10;
            }
            
            if (step <= k) {
                k -= step;
                current++;
            }
            else {
                k--;
                current *= 10;
            }
        }
        
        return current;
    }
    
    public static void main(String[] args) {
        System.out.println(KthSmallestInLexicographicalOrder.solution(13, 2));
    }

}
