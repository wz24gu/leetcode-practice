package edu.wz.cs.leetcode.hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 786. K-th Smallest Prime Fraction<br>
 * https://leetcode.com/problems/k-th-smallest-prime-fraction<br><br>
 * 
 * A sorted list A contains 1, plus some number of primes.  Then, for every p < q in the list, we consider the fraction p/q.<br>
 * 
 * What is the K-th smallest fraction considered?  Return your answer as an array of ints, where answer[0] = p and answer[1] = q.<br><br>
 * 
 * Note:<br>
 * 1. A will have length between 2 and 2000.<br>
 * 2. Each A[i] will be between 1 and 30000.<br>
 * 3. K will be between 1 and A.length * (A.length - 1) / 2.
 */
public class KthSmallestPrimeFraction {
    
    public static int[] solution(int[] A, int k) {
        int n = A.length;
        
        Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return A[a[0]] * A[b[1]] - A[b[0]] * A[a[1]];
            }
        });
        
        for (int i = 0; i < n; i++) {
            pq.offer(new int[] {i, n - 1});
        }
        
        for (int i = 0; i < k - 1; i++) {
            int[] pop = pq.poll();
            if (pop[1] - 1 > pop[0]) {
                pop[1]--;
                pq.add(pop);
            }
        }
        
        int[] peek = pq.peek();
        return new int[] {A[peek[0]], A[peek[1]]};
    }
    
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 5};
        System.out.println(Arrays.toString(KthSmallestPrimeFraction.solution(A, 3)));
    }

}
