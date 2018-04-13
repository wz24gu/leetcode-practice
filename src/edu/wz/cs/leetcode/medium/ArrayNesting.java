package edu.wz.cs.leetcode.medium;

/**
 * 565. Array Nesting<br>
 * https://leetcode.com/problems/array-nesting<br><br>
 * 
 * A zero-indexed array A consisting of N different integers is given. The array contains all integers in the range 
 * [0, N - 1].<br>
 * 
 * Sets S[K] for 0 <= K < N are defined as follows:<br>
 * S[K] = { A[K], A[A[K]], A[A[A[K]]], ... }.<br>
 * Sets S[K] are finite for each K and should NOT contain duplicates.<br>
 * Write a function that given an array A consisting of N integers, return the size of the largest set S[K] for this 
 * array.<br>
 * 
 * Example 1:<br>
 * Input: A = [5,4,0,3,1,6,2]<br>
 * Output: 4<br>
 * Explanation:<br>A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.<br>
 * One of the longest S[K]: S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}<br><br>
 * 
 * Note:<br>
 * 1. N is an integer within the range [1, 20,000].<br>
 * 2. The elements of A are all distinct.<br>
 * 3. Each element of array A is an integer within the range [0, N-1].
 */
public class ArrayNesting {
    
    public static int solution(int[] nums) {        
        int result = 0;
        
        boolean[] marked = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int j = nums[i];
            if (marked[j]) {
                continue;  // don't need to visit the marked element as the start
            }
            
            int count = 1;
            while (j != i) {
                marked[j] = true;
                count++;
                j = nums[j];
            }
            result = Math.max(result, count);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {5, 4, 0, 3, 1, 6, 2};
        System.out.println(ArrayNesting.solution(nums));
    }

}
