package edu.wz.cs.leetcode.easy;

import java.util.Arrays;

import edu.wz.cs.leetcode.model.Interval;

/**
 * 252. Meeting Rooms<br>
 * https://leetcode.com/problems/meeting-rooms<br><br>
 * 
 * Given an array of meeting time intervals consisting of start and end times [[s1, e1],[s2, e2],...] (si < ei), 
 * determine if a person could attend all meetings.<br>
 * 
 * For example,<br>
 * Given [[0, 30],[5, 10],[15, 20]], return false.
 */
public class MeetingRooms {

    public static boolean solution(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }
        
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[i-1].end) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Interval[] intervals = {new Interval(0, 30), new Interval(15, 20), new Interval(5, 10)};
        System.out.println(MeetingRooms.solution(intervals));
    }

}
