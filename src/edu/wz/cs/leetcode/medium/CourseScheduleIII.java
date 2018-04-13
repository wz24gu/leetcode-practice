package edu.wz.cs.leetcode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 630. Course Schedule III<br>
 * https://leetcode.com/problems/course-schedule-iii<br><br>
 * 
 * There are n different online courses numbered from 1 to n. Each course has some duration(course length) t and closed 
 * on dth day. A course should be taken continuously for t days and must be finished before or on the dth day. You will 
 * start at the 1st day.<br>
 * 
 * Given n online courses represented by pairs (t,d), your task is to find the maximal number of courses that can be taken.<br><br>
 * 
 * Note:<br>
 * 1. The integer 1 <= d, t, n <= 10,000.<br>
 * 2. You can't take two courses simultaneously.
 */
public class CourseScheduleIII {

    public static int solution(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        
        int cur = 0;
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int[] course : courses) {
            cur += course[0];
            queue.offer(course[0]);
            if (cur > course[1]) {
                queue.poll();
            }
        }
        
        return queue.size();   
    }
    
    public static void main(String[] args) {
        int[][] courses = { {100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200} };
        System.out.println(CourseScheduleIII.solution(courses));
    }
    
}
