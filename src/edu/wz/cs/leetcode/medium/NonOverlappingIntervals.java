package edu.wz.cs.leetcode.medium;

import java.util.Arrays;

import edu.wz.cs.leetcode.model.Interval;

/**
 * 435. Non-overlapping Intervals<br>
 * https://leetcode.com/problems/non-overlapping-intervals<br><br>
 * 
 * Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the 
 * intervals non-overlapping.<br><br>
 * 
 * Note:<br>
 * 1. You may assume the interval's end point is always bigger than its start point.<br>
 * 2. Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
 */
public class NonOverlappingIntervals {
    
    public static int solution(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        
        int result = 0;
        int n = intervals.length;
        int last = 0;
        for (int i = 1; i < n; i++) {
            if (intervals[i].start < intervals[last].end) {
                result++;
                if (intervals[i].end < intervals[last].end) {
                    last = i;
                }
            }
            else {
                last = i;
            }
        }
        
        return result;   
    }
    
    public static void main(String[] args) {
        Interval[] intervals = {
            new Interval(1, 2),
            new Interval(2, 3),
            new Interval(3, 4),
            new Interval(1, 3) };
        System.out.println(NonOverlappingIntervals.solution(intervals));
        
        Interval[] intervals2 = {
                new Interval(1, 2),
                new Interval(1, 2),
                new Interval(1, 2) };
        System.out.println(NonOverlappingIntervals.solution(intervals2));
        
        Interval[] intervals3 = {
                new Interval(1, 2),
                new Interval(2, 3) };
        System.out.println(NonOverlappingIntervals.solution(intervals3));
    }

}
