package edu.wz.cs.leetcode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

import edu.wz.cs.leetcode.model.Interval;

/**
 * 253. Meeting Rooms II<br>
 * https://leetcode.com/problems/meeting-rooms-ii<br><br>
 * 
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the 
 * minimum number of conference rooms required.<br>
 * 
 * For example, Given [[0, 30],[5, 10],[15, 20]], return 2.
 */
public class MeetingRoomsII {
    
    public static int solution(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        
        PriorityQueue<Interval> queue = new PriorityQueue<>((a, b) -> a.end - b.end);
        queue.offer(intervals[0]);
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= queue.peek().end) {
                queue.poll();
            }
            queue.offer(intervals[i]);
        }
        
        return queue.size();
    }
    
    public static void main(String[] args) {
        Interval[] intervals = new Interval[3];
        intervals[0] = new Interval(0, 30);
        intervals[1] = new Interval(5, 10);
        intervals[2] = new Interval(15, 20);
        System.out.println(MeetingRoomsII.solution(intervals));
    }

}
