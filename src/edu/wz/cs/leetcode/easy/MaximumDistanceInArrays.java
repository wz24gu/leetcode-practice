package edu.wz.cs.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 624. Maximum Distance in Arrays<br>
 * https://leetcode.com/problems/maximum-distance-in-arrays<br><br>
 * 
 * Given m arrays, and each array is sorted in ascending order. Now you can pick up two integers from two different 
 * arrays (each array picks one) and calculate the distance. We define the distance between two integers a and b to be 
 * their absolute difference |a-b|. Your task is to find the maximum distance.<br><br>
 * 
 * Note:<br>
 * 1. Each given array will have at least 1 number. There will be at least two non-empty arrays.<br>
 * 2. The total number of the integers in all the m arrays will be in the range of [2, 10000].<br>
 * 3. The integers in the m arrays will be in the range of [-10000, 10000].
 */
public class MaximumDistanceInArrays {

    public static int solution(List<List<Integer>> arrays) {
        PriorityQueue<int[]> min = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> max = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        
        for (int i = 0; i < arrays.size(); i++) {
            for (int n : arrays.get(i)) {
                min.add(new int[] {n, i});
                max.add(new int[] {n, i});
            }
        }
        
        int[] a = min.poll();
        int[] b = max.poll();
        if (a[1] != b[1]) {
            return Math.abs(b[0] - a[0]);
        }
        else {
            while (!max.isEmpty() && max.peek()[1] == a[1]) {
                max.poll();
            }
            int m = Math.abs(max.peek()[0] - a[0]);
            
            while (!min.isEmpty() && min.peek()[1] == b[1]) {
                min.poll();
            }
            int n = Math.abs(b[0] - min.peek()[0]);
            
            return Math.max(m, n);
        }        
    }
    
    public static int solutionX(List<List<Integer>> arrays) {
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int result = 0;
        
        int len = arrays.size();
        for (int i = 1; i < len; i++) {
            int m = Math.abs(arrays.get(i).get(arrays.get(i).size() - 1) - min);
            int n = Math.abs(max - arrays.get(i).get(0));
            result = Math.max(result, Math.max(m, n));
            
            min = Math.min(min, arrays.get(i).get(0));
            max = Math.max(max, arrays.get(i).get(arrays.get(i).size() - 1));
        }
        return result;
    }
    
    public static void main(String[] args) {
        List<List<Integer>> arrays = new ArrayList<>();
        arrays.add(Arrays.asList(new Integer[] {1, 2, 3}));
        arrays.add(Arrays.asList(new Integer[] {4, 5}));
        arrays.add(Arrays.asList(new Integer[] {1, 2, 3}));
        
        System.out.println(MaximumDistanceInArrays.solution(arrays));
        System.out.println(MaximumDistanceInArrays.solutionX(arrays));
    }

}
