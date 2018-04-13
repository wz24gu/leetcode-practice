package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.wz.cs.leetcode.model.Interval;

/**
 * 56. Merge Intervals<br>
 * https://leetcode.com/problems/merge-intervals<br><br>
 * 
 * Given a collection of intervals, merge all overlapping intervals.<br>
 * 
 * For example, Given [1,3],[2,6],[8,10],[15,18]; return [1,6],[8,10],[15,18].
 */
public class MergeIntervals {
    
    public static List<Interval> solution(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return result;
        }
        
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        
        int n = intervals.size();
        result.add(intervals.get(0));
        for (int i = 1; i < n; i++) {
            if (result.get(result.size() - 1).end >= intervals.get(i).start) {
                result.get(result.size() - 1).end = Math.max(result.get(result.size() - 1).end, intervals.get(i).end);
            }
            else {
                result.add(intervals.get(i));
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));
        System.out.println(MergeIntervals.solution(intervals));
    }

}
