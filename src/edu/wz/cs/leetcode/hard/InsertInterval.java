package edu.wz.cs.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

import edu.wz.cs.leetcode.model.Interval;

/**
 * 57. Insert Interval<br>
 * https://leetcode.com/problems/insert-interval<br><br>
 * 
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).<br>
 * 
 * You may assume that the intervals were initially sorted according to their start times.<br>
 * 
 * Example 1: Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].<br>
 * 
 * Example 2: Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].<br>
 * 
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */
public class InsertInterval {
    
    public static List<Interval> solution(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        int i = 0;
        int n = intervals.size();
        
        // add all intervals ending before newInterval's start
        while (i < n && intervals.get(i).end < newInterval.start) {
            result.add(intervals.get(i));
            i++;
        }
        
        // merge the middle
        while (i < n && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            i++;
        }
        result.add(newInterval);
        
        // add the rest
        while (i < n) {
            result.add(intervals.get(i));
            i++;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(6, 9));
        System.out.println(InsertInterval.solution(intervals, new Interval(2, 5)));
        
        List<Interval> intervals2 = new ArrayList<>();
        intervals2.add(new Interval(1, 2));
        intervals2.add(new Interval(3, 5));
        intervals2.add(new Interval(6, 7));
        intervals2.add(new Interval(8, 10));
        intervals2.add(new Interval(12, 16));
        System.out.println(InsertInterval.solution(intervals2, new Interval(4, 9)));
    }

}
