package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 373. Find K Pairs with Smallest Sums<br>
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums<br><br>
 * 
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.<br>
 * 
 * Define a pair (u,v) which consists of one element from the first array and one element from the second array.<br>
 * 
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 */
public class FindKPairsWithSmallestSums {
    
    public static List<int[]> solution(int[] nums1, int[] nums2, int k) {
        int[][] array = new int[k*k][2];
        int m = nums1.length;
        int n = nums2.length;
        int r = 0;
        
        for (int i = 0; i < Math.min(m, k); i++) {
            for (int j = 0; j < Math.min(n, k); j++) {
                array[r++] = new int[] {nums1[i], nums2[j]};
            }
        }
        
        Arrays.sort(array, (a, b) -> ((a[0] + a[1]) - (b[0] + b[1])));
        
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < Math.min(r, k); i++) {
            result.add(array[i]);
        }
        return result;
    }
    
    public static List<int[]> solutionAlt(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));
        int m = Math.min(k, nums1.length);
        int n = Math.min(k, nums2.length);
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                queue.offer(new int[] {nums1[i], nums2[j]});
            }
        }
        
        List<int[]> result = new ArrayList<>();
        while (k > 0) {
            if (queue.isEmpty()) {
                break;
            }
            result.add(queue.poll());
            k--;
        }
        return result;   
    }
    
    public static void main(String[] args) {
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        System.out.println(FindKPairsWithSmallestSums.solution(nums1, nums2, 3));
        System.out.println(FindKPairsWithSmallestSums.solutionAlt(nums1, nums2, 3));
        
        nums1 = new int[] {1, 1, 2};
        nums2 = new int[] {1, 2, 3};
        System.out.println(FindKPairsWithSmallestSums.solution(nums1, nums2, 2));
        System.out.println(FindKPairsWithSmallestSums.solutionAlt(nums1, nums2, 2));
        
        nums1 = new int[] {1, 2};
        nums2 = new int[] {3};
        System.out.println(FindKPairsWithSmallestSums.solution(nums1, nums2, 3));
        System.out.println(FindKPairsWithSmallestSums.solutionAlt(nums1, nums2, 3));
    }
    
}
