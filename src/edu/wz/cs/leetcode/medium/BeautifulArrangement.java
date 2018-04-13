package edu.wz.cs.leetcode.medium;

/**
 * 526. Beautiful Arrangement<br>
 * https://leetcode.com/problems/beautiful-arrangement<br><br>
 * 
 * Suppose you have N integers from 1 to N. We define a beautiful arrangement as an array that is constructed by these
 * N numbers successfully if one of the following is true for the ith position (1 <= i <= N) in this array:<br>
 * 1. The number at ith position is divisible by i.<br>
 * 2. i is divisible by the number at the ith position<br>
 * 
 * Now given N, how many beautiful arrangements can you construct?<br>
 * 
 * Note: N is a positive integer and will not exceed 15.
 */
public class BeautifulArrangement {
    
    private static int count;

    public static int solution(int N) {
        if (N == 0) {
            return 0;
        }
        
        count = 0;
        boolean[] visited = new boolean[N+1];
        helper(1, N, visited);
        return count;
    }
    
    private static void helper(int k, int N, boolean[] visited) {
        if (k > N) {
            count++;
            return;
        }
        
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && (i % k == 0 || k % i == 0)) {
                visited[i] = true;
                helper(k + 1, N, visited);
                visited[i] = false;  // set it back after one round is done
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println(BeautifulArrangement.solution(2));
        System.out.println(BeautifulArrangement.solution(4));
    }

}
