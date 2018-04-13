package edu.wz.cs.leetcode.hard;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 757. Set Intersection Size At Least Two<br>
 * https://leetcode.com/problems/set-intersection-size-at-least-two<br><br>
 * 
 * An integer interval [a, b] (for integers a < b) is a set of all consecutive integers from a to b, including a and b.<br>
 * 
 * Find the minimum size of a set S such that for every integer interval A in intervals, the intersection of S with A 
 * has size at least 2.<br><br>
 * 
 * Note:<br>
 * 1. intervals will have length in range [1, 3000].<br>
 * 2. intervals[i] will have length 2, representing some integer interval.<br>
 * 3. intervals[i][j] will be an integer in [0, 10 ^ 8].
 */
public class SetIntersectionSizeAtLeastTwo {
    
    public static int solution(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[1] == b[1]) {
                    return b[0] - a[0];
                }
                return a[1] - b[1];
            }
        });
        
        int res = 0;
        int max1 = -1;
        int max2 = -1;
        
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            if (start > max1) {
               res += 2;
               max1 = end;
               max2 = end - 1;
            }
            else if (start > max2) {
                res++;
                max2 = (max1 == end) ? max1 - 1 : max1;
                max1 = end;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[][] intervals = { {1, 3}, {1, 4}, {2, 5}, {3, 5} };
        System.out.println(SetIntersectionSizeAtLeastTwo.solution(intervals));
        
        int[][] intervals2 = { {1, 2}, {2, 3}, {2, 4}, {4, 5} };
        System.out.println(SetIntersectionSizeAtLeastTwo.solution(intervals2));
    }

}
