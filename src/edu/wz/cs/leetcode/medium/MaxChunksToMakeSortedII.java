package edu.wz.cs.leetcode.medium;

/**
 * 768. Max Chunks To Make Sorted II<br>
 * https://leetcode.com/problems/max-chunks-to-make-sorted-ii<br><br>
 * 
 * This question is the same as "Max Chunks to Make Sorted" except the integers of the given array are not necessarily 
 * distinct, the input array could be up to length 2000, and the elements could be up to 10**8.<br>
 * 
 * Given an array arr of integers (not necessarily distinct), we split the array into some number of "chunks" 
 * (partitions), and individually sort each chunk.  After concatenating them, the result equals the sorted array.<br>
 * 
 * What is the most number of chunks we could have made?<br>
 * 
 * Note:<br>
 * 1. arr will have length in range [1, 2000].<br>
 * 2. arr[i] will be an integer in range [0, 10**8].
 */
public class MaxChunksToMakeSortedII {
    
    public static int solution(int[] arr) {
        int n = arr.length;
        int[] maxLeft = new int[n];
        int[] minRight = new int[n];
        
        maxLeft[0] = arr[0];
        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(maxLeft[i-1], arr[i]);
        }
        minRight[n-1] = arr[n-1];
        for (int i = n - 2; i >= 0; i--) {
            minRight[i] = Math.min(minRight[i+1], arr[i]);
        }
        
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            if (maxLeft[i] <= minRight[i+1]) {
                res++;
            }
        }
        return res + 1;
    }
    
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        System.out.println(MaxChunksToMakeSortedII.solution(arr));
        
        int[] arr2 = {2, 1, 3, 4, 4};
        System.out.println(MaxChunksToMakeSortedII.solution(arr2));
    }

}
