package edu.wz.cs.leetcode.medium;

/**
 * 769. Max Chunks To Make Sorted<br>
 * https://leetcode.com/problems/max-chunks-to-make-sorted<br><br>
 * 
 * Given an array arr that is a permutation of [0, 1, ..., arr.length - 1], we split the array into some number of 
 * "chunks" (partitions), and individually sort each chunk.  After concatenating them, the result equals the sorted 
 * array.<br>
 * 
 * What is the most number of chunks we could have made?<br><br>
 * 
 * Note:<br>
 * 1. arr will have length in range [1, 10].<br>
 * 2. arr[i] will be a permutation of [0, 1, ..., arr.length - 1].
 */
public class MaxChunksToMakeSorted {
    
    public static int solution(int[] arr) {
        if (arr == null || arr.length == 1) {
            return 0;
        }
        
        int count = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (i == max) {
                count++;
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1, 0};
        System.out.println(MaxChunksToMakeSorted.solution(arr));
        
        int[] arr2 = {1, 0, 2, 3, 4};
        System.out.println(MaxChunksToMakeSorted.solution(arr2));
    }

}
