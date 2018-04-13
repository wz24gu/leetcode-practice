package edu.wz.cs.leetcode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 360. Sort Transformed Array<br>
 * https://leetcode.com/problems/sort-transformed-array<br><br>
 * 
 * Given a sorted array of integers nums and integer values a, b and c. Apply a quadratic function of the form f(x) = 
 * ax^2 + bx + c to each element x in the array.<br>
 * 
 * The returned array must be in sorted order.<br>
 * 
 * Expected time complexity: O(n)
 */
public class SortTransformedArray {
    
    public static int[] solution(int[] nums, int a, int b, int c) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        
        Queue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(a * num * num + b * num + c);
        }
        
        int[] result = new int[nums.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = pq.poll();
        }
        return result;
    }
    
    public static int[] solutionX(int[] nums, int a, int b, int c) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        
        int[] result = new int[nums.length];
        int i = 0;
        int j = nums.length - 1;
        int index = (a >= 0) ? nums.length - 1 : 0;
        while (i <= j) {
            int x = f(nums[i], a, b, c);
            int y = f(nums[j], a, b, c);
            if (a >= 0) {
                result[index] = Math.max(x, y);
                index--;
                if (x >= y) {
                    i++;
                }
                else {
                    j--;
                }
            }
            else {
                result[index] = Math.min(x, y);
                index++;
                if (x >= y) {
                    j--;
                }
                else {
                    i++;
                }
            }
        }
        
        return result;
    }
    
    private static int f(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
    
    public static void main(String[] args) {
        int[] nums = {-4, -2, 2, 4};
        System.out.println(Arrays.toString(SortTransformedArray.solution(nums, 1, 3, 5)));
        System.out.println(Arrays.toString(SortTransformedArray.solutionX(nums, 1, 3, 5)));
        
        int[] nums2 = {-4, -2, 2, 4};
        System.out.println(Arrays.toString(SortTransformedArray.solution(nums2, -1, 3, 5)));
        System.out.println(Arrays.toString(SortTransformedArray.solutionX(nums2, -1, 3, 5)));
    }

}
